<!DOCTYPE html>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>

<html lang="en">


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

    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                        <center>    <h1 class="title">Register Here</h1>
                            <p>Stay close</p></center>
                        </div>                        
                    </div>
                </div>
            </div>
        </div>
   </section>
    <!--/#action--> 
<script type="text/javascript">
    function checkPass()
{
    //Store the password field objects into variables ...
    var pass1 = document.getElementById('pass1');
    var pass2 = document.getElementById('pass2');
    //Store the Confimation Message Object ...
    var message = document.getElementById('confirmMessage');
    //Set the colors we will be using ...
    var goodColor = "#66cc66";
    var badColor = "#ff6666";
    //Compare the values in the password field 
    //and the confirmation field
    if(pass1.value == pass2.value){
        //The passwords match. 
        //Set the color to the good color and inform
        //the user that they have entered the correct password 
        pass2.style.backgroundColor = goodColor;
        message.style.color = goodColor;
        message.innerHTML = "Passwords Match!"
    }else{
        //The passwords do not match.
        //Set the color to the bad color and
        //notify the user.
        pass2.style.backgroundColor = badColor;
        message.style.color = badColor;
        message.innerHTML = "Passwords Do Not Match!"
    }
}  
  </script>>
  
             
        <div id="wrap" class="col-sm-4">
  
      
                    <div  class="contact-form bottom" >
                       
                        <form id="main-contact-form" name="contact-form" method="post" action="/CodeSalad/Register">
                            
                            <br>
                            <div  class="form-group">
                                <input type="text" name="name" class="form-control" required="required" placeholder="Name">
                            </div>
                            
                            <div class="form-group">
                                <input type="email" name="email" class="form-control" required="required" placeholder="Email Id">
                            </div>
                             <div class="form-group">
                                <input type="password" name="password" id="pass1" class="form-control" required="required" placeholder="Create Password">
                            </div>
                             <div class="form-group">
                                <input type="password" name="password" id="pass2" class="form-control" required="required" placeholder="Confirm Password" onkeyup="checkPass(); return false;">
                            </div>
                                               
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-submit" value="Submit">
                                       </div>

                        </form>
                    </div>
                </div>
   
   
                <div class="col-sm-12">
                    <div class="copyright-text text-center">
                        <p>&copy; Your Company 2016. All Rights Reserved.</p>
                        <p>Crafted by <a target="_blank" href="http://designscrazed.org/"></a></p>
                    </div>
                </div>
                   

    <!--/#footer-->

 
</body>
</html>