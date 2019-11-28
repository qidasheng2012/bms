package com.bms.service.impl;

import com.bms.dao.NewsCommentMapper;
import com.bms.entity.NewsComment;
import com.bms.service.CommentService;
import com.bms.util.PageQueryUtil;
import com.bms.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private NewsCommentMapper newsCommentMapper;

    @Override
    public Boolean addComment(NewsComment newsComment) {
        return newsCommentMapper.insertSelective(newsComment) > 0;
    }

    @Override
    public PageResult getCommentsPage(PageQueryUtil pageUtil) {
        List<NewsComment> comments = newsCommentMapper.findNewsCommentList(pageUtil);
        int total = newsCommentMapper.getTotalNewsComments(pageUtil);
        PageResult pageResult = new PageResult(comments, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean checkDone(Integer[] ids) {
        return newsCommentMapper.checkDone(ids) > 0;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return newsCommentMapper.deleteBatch(ids) > 0;
    }
}
