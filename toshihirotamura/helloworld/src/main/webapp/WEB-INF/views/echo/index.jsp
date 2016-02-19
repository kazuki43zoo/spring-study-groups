<!DOCTYPE html>
<html>
<head>
<title>Echo Application</title>
</head>
<body>
  <%-- タグライブラリを利用し、HTMLフォームを構築している。 modelAttribute 属性に、Controllerで用意したフォームオブジェクトの名前を指定する。 --%>
  <form:form modelAttribute="echoForm" action="${pageContext.request.contextPath}/echo/hello">
    <form:label path="name">Input Your Name:</form:label>
    <form:input path="name" />
    <input type="submit" />
  </form:form>
</body>
</html>