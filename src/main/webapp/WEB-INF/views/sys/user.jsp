<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<div class="form-group">
    <label class="control-label col-md-3 ">会员编号</label>
    <div class="col-md-9">
        <div class="input-group">
            <input type="text" name="id" value="${user.id}" size="30" class="form-control" readonly="readonly" />
        </div>
        <!-- /input-group -->
        <!-- /input-group -->
    </div>
</div>
<div class="form-group">
    <label class="col-md-3 control-label">姓名</label>
    <div class="col-md-9">
        <div class="input-group">
            <input type="text" name="name" value="${user.name}" size="30"  class="form-control" readonly="readonly" />
        </div>
    </div>
</div>

<div class="form-group">
    <label class="control-label col-md-3 ">注册时间</label>
    <div class="col-md-9">
        <div class="input-group">
            <input type="text" name="regTime" value="${user.createTime}" size="30"  class="form-control" readonly="readonly" />
        </div>
    </div>

</div>
