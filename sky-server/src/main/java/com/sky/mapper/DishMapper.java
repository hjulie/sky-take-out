package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.annotation.AutoFill;
import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.entity.Dish;
import com.sky.enumeration.OperationType;
import com.sky.vo.DishVO;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface DishMapper {

    /**
     * 根据分类id查询菜品数量
     * @param categoryId
     * @return
     */
    @Select("select count(id) from sky_take_out.dish where category_id = #{categoryId}")
    Integer countByCategoryId(Long categoryId);

    /*
    * 新增菜品
    * */
    @AutoFill(value = OperationType.INSERT)
    void insert(Dish dish);

    //菜品分页查询
    Page<DishVO> pageQuery(DishPageQueryDTO dishPageQueryDTO);

    //根据主键查询菜品
    @Select("select * from sky_take_out.dish where id = #{id}")
    Dish getById(Long id);

    //根据主键删除菜品数据
    @Delete("delete from sky_take_out.dish where dish.id = #{id};")
    void deleteById(Long id);

    //根据菜品id集合批量删除菜品数据
    void deleteByIds(List<Long> ids);

    //根据ID动态修改菜品
    @AutoFill(value = OperationType.UPDATE)
    void update(Dish dish);

    //根据分类ID查询菜品信息
    List<Dish> list(Dish dish);

    //根据套餐ID查询菜品
    @Select("select d.* from sky_take_out.dish d left join sky_take_out.setmeal_dish sd on d.id = sd.dish_id " +
            "where sd.setmeal_id = #{setmealId}")
    List<Dish> getBySetmealId(Long setmealId);

    //根据条件统计菜品数量
    Integer countByMap(Map map);

}
