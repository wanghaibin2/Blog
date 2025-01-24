package com.quanxiaoha.weblog.web.model.vo.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: wanghaibin
 * @url: www.quanxiaoha.com
 * @date: 2023-04-19 16:06
 * @description: TODO
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QueryArticleDetailRspVO {
    private String title;
    private String content;
    private Date updateTime;
    private QueryArticleLinkRspVO preArticle;
    private QueryArticleLinkRspVO nextArticle;
}
