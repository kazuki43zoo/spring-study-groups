<!DOCTYPE html>
<html>
<head>
<title>Echo Application</title>
</head>
<body>
  <p>
    Hello <c:out value="${name}" /> <%-- XSS対策。f:h() でも可 --%>
  </p>
</body>
</html>