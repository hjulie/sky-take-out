package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.enumeration.OperationType;
import com.sky.vo.SetmealVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from sky_take_out.setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);

    //新增套餐
    @AutoFill(value = OperationType.INSERT)
    void insert(Setmeal setmeal);

    //套餐分页查询
    Page<SetmealVO> pageQuery(SetmealPageQueryDTO setmealPageQueryDTO);

    //批量删除套餐
    @Delete("delete from sky_take_out.setmeal where id = #{id}")
    void deleteById(Long id);

    //根据ID查询套餐
    @Select("select * from sky_take_out.setmeal where id = #{id}")
    Setmeal getById(Long id);

    //修改套餐
    @AutoFill(value = OperationType.UPDATE)
    void update(Setmeal setmeal);
}
