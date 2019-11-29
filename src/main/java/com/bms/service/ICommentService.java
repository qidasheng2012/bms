package com.bms.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bms.entity.Comment;

public interface ICommentService extends IService<Comment> {

    /**
     * 批量审核
     *
     * @param ids
     * @return
     */
    Boolean checkDone(Integer[] ids);

}
