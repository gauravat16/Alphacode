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
                            <h1 class="title">${problem.problemName}</h1>
                            <p>Difficulty - ${problem.difficulty}</p>
                           
                        </div>
                     </div>
                </div>
            </div>
        </div>
        
        <script type="text/javascript">

var TSort_Data = new Array ('tableSection', 's', 's', '','i','i','d','s');
var TSort_Initial = "5D";
tsRegister();

</script>
        
        
   </section>
    <div class="col-md-6 padding" style="margin-left: 7%; text-align: justify;  ">
   
   ${problem.problemText}



 
 

 <a href="/CodeSalad/ShellSolution?pid=${problem.pid}" class="btn btn-sm btn-danger" id="LinkAsButton " style=" display:block;
    margin: 0 90%; width: 60px">submit</a>
</div>

<div class="col-md-4 padding" style="margin-left: 60px; text-align: justify;  ">
 <div >
   <div>
   <table class="tableSection" id="tableSection">
   <thead>
   <tr>
   <th><span class="text"> User Name </span></th>
   
   <th><span class="text"> Status </span></th>
      <th><span class="text"> Code </span></th>
   
   <th><span class="text"> Time </span></th>
   <th><span class="text"> Memory </span></th>
   <th><span class="text"> Submitted on</span></th>
   <th><span class="text"> Language used </span></th>
   
   
  
   </tr> 
   </thead>
   


   <tbody>
   <c:forEach var="sol" items="${pCoders}" varStatus="index">              

   <tr>
   <td><a href="/CodeSalad/UserProfile?isFromOtherUser=true&email=${sol.email}&from=${user.email}">${sol.uname}</a></td>
    <td>${sol.status}</td>
       <td><a href="/CodeSalad/GetCode?lang=${sol.lang}&pid=${sol.probid}&email=${sol.email}">View Code</a></td>
    
     <td>${sol.execTime}55</td>
      <td>${sol.execMem}55</td>
       <td>${sol.submittedOn}</td>
        <td>${sol.lang}</td>
       
   </tr>
   
   </c:forEach>
   </tbody>
   </table>
   </div> 
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
