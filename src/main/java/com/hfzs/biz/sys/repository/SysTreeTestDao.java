package com.hfzs.biz.sys.repository;

import com.hfzs.biz.sys.domain.SysTreeTest;
import com.hfzs.framework.core.web.orm.MyJpaRepository;

/**
 * Created by Administrator on 2017/8/24.
 */
public interface SysTreeTestDao extends MyJpaRepository<SysTreeTest,String> {
    public void delete(SysTreeTest sysTreeTest);
}