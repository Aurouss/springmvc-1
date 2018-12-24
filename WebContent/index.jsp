<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="springmvc/testPOJO" method="post">
		username:<input type="text" name="username"/>
		<br>
		password:<input type="password" name="password"/>
		<br>
		age:<input type="text" name="age"/>
		<br>
		email:<input type="text" name="email"/>
		<br>
		province:<input type="text" name="address.province"/>
		<br>
		city:<input type="text" name="address.city"/>
		<br>
		<input type="submit" value="submit"/>
	
	</form>
	<br>

	<a href="springmvc/testCookieValue">test CookieValue</a>
	<br>
	<a href="springmvc/testRequestHeader">test RequestHeader</a>
	<br>
	<a href="springmvc/testRequestParam?username='ywc'&age=24">test RequestParam</a>
	<br>

	<form action="springmvc/testREST/1" method="post">
		<input type="hidden" name="_method" value="PUT"/>
		<input type="submit" value="testREST-PUT"/>
	</form>
	<br>
	<form action="springmvc/testREST/1" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
		<input type="submit" value="testREST-DELETE"/>
	</form>
	<br>	
	<form action="springmvc/testREST/1" method="post">
		<input type="submit" value="testREST-POST"/>
	</form>
	<br>
	<a href="springmvc/testREST/1">testREST-GET</a>
	<br>
	<form action="springmvc/testMethod" method="post">
		<input type="submit" value="submit"/>
	</form>
	<br>
	<a href="springmvc/testPathVariable/101">testPathVariable</a>
	<br>
	<a href="springmvc/testAntPath/ywc/abc">testAntPath</a>
	<br>
	<a href="springmvc/testParamsAndHeaders?username='ywc'&age=11">testParamsAndHeaders</a>
	<br>
	<a href="springmvc/testRequestMapping">testRequestMapping</a>
	<br>
	<a href="helloword">Hello Word</a>
</body>
</html>