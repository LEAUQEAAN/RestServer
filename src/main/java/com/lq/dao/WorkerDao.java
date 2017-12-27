package com.lq.dao;

import com.lq.model.Worker;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by root on 2017-11-30.
 */


public interface WorkerDao {

    @Select("select * from worker where worker_code = #{0}")
    Worker loadById(String code);

    @Select("select * from worker ")
    List<Worker> list();

    @Select("select * from worker where scenic_code = #{0}")
    List<Worker> load(String scenic_code);

    @Insert("insert into worker(worker_code,worker_name,worker_phone" +
            " ,worker_sex,scenic_code) values (" +
            " #{worker_code},#{worker_name},"
            + " #{worker_phone}, "
            + "  #{worker_sex},"
            + " #{scenic_code} )")
    boolean Add(
            @Param("worker_code")String worker_code,
            @Param("scenic_code")String scenic_code,
            @Param("worker_name")String worker_name,
            @Param("worker_sex")String worker_sex,
            @Param("worker_phone") String worker_phone);


    @Update("update worker " +
            " set worker_name=#{worker_name},"
            + " worker_phone=#{worker_phone}, worker_serviceid=#{worker_serviceid},"
            + " worker_pwd=#{worker_pwd}, worker_sex=#{worker_sex },"
            + " scenic_code=#{scenic_code} where worker_code=#{worker_code} ")
    boolean register(@Param("worker_code")String worker_code,
                     @Param("scenic_code")String scenic_code,
                     @Param("worker_serviceid")String worker_serviceid,
                     @Param("worker_name")String worker_name,
                     @Param("worker_sex")String worker_sex,
                     @Param("worker_phone") String worker_phone,
                     @Param("worker_pwd")String worker_pwd);

    @Update("update worker set worker_pwd = #{1} where worker_code = #{0}")
    boolean alterpwd(String worker_code, String newpwd);

    @Update("update worker " +
            " set worker_name=#{worker_name},"
            + " worker_phone=#{worker_phone},"
            + " worker_sex=#{worker_sex },"
            + " scenic_code=#{scenic_code} " +
            " where worker_code=#{worker_code} ")
    boolean alertinfo(@Param("worker_code")String worker_code,
                      @Param("scenic_code")String scenic_code,
                      @Param("worker_name")String worker_name,
                      @Param("worker_sex")String worker_sex,
                      @Param("worker_phone") String worker_phone);

    @Update("update worker " +
            " set worker_name=#{2},"
            + " worker_phone=#{4},"
            + " worker_sex=#{3 },"
            + " scenic_code=#{1} " +
            " where worker_code=#{0} ")
    boolean alterwoker(String code, String scenic_code, String name, String sex, String phone);

    @Update("delete from worker where  worker_code=#{0}")
    boolean delwoker(String code);
}
