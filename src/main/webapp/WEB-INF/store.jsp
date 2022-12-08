<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ecommerce</title>
    </head>
    <body>
        <h1>Ecommerce</h1>
       
        <h2>Liste des articles</h2>
         <ul>
            <c:forEach items="${articles}" var="article">
                 <li> ${ article.name }
            </c:forEach>             
         </ul>
         
    </body>
</html>