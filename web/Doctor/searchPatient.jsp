<%-- 
    Document   : searchPatient
    Created on : 03.04.2014, 9:52:34
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Поиск пациента</title>
    </head>
    <body>
        <%@ include file="headerDoc.jsp" %>
        <form name="Data Input Form" action="searchPatient/" method="GET">
            Введите номер полиса:<br>
            <input type="text" name="policy" value="" />
            <input type="submit" value="Поиск" />
           
        </form>
        <br>
        <%=session.getAttribute("user")%>
    </body>
</html>
