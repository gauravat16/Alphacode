
<!DOCTYPE html>
<html lang="en">
<%@  taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/Web/Header.jsp"%>


<c:set var="path" value=" ${pageContext.request.contextPath}/Web" />
<section id="page-breadcrumb">
	<div class="vertical-center sun">
		<div class="container">
			<div class="row">
				<div class="action">
					<div class="col-sm-12">
						<h1 class="title">${user.uname}</h1>

					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/#action-->

<section id="portfolio-information" class="padding-top">
	<div class="container">
		<div class="row">
			<div class="col-sm-4">
			
				<c:choose>
					<c:when test="${user.pic==null}">
						<img src="${path}/images/nopic.png" class="img-responsive"
							alt="No profile pic">
							
					</c:when>
					<c:otherwise>
					${user.pic}
						<img src="${user.pic}" class="img-responsive"
							alt="Error Loading Profile pic">
					</c:otherwise>
				</c:choose>
				<form action="/CodeSalad/EditProfile" enctype="multipart/form-data" method="post">
				Upload Picture
				<input type="file" name="pic">
				<input type="submit">
				</form>
				

			</div>
			<div class="col-sm-8">
				<div class="project-name overflow">
					<h2 class="bold">Sailing Vivamus</h2>
					<ul class="nav navbar-nav navbar-default">
						<li><a href="#"><i class="fa fa-clock-o"></i>February11,2014</a></li>
						<li><a href="#"><i class="fa fa-tag"></i>Branding</a></li>
					</ul>
				</div>
				<div class="project-info overflow">
					<h3>Project Info</h3>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
						tempus nibh sed elimttis adipiscing. Fusce in hendrerit purus.
						Suspendisse potenti. Proin quis eros odio, dapibus dictum mauris.
						Donec nisi libero, adipiscing id pretium eget, consectetur sit
						amet leo. Nam at eros quis mi egestas fringilla non nec purus.</p>
					<ul class="elements">
						<li><i class="fa fa-angle-right"></i> Lorem ipsum dolor sit
							amet, consectetur adipiscing elit.</li>
						<li><i class="fa fa-angle-right"></i> Donec tincidunt felis
							quis ipsum porttitor, non rutrum lorem rhoncus.</li>
						<li><i class="fa fa-angle-right"></i> Nam in quam consectetur
							nulla placerat dapibus ut ut nunc.</li>
					</ul>
				</div>
				<div class="skills overflow">
					<h3>Skills:</h3>
					<ul class="nav navbar-nav navbar-default">
						<li><a href="#"><i class="fa fa-check-square"></i>Design</a></li>
						<li><a href="#"><i class="fa fa-check-square"></i>HTML/CSS</a></li>
						<li><a href="#"><i class="fa fa-check-square"></i>Javascript</a></li>
						<li><a href="#"><i class="fa fa-check-square"></i>Backend</a></li>
					</ul>
				</div>
				<div class="client overflow">
					<h3>Client:</h3>
					<ul class="nav navbar-nav navbar-default">
						<li><a href="#"><i class="fa fa-bolt"></i>Okler Themes</a></li>
					</ul>
				</div>
				<div class="live-preview">
					<a href="#" class="btn btn-common uppercase">Live preview</a>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/#portfolio-information-->

<section id="related-work" class="padding-top padding-bottom">
	<div class="container">
		<div class="row">
			<h1 class="title text-center">Related Work</h1>
			<div class="col-sm-3">
				<div class="portfolio-wrapper">
					<div class="portfolio-single">
						<div class="portfolio-thumb">
							<img src="${path}/images/portfolio/1.jpg" class="img-responsive"
								alt="">
						</div>
						<div class="portfolio-view">
							<ul class="nav nav-pills">
								<li><a href="${path}/images/portfolio/1.jpg"
									data-lightbox="example-set"><i class="fa fa-eye"></i></a></li>
							</ul>
						</div>
					</div>
					<div class="portfolio-info ">
						<h2>Sailing Vivamus</h2>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="portfolio-wrapper">
					<div class="portfolio-single">
						<div class="portfolio-thumb">
							<img src="${path}/images/portfolio/2.jpg" class="img-responsive"
								alt="">
						</div>
						<div class="portfolio-view">
							<ul class="nav nav-pills">
								<li><a href="${path}/images/portfolio/2.jpg"
									data-lightbox="example-set"><i class="fa fa-eye"></i></a></li>
							</ul>
						</div>
					</div>
					<div class="portfolio-info ">
						<h2>Sailing Vivamus</h2>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="portfolio-wrapper">
					<div class="portfolio-single">
						<div class="portfolio-thumb">
							<img src="${path}/images/portfolio/3.jpg" class="img-responsive"
								alt="">
						</div>
						<div class="portfolio-view">
							<ul class="nav nav-pills">
								<li><a href="${path}/images/portfolio/3.jpg"
									data-lightbox="example-set"><i class="fa fa-eye"></i></a></li>
							</ul>
						</div>
					</div>
					<div class="portfolio-info ">
						<h2>Sailing Vivamus</h2>
					</div>
				</div>
			</div>
			<div class="col-sm-3">
				<div class="portfolio-wrapper">
					<div class="portfolio-single">
						<div class="portfolio-thumb">
							<img src="${path}/images/portfolio/4.jpg" class="img-responsive"
								alt="">
						</div>
						<div class="portfolio-view">
							<ul class="nav nav-pills">
								<li><a href="${path}/images/portfolio/4.jpg"
									data-lightbox="example-set"><i class="fa fa-eye"></i></a></li>
							</ul>
						</div>
					</div>
					<div class="portfolio-info ">
						<h2>Sailing Vivamus</h2>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>
<!--/#related-work-->


<footer id="footer">
	<div class="container">
		<div class="row">
			<div class="col-sm-12 text-center bottom-separator">
				<img src="images/home/under.png" class="img-responsive inline"
					alt="">
			</div>
			<div class="col-md-4 col-sm-6">
				<div class="testimonial bottom">
					<h2>Testimonial</h2>
					<div class="media">
						<div class="pull-left">
							<a href="#"><img src="images/home/profile1.png" alt=""></a>
						</div>
						<div class="media-body">
							<blockquote>Nisi commodo bresaola, leberkas venison
								eiusmod bacon occaecat labore tail.</blockquote>
							<h3>
								<a href="#">- Jhon Kalis</a>
							</h3>
						</div>
					</div>
					<div class="media">
						<div class="pull-left">
							<a href="#"><img src="images/home/profile2.png" alt=""></a>
						</div>
						<div class="media-body">
							<blockquote>Capicola nisi flank sed minim sunt
								aliqua rump pancetta leberkas venison eiusmod.</blockquote>
							<h3>
								<a href="">- Abraham Josef</a>
							</h3>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3 col-sm-6">
				<div class="contact-info bottom">
					<h2>Contacts</h2>
					<address>
						E-mail: <a href="mailto:someone@example.com">email@email.com</a> <br>
						Phone: +1 (123) 456 7890 <br> Fax: +1 (123) 456 7891 <br>
					</address>

					<h2>Address</h2>
					<address>
						Unit C2, St.Vincent's Trading Est., <br> Feeder Road, <br>
						Bristol, BS2 0UY <br> United Kingdom <br>
					</address>
				</div>
			</div>
			<div class="col-md-4 col-sm-12">
				<div class="contact-form bottom">
					<h2>Send a message</h2>
					<form id="main-contact-form" name="contact-form" method="post"
						action="sendemail.php">
						<div class="form-group">
							<input type="text" name="name" class="form-control"
								required="required" placeholder="Name">
						</div>
						<div class="form-group">
							<input type="email" name="email" class="form-control"
								required="required" placeholder="Email Id">
						</div>
						<div class="form-group">
							<textarea name="message" id="message" required="required"
								class="form-control" rows="8" placeholder="Your text here"></textarea>
						</div>
						<div class="form-group">
							<input type="submit" name="submit" class="btn btn-submit"
								value="Submit">
						</div>
					</form>
				</div>
			</div>
			<div class="col-sm-12">
				<div class="copyright-text text-center">
					<p>&copy; Your Company 2014. All Rights Reserved.</p>
					<p>
						Crafted by <a target="_blank" href="http://designscrazed.org/">Allie</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</footer>
<!--/#footer-->


<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/lightbox.min.js"></script>
<script type="text/javascript" src="js/wow.min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
</body>
</html>
