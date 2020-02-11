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
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.zip.CRC32;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;

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
          stringRedisTemplate.opsForValue().set("test1",i+"abcdef");
      }

        return aboutCompanyService.findOne();
    }


    @RequestMapping("/map")

    public List findMap(HttpServletRequest request){


        StringBuffer requestURL = request.getRequestURL();
        String requestURI = request.getRequestURI();
        System.err.println(requestURL.substring(0,requestURL.length()-requestURI.length()));
        System.err.println();
       List<Map<String, String>> map = aboutCompanyService.findMap();

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



        File zipFile=new File("C:\\Users\\54963\\Desktop\\pth\\aa.txt");



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
