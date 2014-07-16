<%@page import="org.orange.wechatcontainer.pojo.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/simpletable" prefix="simpletable"%>
<%@ include file="../common/taglibs.jsp" %>

<html>
<head>
	<title><spring:message code="user.list.title" /></title>
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
	<form id="queryForm" name="queryForm" action="<c:url value="/user/list"/>" method="get" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend><spring:message code="user.search.title" /></legend>
			<table>
				<tr>	
					<td class="tdLabel"><%=UserInfo.ALIAS_USERNAME%></td>		
					<td>
						<input value="${query.username}" id="username" name="username" maxlength="50"  class=""/>
					</td>
					<td class="tdLabel"><%=UserInfo.ALIAS_PASSWORD%></td>		
					<td>
						<input value="${query.password}" id="password" name="password" maxlength="50"  class=""/>
					</td>
					<td class="tdLabel"><%=UserInfo.ALIAS_BIRTH_DATE%></td>		
					<td>
						<input value="<fmt:formatDate value='${query.birthBegin}' pattern='<%=UserInfo.FORMAT_BIRTH_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=UserInfo.FORMAT_BIRTH_DATE%>'})" id="birthDateBegin" name="birthDateBegin"   />
						<input value="<fmt:formatDate value='${query.birthEnd}' pattern='<%=UserInfo.FORMAT_BIRTH_DATE%>'/>" onclick="WdatePicker({dateFmt:'<%=UserInfo.FORMAT_BIRTH_DATE%>'})" id="birthDateEnd" name="birthDateEnd"   />
					</td>
					<td class="tdLabel"><%=UserInfo.ALIAS_SEX%></td>		
					<td>
						<input value="${query.sex}" id="sex" name="sex" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
				<tr>	
					<td class="tdLabel"><%=UserInfo.ALIAS_AGE%></td>		
					<td>
						<input value="${query.age}" id="age" name="age" maxlength="10"  class="validate-integer max-value-2147483647"/>
					</td>
				</tr>	
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="submit" class="stdButton" style="width:80px" value="<spring:message code="user.list.query" />" onclick="getReferenceForm(this).action='${ctx}/user/list'"/>
			<input type="submit" class="stdButton" style="width:80px" value="<spring:message code="user.list.add" />" onclick="getReferenceForm(this).action='${ctx}/user/create'"/>
			<input type="button" class="stdButton" style="width:90px" value="<spring:message code="user.list.del" />" onclick="batchDelete('${ctx}/user/delete','items',document.forms.queryForm)"/>
		<div>
	</div>
	
	<div class="gridTable">
	
		<simpletable:pageToolbar page="${page}">
		<spring:message code="user.list.title" />
		</simpletable:pageToolbar>
	
		<table width="100%"  border="0" cellspacing="0" class="gridBody">
		  <thead>
			  
			  <tr>
				<th style="width:1px;"> </th>
				<th style="width:1px;"><input type="checkbox" onclick="setAllCheckboxState('items',this.checked)"></th>
				
				<!-- for th add sortColumn,new SimpleTable('sortColumns') will add auto sort function for tableHeader -->
				<th sortColumn="username" ><%=UserInfo.ALIAS_USERNAME%></th>
				<th sortColumn="password" ><%=UserInfo.ALIAS_PASSWORD%></th>
				<th sortColumn="birth_date" ><%=UserInfo.ALIAS_BIRTH_DATE%></th>
				<th sortColumn="sex" ><%=UserInfo.ALIAS_SEX%></th>
				<th sortColumn="age" ><%=UserInfo.ALIAS_AGE%></th>
	
				<th><spring:message code="user.list.op" /></th>
			  </tr>
			  
		  </thead>
		  <tbody>
		  	  <c:forEach items="${page.result}" var="item" varStatus="status">
		  	  
			  <tr class="${status.count % 2 == 0 ? 'odd' : 'even'}">
				<td>${page.thisPageFirstElementNumber + status.index}</td>
				<td><input type="checkbox" name="items" value="userId=${item.userId}&"></td>
				
				<td><c:out value='${item.username}'/>&nbsp;</td>
				<td><c:out value='${item.password}'/>&nbsp;</td>
				<td><c:out value='${item.birthDateString}'/>&nbsp;</td>
				<td><c:out value='${item.sex}'/>&nbsp;</td>
				<td><c:out value='${item.age}'/>&nbsp;</td>
				<td>
					<a href="${ctx}/user/show/${item.userId}"><spring:message code="user.list.show" /></a>&nbsp;&nbsp;&nbsp;
					<a href="${ctx}/user/edit/${item.userId}"><spring:message code="user.list.edit" /></a>
				</td>
			  </tr>
			  
		  	  </c:forEach>
		  </tbody>
		</table>
	
		<simpletable:pageToolbar page="${page}">
		<spring:message code="user.list.title" />
		</simpletable:pageToolbar>
	</div>
	</form>
</body>
</html>



