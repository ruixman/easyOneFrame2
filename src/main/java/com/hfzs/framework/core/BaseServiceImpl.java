package com.hfzs.framework.core;

import com.hfzs.framework.core.web.orm.MyJpaRepository;
import com.hfzs.framework.domain.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Created by xurui on 2017/8/20.
 */
public class BaseServiceImpl<T> implements IBaseService<T> {

    @Autowired
    private MyJpaRepository<T,String> myJpaRepository;

    private Specification<T> spec(Map<String, String[]> params)  {
        Collection<SearchFilter> filters = SearchFilter.parse(params).values();
        Class < T >  entityClass  =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
        Specification<T> sp = (Specification<T>) SearchFilter.spec(filters, entityClass);
        return sp;
    }

    @Override
    public T save(Object o) {
        Object o1= new Object();
       // myJpaRepository.
        return null;
    }

    @Override
    public T findOne(Serializable serializable) {
        return this.myJpaRepository.findOne(serializable.toString());
    }

    @Override
    public Page<T> findAll(Map<String, String[]> params, Pageable pageable) {
        Specification<T> sp=spec(params) ;
        Page<T> sy=this.myJpaRepository.findAll(sp,pageable);
        return sy;
    }

    @Override
    public boolean exists(Serializable serializable) {
        return myJpaRepository.exists(serializable.toString());
    }

    @Override
    public List<T> findAll() {
        return myJpaRepository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return this.myJpaRepository.findAll(sort);
    }

    @Override
    public Page findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List findAll(Iterable iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Serializable serializable) {
      this.myJpaRepository.delete(serializable.toString());
    }

    @Override
    public void delete(Object o) {
        //this.myJpaRepository.delete(T);
    }

    @Override
    public void delete(Iterable iterable) {
         this.myJpaRepository.delete(iterable);
    }

    @Override
    public void deleteAll() {
        this.myJpaRepository.deleteAll();
    }

    @Override
    public void flush() {
        this.myJpaRepository.flush();
    }

    @Override
    public void deleteInBatch(Iterable iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Object getOne(Serializable serializable) {
        return this.findOne(serializable);
    }

    @Override
    public List findAll(Example example, Sort sort) {
        return null;
    }

    @Override
    public List findAll(Example example) {
        return null;
    }

    @Override
    public T saveAndFlush(Object o) {
        return null;
    }

    @Override
    public List save(Iterable iterable) {
        return null;
    }

    @Override
    public Object findOne(Example example) {
        return null;
    }

    @Override
    public Page findAll(Example example, Pageable pageable) {
        return null;
    }

    @Override
    public long count(Example example) {
        return 0;
    }

    @Override
    public boolean exists(Example example) {
        return false;
    }

}
