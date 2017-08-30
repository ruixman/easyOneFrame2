package com.hfzs.biz.cms.service.impl;

import com.hfzs.biz.cms.domain.CmsArticle;
import com.hfzs.biz.cms.repository.CmsChannelDao;
import com.hfzs.biz.cms.service.ICmsArticleService;
import com.hfzs.framework.core.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/30.
 */
@Service
public class CmsArticleServiceImpl extends BaseServiceImpl<CmsArticle> implements ICmsArticleService<CmsArticle>  {

    @Autowired
    private CmsChannelDao cmsChannelDao;

}
