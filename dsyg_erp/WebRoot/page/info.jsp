<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="/WEB-INF/c.tld" %>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
<script type="text/javascript">
	function logout() {
		window.parent.location.href = '<c:url value="/login/logoutAction.action"></c:url>';
	}
	
	function goHome() {
		var urlList = parent.window.frames['leftFrame'].document.getElementsByName("urlList");
		for(var i = 0; i < urlList.length; i++) {
			urlList[i].style.color = "";
		}
		parent.window.frames['mainFrame'].location = '<%=request.getContextPath()%>/frame/showMainFrameAction.action';
		//window.parent.location.href = '<c:url value="/home/showManageHomeAction.action"></c:url>';
	}
</script>
<div class="user"><span>用户：<%=session.getAttribute("user_name")%></span><span>登录时间：<%=session.getAttribute("login_time")%></span></div>