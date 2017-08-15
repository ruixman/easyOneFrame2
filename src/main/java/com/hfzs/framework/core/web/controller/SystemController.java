package com.hfzs.framework.core.web.controller;

import com.hfzs.common.util.PageDto;
import com.hfzs.framework.Constants;
import com.hfzs.framework.core.web.Servlets;
import com.hfzs.framework.domain.SysUser;
import com.hfzs.framework.service.impl.SysUserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("SpringJavaAutowiringInspection")
@Controller
@RequestMapping("/sys")
public class SystemController {

    @Autowired
    private SysUserServiceImpl sysUserService;

    @RequestMapping("/user/list")
    public ModelAndView userList(){
        return new ModelAndView("/sys/user-list2");
    }

    @ResponseBody
    @RequestMapping("/user/list.json")
    public Page<SysUser> userList(@RequestBody PageDto page,
          //  @PageableDefault(sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
                                 HttpServletRequest request){
Pageable pageable = new PageRequest(page.getPage(),page.getLimit(),Sort.Direction.DESC,page.getSort().getFields());
        Map<String, String[]> params = null;
//        Servlets.getParamValuesMap();
        Page<SysUser> pagedList = sysUserService.findAll(params, pageable);
        return pagedList;
    }


    @RequestMapping(value = "/user/{id:[0-9]+}")
    public ModelAndView views(@PathVariable Integer id, @RequestParam(defaultValue = "true") boolean isUpdate,
                      HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("/sys/user").addObject("id",id);
    }
}
