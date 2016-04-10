
<!DOCTYPE HTML>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="path" value="${pageContext.request.contextPath}/Web/LoginMain"/>
<html>
		<head>

		<title>CodeChow</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${path}/assets/css/main.css" />
		</head>
	<body>
		
  
		<!-- Header -->
			<header >
				<h1>CodeSalad</h1>
				<p>You have been logged out</p>
			</header>

		<!-- Signup Form -->
			<form id="signup-form" method="post" action="/CodeSalad/login">
				<input type="email" name="email" id="email" placeholder="Email Address" /><br>
				<input type="password" name="password" id="Password" placeholder="password" />
				<input type="submit" value="Log In" />
			</form>

	
		<!-- Footer -->
			<footer id="footer">
				<ul class="icons">
					<li><a href="#" class="icon fa-twitter"><span class="label">Twitter</span></a></li>
					<li><a href="#" class="icon fa-instagram"><span class="label">Instagram</span></a></li>
					<li><a href="#" class="icon fa-github"><span class="label">GitHub</span></a></li>
					<li><a href="#" class="icon fa-envelope-o"><span class="label">Email</span></a></li>
				</ul>
				<ul class="copyright">
					<li>&copy; Untitled.</li><li>Credits: <a href="http://html5up.net">HTML5 UP</a></li>
				</ul>
			</footer>

		<!-- Scripts -->
			<!--[if lte IE 8]><script src="assets/js/ie/respond.min.js"></script><![endif]-->
		<script  src="${path}/assets/js/main.js"></script>

	</body>
</html>