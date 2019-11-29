package com.bms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bms.entity.NewsCategory;
import com.bms.util.PageQueryUtil;
import com.bms.util.PageResult;

import java.util.List;

public interface INewsCategoryService extends IService<NewsCategory> {

    List<NewsCategory> getAllCategories();

    NewsCategory queryById(Long id);

    /**
     * 查询分类的分页数据
     *
     * @param pageUtil
     * @return
     */
    PageResult getCategoryPage(PageQueryUtil pageUtil);

    /**
     * 添加分类数据
     *
     * @param categoryName
     * @return
     */
    Boolean saveCategory(String categoryName);

    /**
     * 修改分类数据
     *
     * @param categoryId
     * @param categoryName
     * @return
     */
    Boolean updateCategory(Long categoryId, String categoryName);

    /**
     * 删除数据
     *
     * @param ids
     * @return
     */
    Boolean deleteBatchByIds(Integer[] ids);

}
