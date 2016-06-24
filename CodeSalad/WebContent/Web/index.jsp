<!DOCTYPE html>
<%@  taglib  prefix="c"   uri="http://java.sun.com/jsp/jstl/core"  %>
<c:set var="title" value="AlphaCode" />

<html lang="en">
<%@ include file = "/Web/Header.jsp" %>
    <section id="home-slider">
        <div class="container">
            <div class="row">
                <div class="main-slider">
                    <div class="slide-text">
                        <h1>Code & Compete</h1>
                        <c:choose>
                        
                        <c:when test="${user.uname==null}">
                        <a href="/CodeSalad/Web/Register.jsp" class="btn btn-common">SIGN UP</a>
                       
                        </c:when>
                       
                        </c:choose>
                    </div>
                    <img src="${path}/images/home/slider/Java_logo.png" height="250px" width="250px"class="slider-hill" alt="slider image">
                    <img src="${path}/images/home/slider/C.png" height="350px" width="350px" class="slider-house" alt="slider image">
                    <img src="${path}/images/home/slider/Python.png" height="200px" width="200px" class="slider-sun" alt="slider image">
                    
                </div>
            </div>
        </div>
        <div class="preloader"><i class="fa fa-sun-o fa-spin"></i></div>
    </section>
    <!--/#home-slider-->

    <section id="services">
        <div class="container">
            <div class="row">
                <div class="col-sm-4 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="300ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="300ms">
                            <img src="${path}/images/home/icon1.png" alt="">
                        </div>
                        <h2>Problems</h2>
                        <p>Sharpen your programming skills with challenges from peers. </p>
                    </div>
                </div>
                <div class="col-sm-4 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="600ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="600ms">
                            <img src="${path}/images/home/icon2.png" alt="">
                        </div>
                        <h2>Competitions</h2>
                        <p>Solve challenges in online workshops. </p>
                    </div>
                </div>
                <div class="col-sm-4 text-center padding wow fadeIn" data-wow-duration="1000ms" data-wow-delay="900ms">
                    <div class="single-service">
                        <div class="wow scaleIn" data-wow-duration="500ms" data-wow-delay="900ms">
                            <img src="${path}/images/home/icon3.png" alt="">
                        </div>
                        <h2>Blogs</h2>
                        <p>Create and share your views.</p>
                        
                    </div>
                </div>
            </div>
        </div>
    </section>

   <%@ include file="/Web/footer.jsp"%>

    <script type="text/javascript" src="${path}/js/jquery.js"></script>
    <script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${path}/js/lightbox.min.js"></script>
    <script type="text/javascript" src="${path}/js/wow.min.js"></script>
    <script type="text/javascript" src="${path}/js/main.js"></script>   
</body>
</html>
