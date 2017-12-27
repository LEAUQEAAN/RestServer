package com.lq.dao;

import com.lq.model.Policeunit;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by root on 2017-12-02.
 */
public interface PoliceunitDao {

    @Select("select * from policeunit")
    List<Policeunit> load();

    @Select("select * from policeunit  where policeunit_code = #{0}")
    Policeunit loadById(String policeunit_code);

    @Insert("insert into policeunit (policeunit_code,policeunit_name) values (#{0},#{1})")
    boolean add(String code, String name);

    @Update("update policeunit set policeunit_name = #{1} where policeunit_code = #{0} ")
    boolean alterplu(String code, String name);

    @Update("delete from  policeunit  where  policeunit_code = #{0} ")
    boolean delete(String code);

    @Select("select * from policeunit  where policeunit_name = #{0}")
    Policeunit loadByName(String name);
}
