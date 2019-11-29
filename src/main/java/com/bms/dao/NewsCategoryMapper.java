package com.bms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bms.entity.NewsCategory;
import com.bms.util.PageQueryUtil;

import java.util.List;

public interface NewsCategoryMapper extends BaseMapper<NewsCategory> {

    List<NewsCategory> findCategoryList(PageQueryUtil pageUtil);

    int getTotalCategories(PageQueryUtil pageUtil);

    int deleteByPrimaryKey(Long categoryId);

    int insert(NewsCategory record);

    int insertSelective(NewsCategory record);

    NewsCategory selectByPrimaryKey(Long categoryId);

    NewsCategory selectByCategoryName(String categoryName);

    int updateByPrimaryKeySelective(NewsCategory record);

    int updateByPrimaryKey(NewsCategory record);

    int deleteBatch(Integer[] ids);
}