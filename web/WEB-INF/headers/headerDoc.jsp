
<%-- 
    Document   : headerDoc
    Created on : 03.04.2014, 9:41:54
    Author     : ASUS
--%>

<%@page import="Objects.Doctor"%>
<%@page import="Objects.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User loginParol = (User) session.getAttribute("user");
   // if (loginParol == null || !(loginParol.getLevel().equals("doctor"))) {
     //   out.print("You shall not pass!");
    //    out.print("<a href=\"" + request.getContextPath() + "\">обратно</a>");
    //    return;
   // }
    Doctor doctorForHeader = loginParol.getDoctor();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
    <center>  <h3>Электронная регистратура</h3> 
        <hr>      
        <p align="right"><b>Врач</b> <%= doctorForHeader.getSurname() + " "
                + doctorForHeader.getName() + " "
                + doctorForHeader.getPatronymic()%> 
            <a href="/Registry/LogoutUser/">Выйти</a>
        </p>
        <table><tr>
            <td><center><a href="/Registry/ShowPatientList/"   >Список пациентов</a></center></td><td><center><a href="/Registry/ShowProfile/">Личная страница врача</a></center></td>
        </table>
    </center>

</body>
</html>
