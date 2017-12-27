package com.lq.jsonservice;

import com.lq.dao.*;
import com.lq.model.*;
import com.lq.viewmodel.MessageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by business on 2017-12-01.
 */
@Component
@Path("message")
public class MessageService {

    @Autowired
    MessageDao messageDao;
    @Autowired
    ScenicDao scenicDao;
    @Autowired
    WorkerDao workerDao;
    @Autowired
    PoliceDao policeDao;
    @Autowired
    RecmsgDao recmsgDao;

    /**
     * 添加消息
     * @param worker_code
     * @param message_note
     * @param lo
     * @param al
     * @return
     */
    @GET
    @Path("/add/{worker_code}/{message_note}/{lo}/{al}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(@PathParam("worker_code")  String worker_code,
                        @PathParam("message_note") String message_note,
                        @PathParam("lo") String lo,
                        @PathParam("al") String al
                        ){
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message_time = formatter.format(currentTime);
        SimpleDateFormat formatter1 = new SimpleDateFormat("yyyyMMddHHmmss");
        String message_code= worker_code+"_"+formatter1.format(currentTime);
        boolean ok = messageDao.add(message_code,worker_code,message_time,lo,al,message_note);
        return Response.ok(new Info(ok?"1":"0")).build();
    }


    /**
     * 通过安保人员ID获取安保人员的报警信息
     * @param worker_code
     * @return
     */
    @GET
    @Path("/nlist/{worker_code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response nList(@PathParam("worker_code")  String worker_code){
        List<Message> messages = messageDao.newlist(worker_code);
        Worker worker = workerDao.loadById(worker_code);
        List<MessageInfo> list = new ArrayList<MessageInfo>();
        for (Message msg: messages ) {
            MessageInfo mg = new MessageInfo();
            mg.setMessage(msg);
            mg.setWorker(worker);
            mg.setPolice(policeDao.loadByMsg(msg.getMessage_code(),"1"));
            if(mg.getPolice()!=null){
                Recmsg recmsg = recmsgDao.loadByInfo(mg.getPolice().getPolice_code(),msg.getMessage_code());
                if(recmsg!=null && recmsg.getRecmsg_status().equals("1") && recmsg.getRecmsg_wkstatus().equals("0")){
                    boolean ok =  recmsgDao.gotIt(mg.getPolice().getPolice_code(),msg.getMessage_code(),"1");
                }
            }
            list.add(mg);
        }
        return Response.ok(list).build();
    }



    /**
     * 通过景区获取该景区的所有报警信息
     * @param dept
     * @param code
     * @return
     */
    @GET
    @Path("/msglist/{dept}/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response msgList(@PathParam("dept")  String dept ,@PathParam("code")  String code){
        List<Message> msgs = messageDao.plist(dept);
        List<MessageInfo> msginfos = new ArrayList<MessageInfo>();
        for(Message msg: msgs){
            MessageInfo info = new MessageInfo();
            if(recmsgDao.loadByInfo(code,msg.getMessage_code())!=null){
                info.setNew(false);
            }else{
                String recmsg_code = code+"_"+msg.getMessage_code();
                boolean ok = recmsgDao.add(recmsg_code,code,msg.getMessage_code());
                info.setNew(true);
            }
            info.setMessage(msg);
            info.setPolice(policeDao.loadByMsg(msg.getMessage_code(),"1"));
            info.setWorker(workerDao.loadById(msg.getWorker_code()));
            msginfos.add(info);
        }
        return Response.ok(msginfos).build();
    }


    /**
     * 通过管辖单位获取该景区的所有报警信息数量
     * @param dept
     * @param code
     * @return
     */
    @GET
    @Path("/getnewcount/{dept}/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getNewCount(@PathParam("dept")  String dept ,@PathParam("code")  String code){
        List<Scenic> ls = scenicDao.load(dept);
        int newcount = 0;
        for (Scenic sc:ls) {
            List<Message> msgs = messageDao.plist(sc.getScenic_code());
            List<MessageInfo> msginfos = new ArrayList<MessageInfo>();
            for (Message msg : msgs) {
                if (recmsgDao.loadByInfo(code, msg.getMessage_code()) == null) {
                    newcount++;
                }
            }
        }
        return Response.ok(new Info(newcount+"")).build();
    }




}
