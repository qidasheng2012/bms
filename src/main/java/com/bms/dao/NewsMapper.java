package com.bms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bms.entity.News;
import com.bms.util.PageQueryUtil;

import java.util.List;

public interface NewsMapper extends BaseMapper<News> {
    int deleteByPrimaryKey(Long newsId);

    int insert(News record);

    int insertSelective(News record);

    News selectByPrimaryKey(Long newsId);

    int updateByPrimaryKeySelective(News record);

    int updateByPrimaryKey(News record);

    List<News> findNewsList(PageQueryUtil pageUtil);

    int getTotalNews(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);
}