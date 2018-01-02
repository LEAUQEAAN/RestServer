package com.lq.dao;

import com.lq.model.Voice;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by root on 2018-01-01.
 */
public interface VoiceDao {

    @Insert("insert into voice (voice_code, message_code, voice_url, datetime, local_url, voice_length) values (#{0},#{1},#{2},#{3},#{4},#{5})")
    public boolean add(String voice_code, String message_code, String voice_url, String datetime, String local_url, int voice_length);

    @Select("select * from voice where message_code = #{0}")
    List<Voice> loadByMsgCode(String message_code);
}
