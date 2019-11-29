package com.bms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bms.dao.NewsMapper;
import com.bms.entity.News;
import com.bms.service.INewsService;
import com.bms.util.PageQueryUtil;
import com.bms.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public String saveNews(News news) {
        if (newsMapper.insertSelective(news) > 0) {
            return "success";
        }
        return "保存失败";
    }

    @Override
    public PageResult getNewsPage(PageQueryUtil pageUtil) {
        List<News> newsList = newsMapper.findNewsList(pageUtil);
        int total = newsMapper.getTotalNews(pageUtil);
        PageResult pageResult = new PageResult(newsList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

    @Override
    public Boolean deleteBatch(Integer[] ids) {
        return newsMapper.deleteBatch(ids) > 0;
    }

    @Override
    public News queryNewsById(Long newsId) {
        return newsMapper.selectByPrimaryKey(newsId);
    }

    @Override
    public String updateNews(News news) {
        News newsForUpdate = newsMapper.selectByPrimaryKey(news.getNewsId());
        if (newsForUpdate == null) {
            return "数据不存在";
        }
        news.setNewsCategoryId(news.getNewsCategoryId());
        news.setNewsContent(news.getNewsContent());
        news.setNewsCoverImage(news.getNewsCoverImage());
        news.setNewsStatus(news.getNewsStatus());
        news.setNewsTitle(news.getNewsTitle());
        news.setUpdateTime(new Date());
        if (newsMapper.updateByPrimaryKeySelective(news) > 0) {
            return "success";
        }
        return "修改失败";
    }
}
