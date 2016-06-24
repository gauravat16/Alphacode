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
   <div style="display: block;position: relative;padding-left: 8%" class="col-md-8">
   <c:choose>
   <c:when test="${user.uname == null}">
   You need to login to Submit a solution.
   </c:when>
   <c:when test="${user.uname != null}">
   <form action="/CodeSalad/RunMatchCode" method="post">
   <div style="position: relative;padding-bottom: 0.01%">
   <select name="lang">
   <option value="java">Java</option>
   <option value="c">C</option>
   <option value="cpp">C++</option>
   </select>
   </div>
   
   <textarea rows="20" cols="81" placeholder="Enter the code" name="code" style="resize:none"></textarea>
   <div style=position: relative;padding-left: 77%">
   <input type="submit"  value="Submit"  accesskey="c"></input>
   </div>
   </form>
   </c:when>
   </c:choose>
   </div>
   
   <div class="col-md-4" style="padding-top:1.5%;padding-right:5%;  width: 350px">
     <div class="alert alert-info fade in" >
                            
                            <h4>Before you compile</h4>
                            <p>Shortkey for compilation alt+C</p>
                            <p>For Java Class name should be Main</p>
                            <p>For C/C++ use the standerd library</p>
                            
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