package com.magic.redis.controller;

import org.apache.tools.zip.ZipEntry;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.CRC32;
import org.apache.tools.zip.ZipOutputStream;

public class ApacheFileUtil2 {



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
}
