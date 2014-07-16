<%@page import="org.orange.wechatcontainer.pojo.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="../common/taglibs.jsp" %>

<html>
<head>
	<title><spring:message code="role.list.title" /></title>
	<%@ include file="../common/meta.jsp" %>
	<link href="<c:url value="/widgets/simpletable/simpletable.css"/>" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<c:url value="/widgets/simpletable/simpletable.js"/>"></script>
	
	<script type="text/javascript" >
		$(document).ready(function() {
			//
			window.simpleTable = new SimpleTable('queryForm',${page.thisPageNumber},${page.pageSize},'${pageRequest.sortColumns}');
		});
	</script>
</head>

<body>
	<form id="queryForm" name="queryForm" action="<c:url value="/role/list"/>" method="get" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend><spring:message code="role.search.title" /></legend>
			<table>
				<tr>	
					<td class="tdLabel"><spring:message code="role.search.rolename" /></td>		
					<td>
						<input value="${query.roleInfo.name}" id="roleInfo.name" name="roleInfo.name" maxlength="50"  class=""/>
					</td>
					
					
					
				</tr>	
				
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="<spring:message code="role.list.query" />" onclick="getReferenceForm(this).action='${ctx}/role/list'"/>
			<!--  input type="submit" class="stdButton" style="width:80px" value="<spring:message code="user.list.add" />" onclick="getReferenceForm(this).action='${ctx}/user/create'"/>
			<input type="button" class="stdButton" style="width:90px" value="<spring:message code="user.list.del" />" onclick="batchDelete('${ctx}/user/delete','items',document.forms.queryForm)"/-->
		<div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<spring:message code="role.list.title" />
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- for th add sortColumn,new SimpleTable('sortColumns') will add auto sort function for tableHeader -->
				<th sortColumn="u.username" ><%=UserInfo.ALIAS_USERNAME%></th>
				<th sortColumn="u.password" ><%=UserInfo.ALIAS_PASSWORD%></th>
				<th sortColumn="u.birth_date" ><%=UserInfo.ALIAS_BIRTH_DATE%></th>
				<th sortColumn="u.sex" ><%=UserInfo.ALIAS_SEX%></th>
				<th sortColumn="u.age" ><%=UserInfo.ALIAS_AGE%></th>
	            <th sortColumn="r.name"><spring:message code="role.search.rolename" /></th>
	
				<!-- th><spring:message code="user.list.op" /></th-->
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="userId=${item.userInfo.userId}&"></td>
				
				<td><c:out value='${item.userInfo.username}'/>&nbsp;</td>
				<td><c:out value='${item.userInfo.password}'/>&nbsp;</td>
				<td><c:out value='${item.userInfo.birthDateString}'/>&nbsp;</td>
				<td><c:out value='${item.userInfo.sex}'/>&nbsp;</td>
				<td><c:out value='${item.userInfo.age}'/>&nbsp;</td>
				<td><c:out value='${item.roleInfo.name}'/>&nbsp;</td>
				
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<spring:message code="role.list.title" />
		</simpletable:pageToolbar>
	</div>
	</form>
</body>
</html>



