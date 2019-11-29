package com.bms.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.bms.entity.Comment;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper extends BaseMapper<Comment> {

    int checkDone(@Param("ids") Integer[] ids);

}