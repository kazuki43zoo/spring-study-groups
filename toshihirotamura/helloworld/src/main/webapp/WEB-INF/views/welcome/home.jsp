<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div id="wrapper">
		<h1>Hello world!</h1>
		<%--	
		前述の「Controllerの説明(6)」でModelに設定したオブジェクト(serverTime)は、HttpServletRequestに格納される。
		そのため、JSPで${serverTime}と記述することで、Controllerで設定した値を画面に出力することができる。
		ただし、${XXX}の記述は、XSS対象になる可能性があるので、文字列を出力する場合はHTMLエスケープする必要がある。
		--%>
		<p>The time on the server is ${serverTime}.</p>
	</div>
</body>
</html>
