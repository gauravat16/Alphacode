<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>


<head>


<c:set var="path" value=" ${pageContext.request.contextPath}/Web" />
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<title>
<c:choose>
<c:when test="${param.header ==	1}">
${param.title}
</c:when>
<c:otherwise>
${title}
</c:otherwise>
</c:choose>



</title>
<link href="${path}/css/bootstrap.min.css" rel="stylesheet">
<link href="${path}/css/font-awesome.min.css" rel="stylesheet">
<link href="${path}/css/animate.min.css" rel="stylesheet">
<link href="${path}/css/lightbox.css" rel="stylesheet">
<link href="${path}/css/main.css" rel="stylesheet">
<link href="${path}/css/responsive.css" rel="stylesheet">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/highlight.js/7.3/highlight.min.js"></script>
<link
	href="//cdnjs.cloudflare.com/ajax/libs/highlight.js/7.3/styles/monokai.css"
	rel="stylesheet" />
<script>
	hljs.initHighlightingOnLoad();
</script>
<script type="text/javascript" src="${path}/js/gs_sortable.js"></script>


<!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="shortcut icon" href="/CodeSalad/Web/images/alphalogo.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="${path}/images/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="${path}/images/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="${path}/images/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="${path}/images/ico/apple-touch-icon-57-precomposed.png">
</head>
<!--/head-->

<body>
	<header id="header">
		<div class="container">
	
		</div>
		<div class="navbar navbar-inverse" role="banner">
			<div class="container">
				<div class="navbar-header">
					

					 <a
						href="/CodeSalad/Web/index.jsp">
							<h1 style="font-size: 60px; margin-top : -8px;">	&alpha;code</h1>
							</a>
					

				</div>
				<div class="collapse navbar-collapse">
					<ul class="nav navbar-nav navbar-right" >
						<li class="active"><a href="/CodeSalad/Web/index.jsp">Home</a></li>
						<li class="dropdown"><a href="#">Problems <i
								class="fa fa-angle-down"></i></a>
							<ul role="menu" class="sub-menu" style="width:150px;">
								<li><a href="${path}/NewProblem.jsp?title=New Problem&header=1">Add Problem</a></li>
								<li><a
									href="/CodeSalad/ProblemList?difficulty=B&isFromUser=false">Beginner</a></li>
								<li><a
									href="/CodeSalad/ProblemList?difficulty=E&isFromUser=false">Easy</a></li>
								<li><a
									href="/CodeSalad/ProblemList?difficulty=M&isFromUser=false">Medium</a></li>
								<li><a
									href="/CodeSalad/ProblemList?difficulty=H&isFromUser=false">Hard</a></li>
							</ul></li>
						<li class="dropdown"><a href="blog.html">Blog <i
								class="fa fa-angle-down"></i></a></li>

					<li class="dropdown" ><a href="#">Competitions<i
								class="fa fa-angle-down"></i></a>
								<ul role="menu" class="sub-menu" style="width:150px;">
								<li><a href="${path}/newCompetition.jsp">New Competition</a></li>
								<li><a href="/CodeSalad/CompetitionList?email=header">All Competitions</a></li>
								
								
							</ul>
								
											
								
								</li>
						
						
					
						
						
						
						<c:choose>
							
									<c:when test="${user.uname==null}">
									<li class="dropdown">
                     <a href="/CodeSalad/Web/LoginMain/loginmain.jsp" style="margin-top: 0px"> Guest|Login</a>
									</li>
									</c:when>
									
									<c:when test="${user.uname!=null}">
									
									<li class="dropdown">
									<a href="" style="padding-top: 11px;"> ${user.uname}  <img id="HeaderImage" src="${user.pic}" 
							alt="Error Loading Profile pic" style="margin-left: 5px">	 	</a> 
									   
									
									
									
												<c:choose>
					<c:when test="${user.pic==null}">
						<img src="${path}/images/nopic.png" id="HeaderImage" style="margin-left: 10px"	alt="No profile pic">



					</c:when>
					<c:otherwise>

						
								
							

					</c:otherwise>
				</c:choose>
									
									
							
											<ul role="menu" class="sub-menu" style="width: 90%">
												<li><a
													href="/CodeSalad/UserProfile?isFromOtherUser=false">Dashboard</a></li>
												<li><a href="#">Prefrences</a></li>
												<li><a href="/CodeSalad/Logout">Logout</a></li>

											</ul></li>

									</c:when>
								</c:choose>
								
								
						
						
						
						
						
						
						
						
						
						</li>
						
						
					</ul>
				</div>
				
			</div>
		</div>
	</header>
	<!--/#header-->