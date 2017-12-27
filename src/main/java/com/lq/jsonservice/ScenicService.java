package com.lq.jsonservice;

import com.lq.dao.MessageDao;
import com.lq.dao.RecmsgDao;
import com.lq.dao.ScenicDao;
import com.lq.model.Message;
import com.lq.model.Scenic;
import com.lq.viewmodel.MessageInfo;
import com.lq.viewmodel.ScenicInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 2017-12-02.
 */

@Component
@Path("/scenic")
public class ScenicService {

    @Autowired
    ScenicDao scenicDao;
    @Autowired
    MessageDao messageDao;
    @Autowired
    RecmsgDao recmsgDao;
    /**
     * 通过单位获取公安单位下人员信息
     * @param policeunit_code
     * @return
     */
    @GET
    @Path("/list/{policeunit_code}/{police_code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response Load(@PathParam("policeunit_code") String policeunit_code
    ,@PathParam("police_code") String police_code){
        List<Scenic> scenics = scenicDao.load(policeunit_code);
        List<ScenicInfo> ScenicInfos = new ArrayList<ScenicInfo>();
        for (Scenic sc:scenics) {
            ScenicInfo si = new ScenicInfo();
            si.setScenic(sc);
            List<Message> msgs = messageDao.plist(sc.getScenic_code());
            int n = 0;
            for(Message msg: msgs){
                MessageInfo info = new MessageInfo();
                if(recmsgDao.loadByInfo(police_code,msg.getMessage_code())==null){
                    n++;
                }
            }
            si.setNewNum(n==0 ?"":n+"");
            si.setColor(n==0?"light":"danger");
            ScenicInfos.add(si);
        }
        return  Response.ok(ScenicInfos).build();
    }
}
