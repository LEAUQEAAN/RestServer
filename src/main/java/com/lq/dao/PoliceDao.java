package com.lq.dao;

import com.lq.model.Police;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by business on 2017-12-01.
 */
public interface PoliceDao {

    @Select("select * from police where police_code = #{0}")
    Police loadById(String code);

    @Insert("insert into police(police_code,police_name,police_phone" +
            ",police_sex,policeunit_code) values (" +
            " #{police_code},#{police_name},"
            + " #{police_phone}, #{police_sex},"
            + " #{policeunit_code} )")
    boolean Add(
            @Param("police_code")String police_code,
            @Param("policeunit_code")String policeunit_code,
            @Param("police_name")String police_name,
            @Param("police_sex")String police_sex,
            @Param("police_phone") String police_phone );

    @Update("update police " +
            " set police_name=#{police_name},"
            + " police_phone=#{police_phone}, police_serviceid=#{police_serviceid},"
            + " police_pwd=#{police_pwd}, police_sex=#{police_sex },"
            + " policeunit_code=#{policeunit_code} where police_code=#{police_code} ")
    boolean register(@Param("police_code")String police_code,
                     @Param("policeunit_code")String policeunit_code,
                     @Param("police_serviceid")String police_serviceid,
                     @Param("police_name")String police_name,
                     @Param("police_sex")String police_sex,
                     @Param("police_phone") String police_phone,
                     @Param("police_pwd")String police_pwd);


    @Select("select * from police where police_code in (select police_code from recmsg where message_code = #{0} and recmsg_status=#{1}) ")
    Police loadByMsg(String message_code,String recmsg_status);

    @Update("update police set police_pwd = #{1} where police_code = #{0} ")
    boolean alterpwd(String police_code, String newpwd);


    @Update("update police " +
            " set police_name=#{police_name},"
            + " police_phone=#{police_phone},"
            + " police_sex=#{police_sex },"
            + " policeunit_code=#{policeunit_code} where police_code=#{police_code} ")
    boolean alertinfo(@Param("police_code")String police_code,
                      @Param("policeunit_code")String policeunit_code,
                      @Param("police_name")String police_name,
                      @Param("police_sex")String police_sex,
                      @Param("police_phone") String police_phone);

    @Select("select * from police")
    List<Police> list();

    @Update("update police " +
            " set police_name=#{2},"
            + " police_phone=#{4},"
            + " police_sex=#{3 },"
            + " policeunit_code=#{1} where police_code=#{0} ")
    boolean alterpolice(String code, String policeunit_code, String name, String sex, String phone);

    @Update("delete from police where police_code = #{0}")
    boolean delpolice(String code);

    @Select("select * from police where policeunit_code = #{0}")
    List<Police> listByUnit(String policeunit_code);

}
