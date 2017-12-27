package com.lq.jsonservice;

import com.lq.dao.PoliceunitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by root on 2017-12-02.
 */
@Component
@Path("/policeunit")
public class PoliceunitService {

    @Autowired
    PoliceunitDao policeunitDao;
    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Load(){
        return  Response.ok(policeunitDao.load()).build();
    }


}
