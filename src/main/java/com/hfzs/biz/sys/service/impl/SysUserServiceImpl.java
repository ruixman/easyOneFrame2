package com.hfzs.biz.sys.service.impl;

import com.hfzs.framework.core.BaseServiceImpl;
import com.hfzs.biz.sys.domain.SysUser;
import com.hfzs.biz.sys.repository.SysUserDao;
import com.hfzs.biz.sys.service.ISysUserService;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Map;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements ISysUserService<SysUser>{

    @Autowired
    private SysUserDao sysUserDao;

    @Transactional
    public SysUser saveAndFlush(SysUser user){
        return sysUserDao.saveAndFlush(user);

    }

//    @Override
//    public Page<SysUser> findAll(Map<String, String[]> params, Pageable pageable)  {
//
//        Specification sp=spec(params) ;
//        Page<SysUser> sy=sysUserDao.findAll(sp,pageable);
//        return sy;
//    }

//    @Override
//    public SysUser getOne(String id) {
//        return sysUserDao.getOne(id);
//    }

//    private Specification<SysUser> spec(Map<String, String[]> params) {
//        Collection<SearchFilter> filters = SearchFilter.parse(params).values();
//        Specification<SysUser> sp = SearchFilter.spec(filters, SysUser.class);
//        return sp;
//    }
}
