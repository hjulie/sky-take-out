package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    //根据菜品id查询对应的套餐id
    List<Long> getSetmealIdsByDishIds(List<Long> dishIds);

    //新增套餐菜品关系信息
    void insertBatch(List<SetmealDish> setmealDishes);

    //根据套餐ID查询套餐与菜品的关系
    @Select("select * from sky_take_out.setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getBySetmealId(Long setmealId);

    //根据套餐ID删除套餐与菜品的关系
    @Delete("delete from sky_take_out.setmeal_dish where setmeal_id = #{setmealId}")
    void deleteBySetmealId(Long setmealId);

}
