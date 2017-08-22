package com.hfzs.biz.sys.service.impl;

import com.hfzs.common.util.Exceptions;
import com.hfzs.framework.core.BaseServiceImpl;
import com.hfzs.biz.sys.domain.SysUser;
import com.hfzs.biz.sys.repository.SysUserDao;
import com.hfzs.biz.sys.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements ISysUserService {

    @Autowired
    private SysUserDao sysUserDao;

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
