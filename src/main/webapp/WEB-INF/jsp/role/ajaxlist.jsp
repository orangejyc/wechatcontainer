<%@page import="org.orange.wechatcontainer.pojo.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../common/taglibs.jsp" %>

<html>
<head>
	<title><spring:message code="role.list.title" /></title>
	<%@ include file="../common/meta.jsp" %>
	
<script>
function queryAjax(){
   var reqUrl="role/";
   var name=document.queryForm.rolename.value;
   if(name==""){
	   alert("Pls input role name!!");
	   return false;
   }
   reqUrl=reqUrl+name;
   //var param=JSON.parse(document.form1.activity.value);
   $.postJSON(reqUrl, null, function(data) {
					
					$('#status').val(JSON.stringify(data));
	     });
}


</script>	
	
</head>

<body>
	<form id="queryForm" name="queryForm" style="display: inline;">
	<div class="queryPanel">
		<fieldset>
			<legend><spring:message code="role.search.title" /></legend>
			<table>
				<tr>	
					<td class="tdLabel"><spring:message code="role.search.rolename" /></td>		
					<td>
						<input value="Input Role name" id="rolename" name="rolename" maxlength="50"  class=""/>
					</td>
					
					
					
				</tr>	
				
			</table>
		</fieldset>
		<div class="handleControl">
			<input type="button" class="stdButton" style="width:80px" value="<spring:message code="role.list.query" />" onclick="queryAjax()"/>
			
		<div>
	</div>
	
	<div class="gridTable">
	
		Received message:
          
        <textarea rows="12" cols="90" id="status"></textarea>
	
		
	
		
	</div>
	</form>
</body>
</html>



