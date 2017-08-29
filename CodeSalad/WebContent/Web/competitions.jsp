<!DOCTYPE html>
<html lang="en">
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="${problem.problemName}" />
<%@ include file="/Web/Header.jsp"%>
<section id="page-breadcrumb">
	<div class="vertical-center sun">
		<div class="container">
			<div class="row">
				<div class="action">
					<div class="col-sm-12"></div>
				</div>
			</div>
		</div>
	</div>
</section>


<script type="text/javascript">
	var TSort_Data = new Array('tableSection', 'i', 's', 's', 'd');
	var TSort_Initial = "3D";
	tsRegister();
</script>

<div style="padding-top: 1cm">
	<div style="margin-left: 80px; margin-right: 550px;"></div>
</div>


<div class="col-md-12">
	<h2 class="page-header">Competitions</h2>
</div>
<c:forEach var="comp" items="${competition}" varStatus="index">
	<div class="col-sm-3 wow fadeInUp" data-wow-duration="500ms"
		data-wow-delay="300ms">
		<div class="feature-inner">
			
			<a href="/ViewCompetition?compId=${comp.compId}&pid=">
				<h4 style="text-transform: uppercase;">${comp.compName}</h4>
			</a>
			<p></p>
		</div>
	</div>
</c:forEach>


<div style="padding-top: 1cm;">
	<%@ include file="/Web/footer.jsp"%>

	<script type="${path}/text/javascript" src="js/jquery.js"></script>
	<script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
	<script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
	<script type="${path}/text/javascript" src="js/wow.min.js"></script>
	<script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>


	</body>
</html>
