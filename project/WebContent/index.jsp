<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
		 <div class="navbar">	
			
				<a class="active" href="index.html">Home</a>
				<a href="pages/issue.html">Issue</a>
				<a style="float: right" href="pages/register.html">Login/Register</a>
			
		</div>		
		<div class="login-page">
  			<div class="form">
			    <form action="login" class="register-form">
			      <input type="text" placeholder="name"/>
			      <input type="password" placeholder="password"/>
			      <input type="text" placeholder="email address"/>
			      <button>create</button>
			      <p class="message">Already registered? <a href="pages/dashboard.html">Sign In</a></p>
			    </form>
			    <form action="login" class="login-form" method="get">
			      <input type="text" placeholder="username" name="username"/>
			      <input type="password" placeholder="password" name="password"/>
			      <button type="submit">login</button>
			      <p class="message">Not registered? <a href="pages/dashboard.html">Create an account</a></p>
			      <p class="message" style="color:red;" name="errorMsg">${errorMsg}</p>
			    </form>
  			</div>
		</div>

</body>
</html>