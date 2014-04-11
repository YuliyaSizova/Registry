<%-- 
    Document   : index
    Created on : 12.03.2014, 10:42:02
    Author     : ASUS
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Войти</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <a href="loging.jsp">Зарегистрироваться</a>
         <form name="loging" action="LoginUser/" method="POST">
            Введите логин (номер полиса ОМС):<br>
            <input type="text" name="username" value="" />
            <br>
            Введите пароль (дата рождения):<br>
            <input type="password" name="password" value="" />
            <br>
            <input type="submit" value="Войти" />
         </form>
         <form name="Doctor's Patient List Test" action="/Registry/ShowPatientList/" method="GET">
            Введите 7:
            <input type="text" name="doctor_id" value="7" />
            <br>
            <input type="submit" value="Список пациентов доктора с данным id" />
        </form>
    </body>
</html>
