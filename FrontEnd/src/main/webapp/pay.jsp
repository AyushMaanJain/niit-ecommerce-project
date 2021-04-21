<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/theme.css" type="text/css"/>
        <link rel="stylesheet" href="css/pay/pay.css" type="text/css"/>
        <link href="fonts/fonts setup.css" rel="stylesheet" type="text/css"/>
        <script src="Js/Angular.js"></script>
        
    </head>
    <body>
        <div class="body" ng-app="purchase-data" ng-controller="userCtrl">
            <div class="part">
            <table class="rest">
                <tr>
                    <th></th>
                    <th>Name</th>
                    <th>price</th>
                </tr>
                <tr ng-repeat="x in buy">
                    <td></td>
                    <td>{{x.name}}</td>
                    <td>{{x.price}}</td>
                </tr>
                <tr>
                    <th>Total List Price</th>
                    <th></th>
                    <th>{{total}}</th>
                </tr>
                <tr>
                    <td>Discount</td>
                    <td></td>
                    <td>-{{discount}}</td>
                </tr>
                <tr>
                    <td>Value added tax</td>
                    <td></td>
                    <td>+{{vat}}</td>
                </tr>
                <tr>
                    <th>Total price</th>
                    <th></th>
                    <th>{{gross}}</th>
                </tr>
            </table>
             <a href="thanks.jsp">E-Wallet</a>
              <a href="thanks.jsp">Net-Banking</a>
              <a href="thanks.jsp">Debit/Credit Card</a> 
            </div>
              
              
        </div>
        <div class="head">
            <p class="uname" pickup="scrolled"><i>Payment</i></p>
            <a href="Cart" class="fa fa-sign-out"><span>Cancel</span></a>
        </div>
        
        <script>
           
           var app = angular.module('purchase-data', []);
app.controller('userCtrl', function($scope){
    
    var Free=0;
     $scope.buy=<%= request.getAttribute("prod") %>;
    $scope.total=0;
     try{
         var len=$scope.buy.length;
         
         var total=0;
         for(var x=0;x<len;x++){
            total+=$scope.buy[x].price;
           //alert(total);
            }
         $scope.total=total;
         $scope.discount=0;
         $scope.vat=0;
         $scope.gross=$scope.total-$scope.discount+$scope.vat;
     }catch(e){
         //alert(e);
     }
           
});
    </script>
    </body>
</html>
    