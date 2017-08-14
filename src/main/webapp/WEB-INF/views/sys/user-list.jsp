<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fnx" uri="http://java.sun.com/jsp/jstl/functionsx"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="f" uri="http://www.jspxcms.com/tags/form"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<html>
<head>
    <title>user list</title>
</head>
<body>

<form action="" method="get" class="ls-page">
    <tags:search_params excludePage="true"/>
    <f:hidden name="queryNodeId" value="${queryNodeId}"/>
    <f:hidden name="queryNodeType" value="${queryNodeType}"/>
    <f:hidden name="queryInfoPermType" value="${queryInfoPermType}"/>
    <f:hidden id="queryStatus" name="queryStatus" value="${queryStatus}"/>
    <tags:pagination pagedList="${pagedList}"/>
</form>
</body>
</html>
