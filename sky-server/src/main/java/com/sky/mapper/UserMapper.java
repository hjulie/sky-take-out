package com.sky.mapper;

import com.sky.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

@Mapper
public interface UserMapper {

    //根据openid查询用户
    @Select("select * from sky_take_out.user where openid = #{openid}")
    User getByUserId(String openid);

    //插入数据
    void insert(User user);

    @Select("select * from sky_take_out.user where id = #{id}")
    User getById(Long userId);

    //根据动态条件统计用户数量
    Integer countByMap(Map map);
}
