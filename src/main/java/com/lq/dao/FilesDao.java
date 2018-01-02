package com.lq.dao;

import com.lq.model.Files;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Software1 on 2017/12/27.
 */
public interface FilesDao {


    @Insert("insert into files (file_code,message_code,file_type,file_url,datetime,local_url,file_name,file_status) values(#{0},#{1},#{2},#{3},#{4},#{5}，#{6}，#{7})")
    public boolean add(String file_code,String  message_code,String  file_type,String  file_url,String  datetime,String local_url,String  file_name,String file_status);


    @Select("select * from files where message_code = #{0} and file_type = #{1} order by datetime asc")
    public List<Files> loadByMsgCode(String message_code,String type);

    @Update("update files set file_status = #{1} where file_code = #{0}")
    boolean update(String file_code, String file_status);
}
