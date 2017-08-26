package com.hfzs.framework.core;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

/**基础服务类接口，所有的服务接口类需要继承其接口
 * Created by xurui on 2017/8/20.
 */
public interface IBaseService<T> extends JpaRepository<T,String>{

   /**
    * 公用分页数据类
    * @param params ：Map[key,value[]]: key的方式为 Opera_field;
    *               value: 字符串数组，只有Opera 是In的方式，数组才真正使用，否则只使String[0}
    * @param pageable  :分页参数：封闭pagesize,limit等。
    * @return 分页数据列表
    */
   public Page<T> findAll(Map<String, String[]> params, Pageable pageable);

}
