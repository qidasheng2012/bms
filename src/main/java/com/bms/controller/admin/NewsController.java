package com.bms.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bms.entity.News;
import com.bms.service.ICategoryService;
import com.bms.service.INewsService;
import com.bms.util.Result;
import com.bms.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 资讯管理
 */
@Controller
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService iNewsService;
    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private HttpServletRequest request;

    @GetMapping
    public String list() {
        request.setAttribute("path", "news");
        return "admin/news";
    }

    @GetMapping("/list")
    @ResponseBody
    public Result list(Long current, Long size) {
        if (current <= 0 || size <= 0) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        IPage p = new Page(current, size);
        QueryWrapper<News> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByDesc(News::getCreateTime);
        IPage<News> iPage = iNewsService.page(p, queryWrapper);

        return ResultGenerator.genSuccessResult(iPage);
    }

    @PostMapping("/save")
    @ResponseBody
    public Result save(News news) {
        String newsTitle = news.getNewsTitle();
        if (StringUtils.isEmpty(newsTitle)) {
            return ResultGenerator.genFailResult("请输入文章标题");
        }
        if (newsTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        String newsContent = news.getNewsContent();
        if (StringUtils.isEmpty(newsContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (newsContent.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (StringUtils.isEmpty(news.getNewsCoverImage())) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }

        boolean saveFlag = iNewsService.save(news);
        if (saveFlag) {
            return ResultGenerator.genSuccessResult("添加成功");
        } else {
            return ResultGenerator.genFailResult("添加失败");
        }
    }

    @GetMapping("/edit")
    public String edit() {
        request.setAttribute("path", "edit");
        request.setAttribute("categories", categoryService.list());
        return "admin/edit";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id) {
        request.setAttribute("path", "edit");
        News news = iNewsService.getById(id);
        if (news == null) {
            return "400";
        }
        request.setAttribute("news", news);
        request.setAttribute("categories", categoryService.list());
        return "admin/edit";
    }

    @PostMapping("/update")
    @ResponseBody
    public Result update(News news) {
        String newsTitle = news.getNewsTitle();
        if (StringUtils.isEmpty(newsTitle)) {
            return ResultGenerator.genFailResult("请输入文章标题");
        }
        if (newsTitle.trim().length() > 150) {
            return ResultGenerator.genFailResult("标题过长");
        }
        String newsContent = news.getNewsContent();
        if (StringUtils.isEmpty(newsContent)) {
            return ResultGenerator.genFailResult("请输入文章内容");
        }
        if (newsContent.trim().length() > 100000) {
            return ResultGenerator.genFailResult("文章内容过长");
        }
        if (StringUtils.isEmpty(news.getNewsCoverImage())) {
            return ResultGenerator.genFailResult("封面图不能为空");
        }

        boolean updateFlag = iNewsService.updateById(news);
        if (updateFlag) {
            return ResultGenerator.genSuccessResult("修改成功");
        } else {
            return ResultGenerator.genFailResult("修改失败");
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (iNewsService.removeByIds(Arrays.asList(ids))) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("删除失败");
        }
    }

}
