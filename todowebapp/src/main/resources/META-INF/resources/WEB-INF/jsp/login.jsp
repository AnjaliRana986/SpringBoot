<html>
     <head>
         <title> My first HTML Page - JSP</title>
     </head>
     <body>
        Welcome to Login Page!
        <pre>
            ${errorMesage}
        </pre>
<%--        when Request method is get -> all info is sent as part of url which is not secure. so use post--%>
        <form method="post">
            Name: <input type="text" name="name">
            Password : <input type="password" name="password">
            <input type="submit">
        </form>

    </body>
</html>