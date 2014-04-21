<%-- 
    Document   : header
    Created on : 26.03.2014, 17:40:15
    Author     : ASUS
--%>

<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       <% String ROOT = request.getContextPath();%>
        <%= HtmlBuilder.includeCSS(ROOT)%>
    </head>
    <body>
       
        <table class="selectH" border=1 ><tr>
              <th class="selectH" width="25%"><img src="/Registry/pics/logo.gif" alt=":("/><h3>Электронная регистратура</h3></th></tr> 
       </table>
       
    </body>
</html>
