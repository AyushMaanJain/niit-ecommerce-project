<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

    <html>
        <head>
            <link rel="stylesheet" href="css/theme.css" type="text/css">
            <link rel="stylesheet" href="css/basic.css" type="text/css">
            <title>Thank You</title>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
          <div class="head"><span class="Pname" style="height: 30px;"><a href="index.jsp"> Ailmax </a></span></div>  
        <div class="body" at="id" style="height:calc(100%); background: #fff; width: 100%;">
          
            <div class="message">Thank You</div>
            <div class="note" style="text-align: center;font-size: 30px">
                <p>
                    <b>This product have been added to library.</b>
                </p>
            </div>
        </div>
        <script>
            function redirect(){
                window.location.href="index.jsp";
            }
            window.setTimeout(redirect, 5000);
        </script>
    </body>
</html>