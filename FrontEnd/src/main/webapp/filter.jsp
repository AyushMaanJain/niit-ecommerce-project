<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ailmax.backend.model.User" %>
<!DOCTYPE html>

<html>
    <head>
        
        <title>none</title>
        <link rel="stylesheet" href="css/theme.css" type="text/css">
        <link rel="stylesheet" href="css/basic.css" type="text/css">
        <link rel="stylesheet" href="fonts/fonts setup.css" type="text/css"/>
        <link rel="stylesheet" href="Pic/PictureStyling.css" type="text/css"/>
        
        <meta charset="UTF-8">
        <script src="Js/Angular.js"></script>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body  style="overflow-x:hidden">
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

        <div class="body" ng-app="Search_pg" ng-controller="CtrlS">
            <select class="popsize" ng-model="order">
                <option value="relevant">Relevency</option>
                <option value="name">Name</option>
                <option value="downloads">Trending</option>
                <option value="Date">Date</option>
               <option value="price">price</option>
               
            </select>
            <div class="vertical-list" style="">
                
                <div class="cards">
                <div ng-repeat="x in results|orderBy: order" class="card ">
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
        </div>
        
        <script src="Js/jquery-3.4.1.js"></script>
        <script src="Js/main.js"></script>
        <script>
            var app = angular.module('Search_pg', []);
app.controller('CtrlS', function($scope) {
	$scope.order="name";
    $scope.results = <%= request.getAttribute("result") %>;
});
        </script>
    </body>
</html>
