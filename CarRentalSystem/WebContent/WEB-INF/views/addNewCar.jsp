<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html lang="en">

<head>
  <title>CarRentalSystem</title>
  <meta name="description" content="website description" />
   <meta charset="utf-8"> 
  <meta name="keywords" content="website keywords, website keywords" />
  <meta http-equiv="content-type" content="text/html; charset=windows-1252" />
  <link rel="stylesheet" type="text/css" href="css/style.css" />
 
 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 


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
          <li class="current"><a href="adminform.html">Admin</a></li>
          
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
             <h2>Our Features</h2>
                 <p>&#9755; Airport Transfer</p>
                 <p>&#9755; Intercity Travel</p>
                 <p>&#9755; Local usage.</p>
                 <p>&#9755; Daily rental.</p>
                 <p>&#9755; Courtesy Pickup and Drop.</p>
                 <p>&#9755; Year-round promotions.</p>
                 <p>&#9755; On the road assistance 24 hours a day.</p>
                 </div></p><!--close sidebar_item--> 
        </div><!--close sidebar-->     		
		<div class="sidebar">
          <div class="sidebar_item">
            <h2>Offer For You</h2>
            <h3>Free Trip</h3>
            <p>Every month we are selecting some lucky lots to provide the free trip to any were across India.</p>         
		  </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
		  		
        <div class="sidebar">
          <div class="sidebar_item">
            <h2>Contact</h2>
            <p>Phone: +044 567891</p>
            <p>Email: quickCars@gmail.com</a></p>
          </div><!--close sidebar_item--> 
        </div><!--close sidebar-->
       </div><!--close sidebar_container-->	
	
	  <div id="content">
        <div class="content_item">
		  <h1 style="color: silver;">Dear Admin add a new Car here</h1><br><br> 
		 <form action="carAddResult.html" method="post">
          <center>
          <table cellspacing="2">
              <tr>
                  <td><img alt="Suv" src="images/Sedan1.png" width="100px" height="100px">&nbsp;</td>
                  <td><img alt="Suv" src="images/SUV.png" width="100px" height="100px">&nbsp;</td>
                  <td><img alt="Suv" src="images/Wagon.png" width="100px" height="100px">&nbsp;</td>
                  <td><img alt="Suv" src="images/HatchBack.png" width="100px" height="100px">&nbsp;</td>
                  
              </tr>
              <tr>
                  <td style="color: silver;"><center>Sedan</center></td>
                  <td style="color: silver;"><center>SUV</center></td>
                  <td style="color: silver;"><center>Wagon</center></td>
                  <td style="color: silver;"><center>Hatch Back</center></td>
                  
              </tr><br>
              
             
          </table>
            
         <table>
             <tr>
              <td><h3 style="color:silver;"><label for="carType">Car Type</label></h4></td>
         <td>
             <select class="form-control" id="carType" name="carType">
                 <option value="4">Sedan</option>
                 <option value="6">SUV</option>
                 <option value="5">Wagon</option>
                 <option value="6">Hatch Back</option>
                
             </select>   
                 
           </td>
          
           
           <tr>
               <td><h3 style="color:silver;"><label for="registerNumber">Register Number&nbsp;&nbsp;&nbsp;</label></h4></td>
               <td><input required="required" type="text"  id="registerNumber" name="carNumber" class="btn btn-default btn-lg" placeholder="Enter Car Number"><br><br></td>
           </tr>
           
           <tr>
               <td><h3 style="color:silver;"><label for="imageUrl">Upload a Image here&nbsp;&nbsp;&nbsp;</label></h4></td>
               <td><input required="required" type="file"  id="imageUrl" name="imageUrl" class="btn btn-default btn-lg" placeholder="Upload a image"><br><br></td>
           </tr>
           <tr>

               <td></td>
               <td ><input class="btn btn-primary" type="submit" value="Add Car"> &nbsp;&nbsp;<a href="adminform.html"><button class="btn btn-primary" type="button">Go Back</button></a></td>

           </tr>
        </table>
        </center>
        </form> 	
  
    <footer>
	 <center><h3>WE ARE HAPPY TO HELP YOU </h3></center><br>
	 
	 </footer> 
  
  </div><!--close main-->
  
  <!-- javascript at the bottom for fast page loading -->
  <script type="text/javascript" src="js/jquery.min.js"></script>
  <script type="text/javascript" src="js/image_slide.js"></script>
  
</body>
</html>
