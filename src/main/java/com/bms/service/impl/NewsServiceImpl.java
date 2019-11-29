package com.bms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bms.dao.NewsMapper;
import com.bms.entity.News;
import com.bms.service.INewsService;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl extends ServiceImpl<NewsMapper, News> implements INewsService {

}
