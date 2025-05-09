package com.sky.mapper;

import com.sky.entity.AddressBook;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AddressBookMapper {

    //新增地址
    @Insert("insert into sky_take_out.address_book (user_id, consignee, sex, phone, province_code, province_name, city_code, city_name, district_code, district_name, detail, label, is_default) " +
            "VALUES (#{userId},#{consignee},#{sex},#{phone},#{provinceCode},#{provinceName},#{cityCode},#{cityName},#{districtCode},#{districtName},#{detail},#{label},#{isDefault})")
    void insert(AddressBook addressBook);

    //查询当前登录用户的所有地址信息
    List<AddressBook> list(AddressBook addressBook);

    //根据id修改地址
    void update(AddressBook addressBook);

    //根据 用户id修改 是否默认地址
    @Update("update sky_take_out.address_book set is_default = #{isDefault} where user_id = #{userId}")
    void updateIsDefaultByUserId(AddressBook addressBook);

    //根据id删除地址
    @Delete("delete from sky_take_out.address_book where id = #{id}")
    void deleteById(Long id);

    //根据id查询地址
    @Select("select * from sky_take_out.address_book where id = #{id}")
    AddressBook getById(Long id);
}
