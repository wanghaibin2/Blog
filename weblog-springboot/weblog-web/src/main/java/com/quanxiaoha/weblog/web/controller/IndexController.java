package com.quanxiaoha.weblog.web.controller;

import com.quanxiaoha.weblog.common.PageResponse;
import com.quanxiaoha.weblog.common.aspect.ApiOperationLog;
import com.quanxiaoha.weblog.web.model.vo.article.QueryIndexArticlePageListReqVO;
import com.quanxiaoha.weblog.web.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: wanghaibin
 * @url: www.quanxiaoha.com
 * @date: 2023-04-18 8:14
 * @description: 首页
 **/
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private ArticleService articleService;

    @PostMapping("/article/list")
    @ApiOperationLog(description = "获取首页文章分页数据")
    public PageResponse queryArticlePageList(@RequestBody QueryIndexArticlePageListReqVO queryArticlePageListReqVO) {
        return articleService.queryIndexArticlePageList(queryArticlePageListReqVO);
    }
}
