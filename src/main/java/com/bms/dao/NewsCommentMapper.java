package com.bms.dao;

import com.bms.entity.NewsComment;

import java.util.List;
import java.util.Map;

public interface NewsCommentMapper {
    int insert(NewsComment record);

    int insertSelective(NewsComment record);

    NewsComment selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(NewsComment record);

    int updateByPrimaryKey(NewsComment record);

    List<NewsComment> findNewsCommentList(Map map);

    int getTotalNewsComments(Map map);

    int checkDone(Integer[] ids);

    int deleteBatch(Integer[] ids);
}