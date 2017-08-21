/**
 * Created by xurui on 2017/8/20.
 */
package com.hfzs.framework.core;

import com.hfzs.framework.domain.dto.PageDto;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

public class BaseAction {
    protected Pageable genPageAble(PageDto pageDto){
        Sort.Direction o1=Sort.Direction.DESC;
        switch (pageDto.getAsc()){
            case "desc":
                o1=Sort.Direction.DESC;
                break;
            case "asc":
                o1= Sort.Direction.ASC;
                break;
            default:
                o1= Sort.Direction.DESC;
                break;

        }

        Pageable pageable;
        pageable = new PageRequest(pageDto.getPage(),pageDto.getLimit(),
                o1,pageDto.getSort());

        return pageable;
    }

}


