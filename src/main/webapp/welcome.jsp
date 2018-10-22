<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>RabbitMQ Testing</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<h1>Test RabbitMQ Messaging</h1>
<form action="/send" method="post">
	<h3>Sending</h3>
	Queue Name:
	<br/>
	<br/>
	<select id="queueNamesList" name="queueName" onchange="javascript:queueHint.showHint(this.value)">
		<c:forEach items="${queueNamesList}" var="queueName">	
			<option><c:out value="${queueName}"/></option>
		</c:forEach>
	</select>
	<span id="queueHint"></span>
	<br/>
	<br/>
	# Times:
	<br/>
	<select id="times" name="times">
		<c:forEach var="number" begin="1" end="10">	
			<option><c:out value="${number}"/></option>
		</c:forEach>
	</select>
	<br/>
	<br/>
	Message:
	<br/>
	<input type="text" id="message" name="message" value="" />
	<br/>
	<br/>
	<c:if test="${senderResult != null}">	
		<p>${senderResult}</p>
	</c:if>
	<input type="submit" value="Send" />
	<br/>
</form>
<hr/>
<form action="/consume" method="post">
	<h3>Consuming</h3>
	Message:
	<br/>
	<input type="text" readonly="readonly" value="${consumedMessage}" />
	<br/>
	<br/>
	<input type="submit" value="Consume" />
	<br/>
</form>
</body>
</html>