<%-- 
    Document   : PatientHistory
    Created on : 15.04.2014, 21:36:48
    Author     : ASUS
--%>

<%@page import="Objects.Patient"%>
<%@page import="java.util.List"%>
<%@page import="Objects.Journal"%>
<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>История посещений врачей</title>
    </head>
    <body>  
        <jsp:useBean id="user" class="Objects.User" scope="session" />
        <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER%>" />
        <jsp:include page="<%= HtmlBuilder.CHECK_ACCEPT%>" flush="true"/>
        <%            Object J = request.getAttribute("journal");
            if (J == null) {
                out.print(":(");
                return;
            }
            List<Journal> jo = (List<Journal>) J;
               Object p = request.getAttribute("patient");
                Patient pa = (Patient) p;
               
         %>
        

         <a class="other" href="http://localhost:8084/Registry/showPatient/?patient_id=<%=pa.getId_patient()%>">Вернуться на страницу пациента</a><br><br>
        <%
            for (Journal j : jo) {

        %>
        <b>Число </b><%=j.getTicket().getD().getDaten()%> <b>Время </b><%=j.getTicket().getTime().getTime()%><br>
        <b>Врач: </b><%= j.getTicket().getDoctor().getSurname()%> <%= j.getTicket().getDoctor().getName()%>
        <%= j.getTicket().getDoctor().getPatronymic()%><br>
        <i><%=j.getTicket().getDoctor().getProfile()%></i><br>             
    <b>Запись о посещении: </b><%= j.getDiagnosis()%> <br>
    
    <b>Выписанные лекарства: </b><%= j.getMed()%>
    <br>-----------------------------------------<br>


    <%
        }
    %>
</body>
</html>
