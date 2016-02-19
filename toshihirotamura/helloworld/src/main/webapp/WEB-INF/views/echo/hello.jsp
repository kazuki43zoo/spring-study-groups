<!DOCTYPE html>
<html>
<head>
<title>Echo Application</title>
</head>
<body>
  <p>
    こんにちは <c:out value="${name}" /> さん。<%-- c.outはXSS対策。f:h()でも可 --%>
  </p>
</body>
</html>