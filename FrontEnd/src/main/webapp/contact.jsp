<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Contact Us</title>
         <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/theme.css" type="text/css">
        <link rel="stylesheet" href="css/basic.css" type="text/css">
        <link rel="stylesheet" href="fonts/fonts setup.css" type="text/css"/>
    </head>
    <body>
        <div class="head">
            <span class="Pname"><a href="index.html">Ailmax</a></span>
            <button class="searchToggle fa fa-search" style="margin-right: 30px;"></button>
            <div class="searchCon" display="none">
                    <span class="back fa fa-arrow-left"></span>
                    <form method="get" action="filter" class="searchBox">
                    <span class="fa fa-search"></span>
                    <input type="text" name="search" placeholder="search..." autocomplete="off"/>
                    </form>
            </div>
        </div>
        <div class="body" at="id" style="height:calc(100%); width: 100%;">
            <div class="form">
                <form method="post" action="complaint">
                    <h2>Write your message</h2>
                    <input type="email" name="email" placeholder="write your email"/><br>
                    <textarea name="message" placeholder="write your message"></textarea><br>
                    <button type="submit">submit</button>
                </form>
            </div></div>
    </body>
</html>
