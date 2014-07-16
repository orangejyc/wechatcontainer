<%@page import="org.orange.wechatcontainer.pojo.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common/taglibs.jsp" %>

<html>
<head>
	<title><spring:message code="user.show.title" /></title>
	<%@ include file="../common/meta.jsp" %>
</head>

<body>
	<form action="/user/list" method="post">
		<input type="button" value="<spring:message code="user.create.backtolist" />" onclick="window.location='${ctx}/user/list'"/>
		<input type="button" value="<spring:message code="user.create.back" />" onclick="history.back();"/>
		
		<input type="hidden" id="userId" name="userId" value="${userInfo.userId}"/>
	
		<table class="formTable">
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_USERNAME%></td>	
				<td><c:out value='${userInfo.username}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_PASSWORD%></td>	
				<td><c:out value='${userInfo.password}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_BIRTH_DATE%></td>	
				<td><c:out value='${userInfo.birthDateString}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_SEX%></td>	
				<td><c:out value='${userInfo.sex}'/></td>
			</tr>
			<tr>	
				<td class="tdLabel"><%=UserInfo.ALIAS_AGE%></td>	
				<td><c:out value='${userInfo.age}'/></td>
			</tr>
		</table>
	</form>
	</body>
</html>