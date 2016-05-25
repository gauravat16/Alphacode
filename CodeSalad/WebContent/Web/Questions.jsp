<!DOCTYPE html>
<html lang="en">
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ include file = "/Web/Header.jsp" %>
    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1 class="title">${PObjs[0].difficulty}</h1>
                           
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
   
   <table class="tableSection" id ="tableSection">
   <thead>
   <tr>
   <th><span class="text"> Problem ID </span></th>
   <th><span class="text"> Name </span></th>
   <th><span class="text"> Author </span></th>
   <th><span class="text"> Time </span></th>
  
   </tr> 
   </thead>
   


   <tbody>
   <c:forEach var="problem" items="${PObjs}" varStatus="index">
  

   <tr>
   <td ><c:out value="${problem.pid}" /></td>
   <td><a href="/CodeSalad/ViewProblem?pid=${problem.pid}">${problem.problemName}</a></td>
   <td>${problem.author} </td>
   <td>${problem.createdOn} </td>
   </tr>
   
   </c:forEach>
   </tbody>
   </table>
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
