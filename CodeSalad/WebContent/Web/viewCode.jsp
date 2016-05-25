<!DOCTYPE html>
<html lang="en">
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="title" value="Code" />

<%@ include file = "/Web/Header.jsp" %>
	
    <section id="page-breadcrumb">
        <div class="vertical-center sun">
             <div class="container">
                <div class="row">
                    <div class="action">
                        <div class="col-sm-12">
                            <h1 class="title">Code</h1>
                           
                           
                        </div>
                     </div>
                </div>
            </div>
        </div>
   </section>
     
  
    <div class="col-md-6 padding" style="margin-left: 10%">
   <pre >
   <code style="margin: -30px -10px -45px -10px;" >
  
  <c:out value="${code}"></c:out>
  
  	
   </code>
   </pre>


</div>





    <%@ include file="/Web/footer.jsp"%>
    <script type="${path}/text/javascript" src="js/jquery.js"></script>
    <script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
    <script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
    <script type="${path}/text/javascript" src="js/wow.min.js"></script>
    <script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>
  
   
</body>
</html>
