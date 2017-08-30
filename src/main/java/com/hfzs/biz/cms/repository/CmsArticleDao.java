package com.hfzs.biz.cms.repository;

import com.hfzs.biz.cms.domain.CmsArticle;
import com.hfzs.framework.core.web.orm.MyJpaRepository;

/**
 * Created by Administrator on 2017/8/30.
 */
public interface CmsArticleDao extends MyJpaRepository<CmsArticle,String> {
    public CmsArticle findById(String id);
}
