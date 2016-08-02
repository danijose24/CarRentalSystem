
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>
  <title>CarRentalSystem</title>
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <!-- modernizr enables HTML5 elements and feature detects -->
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
  <div id="main">
    <header>
	  <div id="banner">
	    <div id="welcome">
	      <h2>Qiuck Cars</h2>
	    </div><!--close welcome-->			  	
	  </div><!--close banner-->	
	</header>
	
	<nav>
	  <div id="menubar">
        <ul id="nav">
          <li><a href="mainHome.html">Home</a></li>
          <li class="current"><a href="availableCar.html">Available Cars</a></li>
         
          
        </ul>
      </div><!--close menubar-->	
    </nav>	
    
	<div id="site_content">		

      <div class="slideshow">
	    <ul class="slideshow">
          <li class="show"><img width="940" height="300" src="images/car1.jpg" alt="&quot;Happy Journy With Us&quot;" /></li>
          <li><img width="940" height="300" src="images/car2.jpg" alt="&quot;Pay Less Drive More&quot;" /></li>
          <li><img width="940" height="300" src="images/car3.jpg" alt="&quot;Feel Safe we will be With u&quot;" /></li>
          <li><img width="940" height="300" src="images/car4.jpg" alt="&quot;Every Journy thought us lot&quot;" /></li>
          <li><img width="940" height="300" src="images/car5.png" alt="&quot;Provide our Best Service to U&quot;" /></li>
          <li><img width="940" height="300" src="images/car6.jpg" alt="&quot;Have a great Journy&quot;" /></li>
        </ul> 
	  </div><!--close slideshow-->	
	
	  <div id="content">
        <div class="content_item">
		  <h1>Here Comes Available Cars</h1> 
              <center>
                  <br>
                      <div style="color: teal;font-size: 30px">Car Details </div>
                      <br>
                      <c:if test="${!empty car}">
                       <table border="1" bgcolor="black" width="600px">
                          <tr style="background-color: teal;color: white; text-align: center;" height="40px">
                              <td>Car Id</td>
                              <td>Car Type</td>
                              <td>Car Number</td>
                              <td>Book</td>
                          </tr>
                           
                     		<c:forEach items="${car}" var="car">
                     		<tr style="background-color:white;color: black;text-align: center;" height="30px" >
                       		   <td><c:out value="${car.id}"/></td>
                       		   <td><c:out value="${car.carType}"/></td>
                       		   <td><c:out value="${car.carNumber}"/></td>
                       		   <td><a href="signUp.html"><input type="submit" value="Book"/></a>
                    		</tr>
                            </c:forEach>
                         </table>
                      </c:if>
<br>
</center>
        </div><!--close content_item-->
      </div><!--close content-->   
	
	</div><!--close site_content-->  	
  
    <footer>
	  <h3>copy rights reserved by Ideas2It</h3>
    </footer> 
  
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  
</body>
</html>

