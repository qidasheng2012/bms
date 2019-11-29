package com.bms.controller.admin;

import com.bms.entity.Category;
import com.bms.service.ICategoryService;
import com.bms.util.PageQueryUtil;
import com.bms.util.Result;
import com.bms.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

/**
 * 分类管理
 */
@Controller
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private ICategoryService iCategoryService;

    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public String categoryPage() {
        request.setAttribute("path", "categories");
        return "admin/category";
    }

    /**
     * 分类列表
     */
    @GetMapping("/list")
    @ResponseBody
    public Result list(@RequestParam Map<String, Object> params) {
        if (StringUtils.isEmpty(params.get("page")) || StringUtils.isEmpty(params.get("limit"))) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        PageQueryUtil pageUtil = new PageQueryUtil(params);
        return ResultGenerator.genSuccessResult(iCategoryService.getCategoryPage(pageUtil));
    }

    /**
     * 详情
     */
    @GetMapping("/info/{id}")
    @ResponseBody
    public Result info(@PathVariable("id") Long id) {
        Category newsCategory = iCategoryService.getById(id);
        return ResultGenerator.genSuccessResult(newsCategory);
    }


    /**
     * 分类添加
     */
    @PostMapping("/save")
    @ResponseBody
    public Result save(String categoryName) {
        if (StringUtils.isEmpty(categoryName)) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        Category category = Category.builder().categoryName(categoryName).build();
        boolean saveFlag = iCategoryService.save(category);
        if (saveFlag) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }


    /**
     * 分类修改
     */
    @PostMapping("/update")
    @ResponseBody
    public Result update(@RequestParam("categoryId") Long id, String categoryName) {
        if (StringUtils.isEmpty(categoryName)) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        Category category = Category.builder().id(id).categoryName(categoryName).build();
        if (iCategoryService.updateById(category)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("分类名称重复");
        }
    }


    /**
     * 分类删除
     */
    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (iCategoryService.removeByIds(Arrays.asList(ids))) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}
