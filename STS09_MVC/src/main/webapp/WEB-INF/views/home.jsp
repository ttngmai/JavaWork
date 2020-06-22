<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<img src="<%= request.getContextPath() %>/myRes/img/jsp.png"/>

<img src="/sts09_mvc/resources/img/jsp.png"/>
<img src="<%= request.getContextPath() %>/resources/img/jsp.png"/>
<img src="${pageContext.request.contextPath }/resources/img/jsp.png"/>
</body>
</html>
