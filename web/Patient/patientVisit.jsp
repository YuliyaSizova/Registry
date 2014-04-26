<%-- 
    Document   : patientVisit
    Created on : 21.04.2014, 7:22:11
    Author     : ASUS
--%>

<%@page import="Objects.Patient"%>
<%@page import="Objects.Journal"%>
<%@page import="java.util.List"%>
<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Прием у врача</title>
    </head>
    <body>

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
        <form  name="visit" action="addVisit/" method="POST">
             <a href="/Registry/Patient/sickList.jsp"> Больничный </a> <br>
             Добавте запись в электронную карту пациента: <br> 
           <textarea  name="blank" rows="4" cols="70">
            </textarea><br>
           Лекарства:         <input type="text" name="med" value="" size="80" /><br>
            <input type="submit" value="Добавить результат приема" name="add" />
              </form>
        <br>
        <% String hr ="-----------------------------------------";%>
        <b>Предыдущие посещения:</b><br><%=hr%><br>
        <%
            for (Journal j : jo) {

        %>
        <b>Число </b><%=j.getTicket().getD().getDaten()%> <b>Время </b><%=j.getTicket().getTime().getTime()%><br>
        <b>Врач: </b><%= j.getTicket().getDoctor().getSurname()%> <%= j.getTicket().getDoctor().getName()%>
        <%= j.getTicket().getDoctor().getPatronymic()%><br>
        <i><%=j.getTicket().getDoctor().getProfile()%></i><br>             
        <%= j.getDiagnosis()%> <br><%=hr%><br>


        <%
            }
        %>
    </body>
</html>
