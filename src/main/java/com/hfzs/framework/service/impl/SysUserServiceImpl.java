package com.hfzs.framework.service.impl;

import com.hfzs.framework.domain.SearchFilter;
import com.hfzs.framework.domain.SysUser;
import com.hfzs.framework.repository.SysUserDao;
import com.hfzs.framework.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class SysUserServiceImpl implements ISysUserService {


    @Autowired
    private SysUserDao dao;


    @Override
    public Page<SysUser> findAll(Map<String, String[]> params, Pageable pageable) {
        //return dao.findAll(spec(params), pageable);

       String[] nickname=params.get("nickName");

       final String name=nickname[0];

        //使用spec进行封装，其实不如直接使用toPredicate
        Specification querySpecifi = new Specification<SysUser>() {
            @Override
            public Predicate toPredicate(Root<SysUser> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                List<Predicate> predicates = new ArrayList<>();

                if(null != name){
                    predicates.add(criteriaBuilder.like(root.<String>get("name"), "%"+name+"%"));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
        return dao.findAll(querySpecifi,pageable);
    }

    private Specification<SysUser> spec(Map<String, String[]> params) {
        Collection<SearchFilter> filters = SearchFilter.parse(params).values();
        Specification<SysUser> sp = SearchFilter.spec(filters, SysUser.class);
        return sp;
    }
}
