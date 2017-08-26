package com.hfzs.framework.core;

import com.hfzs.framework.core.web.orm.MyJpaRepository;
import com.hfzs.framework.domain.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**基础服务实现类：封闭基础的方法，可传泛型参数
 * @see com.hfzs.framework.core.IBaseService
 * Created by xurui on 2017/8/20.
 */
public class BaseServiceImpl<T> implements IBaseService<T>{

    @Autowired
    private MyJpaRepository<T,String> myJpaRepository;

    private Specification<T> spec(Map<String, String[]> params)  {
        Collection<SearchFilter> filters = SearchFilter.parse(params).values();
        Class < T >  entityClass  =  (Class < T > ) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[ 0 ];
        Specification<T> sp = (Specification<T>) SearchFilter.spec(filters, entityClass);
        return sp;
    }

    @Override
    public Page<T> findAll(Map<String, String[]> params, Pageable pageable) {
        Specification<T> sp=spec(params) ;
        return this.myJpaRepository.findAll(sp,pageable);
        //return sy;
    }

    @Override
    public List<T> findAll() {
        return this.myJpaRepository.findAll();
    }

    @Override
    public List<T> findAll(Sort sort) {
        return this.findAll(sort);
    }

    @Override
    public Page<T> findAll(Pageable pageable) {
        return this.findAll(pageable);
    }

    @Override
    public List<T> findAll(Iterable<String> iterable) {
        return this.myJpaRepository.findAll(iterable);
    }

    @Override
    public long count() {
        return this.myJpaRepository.count();
    }

    @Transactional
    @Override
    public void delete(String s) {
       this.myJpaRepository.delete(s);
    }

    @Override
    public void delete(T t) {
       this.myJpaRepository.delete(t);
    }

    @Override
    public void delete(Iterable<? extends T> iterable) {
        this.myJpaRepository.delete(iterable);
    }

    @Override
    public void deleteAll() {
        this.myJpaRepository.deleteAll();

    }

    @Override
    @Transactional
    public <S extends T> S save(S s) {
        return this.myJpaRepository.save(s);
    }

    @Override
    public <S extends T> List<S> save(Iterable<S> iterable) {
        return this.myJpaRepository.save(iterable);
    }

    @Override
    public T findOne(String s) {
        return this.myJpaRepository.findOne(s);
    }

    @Override
    public boolean exists(String s) {
        return this.myJpaRepository.exists(s);
    }

    @Override
    public void flush() {
        this.myJpaRepository.flush();
    }

    @Override
    public <S extends T> S saveAndFlush(S s) {
        return this.myJpaRepository.saveAndFlush(s);
    }

    @Override
    public void deleteInBatch(Iterable<T> iterable) {
        this.myJpaRepository.deleteInBatch(iterable);
    }

    @Override
    public void deleteAllInBatch() {
        this.myJpaRepository.deleteAllInBatch();
    }

    @Override
    public T getOne(String s) {
        return this.myJpaRepository.getOne(s);
    }

    @Override
    public <S extends T> S findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends T> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends T> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends T> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends T> boolean exists(Example<S> example) {
        return false;
    }

}
