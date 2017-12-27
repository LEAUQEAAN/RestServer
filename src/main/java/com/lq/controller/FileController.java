package com.lq.controller;

/**
 * Created by Software1 on 2017/12/27.
 */

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class FileController {

    /**
     * 文件上传
     * @param file
     * @param request
     * @param model
     * @return
     */
    @RequestMapping(value = "/upload")
    public String upload(MultipartFile file, HttpServletRequest request, Model model) {

        System.out.println("开始");
        String path = request.getSession().getServletContext().getRealPath("upload");

        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
//        String fileName = new Date().getTime()+".jpg";
        System.out.println(path);
        File targetFile = new File(path, fileName);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }

        //保存
        try {
            file.transferTo(targetFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
        model.addAttribute("fileName", fileName);
        return "index";
    }


}
