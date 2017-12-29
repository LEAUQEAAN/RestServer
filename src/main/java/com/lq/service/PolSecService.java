package com.lq.service;

import com.lq.dao.PoliceunitDao;
import com.lq.dao.ScenicDao;
import com.lq.model.Policeunit;
import com.lq.model.Scenic;
import com.lq.model.Worker;
import com.lq.viewmodel.PoliceunitInfo;
import com.lq.viewmodel.WorkerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by business on 2017-12-07.
 */


@Service
public class PolSecService {

    @Resource
    ScenicDao scenicDao;

    @Resource
    PoliceunitDao policeunitDao;


    /**
     * 获取管辖信息
     * @return
     */
    public List<PoliceunitInfo> LoadInfo(){

        List<PoliceunitInfo> policeunitInfos = new ArrayList<PoliceunitInfo>();
        List<Policeunit> policeunits = policeunitDao.load();

        for (Policeunit policeunit:  policeunits  ) {
            PoliceunitInfo pol = new PoliceunitInfo();
            pol.setPoliceunit(policeunit);
            List<Scenic> scenics = scenicDao.load(policeunit.getPoliceunit_code());

            pol.setScenics(scenics);

            policeunitInfos.add(pol);
        }

        return policeunitInfos;

    }


    public List<Scenic> LoadSces() {
        return scenicDao.list();
    }

    public List<Policeunit> loadplus() {
        return policeunitDao.load();
    }

    public boolean addplu(String code, String name) {
        return policeunitDao.add(code,name);
    }

    public boolean addsec(String code, String name, String dept) {
        return scenicDao.addsec(code,name,dept);
    }

    public boolean alterplu(String code, String name) {
        return policeunitDao.alterplu(code,name);
    }

    public boolean altersec(String code, String name, String dept) {
        return scenicDao.altersec(code,name,dept);
    }

    public boolean plscdel(String code,String type) {
        if(type.equals("0")){
            return scenicDao.delete(code);
        }else  if(type.equals("1")){
            return policeunitDao.delete(code);
        }
       return false;
    }
}

