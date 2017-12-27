package com.lq.jsonservice;

import com.lq.dao.FilesDao;
import com.lq.model.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

    @GET
    @Path("/add/{worker_code}/{message_code}/{file_type}/{file_url}/{local_url}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@PathParam("worker_code") String worker_code,
                        @PathParam("file_code") String file_code,
                        @PathParam("message_code") String  message_code,
                        @PathParam("file_type") String  file_type,
                        @PathParam("file_url") String  file_url,
                        @PathParam("local_url") String  local_url
    ){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String datetime = formatter.format(currentTime);
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String code= worker_code+"_"+formatter1.format(currentTime);
        boolean ok = filesDao.add(code,message_code,file_type,file_url,datetime,local_url);
        return Response.ok(new Info(ok?"1":"0")).build();

    }
}

