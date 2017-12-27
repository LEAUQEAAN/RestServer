package com.lq.dao;

import com.lq.model.Recmsg;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by business on 2017-12-01.
 */
public interface RecmsgDao {

    @Insert("insert into recmsg(recmsg_code,police_code,message_code,recmsg_status,recmsg_wkstatus) values(#{0},#{1},#{2},'0','0')")
    boolean add(String recmsg_code, String police_code, String message_code);

    @Select("select * from recmsg where message_code = #{1} and police_code = #{0} ")
    Recmsg loadByInfo(String police_code, String message_code);

    @Update("update recmsg set recmsg_status = #{2} where   message_code = #{1} and police_code = #{0} ")
    boolean recReport(String police_code, String message_code,String recmsg_status);

    @Select("select * from recmsg where message_code = #{0} and recmsg_status = #{1} ")
    Recmsg exist(String message_code, String recmsg_status);

    @Select("select * from recmsg where message_code  in (select message_code from message where worker_code = #{0}  )")
    List<Recmsg> loadByWkcode(String worker_code);

    @Update("update recmsg set recmsg_wkstatus = #{2} where police_code = #{0} and message_code = #{1}  ")
    boolean gotIt(String police_code, String message_code,String status);

}
