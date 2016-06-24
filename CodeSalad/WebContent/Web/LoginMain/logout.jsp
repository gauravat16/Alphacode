<!DOCTYPE html>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<html>
<head>
<meta charset="UTF-8">
<title>AlphaCode|Login</title>
<c:set var="path" value=" ${pageContext.request.contextPath}/Web" />



<link rel="stylesheet" href="${path}/LoginMain/css/style.css">


<script src="checks.js" type="${path}/LoginMain/text/javascript"></script>


</head>



<body onload="document.registration.userid.focus();">

	<div class="wrapper">
		<div class="container">
			<h1>Welcome</h1>
			
			<form class="form" method="post" action="/CodeSalad/login">
<c:choose>
<c:when test = "${isNotRegistered==true}">

<h3 style="color: red;">Check your email or password.</h3>

</c:when>
<c:when test="${isLoggedout==true}">
<h3 style="color: green;">You have been logged out</h3>
</c:when>
</c:choose>

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
