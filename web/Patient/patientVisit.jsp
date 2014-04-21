<%-- 
    Document   : patientVisit
    Created on : 21.04.2014, 7:22:11
    Author     : ASUS
--%>

<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Прием у врача</title>
    </head>
    <body>
        <jsp:include page="<%= HtmlBuilder.CHECK_ACCEPT%>" flush="true"/>
        <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER %>" />
    </body>
</html>
