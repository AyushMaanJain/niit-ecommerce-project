<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Cart</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/account/main.css" type="text/css"/>
        <link rel="stylesheet" href="css/theme.css" type="text/css"/>
        <link href="fonts/fonts setup.css" rel="stylesheet" type="text/css"/>
        <script src="Js/Angular.js"></script>
    </head>
    <body ng-app="cart-data" ng-controller="userCtrl" id="userCtrl" style="overflow:hidden;background: #25a5d5">

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
                    <li id="li1" state="inactive"><a href="Account#gen">General</a></li>
                    <li id="li2" state="inactive"><a href="Account#link">Linked Account</a></li>
                    <li id="li3" state="inactive"><a href="Account#pay">Payments</a></li>
                    <li id="li4" state="inactive"><a href="Account#sec">Security</a></li>
                </ul>
                <ul class="fa slidable">
                    <li class="for-mobile"><a href="Account" span-color="red"><span class="icon fa-user-circle"></span><span class="text">User Setting</span></a></li>
                    <li><a href="UserCart" span-color="green"><span class="icon fa-cart-arrow-down"></span><span class="text">Cart</span></a></li>
                    <li><a href="Activity.html?transection" span-color="blue"><span class="icon fa-history"></span><span class="text">Transection</span></a></li>
                </ul>
            </div>
        
            <div class="body" id="cart" style="height:100vh;background: #fff; overflow:scroll;">
            <div class="part">
                <h1>User cart</h1>
                 
                     <table ng-if="cart.length>0">
                         <tr>
                         <th>Product</th>
                         <th>Price</th>
                         <th colspan="2"></th>
                         </tr>
                         <tr ng-repeat="x in cart">
                         <td>{{x.name}}</td>
                         <td>{{x.price}}</td>
                         <td>
                             <form action="Payer" method="post">
                                 <input type="hidden" name="name" value="{{x.id}}"/>
                                 <button type="submit"><span class="fa"> Buy </span></button>
                             </form>
                         </td><td>
                             <form action="CartHandeler" method="get">
                                 <input type="hidden" name="name" value="{{x.id}}"/>
                                 <button type="submit"><span class="fa fa-close"></span></button>
                             </form>
                         </td>
                         </tr>
                         <tr>
                         <th>Total</th>
                         <th>{{total}}</th>
                         <th colspan="2"><form action="Payer" method="post">
                                 <input type="hidden" name="name" value="all"/>
                                 <button type="submit"><span class="fa"> Buy </span></button>
                             </form></th>
                         </tr>
                     </table>
                    <h3 ng-if="cart.length===0">
                    There is no Product in cart. visit <a href="index.jsp">product pages</a> to find your product
                    </h3>
            </div>
        </div>

        <script src="Js/jquery-3.4.1.js"></script>
       <script>
           var app = angular.module('cart-data', []);
app.controller('userCtrl', function($scope){
    $scope.name="Ailmax";
    var Free=0;
     $scope.cart=<%= request.getAttribute("cart") %>;
    $scope.total=0;
     try{
         var len=$scope.cart.length;
         
         var total=0;
         for(var x=0;x<len;x++){
            total+=$scope.cart[x].price;
           //alert(total);
            }
         $scope.total=total;
     }catch(e){
         //alert(e);
     }
           
});
    </script>
    <script src="Js/Account/other.js" type="text/javascript"></script>
    </body>
</html>
    