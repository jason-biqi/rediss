package com.magic.redis.controller;

import cn.mp.ms.common.util.StringUtil;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.tools.zip.ZipEntry;

import java.io.*;
import java.util.HashSet;
import java.util.zip.CRC32;
import org.apache.tools.zip.ZipOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApacheFileUtil2 {

    protected static final Logger logger = LoggerFactory.getLogger(cn.mp.ms.common.util.ApacheFileUtil2.class);

    /**
     * zip流存储文件，仅存储，不压缩
     *
     * @param entryName
     * @param file
     * @param zos
     * @return
     * @throws IOException
     */
    public static ZipEntry zipFileStore(String entryName, File file, ZipOutputStream zos) throws IOException {
        ZipEntry zipEntry = new ZipEntry(entryName);
        zipEntry.setUnixMode(644);//解决linux乱码

        byte[] fileData = getFileBytes(file);
        /** ZipEntry.STORED */
        zipEntry.setMethod(ZipEntry.STORED);
        zipEntry.setCompressedSize(fileData.length);
        zipEntry.setSize(fileData.length);
        CRC32 crc = new CRC32();
        crc.update(fileData);
        zipEntry.setCrc(crc.getValue());
        /** ZipEntry.STORED */
        zos.putNextEntry(zipEntry);
        zos.write(fileData, 0, fileData.length);

        return zipEntry;
    }

    /**
     * zip流添加（目录）
     *
     * @param entryName
     * @param zos
     * @return
     * @throws IOException
     */
    public static ZipEntry zipDirectory(String entryName, org.apache.tools.zip.ZipOutputStream zos) throws IOException {
        ZipEntry zipEntry = new ZipEntry(entryName);
        zipEntry.setUnixMode(755);//解决linux乱码
        zos.putNextEntry(zipEntry);
        return zipEntry;
    }




    //获取文件字节
    public static byte[] getFileBytes(File file) throws IOException {
        IOException thrown = null;

        FileInputStream fis = null;
        ByteArrayOutputStream bos = null;
        try {
            fis = new FileInputStream(file);
            bos = new ByteArrayOutputStream();
            byte[] b = new byte[2048];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            return bos.toByteArray();
        } catch (IOException e) {
            thrown = e;
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    if (thrown == null)
                        thrown = e;
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    if (thrown == null)
                        thrown = e;
                }
            }

            if (thrown != null)
                throw thrown;
        }

        return null;
    }

    /**
     * 压缩文件夹,支持中文和递归
     *
     * @param source
     * @param dest
     * @throws IOException
     */
    public static File zip(String source, String dest) throws IOException {
        return zip(source, dest, null);
    }


    public static File zip(String source, String dest, HashSet<String> notCompressExtSet) throws IOException {

        source = source.replaceAll("\\\\", "/").replaceAll("//", "/");
        dest = dest.replaceAll("\\\\", "/").replaceAll("//", "/");

        OutputStream os = null;
        BufferedOutputStream bos = null;
        ZipOutputStream zos = null;

        IOException thrown = null;
        try {
            os = new FileOutputStream(dest);
            bos = new BufferedOutputStream(os);
            zos = new ZipOutputStream(bos);

            //支持中文，但有缺陷！这是硬编码！
            zos.setEncoding("gbk");

            File file = new File(source);

            //获取资源根目录
            String sourceRootDir = null;
            if (file.isDirectory()) {
                sourceRootDir = file.getPath();
            } else {
                sourceRootDir = file.getParent();
            }

            zipFile(file, sourceRootDir, "", zos, notCompressExtSet);

        } catch (IOException e) {

            logger.error(ExceptionUtils.getFullStackTrace(e));
            thrown = e;

        } finally { //关闭流
            closeZipFileStream(os, bos, zos, thrown);
        }

        return new File(dest);
    }

    //关闭zip流
    public static void closeZipFileStream(OutputStream os, BufferedOutputStream bos, ZipOutputStream zos, IOException thrown) throws IOException {
        if (zos != null) {
            try {
                zos.closeEntry();
            } catch (IOException e) {
                logger.error(ExceptionUtils.getFullStackTrace(e));
                if (thrown == null)
                    thrown = e;
            }
            try {
                zos.close();
            } catch (IOException e) {
                logger.error(ExceptionUtils.getFullStackTrace(e));
                if (thrown == null)
                    thrown = e;
            }
            zos = null;
        }
        if (bos != null) {
            try {
                bos.close();
            } catch (IOException e) {
                logger.error(ExceptionUtils.getFullStackTrace(e));
                if (thrown == null)
                    thrown = e;
            }
            bos = null;
        }
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                logger.error(ExceptionUtils.getFullStackTrace(e));
                if (thrown == null)
                    thrown = e;
            }
            os = null;
        }

        if (thrown != null)
            throw thrown;
    }

    public static void zipFile(File source, String sourceRootDir, String zipRootDir, ZipOutputStream zos, HashSet<String> notCompressExtSet) throws IOException {
        File[] files = new File[0];

        if (source.isDirectory()) {
            files = source.listFiles();
        } else {
            files = new File[1];
            files[0] = source;
        }

        //设置zipRootDir
        if (StringUtils.isEmpty(zipRootDir)) {
            zipRootDir = "";
        } else {
            zipRootDir = zipRootDir.replaceAll("\\\\", "/").replaceAll("//", "/");
            if (zipRootDir.lastIndexOf("/") != zipRootDir.length() - 1) {   //最后一个字符不是“斜杠”
                zipRootDir += "/";  //自动加上 “斜杠”
            }
        }

        String pathName;
        for (File file : files) {
            if (file.isDirectory()) {
                pathName = zipRootDir + file.getPath().substring(sourceRootDir.length() + 1) + "/";   // d:/b/c.png -> c/
                zipDirectory(pathName, zos);
                zipFile(file, sourceRootDir, zipRootDir, zos, notCompressExtSet);
            } else {
                pathName = zipRootDir + file.getPath().substring(sourceRootDir.length() + 1);         // d:/b/c.png -> c.png
                //通过后缀判断是否需要压缩
                if (notCompressExtSet != null
                        && notCompressExtSet.contains(StringUtil.getExtension(file.getPath()).toLowerCase())) {
                    zipFileStore(pathName, file, zos);
                } else {
                    zipFileCompress(pathName, file, zos);
                }
            }
        }
    }

    public static ZipEntry zipFileCompress(String entryName, File file, ZipOutputStream zos) throws IOException {
        IOException thrown = null;
        ZipEntry zipEntry = new ZipEntry(entryName);
        zipEntry.setUnixMode(644);//解决linux乱码

        byte[] buf = new byte[2048];
        int length = 0;
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream(file);
            bis = new BufferedInputStream(is);
            zos.putNextEntry(zipEntry);
            while ((length = bis.read(buf)) != -1) {
                zos.write(buf, 0, length);
            }
        } catch (IOException e) {
            logger.error(ExceptionUtils.getFullStackTrace(e));
            thrown = e;
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    logger.error(ExceptionUtils.getFullStackTrace(e));
                    if (thrown == null)
                        thrown = e;
                }
                bis = null;
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error(ExceptionUtils.getFullStackTrace(e));
                    if (thrown == null)
                        thrown = e;
                }
                is = null;
            }

            if (thrown != null)
                throw thrown;
        }

        return zipEntry;
    }
}
