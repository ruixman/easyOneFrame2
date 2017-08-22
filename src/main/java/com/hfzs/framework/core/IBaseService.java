package com.hfzs.framework.core;

import com.hfzs.biz.sys.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by xurui on 2017/8/20.
 */
public interface IBaseService<T> extends JpaRepository{

//   Specification<T> spec(Map<String, String[]> params);
   public Page<T> findAll(Map<String, String[]> params, Pageable pageable);

}
