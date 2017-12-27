package com.lq.controller;

import com.lq.model.Policeunit;
import com.lq.model.Scenic;
import com.lq.service.PolSecService;
import com.lq.viewmodel.PoliceunitInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * Created by business on 2017-12-07.
 */

@Controller
public class PoliceunitController {

    @Resource
    PolSecService polSecService;

    @RequestMapping("/loadpls")
    @ResponseBody
    List<PoliceunitInfo> loadpls(){
         return  polSecService.LoadInfo();
    }

    @RequestMapping("/loadsces")
    @ResponseBody
    List<Scenic> loadsces(){
        return  polSecService.LoadSces();
    }

    @RequestMapping("/loadplus")
    @ResponseBody
    List<Policeunit> loadplus(){
        return  polSecService.loadplus();
    }

    @RequestMapping("/addplu")
    @ResponseBody
    boolean addplu(String code,String name){
        return  polSecService.addplu(code,name);
    }

    @RequestMapping("/addsec")
    @ResponseBody
    boolean addsec(String code,String name,String dept){
        return  polSecService.addsec(code,name,dept);
    }



    @RequestMapping("/alterplu")
    @ResponseBody
    boolean alterplu(String code,String name){
        return  polSecService.alterplu(code,name);
    }

    @RequestMapping("/altersec")
    @ResponseBody
    boolean altersec(String code,String name,String dept){
        return  polSecService.altersec(code,name,dept);
    }

    @RequestMapping("/plscdel")
    @ResponseBody
    boolean plscdel(String code,String type){
        return  polSecService.plscdel(code,type);
    }

}
