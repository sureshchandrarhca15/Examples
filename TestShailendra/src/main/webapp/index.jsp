
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<body>
	<h1>Login Page</h1>
	<center>
		<form action="Simple" method="post">
			<br />Name:<input type="text" name="username"/> 
			<input type="submit" value="Submit">
		</form>
	</center>
	<%= request.getAttribute("Name")
	%>
	<br />
	<br />
	<%= request.getAttribute("Module")
	%>
</body>
</html>

