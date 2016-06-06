<!DOCTYPE html>
<html lang="en">
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="${comp.compName}" />
<%@ include file="/Web/Header.jsp"%>
<section id="page-breadcrumb">
	<div class="vertical-center sun">
		<div class="container">
			<div class="row">



				<div class="action">
					<div class="col-sm-12">
						<h1 class="title">${comp.compName}</h1>








					</div>
					
				</div>
			</div>
		</div>
	</div>
</section>
<form method="post"
	action="/CodeSalad/Competition?addProb=true&newComp=false&id=${comp.compId}">
	<c:choose>
		<c:when test="${comp.compAuthor == user.email}">
			<input type="submit" class="btn btn-sm btn-primary"
				value="Add Problem"></input>
		</c:when>
	</c:choose>

</form>
${enrolled }
<form method="post"
	action="/CodeSalad/Enroll?compid=${comp.compId}&email=${user.email}">

	<c:choose>
		<c:when test="${enrolled==0}">
			<input type="submit" class="btn btn-sm btn-primary" Value="Enroll"
				style="margin-left: 0; margin-top: -7%"></input>
		</c:when>
		<c:otherwise>
			<div style="margin-left: 0; margin-top: -2.5%; font-size: 15px">
				<i class="fa fa-check" aria-hidden="true"></i>Enrolled
			</div>
		</c:otherwise>
	</c:choose>


</form>

<div class="col-md-6 padding">${comp.compText}</div>


<div class="col-md-6">

	<ul id="tab1" class="nav nav-tabs">
		<c:forEach var="problem" items="${plist}" varStatus="index">

			<li class="active"><a href="#tab${index}-item${index}"
				data-toggle="tab">${problem.problemName}</a></li>
		</c:forEach>
	</ul>


	<div class="tab-content">
		<c:forEach var="problem" items="${plist}" varStatus="index">

			<div class="tab-pane fade active in" id="tab${index}-item${index}">
				<p>${ }</p>
			</div>
		</c:forEach>
	</div>



</div>

<%@ include file="/Web/footer.jsp"%>

<script type="${path}/text/javascript" src="js/jquery.js"></script>
<script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
<script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
<script type="${path}/text/javascript" src="js/wow.min.js"></script>
<script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>


</body>
</html>
