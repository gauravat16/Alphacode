<!DOCTYPE html>
<html lang="en">
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="title" value="${problem.problemName}" />
<%@ include file = "/Web/Header.jsp" %>
    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            
                           
                        </div>
                     </div>
                </div>
            </div>
        </div>
   </section>
   

<script type="text/javascript">

var TSort_Data = new Array ('tableSection', 'i', 's', 's','d');
var TSort_Initial = "3D";
tsRegister();

</script>

   <div style="padding-top: 1cm">
   <div style="margin-left: 80px; margin-right: 550px;">
   
   
  
   
    <c:forEach var="comp" items="${competition}" varStatus="index">
  
 <div class="alert alert-success fade in" style="margin-left: 15%">
              <a href="/CodeSalad/ViewCompetition?compId=${comp.compId}&pid="> <h4>${comp.compName}</h4></a>
               <p>${comp.compText}</p>
                        </div>
   
   </c:forEach>
   
   
   </div> 
   </div>

<div style="padding-top: 1cm;">
   <%@ include file="/Web/footer.jsp"%>

    <script type="${path}/text/javascript" src="js/jquery.js"></script>
    <script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
    <script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
    <script type="${path}/text/javascript" src="js/wow.min.js"></script>
    <script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>
  
   
</body>
</html>
