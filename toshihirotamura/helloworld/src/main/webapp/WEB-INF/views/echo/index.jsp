<!DOCTYPE html>
<html>
<head>
<title>Echo Application</title>
</head>
<body>
	<%-- modelAttribute属性に、Controllerで用意したフォームオブジェクトの名前を指定する。POSTの時はmethod属性省略可 --%>
	<form:form modelAttribute="echoForm"
		action="${pageContext.request.contextPath}/echo/hello">
		<form:label path="name">Input Your Name:</form:label>
		<form:input path="name" />
		<form:errors path="name" cssStyle="color:red" /> <%-- エラー表示用 --%>
		<input type="submit" />
	</form:form>
</body>
</html>