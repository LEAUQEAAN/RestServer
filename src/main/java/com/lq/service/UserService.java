package com.lq.service;

import com.lq.dao.*;
import com.lq.model.*;
import com.lq.viewmodel.PoliceInfo;
import com.lq.viewmodel.PoliceunitInfo;
import com.lq.viewmodel.WorkerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by business on 2017-12-08.
 */
@Service
public class UserService {

    @Resource
    WorkerDao workerDao;

    @Resource
    ScenicDao scenicDao;

    @Resource
    PoliceDao policeDao;

    @Resource
    PoliceunitDao policeunitDao;

    @Resource
    AdminDao adminDao;


    public List<WorkerInfo> list(){

        List<WorkerInfo> workerInfos = new ArrayList<WorkerInfo>();
        List<Worker> lists = workerDao.list();

        for (Worker worker:  lists) {
            WorkerInfo wk = new WorkerInfo();
            wk.setWorker(worker);
            wk.setScenic(scenicDao.loadById(worker.getScenic_code()));
            workerInfos.add(wk);
        }

        return workerInfos;
    }

    public List<PoliceInfo> pllist() {
        List<PoliceInfo> workerInfos = new ArrayList<PoliceInfo>();
        List<Police> lists = policeDao.list();

        for (Police police:  lists) {
            PoliceInfo wk = new PoliceInfo();
            wk.setPolice(police);
            wk.setPoliceunit(policeunitDao.loadById(police.getPoliceunit_code()));
            workerInfos.add(wk);
        }

        return workerInfos;

    }

    public boolean addwoker(String code, String name, String sex, String dept, String phone) {
        Scenic sc = scenicDao.loadByName(dept);
        return workerDao.Add(code,sc.getScenic_code(),name,sex,phone);
    }

    public boolean alterwoker(String code, String name, String sex, String dept, String phone) {
        Scenic sc = scenicDao.loadByName(dept);
        return workerDao.alterwoker(code,sc.getScenic_code(),name,sex,phone);
    }


    public boolean delwoker(String code) {
        return workerDao.delwoker(code);
    }

    public boolean addpolice(String code, String name, String sex, String dept, String phone) {
        Policeunit plu = policeunitDao.loadByName(dept);

        System.out.println(code+"_"+plu.getPoliceunit_code()+"_"+name+"_"+sex+"_"+phone);
        return policeDao.Add(code,plu.getPoliceunit_code(),name,sex,phone);
    }

    public boolean alterpolice(String code, String name, String sex, String dept, String phone) {
        Policeunit plu = policeunitDao.loadByName(dept);
        return policeDao.alterpolice(code,plu.getPoliceunit_code(),name,sex,phone);
    }

    public boolean delpolice(String code) {
        return policeDao.delpolice(code);
    }


    public Admin login(String code , String Pwd){
        Admin admin = adminDao.loadById(code);
        if(admin==null){
            return new Admin("-1","","");
        }
        else if(admin.getPwd().equals(Pwd)){
           return  admin;
        }
        return new Admin("-2","","");
    }

    public boolean alterInfo(String code , String name){
      return  adminDao.AlterInfo(code,name);
    }

    public boolean alterPwd(String code , String pwd){
        return  adminDao.AlterPwd(code,pwd);
    }
}
