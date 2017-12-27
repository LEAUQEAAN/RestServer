package com.lq.controller;

import com.lq.model.Admin;
import com.lq.service.UserService;
import com.lq.viewmodel.PoliceInfo;
import com.lq.viewmodel.PoliceunitInfo;
import com.lq.viewmodel.WorkerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by business on 2017-12-08.
 */
@Controller
public class UserController {

    @Resource
    UserService userService;

    @RequestMapping("/wklist")
    @ResponseBody
    List<WorkerInfo> loadwklist(){
        return  userService.list();
    }

    @RequestMapping("/pllist")
    @ResponseBody
    List<PoliceInfo> loadpllist(){
        return  userService.pllist();

    }

    @RequestMapping("/addwoker")
    @ResponseBody
    boolean addwoker(String code, String  name ,String  sex ,String  dept,String phone){
        return  userService.addwoker(code,name,sex,dept,phone);

    }

    @RequestMapping("/alterwoker")
    @ResponseBody
    boolean alterwoker(String code, String  name ,String  sex ,String  dept,String phone){
        return  userService.alterwoker(code,name,sex,dept,phone);

    }

    @RequestMapping("/delwoker")
    @ResponseBody
    boolean delwoker(String code){
        return  userService.delwoker(code);
    }

    @RequestMapping("/addpolice")
    @ResponseBody
    boolean addpolice(String code, String  name ,String  sex ,String  dept,String phone){
        return  userService.addpolice(code,name,sex,dept,phone);
    }

    @RequestMapping("/alterpolice")
    @ResponseBody
    boolean alterpolice(String code, String  name ,String  sex ,String  dept,String phone){
        return  userService.alterpolice(code,name,sex,dept,phone);
    }

    @RequestMapping("/delpolice")
    @ResponseBody
    boolean delpolice(String code){
        return  userService.delpolice(code);
    }

    @RequestMapping("/login")
    @ResponseBody
    Admin login(String code, String pwd,HttpSession session,Model model){
        Admin admin =   userService.login(code,pwd);
        if(!admin.getId().equals("-1") && !admin.getId().equals("-2")){
            session.setAttribute("admin",admin);
        }
        return admin;
    }

    @RequestMapping("/logout")
    @ResponseBody
    boolean logout(String code, String pwd,HttpSession session){
        session.removeAttribute("admin");
        return true;
    }
    @RequestMapping("/alterPwd")
    @ResponseBody
    boolean alterPwd(String code, String pwd){
        return  userService.alterPwd(code,pwd);
    }

    @RequestMapping("/alterInfo")
    @ResponseBody
    boolean alterInfo(String code, String name){
        return  userService.alterInfo(code,name);
    }



}
