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
                            <h1 class="title">Problem - ${problem.problemName}</h1>
                           </div>
                     </div>
                </div>
            </div>
        </div>
   </section>
   
   <c:choose>
   <c:when test="${user.uname == null}">
   You need to login to Submit a solution.
   </c:when>
   <c:when test="${user.uname != null}">
   <form action="/CodeSalad/RunMatchCode" method="post">
   <div style="margin-left: 25.2%">
   <select name="lang">
   <option value="java">Java</option>
   <option value="c">C</option>
   <option value="cpp">C++</option>
   </select><br>
   </div>	
   <textarea rows="20" cols="81" placeholder="Enter the code" name="code" style="display:block; margin-left:auto;
    margin-right:auto;"></textarea>
   <input type="submit"  style="margin-left: 70.5%"value="Submit"></input>
   
   
   
   </form>

   
   </c:when>
   </c:choose>
   <%@ include file="/Web/footer.jsp"%>
    <script type="${path}/text/javascript" src="js/jquery.js"></script>
    <script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
    <script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
    <script type="${path}/text/javascript" src="js/wow.min.js"></script>
    <script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>
  
   
</body>
</html>