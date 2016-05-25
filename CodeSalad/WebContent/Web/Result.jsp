<!DOCTYPE html>
<html lang="en">
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="title" value="Result" />
<%@ include file = "/Web/Header.jsp" %>
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
     
  
    <div class="col-md-6 padding">
    
    <c:choose>
    <c:when test="${status==101}">
        <div class="alert alert-danger fade in" style="margin-left: 15%">
                            <h4>You got an error!</h4>
                            <p>${msg}</p>
                        </div>
    </c:when>
    <c:when test="${status==102}">
    <div class="alert alert-danger fade in" style="margin-left: 15%">
                            <h4>You got an error!</h4>
                            <p>${msg}</p>
                        </div>
    </c:when>
    <c:when test="${status==103}">
               <div class="alert alert-success fade in" style="margin-left: 15%">
               <h4>${msg }</h4>
               <p>You passed all the testcases!</p>
                        </div>
                    </div>
    
    </c:when>
    <c:when test="${status==104}">
     <div class="alert alert-warning fade in" style="margin-left: 15%">
                            <h4>${msg}</h4>
                            <p>Looks like you failed some testcases.</p>
                        </div>
                    </div>
   
    </c:when>
    
    
    
    
    </c:choose>
   
   
 
   


</div>


<%@ include file="/Web/footer.jsp"%>

    <script type="${path}/text/javascript" src="js/jquery.js"></script>
    <script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
    <script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
    <script type="${path}/text/javascript" src="js/wow.min.js"></script>
    <script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>
  
   
</body>
</html>
