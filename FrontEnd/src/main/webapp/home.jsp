<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ailmax.backend.model.User" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/theme.css" type="text/css">
        <link rel="stylesheet" href="css/basic.css" type="text/css">
        <link rel="stylesheet" href="fonts/fonts setup.css" type="text/css"/>
        <link rel="stylesheet" href="Pic/PictureStyling.css" type="text/css"/>
        <title>Ailmax</title>
        <meta charset="UTF-8">
        <script src="Js/Angular.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body style="overflow-x:hidden">
         <div class="slidenav" style="overflow: scroll" expand="false">
       
            <a href="Search?search=anti virus">Anti Virus</a>
            <a href="Search?search=Operating system">Operating System</a>
            <a href="Search?search=ide">Developement</a>
            <a href="Search?search=3d">3D CAD</a>
            <a href="Search?search=graphic design">Graphic Design</a>
            <a href="Search?search=financial data">Data/Financing</a>
            
        </div>
        <nav class="head">
            <Button class="slideToggle">&#9776;</Button>
        <span class="Pname"><a href="index.jsp">Ailmax</a></span>
        <nav class="options" display='none'>
            <nav class="popbase">
            <% User user=(User)request.getAttribute("onUser");
				if(user==null){
					out.print("<a href=\"log.jsp?login\" class=\"fa fa-sign-in\"><span style=\"\">sign in</span></a>");
					out.print("<a href=\"log.jsp?register\" class=\"fa fa-user-circle-o\"><span>sign up</span></a>");
				}else{
					out.print("<a href=\"Account\" class=\"fa fa-user\"><span>"+user.getU_name()+"</span></a>");
					out.print("<a href=\"Cart\" class=\"fa fa-cart-arrow-down\"><span>cart</span></a>");
					out.print("<a href=\"log.jsp\" class=\"fa fa-sign-out\"><span>sign out</span></a>");
				}
			%>
                
            </nav>
        </nav>
        <button class="popup fa fa-user"></button>
        <button class="searchToggle fa fa-search"></button>
        <div class="searchCon" display="none">
            <span class="back fa fa-arrow-left"></span>
        	<form method="get" action="Search" class="searchBox">
            	<span class="fa fa-search"></span>
            	<input type="text" name="search" placeholder="search..." autocomplete="off"/>
	        </form>
        </div>
        </nav>
     

                <div class="body" ng-app="Home_pg" ng-controller="ControllA">
            <div class="carousel_container">
                <div class="image">
                    <div ng-repeat="x in offer" id="pic{{$index+1}}" active="{{$first}}" class="carousel_picture">
                        <img src={{x.img}} style="">
                    </div>
                    
                </div>
                <div class="desc">
                <div class="fa arrows">
                    <span id="shiftL" class="fa-arrow-left"></span>
                    <span id="shiftR" class="fa-arrow-right"></span>
                    <div class="dots">
                        <span ng-repeat="x in offer" id="port{{offer.length-$index}}" class="circle" active="{{$last}}"></span>
                        
                    </div>
                </div>
                    <div ng-repeat="x in offer" id="text{{$index+1}}" active="{{$first}}" class="carousel_text">
                        <h1>{{x.name}}</h1>
                        <p>{{x.data}}</p>
                        <a href="#">See more information &rarr;</a>
                    </div>
                    
            </div>
            </div>
         
            <div class="horizontal-list" style="">
                <h2>Latest</h2>
                <div class="cards">
                    <div ng-repeat="x in latest" class="card" last="{{$last}}">
                        <a href="product.html?{{x.name}}">
                        <img src="{{x.img}}">
                        <h3>{{x.name}}</h3>
                        <p ng-if="x.price===0">Free</p>
                        <p ng-if="x.price>0">&#8377; {{x.price}}</p>
                        </a>
                        <form action="CartHandeler" method="get">
                            <input type="hidden" name="name" value="{{x.id}}"/>
                            <button type="submit">
                                <span ng-if="x.inCart">Remove from Cart</span>
                                <span ng-if="!x.inCart">Add To Cart</span>
                            </button>
                        </form>
                    </div>

                </div>
            </div>
            <div class="horizontal-list" style="">
                <h2>Free</h2>
                <div class="cards">
                    <div ng-repeat="x in free" class="card" last="{{$last}}">
                        <a href="product.html?{{x.name}}">
                        <img src="{{x.img}}">
                        <h3>{{x.name}}</h3>
                        <p ng-if="x.price===0">Free</p>
                        <p ng-if="x.price>0">&#8377; {{x.price}}</p>
                        </a>
                        <form action="CartHandeler" method="get">
                            <input type="hidden" name="name" value="{{x.id}}"/>
                            <button type="submit">
                                <span ng-if="x.inCart">Remove from Cart</span>
                                <span ng-if="!x.inCart">Add To Cart</span>
                            </button>
                        </form>
                    </div>

                </div>
            </div>
            <div class="horizontal-list" style="">
                <h2>Paid</h2>
                <div class="cards">
                    <div ng-repeat="x in paid" class="card" last="{{$last}}">
                        <a href="product.html?{{x.name}}">
                        <img src="{{x.img}}">
                        <h3>{{x.name}}</h3>
                        <p ng-if="x.price===0">Free</p>
                        <p ng-if="x.price>0">&#8377; {{x.price}}</p>
                        </a>
                        <form action="CartHandeler" method="get">
                            <input type="hidden" name="name" value="{{x.id}}"/>
                            <button type="submit">
                                <span ng-if="x.inCart">Remove from Cart</span>
                                <span ng-if="!x.inCart">Add To Cart</span>
                            </button>
                        </form>
                    </div>

                </div>
            </div>
            <div class="horizontal-list" style="">
                <h2>Trending</h2>
                <div class="cards">
                    <div ng-repeat="x in trending" class="card" last="{{$last}}">
                        <a href="product.html?{{x.name}}">
                        <img src="{{x.img}}">
                        <h3>{{x.name}}</h3>
                        <p ng-if="x.price===0">Free</p>
                        <p ng-if="x.price>0">&#8377; {{x.price}}</p>
                        </a>
                        <form action="CartHandeler" method="get">
                            <input type="hidden" name="name" value="{{x.id}}"/>
                            <button type="submit">
                                <span ng-if="x.inCart">Remove from Cart</span>
                                <span ng-if="!x.inCart">Add To Cart</span>
                                
                                    </button>
                        </form>
                    </div>

                </div>
            </div>
           
            
            <div class="bottom">
                <h3>Follow Us on:</h3>
                <div class="fa">
                    <a href="#" class="hidenable"><span class="fa-github" onColor="black"></span></a>
                    <a href="#"><span class="fa-facebook" onColor="blue"></span></a>
                    <a href="#" class="hidenable"><span class="fa-paypal" onColor="cyan-blue"></span></a>
                    <a href="#"><span class="fa-skype" onColor="Lblue"></span></a>
                    <a href="#"><span class="fa-twitter" onColor="cyan"></span></a>
                    <a href="#"><span class="fa-google-plus" onColor="red"></span></a>
                </div>
                 <h3>Consumer Support</h3>
                 <div class="text">
                     <ul>
                        <li><a href="contact.jsp">Contact Us</a></li>
                        <li><a href="about.jsp">About Us</a></li>
                        
                     </ul>
                 </div>
                 </div>
        </div>
          <script src="Js/jquery-3.4.1.js"></script>
        <script src="Js/main.js"></script>
        <script>
var app = angular.module('Home_pg', []);
app.controller('ControllA', function($scope) {
    //start data
    
  $scope.offer = [
      {name:"Koding",    img:"Pic/products/koding.png",   data:"Now avilable in .msi extention"},
      {name:"Haudini",   img:"Pic/products/haudini.png",  data:"getting 20% discount on Licence"},
      {name:"Dream Waver",img:"Pic/products/dw.jpg",  data:"getting 90% discount"},
      {name:"Windows 10",img:"Pic/products/windows10.jpg",data:"getting 50% discount on Product-key"}
  ];
  $scope.len=$scope.offer.length;
  $scope.latest =<%= request.getAttribute("latest") %>;
  $scope.paid = <%= request.getAttribute("paid") %>;
  $scope.free = <%= request.getAttribute("free") %>;
  $scope.trending = <%= request.getAttribute("trending") %>;
  //end data
});
</script>
    </body>
</html>

