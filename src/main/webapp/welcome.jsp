<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RabbitMQ Testing</title>
</head>
<body>
<h1>Test RabbitMQ Messaging</h1>
<form action="/send" method="post">
	<h3>Sending</h3>
	<input type="text" id="message" name="message" value="" />
	<br/>
	<c:if test="${result != null}">	
		<p>${result}</p>
	</c:if>
	<input type="submit" value="Send" />
	<br/>
</form>
<hr/>
<form action="/consume" method="post">
	<h3>Consuming</h3>
	<input type="text" readonly="readonly" value="${message}" />
	<br/>
	<input type="submit" value="Consume" />
	<br/>
</form>
</body>
</html>