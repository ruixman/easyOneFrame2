package com.hfzs.biz.sys.service;

import com.hfzs.biz.sys.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Map;

public interface ISysUserService {

    public Page<SysUser> findAll(Map<String, String[]> params, Pageable pageable) throws ClassNotFoundException;

    public SysUser getOne(String id);
}
