<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>  <title>CarRentalSystem</title>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
  <meta name="description" content="website description" />
  <meta name="keywords" content="website keywords, website keywords" />
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  
  <link rel="stylesheet" type="text/css" href="css/style.css" />
  <link rel="stylesheet" href="css/bootstrap.min.css">
  
  <!-- modernizr enables HTML5 elements and feature detects -->
 
  <script src="js/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="js/modernizr-1.5.min.js"></script>
</head>

<body>
  <div id="main">
    <header>
	  <div id="banner">
	    <div id="welcome">
	      <h2>Quick Cars</h2>
	    </div><!--close welcome-->			  	
	  </div><!--close banner-->	
	</header>
	<br>
	<br>
	<nav>
	  <div id="menubar">
        <ul id="nav">
          <li><a href="mainHome.html">Home</a></li>
          <li><a href="availableCar.html">Available Cars</a></li>
          <li><a href="logIn.html">LogIn</a></li>
          <li class="current"><a href="logIn.html">Book A Car</a></li>
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
	
	  <div class="sidebar_container">       
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Our Service</h2>
            <p>Welcome to our website.this is the great palce to book a car for your drive to any palce.we are providing the Best Service in car Rending</p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->     		
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Offer For You</h2>
            <h3>Free Trip</h3>
            <p>Every month we are selecting some lucky lots to provide the free trip to any were across India .</p>         
		  </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
		  		
        <div class="sidebar">
          <div class="sidebar_item">
            <h2>Contact</h2>
            <p>Phone: +044 567891</p>
            <p>Email: quickCars@gmailcom</p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
       </div><!--close sidebar_container-->	
	
	  <div id="content">
        <div class="content_item">
		  <h1 style="color:silver;">Book A Car</h1> 
            <form action="bookingSuccess.html" modelAttribute="booking" method="post">
        <center><h2 style="color:silver;">Place your Booking Here</h2></center>
       <center>
       <table>             
           <tr>
               <td><h3 style="color:silver"> Pick Date&nbsp;&nbsp;&nbsp;&nbsp;</h3></td>
               <td><input required pattern="^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$" type="text" name="pickupDate" class="form-control" placeholder="MM/DD/YYYY"></td>
           </tr>         
           <tr>
               <td><h3 style="color:silver">Drop Date</h3></td>
               <td><input required pattern="^(1[0-2]|0[1-9])/(3[01]|[12][0-9]|0[1-9])/[0-9]{4}$" type="text" name="dropDate"  class="form-control" placeholder="MM/DD/YYYY"></td>
           </tr>   
            <tr>
               <td><h3 style="color:silver"> Address</h3></td>
               <td><input required type="text" name="address"  class="form-control" placeholder="Enter address"></td>
           </tr>  <br>    
           <tr> <td></td>
                     <td> <input class="btn btn-default " type="submit" value="Confirm Booking"></td>
           </tr>
        </table>
        </center>
    
    </form>

		  </div><!--close content-->   
	
	</div><!--close site_content-->  	
  
    <footer>
	 <center><h3>WE ARE HAPPY TO HELP YOU </h3></center><br>
	 
	 </footer> 
  
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  </div>
</body>
</html>

