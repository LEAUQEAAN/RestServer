package com.lq.dao;

import com.lq.model.Scenic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by root on 2017-12-02.
 */
public interface ScenicDao {

    @Select("select * from scenic where policeunit_code = #{0} ")
    List<Scenic> load(String policeunit_code);

    @Select("select * from scenic")
    List<Scenic> list();

    @Select("select * from scenic where scenic_code = #{0} ")
    Scenic loadById(String scenic_code);

    @Insert("insert into scenic (scenic_code,scenic_name,policeunit_code) values (#{0},#{1},#{2})")
    boolean addsec(String code, String name, String dept);

    @Update("update scenic set scenic_name = #{1} , policeunit_code = #{2} where  scenic_code = #{0} ")
    boolean altersec(String code, String name, String dept);

    @Update("delete from  scenic  where  scenic_code = #{0} ")
    boolean delete(String code);

    @Select("select * from scenic where scenic_name = #{0} ")
    Scenic loadByName(String dept);
}
