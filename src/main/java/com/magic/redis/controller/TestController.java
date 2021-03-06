package com.magic.redis.controller;


import com.github.pagehelper.Page;
import com.magic.redis.entity.AboutCompany;
import com.magic.redis.entity.Letter;
import com.magic.redis.service.AboutCompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.zip.CRC32;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

@RestController
@RequestMapping("/test")
@Api( tags = "redis",description = "redis接口")
public class TestController {


    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    AboutCompanyService aboutCompanyService;

    @ApiOperation(value = "说明方法的用途、作用",notes = "方法的备注说明")
    @ApiImplicitParams(
            @ApiImplicitParam(name ="000",value = "AAA",required = false,paramType = "query")
    )
    @GetMapping("/redis")
    public AboutCompany redis(){
//        stringRedisTemplate.opsForValue().set("test","123456");

        System.err.println("success");

      Integer i= Integer.parseInt(stringRedisTemplate.opsForValue().get("test"));

      if (true){
          i=i-1;
          stringRedisTemplate.opsForValue().set("test1",i+"");
      }

        return aboutCompanyService.findOne();
    }


    @RequestMapping("/map")
    public Page findMap(){

        System.err.println("success");
       Page<Map<String, String>> map = aboutCompanyService.findMap();
//       System.out.println(map.get("count(1)"));
        return map;
    }

    @RequestMapping("/myAsync")
    public String MyAsync(){


        aboutCompanyService.myAsync();
        return "success";
    }


    /**+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */

    public static void main(String[] args)throws Exception {



//        File file=new File("C:\\Users\\54963\\Desktop\\pth\\");



        String str="D:\\first.zip";
        String s="C:\\data\\";
        String si="C:\\data\\a\\cc.png";
        File file=new File(si);
        File file1=new File(s);

//        String ss=file.getAbsolutePath().substring(file.getAbsolutePath().length());
//        System.err.println(ss);


        FileOutputStream fos=new FileOutputStream(str);
        ZipOutputStream zipOut=new ZipOutputStream(fos);

//        ApacheFileUtil2.zipFileStore("data\\a\\cc.png",new File(si),zipOut);
//        ApacheFileUtil2.zipFileStore("data\\a\\cc - 2.png",new File("C:\\data\\a\\cc - 2.png"),zipOut);

//        DriToZip(new File(s),zipOut,s,"data\\");

         File file2=new File(str);
         file2.mkdirs();
//        FileUtils.copyDirectory(new File("C:\\data"),new File("D:\\test\\1"));

        fos.close();
        zipOut.flush();


    }


    public static void DriToZip(File src, ZipOutputStream zos,String srcString,String fistName) throws Exception{


        if (!src.isDirectory()){
            ApacheFileUtil2.zipFileStore(fistName+src.getAbsolutePath().substring(srcString.length()),src,zos);
        }else {


        File[] files = src.listFiles();

        for (File file:files){
            if (!file.isDirectory()){
                ApacheFileUtil2.zipFileStore(fistName+file.getAbsolutePath().substring(srcString.length()), file, zos);
            }else {
                File[] files1 = file.listFiles();
                if (files1.length==0){
                    ApacheFileUtil2.zipDirectory(fistName+file.getAbsolutePath().substring(srcString.length())+"/",zos);
                }else {
                    for (File file1:files1){
                        DriToZip(file1,zos,srcString,fistName);
                    }
                }
            }


        }
        }


    }


    /**
     * zip流添加（目录）
     *
     * @param entryName
     * @param zos
     * @return
     * @throws IOException
     */
    public static ZipEntry zipDirectory(String entryName, ZipOutputStream zos) throws IOException {
        ZipEntry zipEntry = new ZipEntry(entryName);
        zipEntry.setUnixMode(755);//解决linux乱码
        zos.putNextEntry(zipEntry);
        return zipEntry;
    }









    public static void fileToZip(List<String> fList,String targerFile,int index)
    {
        //创建Zip输出流对象
        try {
            FileOutputStream fos=new FileOutputStream(targerFile);
            ZipOutputStream zipOut=new ZipOutputStream(fos);
            byte buffer[]=new byte[1024];
            for(String path:fList)
            {
                //创建输入流对象
                FileInputStream fis=new FileInputStream(path);
                ZipEntry en=new ZipEntry(path.substring(index));
                zipOut.putNextEntry(en);
                int len=0;
                while((fis.read(buffer))!=-1)
                {
                    zipOut.write(buffer, 0, len);
                }
                zipOut.closeEntry();
                fis.close();
            }

            zipOut.close();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }






}
