<!DOCTYPE html>
<html lang="en">
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="title" value="New Competition" />
<%@ include file="/Web/Header.jsp"%>
<section id="page-breadcrumb">
	<div class="vertical-center sun">
		<div class="container">
			<div class="row">
				<div class="action">
					<div class="col-sm-12">
						<h1 class="title">Result</h1>


					</div>
				</div>
			</div>
		</div>
	</div>
</section>



<form action="/Competition?newComp=true&addProb=false" method="post">



	<div class="col-md-8 " style="margin-top: 2%;">
     <div style="margin-left: 2%;">
     	When should it start?
		<input style="" type="date" name="compOn">
		Duration 
		<input type="text" name="compDuration" placeholder="Days:hours:min">
		</div>
		<br>	
		<textarea rows="1" cols="80 " placeholder="Competition Name"
			style="margin-left: 2%; resize:none" name="compName"></textarea>
		<textarea rows="20" cols="80" placeholder="Competition Rules"
			style="margin-left: 2%; resize:none" name="compInfo"></textarea>
			
			
		
		



	</div>
	<div class="col-md-4">




			
			
			<input type="submit" class="btn btn-sm btn-primary"></input>
</form>





	</div>









<%@ include file="/Web/footer.jsp"%>
<script type="${path}/text/javascript" src="js/jquery.js"></script>
<script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
<script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
<script type="${path}/text/javascript" src="js/wow.min.js"></script>
<script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>


</body>
</html>
