<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../common/taglibs.jsp" %>

<html>
<head>
	<title><spring:message code="user.create.title" /></title>
	<%@ include file="../common/meta.jsp" %>
</head>

<body>
	<form:form action="${ctx}/user/save" method="post" commandName="userInfo">
		<input id="submitButton" name="submitButton" type="submit" value="<spring:message code="user.create.submit" />" />
		<input type="button" value="<spring:message code="user.create.backtolist" />" onclick="window.location='${ctx}/user/list'"/>
		<input type="button" value="<spring:message code="user.create.back" />" onclick="history.back();"/>
		
		<table class="formTable">
		<%@ include file="form_include.jsp" %>
		</table>
	</form:form>
	
	<script>
		
		new Validation(document.forms[0],{onSubmit:true,onFormValidate : function(result,form) {
			var finalResult = result;
			
			return disableSubmit(finalResult,'submitButton');
		}});
	</script>
</body>
</html>

