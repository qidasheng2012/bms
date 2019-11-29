package com.bms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bms.entity.Category;
import com.bms.util.PageQueryUtil;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    List<Category> findCategoryList(PageQueryUtil pageUtil);

    int getTotalCategories(PageQueryUtil pageUtil);

    int deleteByPrimaryKey(Long categoryId);

    int insert(Category record);

    int insertSelective(Category record);

    Category selectByPrimaryKey(Long categoryId);

    Category selectByCategoryName(String categoryName);

    int updateByPrimaryKeySelective(Category record);

    int updateByPrimaryKey(Category record);

    int deleteBatch(Integer[] ids);
}