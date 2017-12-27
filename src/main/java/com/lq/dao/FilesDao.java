package com.lq.dao;

import org.apache.ibatis.annotations.Insert;

/**
 * Created by Software1 on 2017/12/27.
 */
public interface FilesDao {


    @Insert("insert into files (file_code,message_code,file_type,file_url,datetime,local_url) values(#{0},#{1},#{2},#{3},#{4},#{5})")
    public boolean add(String file_code,String  message_code,String  file_type,String  file_url,String  datetime,String local_url);

        }
