package com.lq.jsonservice;

import com.lq.dao.ScenicDao;
import com.lq.dao.WorkerDao;
import com.lq.model.Info;
import com.lq.model.Worker;
import com.lq.viewmodel.WorkerInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by root on 2017-11-30.
 */
@Component
@Path("/worker")
public class WorkerService {
    @Autowired
    private WorkerDao workerDao;
    @Autowired
    private ScenicDao scenicDao;

    /**
     * 获取个人信息
     * @param code
     * @return
     */
    @GET
    @Path("/loadById/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadById(@PathParam("code") String code) {

        Worker w = workerDao.loadById(code);

        return w != null ? Response.ok(w).build():Response.ok(new Worker("-1","","","","","","","","")).build() ;
    }

    /**
     * 获取个人及部门信息
     * @param code
     * @return
     */
    @GET
    @Path("/loadInfoById/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadInfoById(@PathParam("code") String code) {
        Worker w = workerDao.loadById(code);
        WorkerInfo workerInfo = new WorkerInfo();
        if(w!=null){
            workerInfo.setWorker(w);
            workerInfo.setScenic(scenicDao.loadById(w.getScenic_code()));
        }
        return Response.ok(workerInfo).build() ;
    }

    /**
     * 添加个人信息
     * @param code
     * @param name
     * @param sex
     * @param scenic
     * @param phone
     * @return
     */

    @GET
    @Path("/add/{code}/{name}/{sex}/{scenic}/{phone}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(
            @PathParam("code") String code,
            @PathParam("name") String name
            ,@PathParam("sex") String sex
            ,@PathParam("scenic") String scenic
            ,@PathParam("phone") String phone
    ) {
        boolean ok = workerDao.Add(code,scenic,name,sex,phone);
        if(ok){

            return Response.ok(new Info("添加成功！")).build();
        }else{
           // System.out.println("222");
            return Response.ok(new Info("添加失败！")).build();
        }
    }

    /**
     * 修改个人信息、用户注册
     * @param code
     * @param name
     * @param sex
     * @param scenic
     * @param phone
     * @param pwd
     * @param serviceid
     * @return
     */
    @GET
    @Path("/register/{code}/{name}/{sex}/{scenic}/{phone}/{pwd}/{serviceid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(
            @PathParam("code") String code,
            @PathParam("name") String name
            ,@PathParam("sex") String sex
            ,@PathParam("scenic") String scenic
            ,@PathParam("phone") String phone
            ,@PathParam("pwd") String pwd
            ,@PathParam("serviceid") String serviceid
    ) {
        boolean ok = workerDao.register(code,scenic,serviceid,name,sex,phone,pwd);
        if(ok){
            return Response.ok(new Info("注册成功！")).build();
        }else{
          //  System.out.println("222");
            return Response.ok(new Info("注册失败！")).build();
        }
    }

    /**
     * 用户登录
     * @param code
     * @param pwd
     * @param serviceid
     * @return
     */
    @GET
    @Path("/login/{code}/{pwd}/{serviceid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(
            @PathParam("code") String code
            ,@PathParam("pwd") String pwd
            ,@PathParam("serviceid") String serviceid
    ){

        Worker wk =  workerDao.loadById(code);
        if(wk==null){
            return Response.ok(new Info("账号不存在！")).build();
        }else if(wk.getWorker_serviceid()==null){
            return Response.ok(new Info("账号可用,请先注册！")).build();
        }else if(wk.getWorker_pwd().equals(pwd)){
            return Response.ok(wk).build();
        }else{
            return Response.ok(new Info("密码不正确！")).build();
        }
    }

    /**
     * 通过单位编号查找单位下安保人员
     * @param scenic_code
     * @return
     */
    @GET
    @Path("/list/{scenic_code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response load(
            @PathParam("scenic_code") String scenic_code
    ){
            return Response.ok(workerDao.load(scenic_code)).build();
    }

    /**
     * 修改密码
     * @param worker_code
     * @param oldpwd
     * @param newpwd
     * @return
     */
    @GET
    @Path("/alterpwd/{worker_code}/{oldpwd}/{newpwd}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response alertPwd(
         @PathParam("worker_code") String worker_code,
         @PathParam("oldpwd") String oldpwd,
         @PathParam("newpwd") String newpwd
    ){
        Worker worker = workerDao.loadById(worker_code);
        if(worker.getWorker_pwd().equals(oldpwd)){
            boolean ok = workerDao.alterpwd(worker_code,newpwd);
            if(ok){
                return Response.ok(new Info("密码修改成功！")).build();
            }else{
                return Response.ok(new Info("密码修改失败！")).build();
            }
        }
        return Response.ok(new Info("原密码错误！")).build();
    }

    /**
     * 修改信息
     * @param code
     * @param name
     * @param sex
     * @param scenic
     * @param phone
     * @return
     */
    @GET
    @Path("/alterinfo/{code}/{name}/{sex}/{scenic}/{phone}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response alertInfo(
            @PathParam("code") String code,
            @PathParam("name") String name,
            @PathParam("sex") String sex
            ,@PathParam("scenic") String scenic
            ,@PathParam("phone") String phone
    ){
        boolean ok = workerDao.alertinfo(code,scenic,name,sex,phone);
        if(ok){
            return Response.ok(new Info("修改成功！")).build();
        }else{
            return Response.ok(new Info("修改失败！")).build();
        }
    }

    /**
     * 更新位置信息
     * @param code
     * @param lo
     * @param al
     * @return
     */
    @GET
    @Path("/updatePos/{code}/{lo}/{al}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePos(
            @PathParam("code") String code,
            @PathParam("lo") String lo,
            @PathParam("al") String al
    ){
        boolean ok = workerDao.updatePos(code,lo,al);
        if(ok){
            return Response.ok(new Info("更新成功！")).build();
        }else{
            return Response.ok(new Info("更新失败！")).build();
        }
    }




}
