package com.lq.dao;

import com.lq.model.Admin;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Software1 on 2017/12/11.
 */

public interface AdminDao {

    @Select("select * from admin where id = #{0}")
    Admin loadById(String code );

    @Update("update admin set pwd = #{1} where code = #{0}")
    boolean AlterPwd(String code ,String pwd);

    @Update("update admin set name = #{1} where code = #{0}")
    boolean AlterInfo(String code ,String name );

}
