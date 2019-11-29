package com.bms.controller.index;

import com.bms.entity.Comment;
import com.bms.entity.News;
import com.bms.service.ICommentService;
import com.bms.service.INewsService;
import com.bms.util.AntiXssUtils;
import com.bms.util.Result;
import com.bms.util.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    @Autowired
    private ICommentService commentService;
    @Autowired
    private INewsService newsService;

    /**
     * 详情页
     *
     * @return
     */
    @GetMapping({"/news/{id}"})
    public String detail(HttpServletRequest request, @PathVariable("id") Long id) {
        News news = newsService.getById(id);
        if (news != null) {
            request.setAttribute("newsDetail", news);
        }
        request.setAttribute("pageName", "详情");
        return "index/detail";
    }

    /**
     * 评论操作
     */
    @PostMapping(value = "/news/comment")
    @ResponseBody
    public Result comment(HttpServletRequest request, HttpSession session,
                          @RequestParam Long newsId, @RequestParam String verifyCode,
                          @RequestParam String commentator, @RequestParam String commentBody) {
        if (StringUtils.isEmpty(verifyCode)) {
            return ResultGenerator.genFailResult("验证码不能为空");
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StringUtils.isEmpty(kaptchaCode)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (!verifyCode.equals(kaptchaCode)) {
            return ResultGenerator.genFailResult("验证码错误");
        }
        String ref = request.getHeader("Referer");
        if (StringUtils.isEmpty(ref)) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (null == newsId || newsId < 0) {
            return ResultGenerator.genFailResult("非法请求");
        }
        if (StringUtils.isEmpty(commentator)) {
            return ResultGenerator.genFailResult("请输入称呼");
        }
        if (StringUtils.isEmpty(commentBody)) {
            return ResultGenerator.genFailResult("请输入评论内容");
        }
        if (commentBody.trim().length() > 200) {
            return ResultGenerator.genFailResult("评论内容过长");
        }

        Comment comment = Comment.builder()
                .newsId(newsId)
                .commentator(AntiXssUtils.cleanString(commentator))
                .commentBody(AntiXssUtils.cleanString(commentBody))
                .build();
        return ResultGenerator.genSuccessResult(commentService.save(comment));
    }
}
