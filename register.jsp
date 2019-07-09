<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
</head>
<body>
<form action="register.lti" method="post" enctype="multipart/form-data">
Enter your name : <input type="text" name="name"/><br/>
Enter age : <input type="number" name="age"/><br/>
Enter your emailId : <input type="email" name="email"/><br/>
Enter your city : <input type="text" name="city"/><br/>
upload your profile Pic : <input type="file" name="profilePic"/><br/>

<button type="submit">Register Now</button>
</form>
</body>
</html>