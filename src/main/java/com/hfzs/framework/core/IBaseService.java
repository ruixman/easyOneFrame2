package com.hfzs.framework.core;

import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

/**
 * Created by xurui on 2017/8/20.
 */
public interface IBaseService<T> {
   Specification<T> spec(Map<String, String[]> params);
}
