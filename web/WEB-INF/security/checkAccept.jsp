<%-- 
    Document   : checkAccept
    Created on : 16.04.2014, 19:12:11
    Author     : ASUS
--%>




<%@page import="HtmlBuild.HtmlBuilder"%>
<%--
    Проверяет, есть ли у пользователя право просмотра страницы.
    Список ролей, имеющих доступ к странице, должен быть заполнен заранее.
    Если доступа нет, выводит соответствующее сообщение и закрывает
    поток для вывода.
--%>
<%@page import="Objects.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="security" class="security.SecurityBean" scope="request" />
<jsp:useBean id="user" scope="session" class="Objects.User" />
<%
    if ( !security.isUserAccepted(user)) {
        out.print("You shall no pass!");
        out.print("<a href=\"" + request.getHeader("referer")+ "\">обрано</a>");
        out.close();
        return;
    }
%>


