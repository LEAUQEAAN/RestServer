package com.lq.dao;

import com.lq.model.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by business on 2017-12-01.
 */
public interface MessageDao {

    @Insert("insert into message(message_code,worker_code,message_time,message_lo,message_al,message_note,message_status) " +
            "values( #{message_code},#{worker_code},#{message_time},#{message_lo},#{message_al},#{message_note},'0')")
    public  boolean add(@Param("message_code") String message_code,
                        @Param("worker_code") String worker_code,
                        @Param("message_time") String  message_time,
                        @Param("message_lo") String  message_lo,
                        @Param("message_al") String  message_al,
                        @Param("message_note") String message_note );



    @Select("select * from  (select * from message where worker_code = #{0} order by message_time desc ) where rownum < 11 order by message_time asc")
    List<Message> newlist(String worker_code);

    @Select("select * from (select * from MESSAGE where WORKER_CODE in (" +
            "select WORKER_CODE from WORKER where SCENIC_CODE = #{0}" +
            ") ORDER BY MESSAGE_TIME desc)  where rownum < 5 ORDER BY MESSAGE_TIME asc")
    List<Message> plist(String dept);

    @Select("select * from MESSAGE where MESSAGE_CODE  = #{0}")
    Message loadById(String msg_code);

    @Update("update MESSAGE set message_note = #{1} where message_code = #{0} ")
    boolean appendText(String usercode, String addtext);
}
