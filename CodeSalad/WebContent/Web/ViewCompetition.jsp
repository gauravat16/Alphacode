<!DOCTYPE html>
<html lang="en">
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="title" value="${comp.compName}" />
<%@ include file = "/Web/Header.jsp" %>
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
     
  
    <div class="col-md-6 padding">
    
    ${comp.compText}
   
</div>
<form method="post" action="/CodeSalad/Competition?addProb=true&newComp=false&id=${comp.compId}">
		
			<input type="submit" class="btn btn-sm btn-primary" Value="Add Problem"></input>
			</form>
			<form method="post" action="/CodeSalad/Enroll?addProb=true&newComp=false&id=${comp.compId}">
		
			<input type="submit" class="btn btn-sm btn-primary" Value="Add Problem"></input>
			</form>




<%@ include file="/Web/footer.jsp"%>

    <script type="${path}/text/javascript" src="js/jquery.js"></script>
    <script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
    <script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
    <script type="${path}/text/javascript" src="js/wow.min.js"></script>
    <script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>
  
   
</body>
</html>
