<%-- 
    Document   : index
    Created on : 12.03.2014, 10:42:02
    Author     : ASUS
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="HtmlBuild.HtmlBuilder"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Войти</title>
    </head>
    <body>
         <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER %>" />
       
         <p align="right"> <a class="other" href="">Зарегистрировать пациента</a></p>
         <jsp:useBean id="addAnswer" scope="session" class="fabric.AnswerBean" />
        <%
            String answer = addAnswer.getMessage();
            // Мы пытаемся считать сообщение о том, была или не была
            // добавлена запись. Если сообщение равно null, то ничего не пишем.
            if (answer != null) {
                %><font color = "Red"><%out.println(answer);%></font><%
                addAnswer.setMessage(null);
            }
        %> 
        <form name="loging" action="LoginUser/" method="POST">
            Введите логин :<br>
            <input type="text" name="username" value="" />
            <br>
            Введите пароль :<br>
            <input type="password" name="password" value="" />
            <br>
            <input class="patient" type="submit" value="Войти" />
         </form>
 
    </body>
</html>
