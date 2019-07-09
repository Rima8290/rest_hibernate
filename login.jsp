<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
<form method="post" action="login.lti">
Enter User name : <input type="text" name="username"/><br/>
Enter Password : <input type="password" name="password"/><br/>
<button type="submit">Login</button>
</form>
<h1>${message}</h1>
</body>
</html>