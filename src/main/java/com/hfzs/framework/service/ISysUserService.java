package com.hfzs.framework.service;

import com.hfzs.framework.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ISysUserService {

    public Page<SysUser> findAll(Map<String, String[]> params, Pageable pageable);
}
