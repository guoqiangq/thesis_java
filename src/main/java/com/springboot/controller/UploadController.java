package com.springboot.controller;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

@RestController
@RequestMapping("/api/file")
public class UploadController {

    @Value("${file.uploadFolder}")
    private String uploadFolder;

    @Value("${file.staticAccessPath}")
    private String staticAccessPath;

    @Value("${file.upload.nama}")
    private String reurl;

    @RequestMapping(value = "/upload", method = {RequestMethod.POST, RequestMethod.GET})
    public Map<String,Object> upload(HttpServletRequest request) throws MultipartException {
        String path = "";
        List<String> ksfs = new ArrayList<>();
        Map<String,Object> retrun_obj = new HashMap<>();
        retrun_obj.put("code",0);
        //1 需传imgUrl 其他值就是传file文件上传
        try {
            //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
            CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                    request.getSession().getServletContext());

            //检查form中是否有enctype="multipart/form-data"
            if (multipartResolver.isMultipart(request)) {
                //将request变成多部分request
                MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
                //获取multiRequest 中所有的文件名
                Iterator<String> iter = multiRequest.getFileNames();

                while (iter.hasNext()) {
                    //多个文件上传
                    List<MultipartFile> fileList = multiRequest.getFiles(iter.next());
                    for (MultipartFile multipartFile : fileList) {
                        String realPath = uploadFolder;
                        String trueFileName = System.currentTimeMillis() + "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
                        // 设置存放图片文件的路径
                        path = realPath + trueFileName;
                        File file = new File(path);
                        multipartFile.transferTo(file);
                        path = reurl + "/upload/" + trueFileName;
                        ksfs.add(path);
                    }
                    //单个文件
                       /* MultipartFile multipartFile=multiRequest.getFile(iter.next().toString());
                        if (multipartFile != null) {
                            excelFile = File.createTempFile(prefix, ".jpg");
                            multipartFile.transferTo(excelFile);
                            path = KSFileSave.uploadFile(prefix, excelFile, "jpg");
                            ksfs.add(path);
                       }*/

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            retrun_obj.put("code",404);
            retrun_obj.put("message","上传失败");
            return retrun_obj;
        } finally {
        }
        retrun_obj.put("data",ksfs);
        return retrun_obj;
    }

}
