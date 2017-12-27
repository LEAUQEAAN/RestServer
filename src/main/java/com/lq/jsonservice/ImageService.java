package com.lq.jsonservice;

import com.lq.dao.ImageDao;
import com.lq.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Software1 on 2017/12/15.
 */

@Component
@Path("image")
public class ImageService {

    @Autowired
    ImageDao imageDao;

    @GET
    @Path("/add/{worker_code}/{img}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@PathParam("worker_code")  String  worker_code,@PathParam("img")  String  img){
        Date currentTime = new Date();
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String code= worker_code+"_"+formatter1.format(currentTime);
        boolean ok = imageDao.add(code,img);
        return Response.ok(new Info(ok?"1":"0")).build();
    }



}

