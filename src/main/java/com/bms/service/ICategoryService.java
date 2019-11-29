package com.bms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bms.entity.Category;
import com.bms.util.PageQueryUtil;
import com.bms.util.PageResult;

import java.util.List;

public interface ICategoryService extends IService<Category> {

    /**
     * 查询分类的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getCategoryPage(PageQueryUtil pageUtil);

}
