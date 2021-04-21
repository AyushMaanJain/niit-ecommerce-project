<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.ailmax.backend.model.User" %>
     <%@page import="com.ailmax.backend.model.UserDet" %>
<!DOCTYPE html>

    <head>
        <title>Account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/account/main.css" type="text/css"/>
        <link rel="stylesheet" href="css/theme.css" type="text/css"/>    
        <link rel="stylesheet" href="fonts/fonts setup.css" type="text/css"/>
        <script src="Js/Angular.js"></script>
    </head>
    <body ng-app="user-data" ng-controller="userCtrl" id="userCtrl" style="overflow-x:hidden;background: #25a5d5">
        <div class="head">
            <p class="uname" pickup="scrolled"><i>{{name}}</i></p>
            <nav class="options" display='none'>
            <nav class="popbase">
                <a href="log.jsp" class="fa fa-sign-out"><span>Sign_out</span></a>
            </nav>
        </nav>
        </div>
        <div class="side-one">
                <ul class="hidable">
                    <li id="li1" state="inactive"><a href="account.html#gen">General</a></li>
                    <li id="li2" state="inactive"><a href="account.html#link">Linked Account</a></li>
                    <li id="li3" state="inactive"><a href="account.html#pay">Payments</a></li>
                    <li id="li4" state="inactive"><a href="account.html#sec">Security</a></li>
                </ul>
                <ul class="fa slidable">
                    <li class="for-mobile"><a href="account.html" span-color="red"><span class="icon fa-user-circle"></span><span class="text">User Setting</span></a></li>
                    <li><a href="Activity.html?cart" span-color="green"><span class="icon fa-cart-arrow-down"></span><span class="text">Cart</span></a></li>
                    <li><a href="Activity.html?transection" span-color="blue"><span class="icon fa-history"></span><span class="text">Transection</span></a></li>
                </ul>
            </div>
        <div class="body" style="background: #fff;" id="user">
            <div class="part" id="gen">
                <h1>General Setting</h1>
                <h2>User account</h2>
                <div class="form-container">
                    
                    <h2>Personal Details</h2>
                    <div class="person">
                        <form method="post" action="C_person" class="full">
                            <input type="number" width="half" placeholder="Phone number" name="Phone"/>
                            <input type="text" width="half" placeholder="address line1" name="address"/>
                            <input type="text" width="half" placeholder="Region" name="Country"/>
                            <input type="text" width="half" placeholder="State" name="State"/>
                            <input type="text" width="half" placeholder="City" name="city"/>
                            <input type="text" width="half" placeholder="Pin code" name="PIN"/>
                            <br>
                            <button type="submit">Update</button>
                        </form>
                    </div>
                </div>
            </div>
            <div id="link" class="part">
                <h1>Linked Account Settings</h1>
                <div class="card-container">
                    <div class="card">
                        <span class="fa fa-google-plus" Color="red"></span><br>
                        <button class="connect">Connect</button>
                    </div>
                    <div class="card">
                        <span class="fa fa-github" Color="black"></span><br>
                        <button class="connect">Connect</button>
                    </div>
                    <div class="card">
                        <span class="fa fa-facebook" Color="blue"></span><br>
                        <button class="connect">Connect</button>
                    </div>
                    <div class="card">
                        <span class="fa fa-twitter" Color="Lblue"></span><br>
                        <button class="connect">Connect</button>
                    </div>
                </div>
            </div>
            <div id="pay" class="part">
                <h1>Payment method</h1>

                    <div class="payment-way">
                        <h3>Debit Card/Credit Card</h3>
                        
                    
                             <div class="form-container">
                                 <form action="add" class="full" method="post">
                                    <input type="number" width="auto" name="number" placeholder="Card Number">
                                    <input type="number" width="auto" name="cvv" placeholder="Cvv">
                                    <input type="number" width="auto" name="month" placeholder="month">
                                    <input type="number" width="auto" name="year" placeholder="year">
                                    <button type="submit">Add</button>
                                </form>
                             </div>
                            <div class="form-container" ng-repeat="x in card">
                                <form class="full" action="add" method="post">
                                <input name="number" width="auto" disabled="true" value="{{x.number}}">
                                <input name="cvv" width="auto" disabled="true" value="{{x.cvv}}">
                                <input name="month" width="auto" disabled="true" value="{{x.month}}">
                                <input name="year" width="auto" disabled="true" value="{{x.year}}">
                                <button type="submit">Remove</button>
                                </form>
                             </div>
                       
                    </div>
                    
                    <div class="payment-way">
                            <h3>Pay Pal</h3>
                    
                        <div class="form-container">
                            
                            <p>This payment method will be stored and associated with your <i><b>Ailmax</b></i> account for future purchases.
                                <br>
You will be directed to PayPal to authorize your payment method, then you will be returned to <i><b>Ailmax</b></i> to complete this purchase.</p>
                            <div class="full">
                                <form action="paypal" method="post">
                                <button type="submit">Add PAYPAL </button>
                            </form></div>
                        </div>
                    </div>
                
            </div>
            <div id="sec" class="part">
                <h1>Security Settings</h1>
                <div class="form-container">
                    <h2>Change Password</h2>
                    <form action="update" method="post" class="full">
                        <button type="submit">Update</button>
                    </form>
                </div>
                <div class="form-container">
                    <h2>Delete your account</h2>
                    <form action="delete" method="post" class="full">
                        <p>Start the process of deleting your <b><i>Ailmax</i></b> account including all purchases, Product key and Licence permanently</p>
                        <p class="note">This action is irreversible once completed.</p>
                        <input type=hidden name=class value="user"/>
                        <input type="hidden" name="id" value="{{id}}"/>
                        <button type="delete">Delete Account</button>                       
                    </form>
 
                </div>
                <div class="form-container">
                    <h2>Change your E-Mail</h2>
                    <form action="authanticate" method="get" class="full">
                        <p>user logs in by email id which is most important refrencial part</p>
                        <button type="submit">Change E-Mail Id</button>                       
                    </form>
                </div>
                
            </div>
        </div>
         <% 
    User user=(User)request.getAttribute("UserA");
    UserDet ud=(UserDet)request.getAttribute("UserD");
	String phone="";
		if(ud.getPhone()!=null){       
     phone=ud.getPhone();}
		String address="";
		if(ud.getAddress()!=null){       
     address=ud.getAddress();} 
		String region="";
		if(ud.getCountry()!=null){       
     region=ud.getCountry();}
		String state="";
		if(ud.getState()!=null){       
     state=ud.getState();} 
		String city="";
		if(ud.getCity()!=null){       
     city=ud.getCity();}
		String pin="";
		if(ud.getPostal()!=null){       
     pin=ud.getPostal();}
    %>
       <script src="Js/jquery-3.4.1.js"></script>
       <script>
       var app = angular.module('user-data', []);
       app.controller('userCtrl', function($scope){
    	   $scope.id="<%= user.getU_id() %>";
           $scope.name="<%= user.getU_name() %>";
           $scope.email="<%= user.getE_mail() %>";
           $scope.phone="<%=phone%>";
           $scope.address="<%=address%>";
           $scope.region="<%=region%>";
           $scope.state="<%=state%>";
           $scope.city="<%=city%>";
           $scope.Pin="<%=pin%>";
           
           $scope.card=[
              
           ];
           
          
           
       });
       
       </script>
        <script src="Js/Account/main.js"></script>
    </body>

