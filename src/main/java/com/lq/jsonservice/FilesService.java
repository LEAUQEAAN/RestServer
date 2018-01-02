package com.lq.jsonservice;

import com.lq.dao.FilesDao;
import com.lq.dao.VoiceDao;
import com.lq.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Software1 on 2017/12/15.
 */

@Component
@Path("files")
public class FilesService {

    @Autowired
    FilesDao filesDao;

    @Autowired
    VoiceDao voiceDao;

    /**
     * 添加音频、图片、视频
     * @param worker_code
     * @param message_code
     * @param file_type
     * @param file_url
     * @param local_url
     * @param file_name
     * @return
     */
    @GET
    @Path("/add/{worker_code}/{message_code}/{file_type}/{file_url}/{file_name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@PathParam("worker_code") String worker_code,
                        @PathParam("message_code") String  message_code,
                        @PathParam("file_type") String  file_type,
                        @PathParam("file_url") String  file_url,
                        @QueryParam("local_url") String local_url,
                        @PathParam("file_name") String  file_name
    ){
        System.out.println(local_url);
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = formatter.format(currentTime);
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String code = worker_code + "_" + formatter1.format(currentTime);

        if(file_type.equals("2")){
            boolean ok = voiceDao.add(code, message_code, file_url, datetime, local_url,Integer.parseInt(file_name));
            return Response.ok(new Info(ok ? "1" : "0")).build();
        }else {

            boolean ok = filesDao.add(code, message_code, file_type, file_url, datetime, local_url, file_name, "0%");
            return Response.ok(new Info(ok ? code : "0")).build();
        }
    }


    /**
     * 更新上传进度
     * @param file_code
     * @param file_status
     * @return
     */
    @GET
    @Path("/update/{file_code}/{file_status}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("file_code") String file_code,
                        @PathParam("file_status") String  file_status
    ){

        boolean ok = filesDao.update(file_code,file_status+"%");
        return Response.ok(new Info(ok? "1":"0")).build();
    }

}

