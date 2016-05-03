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
    <div class="col-md-6 padding" style="margin-left: 60px; text-align: justify;  ">
   
   ${problem.problemText}



 
 

 <a href="/CodeSalad/ShellSolution?pid=${problem.pid}" class="btn btn-sm btn-danger" id="LinkAsButton " style=" display:block;
    margin: 0 90%; width: 60px">submit</a>
</div>

<div class="col-md-4 padding" style="margin-left: 60px; text-align: justify;  ">
 <div >
   <div style="margin-left: 80px; margin-right: 550px;">
   <table class="tableSection" id="tableSection">
   <thead>
   <tr>
   <th><span class="text"> User </span></th>
   
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
    
     <td>${sol.execTime}</td>
      <td>${sol.execMem}</td>
       <td>${sol.submittedOn}</td>
        <td>${sol.lang}</td>
       
   </tr>
   
   </c:forEach>
   </tbody>
   </table>
   </div> 
   </div>

</div>
 



    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-sm-12 text-center bottom-separator">
                    <img src="${path}/images/home/under.png" class="img-responsive inline" alt="">
                </div>
                <div class="col-md-4 col-sm-6">
                    <div class="testimonial bottom">
                        <h2>Testimonial</h2>
                        <div class="media">
                            <div class="pull-left">
                                <a href="#"><img src="${path}/images/home/profile1.png" alt=""></a>
                            </div>
                            <div class="media-body">
                                <blockquote>Nisi commodo bresaola, leberkas venison eiusmod bacon occaecat labore tail.</blockquote>
                                <h3><a href="#">- Jhon Kalis</a></h3>
                            </div>
                         </div>
                        <div class="media">
                            <div class="pull-left">
                                <a href="#"><img src="${path}/images/home/profile2.png" alt=""></a>
                            </div>
                            <div class="media-body">
                                <blockquote>Capicola nisi flank sed minim sunt aliqua rump pancetta leberkas venison eiusmod.</blockquote>
                                <h3><a href="">- Abraham Josef</a></h3>
                            </div>
                        </div>   
                    </div> 
                </div>
                <div class="col-md-3 col-sm-6">
                    <div class="contact-info bottom">
                        <h2>Contacts</h2>
                        <address>
                        E-mail: <a href="mailto:someone@example.com">email@email.com</a> <br> 
                        Phone: +1 (123) 456 7890 <br> 
                        Fax: +1 (123) 456 7891 <br> 
                        </address>

                        <h2>Address</h2>
                        <address>
                        Unit C2, St.Vincent's Trading Est., <br> 
                        Feeder Road, <br> 
                        Bristol, BS2 0UY <br> 
                        United Kingdom <br> 
                        </address>
                    </div>
                </div>
                <div class="col-md-4 col-sm-12">
                    <div class="contact-form bottom">
                        <h2>Send a message</h2>
                        <form id="main-contact-form" name="contact-form" method="post" action="sendemail.php">
                            <div class="form-group">
                                <input type="text" name="name" class="form-control" required="required" placeholder="Name">
                            </div>
                            <div class="form-group">
                                <input type="email" name="email" class="form-control" required="required" placeholder="Email Id">
                            </div>
                            <div class="form-group">
                                <textarea name="message" id="message" required="required" class="form-control" rows="8" placeholder="Your text here"></textarea>
                            </div>                        
                            <div class="form-group">
                                <input type="submit" name="submit" class="btn btn-submit" value="Submit">
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-sm-12">
                    <div class="copyright-text text-center">
                        <p>&copy; Your Company 2014. All Rights Reserved.</p>
                        <p>Crafted by <a target="_blank" href="http://designscrazed.org/">Allie</a></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>
    <!--/#footer-->

    <script type="${path}/text/javascript" src="js/jquery.js"></script>
    <script type="${path}/text/javascript" src="js/bootstrap.min.js"></script>
    <script type="${path}/text/javascript" src="js/lightbox.min.js"></script>
    <script type="${path}/text/javascript" src="js/wow.min.js"></script>
    <script type="${path}/text/javascript" src="js/jquery.countTo.js"></script>
  
   
</body>
</html>
