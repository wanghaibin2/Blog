package com.quanxiaoha.weblog.common.eventbus;

/**
 * @author: wanghaibin
 * @url: www.quanxiaoha.com
 * @date: 2023-07-02 9:20
 * @description: TODO
 **/
public interface EventListener {
    void handleEvent(ArticleEvent weblogEvent);
}
