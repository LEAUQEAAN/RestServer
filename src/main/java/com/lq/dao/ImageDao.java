package com.lq.dao;

import org.apache.ibatis.annotations.Insert;

/**
 * Created by Software1 on 2017/12/15.
 */
public interface ImageDao {

    @Insert("insert into  images ( id , img ) values (#{0} ,#{1})" )
    boolean add(String code ,String img);

}
