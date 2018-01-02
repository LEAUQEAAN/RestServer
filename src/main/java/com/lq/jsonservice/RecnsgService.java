package com.lq.jsonservice;

import com.lq.dao.RecmsgDao;
import com.lq.model.Info;
import com.lq.model.Recmsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by business on 2017-12-01.
 */
@Component
@Path("recmsg")
public class RecnsgService {

    @Autowired
    RecmsgDao recmsgDao;

    @GET
    @Path("/add/{police_code}/{message_code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response recieve(@PathParam("police_code")  String police_code,
                        @PathParam("message_code") String message_code){
        if(recmsgDao.exist(message_code,"1")!=null){
            return Response.ok(new Info("已有人接警！")).build();
        }
        boolean ok = recmsgDao.recReport(police_code,message_code,"1");
        return Response.ok(new Info(ok?"接警成功！":"接警失败！")).build();
    }

    @GET
    @Path("/getnewinfo/{worker_code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewCount(@PathParam("worker_code")  String worker_code){

        List<Recmsg> recs =  recmsgDao.loadByWkcode(worker_code);
        int n = 0 ;
        //System.out.println(recs);
        for (Recmsg r:recs ) {
            //System.out.println(r);
            if(r.getRecmsg_status().equals("1") && r.getRecmsg_wkstatus().equals("0")){
                 n++;
            }
        }
        return Response.ok(new Info(n+"")).build();
    }
}
