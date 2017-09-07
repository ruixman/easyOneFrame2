package com.hfzs.biz.cms.repository;

import com.hfzs.biz.cms.domain.CmsArticle;
import com.hfzs.framework.core.web.orm.MyJpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/8/30.
 */
public interface CmsArticleDao extends MyJpaRepository<CmsArticle,String> {
    public CmsArticle findById(String id);

    public List<CmsArticle> findByTitle(String title);
}
