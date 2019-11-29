package com.bms.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bms.dao.CategoryMapper;
import com.bms.entity.Category;
import com.bms.service.ICategoryService;
import com.bms.util.PageQueryUtil;
import com.bms.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

    @Autowired
    private CategoryMapper newsCategoryMapper;

    @Override
    public PageResult getCategoryPage(PageQueryUtil pageUtil) {
        List<Category> categoryList = newsCategoryMapper.findCategoryList(pageUtil);
        int total = newsCategoryMapper.getTotalCategories(pageUtil);
        PageResult pageResult = new PageResult(categoryList, total, pageUtil.getLimit(), pageUtil.getPage());
        return pageResult;
    }

}
