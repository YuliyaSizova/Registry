<%-- 
    Document   : SickList
    Created on : 25.04.2014, 10:15:09
    Author     : ASUS
--%>

<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Больничные</title>
    </head>
    <body>
         <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER%>" />
         <jsp:include page="<%= HtmlBuilder.CHECK_ACCEPT%>" flush="true"/>
     
    </body>
</html>
