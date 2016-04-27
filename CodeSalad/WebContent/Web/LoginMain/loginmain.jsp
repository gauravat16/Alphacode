<!DOCTYPE html>
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>AlphaCode|Login</title>




<link rel="stylesheet" href="css/style.css">

<script src="checks.js" type="text/javascript"></script>


</head>

<body onload="document.registration.userid.focus();">

	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			
			<form class="form" method="post" action="/CodeSalad/login">


				<input type="email" placeholder="Email" name="email" id="email">
				<input type="password" placeholder="Password" name="password"
					id="Password">
				<button type="submit" id="login-button">Login</button>
				<p style="margin-right: 33%;">
					<a href="/CodeSalad/Web/Register.jsp">Sign Up!</a>
				</p>

			</form>











		</div>

		<ul class="bg-bubbles">
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<div style="padding: 0% 2%;">
				<font size="36" style>&alpha;code</font>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
		</ul>
	</div>





</body>
</html>
