<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Admin Table Data</title>
  <link rel="stylesheet" href="fonts/fonts setup.css" type="text/css"/>
  <link href="css/theme.css" rel="stylesheet" type="text/css"/>
  <link href="css/table/gen.css" rel="stylesheet" type="text/css"/>
  <script src="Js/Angular.js"></script>
    </head>
    <body>
        <div class="body" ng-app="Table" ng-controller="ControllerA" > 
            <div class="tab_host" theme="green">
   <ul class="tabs">
    <li><button target="tab-1">User</button></li>
    <li><button target="tab-2">Product</button></li>
    <li><button target="tab-3">Developers</button></li>
    <li><button target="tab-4">Group</button></li>
  </ul>
    <div class="tab_body" id="tab-1">
      <table>
          <thead>
          <tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>Password</th>
                  <th>Authority</th>
                  <th>Additional</th>
              </tr>
          </thead>
          <tr ng-repeat="x in user" id="user{{$index}}">
              <td><id>{{x.id}}</id></td>
              <td><name>{{x.name}}</name></td>
      <td><email>{{x.email}}</email></td>
      <td><pass>{{x.pass}}</pass></td>
      <td><auth>{{x.auth}}</auth></td>
              <td><button action="edit" get="user{{$index}}"><span class="fa fa-edit"></span></button>
              <button action="delete" get="user{{$index}}"><span class="fa fa-trash"></span></button>
              </td>
                    
          </tr>

      </table>
  </div>
      <div class="tab_body" id="tab-2">
      <table style="width: 150%" >
          <thead><tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th>dev</th>
                  <th>Group</th>
                  <th>Date</th>
                  <th class="limit">Category</th>
                  <th>trend</th>
                  <th>Price</th>
                  <th>image</th>
                  <th>Addition</th>
              </tr></thead>
          <tr ng-repeat="x in product" id="product{{$index}}">
            <td><ID>{{x.id}}</ID></td>
            <td><Name>{{x.name}}</Name></td>
      <td><dev>{{x.dev}}</dev></td>
      <td><group>{{x.group}}</group></td>
      <td><date>{{x.date}}</date></td>
      <td class="limit"><category>{{x.cat}}</category></td>
        <td><trend>{{x.trend}}</trend></td>
      <td><price>{{x.price}}</price></td>
            <td><img src="{{x.img}}" style="width: 100px;height: 100px;"/></td>
              <td><button action="edit" get="product{{$index}}"><span class="fa fa-edit"></span></button>
              <button action="delete" get="product{{$index}}"><span class="fa fa-trash"></span></button>
              </td>
                    
          </tr>
      </table>
  </div>
    <div class="tab_body" id="tab-3">
      <table>
          <thead><tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th class="limit">Description</th>
                  <th>Additional</th>
              </tr></thead>
          <tr ng-repeat="x in developer" id="developer{{$index}}">
            <td><ID>{{x.id}}</ID></td>
            <td><name>{{x.name}}</name></td>
      <td class="limit"><desc>{{x.desc}}</desc></td>
              <td><button action="edit" get="developer{{$index}}"><span class="fa fa-edit"></span></button>
              <button action="delete" get="developer{{$index}}"><span class="fa fa-trash"></span></button>
              </td>
                    
          </tr>
      </table>
  </div>
    <div class="tab_body" id="tab-4">
      <table>
         <thead><tr>
                  <th>ID</th>
                  <th>Name</th>
                  <th class="limit">Description</th>
                  <th>Additional</th>
              </tr></thead>
         <tr ng-repeat="x in group" id="group{{$index}}">
             <td><ID>{{x.id}}</ID></td>
      <td><name>{{x.name}}</name></td>
      <td class="limit"><desc>{{x.desc}}</desc></td>
              <td><button action="edit" get="group{{$index}}"><span class="fa fa-edit"></span></button>
              <button action="delete" get="group{{$index}}"><span class="fa fa-trash"></span></button>
              </td>
                    
          </tr>
      </table>
  </div>
</div>
            <div class="blur_pop" id="delete">
                <div class="confim" theme="">
                    <p> Are You sure to delete this <class></class> which id is <ID></ID>? </p>
                    <form action="del" method="post">
                            <input type="hidden" name="class" value="xl"/>
                            <input type="hidden" name="uid" value="XX"/>
                            <input type="hidden" name="additional" value=""/>
                            <button type="submit">OK</button>
                            <button type="reset">Cancel</button>
                    </form>
                </div>
            </div>
            <div id="user-update" class="blur_pop">
                <div class="form-center" theme="green">
                    <form action="update" method="post">
                    <h1>Update User</h1>    
                    <input type="hidden" name="class" value="user"/>
                    <input type="hidden" name="id" value="">
                    <p>User-Id</p> 
                    <input type="text" name="id" value="" disabled>
                    <p>User name</p>
                    <input type="text" name="name" value="" placeholder="User name">
                    <p>Email</p>
                    <input type="text" name="email" value="" placeholder="E-mail">
                    <p>Password</p>
                    <input type="text" name="pass" value="" placeholder="Password">
                    <div class="boolean" value="false">
                    <input type="hidden" name="auth" value="false"/>
                    <span class="yes">Authorized</span>
                    <span class=no>Unauthorized</span>
                    </div>
                    
                    <button type="submit">Update</button>
                    <button type="reset">Cancel</button>
                    </form>
                    
                </div>
            </div>
            <div id="product-update" class="blur_pop">
                <div class="form-center" theme="blue">
                    <form action="update" method="post" enctype="multipart/form-data">
                    <h1>Update product</h1>    
                    <input type="hidden" name="class" value="product"/>
                    <input type="hidden" name="id" value="">
                    <p>Product Id</p>
                    <input type="text" name="id" value="" disabled>
                    <p>Product name</p>
                    <input type="text" name="name" value="" placeholder="Product name">
                    <p>Developer id</p>
                    <div class="dropdown">
                        <select class="original" name="dev">
                            <option ng-repeat="x in developer" value="{{x.id}}">{{x.name}}</option>
                            
                        </select>
                        <div class="modified" name="dev">
                            <span></span>
                        <ul class="sublist">
                            <li ng-repeat="x in developer" value="{{x.id}}">{{x.name}}</li>
                            
                        </ul>
                        </div>
                        </div>
                    <p>Group Id</p>
                    <div class="dropdown">
                        <select class="original" name="group">
                            <option ng-repeat="x in group" value="{{x.id}}">{{x.name}}</option>
                            
                        </select>
                        <div class="modified" name="group">
                            <span></span>
                        <ul class="sublist">
                            <li ng-repeat="x in group" value="{{x.id}}">{{x.name}}</li>
                            
                        </ul>
                        </div>
                        </div>
                    <p>Logo of Product</p>
                    <input type="file" name="image" value="Pic/icons/windows10.png" accept="image/*">
                    <p>Categories</p>
                    <input type="text" name="category" value="" placeholder="Categories">
                    <p>Launch Date</p>
                    <input type="date" name="date">
                    <p>Trends</p>
                    <input type="number" name="trend">
                    <p>Price</p>
                    <input type="number" name="price">
                    <button type="submit">Update</button>
                    <button type="reset">Cancel</button>
                    </form>
                    
                </div>
                
            </div>
            <div id="developer-update" class="blur_pop">
                    <div class="form-center" theme="margenta">
                        <form action="update" method="post">
                            <h1></h1>
                            <input type="hidden" name="class" value="developer"/>
                            <input type="hidden" name="id" value="">
                            <p>Developer-Id</p>
                            <input type="text" name="id" value="" disabled>
                            <p>Developer name</p>
                            <input type="text" name="name" value="" placeholder="Developer name">
                            <p>Description</p>
                            <input type="text" name="desc" value="" placeholder="Developer name">
                            <button type="submit">Update</button>
                             <button type="reset">Cancel</button>
                        </form> 
                    </div>
                </div>
            <div id="group-update" class="blur_pop">
                    <div class="form-center" theme="saffron">
                        <form action="update" method="post">
                            <h1></h1>
                            <input type="hidden" name="class" value="group"/>
                            <input type="hidden" name="id" value="">
                            <p>Group-Id</p>
                            <input type="text" name="id" value="" disabled>
                            <p>Group name</p>
                            <input type="text" name="name" value="" placeholder="Group name">
                            <p>Description</p>
                            <input type="text" name="desc" value="" placeholder="Group name">
                            <button type="submit">Update</button>
                             <button type="reset">Cancel</button>
                        </form> 
                    </div>
                </div>
            <button class="RFloat" target="user"><span class="fa fa-plus"></span></button>
            <button class="LFloat" target="user"><span class="fa fa-sign-out"></span></button>
        </div>
        <script src="Js/jquery-3.4.1.js"></script>
        <script src="Js/Table/main.js" type="text/javascript"></script>
        <script>
            var app = angular.module('Table', []);
app.controller('ControllerA', function($scope) {
    $scope.user= <%= request.getAttribute("User") %>;
    $scope.developer=<%= request.getAttribute("Dev") %>;
    $scope.group=<%= request.getAttribute("Group") %>;
    $scope.product=<%= request.getAttribute("Prod") %>;
});

        </script>
    </body>
</html>
