
<!DOCTYPE html>
<html lang="en">
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="${profile.uname}" />

<%@ include file="/Web/Header.jsp"%>



<c:set var="path" value=" ${pageContext.request.contextPath}/Web" />
<section id="page-breadcrumb">
	<div class="vertical-center sun">
		<div class="container">
			<div class="row">
				<div class="action">
					<div class="col-sm-12">
						<h1 class="title">Dashboard</h1>
						
						
						

					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/#action-->
 <script type="text/javascript">

var TSort_Data = new Array ('tableSection', 's', 's','i','i','d','s');
var TSort_Initial = "4D";
tsRegister();

</script>



<section id="portfolio-information" >

	<div class="container">
		<div class="row">
		
		
			<c:choose>
				<c:when
					test="${(isFromOtherUser==true) and (from != profile.email) }">
					
					<div class="collapse navbar-collapse" style="margin-top: 130px;">
					</div>
					
					</c:when>
					<c:otherwise>
					<header id="header">
					<div class="navbar navbar-inverse" role="banner">
			
			<div class="collapse navbar-collapse" style="margin-top: -130px;">
					<ul class="nav navbar-nav navbar-right">
			<li class="dropdown" style="width: 150px"><a href="#"><b style="font-size: 13px">Things to do</b> <i
								class="fa fa-angle-down"></i></a>
							<ul role="menu" class="sub-menu" style="width: 150px">
								<li><a href="${path}/NewProblem.jsp">Add Problem</a></li>
								<li><a
								href="/CodeSalad/ProblemList?isFromUser=true&userMail=${profile.email}">Your problems</a></li>
							</ul></li>
			</ul>
			</div>
			</div>
			</header>
					</c:otherwise>
				
			</c:choose>
		
		
		<div class="project-name overflow" style=" margin-bottom: -100px;">
				</div>
			<div class="col-sm-4" style="margin-top: 2%;">

				<c:choose>
					<c:when test="${profile.pic==null}">
						<img src="${path}/images/nopic.png" class="img-responsive"
							alt="No profile pic">



					</c:when>
					<c:otherwise>
					
					<font color="red" size="4px" style="padding-left: 8%">${sizeExceeded}</font>

						<img id="roundImage" src="${profile.pic}" class="img-responsive"
							alt="Error Loading Profile pic" height="300px" width="300px">
							

					</c:otherwise>
				</c:choose>

				<c:choose>
					<c:when
						test="${(isFromOtherUser==true) and (from != profile.email) }"></c:when>
					<c:otherwise>
						<form action="/CodeSalad/EditProfile"
							enctype="multipart/form-data" method="post">
								Upload new Picture <input type="file" name="pic"> <input
								type="submit" value="Upload">
						</form>
					</c:otherwise>
				</c:choose>



			</div>
			<div class="col-sm-8">
			
				
				<div class="project-info overflow">
					<h3>Problems Solved</h3>
					<c:choose>
						<c:when test="${probSolved[0].probid==null}">
					You haven't solved any problems</c:when>
						<c:otherwise>



							<div>
								<div style=" margin-right: ;">
									<table class="tableSection" id="tableSection">
										<thead>
											<tr>
												<th><span class="text"> Problem</span></th>
												<th><span class="text"> Status </span></th>
												<th><span class="text"> Time </span></th>
												<th><span class="text"> Memory </span></th>
												<th><span class="text"> Date </span></th>
												<th><span class="text"> Language </span></th>
												

											</tr>
										</thead>



										<tbody>
											<c:forEach var="solution" items="${probSolved}"
												varStatus="index">
												<tr>
													<td><a
														href="/CodeSalad/ViewProblem?pid=${solution.probid}">${solution.problemName}</a></td>
													<td>${solution.status}</td>
													<td>${solution.execTime}</td>
													<td>${solution.execMem }</td>
													<td>${solution.submittedOn}</td>
													<td>${solution.lang}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</c:otherwise>
					</c:choose>
				</div>

			</div>








		</div>
	</div>
</section>

<%@ include file="/Web/footer.jsp"%>


<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/lightbox.min.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
