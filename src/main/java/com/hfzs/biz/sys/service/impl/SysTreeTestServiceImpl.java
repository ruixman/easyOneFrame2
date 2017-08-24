package com.hfzs.biz.sys.service.impl;

import com.hfzs.biz.sys.domain.SysTreeTest;
import com.hfzs.biz.sys.repository.SysTreeTestDao;
import com.hfzs.biz.sys.service.ISysTreeTestService;
import com.hfzs.framework.core.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/8/24.
 */
@Service
public class SysTreeTestServiceImpl extends BaseServiceImpl<SysTreeTest> implements ISysTreeTestService {
    @Autowired
    private SysTreeTestDao sysTreeTestDao;
}
