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
        <title></title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/theme.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="fonts/fonts setup.css" type="text/css"/>
        <style>
            body{margin: 0;
                 background: none;
            }
            .baseimg{
                padding-top: 400px;
                background-image: url(Pic/products/windows10.jpg);
                background-repeat: no-repeat;
                background-size: cover;
                background-position:center;
                width: 100%;
                opacity: 1;
                    }
                    .fixed{
                        display: block;
                        position: fixed
                    }
                    .fixed[display="none"]{
                        display: none;
                    }
                    .head{
                        
                        margin-left: auto;
                        margin-right: auto;
                        padding:20px;
                        font-family: sans-serif;
                        width: 100%;
                    }
                    #Ohead{
                        width: 900px;
                    }
                    .icon{margin-top: 10px;
                        width: 50px;}
                    .heading{ padding: 10px;
                              font-weight: 500;
                   
                            font-size: 30px;}
                    
                    .body h2{padding:20px;margin:0;}
                    .body p,.body ul{font-size:20px;padding:30px;padding-top:0;margin:0; text-align:center;}
                    .body ul{margin-left:40px;text-align:left;}
                    .body ul li{padding-bottom:20px;}
                    .fadehead{
                        width: 100%;
                        padding: 0;
                    }
                    .options{
                        margin-left: auto;
                        border-spacing: 5px;
                    }
                    .options button:focus{
                        outline: none;
                    }
                    .options button{
                        padding: 10px;
                        border: none;
                        border-radius: 15px;
                        
                    }
        </style>
    </head>
    <body>
        <div class="head fixed" display="none">
            <table>
                <tr>
                    <td><img class="icon" src="Pic/icons/windows10.png"></td>
                    <td><span class="heading">Windows 10 Pro 2019</span></td>
                </tr>
            </table> 
        </div>
        <div class="fadehead">
            <div class="baseimg">
                            <div id="Ohead" class=" head">
                    <table>
                        <tr><td><img class="icon" src="Pic/icons/windows10.png"></td>
                            <td><span class="heading">Windows 10 Pro 2019</span></td>
                        </tr>
                    </table>
                    <table class="options">
                        <tr>
                            <td><form method="get" target="buy">
                    <input type="hidden" value="1234" name="product">
                    <button type="submit">Buy &#8377;1234</button>
                </form></td>
                <td><form method="post" target="Addcart">
                    <input type="hidden" value="1234" name="product">
                    <button type="submit" class="fa fa-cart-plus"> Cart</button>
                </form></td>
                        </tr>
                    </table>
            </div>
            </div>

        </div>
        <div class="body">
        <h2>Windows 10</h2>
        <p>
       Windows 10 is a series of operating systems developed by Microsoft and released as part of its Windows NT family of operating systems. It is the successor to Windows 8.1, released nearly two years earlier, and was released to manufacturing on July 15, 2015, and broadly released for the general public on July 29, 2015.[14] Windows 10 was made available for download via MSDN and Technet, and as a free upgrade for retail copies of Windows 8 and Windows RT users via the Windows Store. Windows 10 receives new builds on an ongoing basis, which are available at no additional cost to users, in addition to additional test builds of Windows 10, which are available to Windows Insiders.
        </p>
        <h2>Features</h2>
        
        <ul>
        <li>Start Menu Returns. It's what Windows 8 detractors have been clamoring for, and Microsoft has finally brought back the Start Menu.</li>
		<li>Cortana on Desktop. Being lazy just got a lot easier.</li>
		<li>Xbox App.</li>
		<li>Project Spartan Browser.</li>
		<li>Improved Multitasking.</li>
		<li>Universal Apps.</li>
		<li>Office Apps Get Touch Support.</li>
		<li>Continuum.
</ul>
        
        <h2>Requirements</h2>
        <ul>
        <li>1 gigahertz (GHz) or faster processor or System on a Chip (SoC)</li>
        <li>1 gigabyte (GB) for 32-bit or 2 GB for 64-bit</li>
        <li>16 GB for 32-bit OS 32 GB for 64-bit OS</li>
        <li>DirectX 9 or later with WDDM 1.0 driver</li>
        <li>800x600 display resolution (minimum)</li>
        </ul>
        </div>
        <script src="Js/jquery-3.4.1.js"></script>
        <script>
            $(document).ready(function(){
                var head=document.getElementById("Ohead");
                var vizPoint=head.offsetTop;
                
                $(window).scroll(function(){
                    var scrolled=window.pageYOffset;
                   if(scrolled>=vizPoint){
                       $(".fixed").css("display","block");
                   }else{
                       $(".fixed").css("display","none");;
                   }
                });
            });
        </script>
    </body>
</html>
