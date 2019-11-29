package com.bms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bms.entity.NewsComment;
import com.bms.util.PageQueryUtil;
import com.bms.util.PageResult;

public interface INewsCommentService extends IService<NewsComment> {
    /**
     * 添加评论
     *
     * @param newsComment
     * @return
     */
    Boolean addComment(NewsComment newsComment);

    /**
     * 后台管理系统中评论分页功能
     *
     * @param pageUtil
     * @return
     */
    PageResult getCommentsPage(PageQueryUtil pageUtil);

    /**
     * 批量审核
     *
     * @param ids
     * @return
     */
    Boolean checkDone(Integer[] ids);

    /**
     * 批量删除
     *
     * @param ids
     * @return
     */
    Boolean deleteBatch(Integer[] ids);
}
