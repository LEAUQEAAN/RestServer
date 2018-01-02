package com.lq.jsonservice;

import com.lq.dao.PoliceDao;
import com.lq.dao.PoliceunitDao;
import com.lq.model.Info;
import com.lq.model.Police;
import com.lq.viewmodel.PoliceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by business on 2017-12-01.
 */

@Component
@Path("police")
public class PoliceService {

    @Autowired
    private PoliceDao policeDao;
    @Autowired
    private PoliceunitDao policeunitDao;

    /**
     * 获取个人信息
     * @param code
     * @return
     */
    @GET
    @Path("/loadById/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadById(@PathParam("code") String code) {
        Police w = policeDao.loadById(code);
        return w != null ? Response.ok(w).build():Response.ok(new Police("-1","","","","","","")).build() ;
    }

    /**
     * 获取个人信息及单位信息
     * @param code
     * @return
     */
    @GET
    @Path("/loadInfoById/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response loadInfoById(@PathParam("code") String code) {
        Police w = policeDao.loadById(code);
        PoliceInfo policeInfo = new PoliceInfo();
        if(w!=null){
            policeInfo.setPolice(w);
            policeInfo.setPoliceunit(policeunitDao.loadById(w.getPoliceunit_code()));
        }
        return Response.ok(policeInfo).build();
    }


    /**
     * 添加个人信息
     * @param code
     * @param name
     * @param sex
     * @param policeunit_code
     * @param phone
     * @return
     */

    @GET
    @Path("/add/{code}/{name}/{sex}/{policeunit_code}/{phone}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(
            @PathParam("code") String code,
            @PathParam("name") String name
            ,@PathParam("sex") String sex
            ,@PathParam("policeunit_code") String policeunit_code
            ,@PathParam("phone") String phone
    ) {
        boolean ok = policeDao.Add(code,policeunit_code,name,sex,phone);
        if(ok){

            return Response.ok(new Info("添加成功！")).build();
        }else{
            //System.out.println("222");
            return Response.ok(new Info("添加失败！")).build();
        }
    }

    /**
     * 修改个人信息、用户注册
     * @param code
     * @param name
     * @param sex
     * @param policeunit_code
     * @param phone
     * @param pwd
     * @param serviceid
     * @return
     */
    @GET
    @Path("/register/{code}/{name}/{sex}/{policeunit_code}/{phone}/{pwd}/{serviceid}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response register(
            @PathParam("code") String code,
            @PathParam("name") String name
            ,@PathParam("sex") String sex
            ,@PathParam("policeunit_code") String policeunit_code
            ,@PathParam("phone") String phone
            ,@PathParam("pwd") String pwd
            ,@PathParam("serviceid") String serviceid
    ) {
        boolean ok = policeDao.register(code,policeunit_code,serviceid,name,sex,phone,pwd);
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


        Police wk =  policeDao.loadById(code);
        if(wk==null){
            return Response.ok(new Info("账号不存在！")).build();
        }else if(wk.getPolice_serviceid()==null){
            return Response.ok(new Info("账号可用,请先注册！")).build();
        }else if(wk.getPolice_pwd().equals(pwd)){
            return Response.ok(wk).build();
        }else{
            return Response.ok(new Info("密码不正确！")).build();
        }
    }


    /**
     * 修改密码
     * @param police_code
     * @param oldpwd
     * @param newpwd
     * @return
     */
    @GET
    @Path("/alterpwd/{police_code}/{oldpwd}/{newpwd}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response alertPwd(
            @PathParam("police_code") String police_code,
            @PathParam("oldpwd") String oldpwd,
            @PathParam("newpwd") String newpwd
    ){

        Police police = policeDao.loadById(police_code);
        if(police.getPolice_pwd().equals(oldpwd)){
            boolean ok = policeDao.alterpwd(police_code,newpwd);
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
        boolean ok = policeDao.alertinfo(code,scenic,name,sex,phone);
        if(ok){
            return Response.ok(new Info("修改成功！")).build();
        }else{
            return Response.ok(new Info("修改失败！")).build();
        }
    }

    /**
     * 通过部门ID获取公安部门的所以接警人员信息
     * @param policeunit_code
     * @return
     */
    @GET
    @Path("/pslist/{policeunit_code}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listByUnit(
            @PathParam("policeunit_code") String policeunit_code
    ){
        List<Police> polices = policeDao.listByUnit(policeunit_code);
        return Response.ok(polices).build();
    }

}
