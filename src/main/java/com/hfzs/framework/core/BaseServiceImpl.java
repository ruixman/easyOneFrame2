package com.hfzs.framework.core;

import com.hfzs.framework.domain.SearchFilter;
import org.springframework.data.jpa.domain.Specification;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.Map;

/**
 * Created by xurui on 2017/8/20.
 */
public class BaseServiceImpl<T> implements IBaseService<T> {
    @Override
    public Specification<T> spec(Map<String, String[]> params)  {
        Collection<SearchFilter> filters = SearchFilter.parse(params).values();
        Class < T >  entityClass  =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
        Specification<T> sp = (Specification<T>) SearchFilter.spec(filters, entityClass);
        return sp;
    }

//    public T getOne(String id){
//        return null;
//    }
}
