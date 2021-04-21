<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
    <head>
        <title>account</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/theme.css" type="text/css">
        <link rel="stylesheet" href="css/basic.css" type="text/css">
        <link rel="stylesheet" href="fonts/fonts setup.css" type="text/css"/>
    </head>
    <body>
    <%
    HttpSession httpSession = request.getSession(false);
    if (session != null) {
        session.invalidate();
    } 
    %>
        <div class="head">
            <span class="Pname"><a href="index.jsp">Ailmax</a></span>
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
                <div class="outer">
                    <button class="fa fa-google" style="background: #d00;"></button>
                    <button class="fa fa-facebook" style="background: #00d;"></button>
                    <button class="fa fa-twitter" style="background: #0dd;"></button>
                    <button class="fa fa-github" style="background: #222;"></button>
                </div>
                <br>
                <div id="register">
                    <form method="post" action="Register">
                        <h2>Sign Up</h2>
                    <input type="hidden" name="request" valune="none">
                    <input type="text" name="name" placeholder="Your Name"/><br>
                    <input type="email" name="email" placeholder="Your email"/><br>
                    
                    <input type="password" name="password" placeholder="Your Password"/><br>
                    <%String s=request.getParameter("message");
                    if(!(s==null||s.equals(""))){
                    	out.print("<message>"+s+"</message><br>");
                    } %>
                   
                    <button type="submit">Create Account</button>
                    <a href="?login"><b>Sign in</b></a>
                    </form>
                </div>
                <br>
                <div id="Login">
                <h2>Sign In</h2>
                <form method="post" action="Login">
                    <input type="hidden" name="request" valune="none">
                    <input type="email" name="email" placeholder="Your email"/><br>
                    
                    <input type="password" name="password" placeholder="Your Password"/><br>
                    <%//String s=request.getParameter("message");
                    if(!(s==null||s.equals(""))){
                    	out.print("<message>"+s+"</message><br>");
                    } %>
                    <button type="submit">Sign In</button>
                   
                    <a href="?register"><b>Create new Account</b></a>
                </form>
                </div>
            </div>
        </div>
        <script src="Js/jquery-3.4.1.js"></script>
        <script src="Js/ID/main.js"></script>
    </body>
</html>
