<head>


<c:set var="path" 	value=" ${pageContext.request.contextPath}/Web"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Home | Triangle</title>
    <link href="${path}/css/bootstrap.min.css" rel="stylesheet">
    <link href="${path}/css/font-awesome.min.css" rel="stylesheet">
    <link href="${path}/css/animate.min.css" rel="stylesheet"> 
    <link href="${path}/css/lightbox.css" rel="stylesheet"> 
	<link href="${path}/css/main.css" rel="stylesheet">
	<link href="${path}/css/responsive.css" rel="stylesheet">

    <!--[if lt IE 9]>
	    <script src="js/html5shiv.js"></script>
	    <script src="js/respond.min.js"></script>
    <![endif]-->       
    <link rel="shortcut icon" href="images/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="${path}/images/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="${path}/images/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="${path}/images/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="${path}/images/ico/apple-touch-icon-57-precomposed.png">
</head><!--/head-->

<body>
	<header id="header">      
        <div class="container">
            <div class="row">
                <div class="col-sm-12 overflow">
                   <div class="social-icons pull-right">
                        <ul class="nav nav-pills">
                           ${user.uname}|<a href="/CodeSalad/Logout">Logout</a>
                           
                          
                        </ul>
                    </div> 
                </div>
             </div>
        </div>
        <div class="navbar navbar-inverse" role="banner">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>

                    <a class="navbar-brand" href="index.html">
                    	<h1><img src="${path}/images/logo.png" alt="logo"></h1>
                    </a>
                    
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li class="active"><a href="/CodeSalad/HomeRefresh?user=${user}">Home</a></li>
                        <li class="dropdown"><a href="#">Problems <i class="fa fa-angle-down"></i></a>
                            <ul role="menu" class="sub-menu">
                            <li><a href="${path}/NewProblem.jsp">Add Problem</a></li>
                                <li><a href="${path}/aboutus.html">Beginner</a></li>
                                <li><a href="${path}/aboutus2.html">Easy</a></li>
                                <li><a href="${path}/service.html">Medium</a></li>
                                <li><a href="${path}/pricing.html">Hard</a></li>
                               </ul>
                        </li>                    
                        <li class="dropdown"><a href="blog.html">Blog <i class="fa fa-angle-down"></i></a>
                            
                        </li>
                                              
                        <li><a href="${path}/shortcodes.html ">Competitions</a></li>                    
                    </ul>
                </div>
                <div class="search">
                    <form role="form">
                        <i class="fa fa-search"></i>
                        <div class="field-toggle">
                            <input type="text" class="search-form" autocomplete="off" placeholder="Search">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </header>
    <!--/#header-->
