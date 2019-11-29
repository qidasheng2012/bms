package com.bms.controller.admin;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bms.entity.Comment;
import com.bms.service.ICommentService;
import com.bms.util.Result;
import com.bms.util.ResultGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 评论管理
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Resource
    private ICommentService iCommentService;

    @GetMapping
    public String list(HttpServletRequest request) {
        request.setAttribute("path", "comments");
        return "admin/comment";
    }

    @GetMapping("/list")
    @ResponseBody
    public Result list(Long current, Long size) {
        if (current <= 0 || size <= 0) {
            return ResultGenerator.genFailResult("参数异常！");
        }

        IPage p = new Page(current, size);
        QueryWrapper<Comment> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().orderByDesc(Comment::getCreateTime);
        IPage<Comment> iPage = iCommentService.page(p, queryWrapper);

        return ResultGenerator.genSuccessResult(iPage);
    }

    @PostMapping("/checkDone")
    @ResponseBody
    public Result checkDone(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (iCommentService.checkDone(ids)) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("审核失败");
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody Integer[] ids) {
        if (ids.length < 1) {
            return ResultGenerator.genFailResult("参数异常！");
        }
        if (iCommentService.removeByIds(Arrays.asList(ids))) {
            return ResultGenerator.genSuccessResult();
        } else {
            return ResultGenerator.genFailResult("刪除失败");
        }
    }
}
