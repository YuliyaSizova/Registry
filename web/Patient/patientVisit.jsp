<%-- 
    Document   : patientVisit
    Created on : 21.04.2014, 7:22:11
    Author     : ASUS
--%>

<%@page import="Objects.Ticket"%>
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
            Object t = request.getAttribute("ticket");
            Ticket ticket = (Ticket) t;

        %>


        <a class="other" href="http://localhost:8084/Registry/showPatient/?patient_id=<%=pa.getId_patient()%>">Вернуться на страницу пациента</a><br><br>
        <%if (ticket.getId_ticket() != 0) {%>
        <form  name="visit" action="/Registry/addVisit/" >
            
            <br> 
            <b> № талона: </b>  <%=ticket.getId_ticket()%><br>
            <b>Причина посещения:</b>   <%=ticket.getPrimary_diagnosis()%><br>
            <i>Добавте запись в электронную карту пациента:</i><br>
            <textarea  name="blank"  cols="70">
            </textarea><br>
            <input type="hidden" name="patient_id" value="<%=pa.getId_patient()%>" />
            <input type="hidden" name="id_ticket" value="<%=ticket.getId_ticket()%>" /> 
            Лекарства:         <input type="text" name="med" value="" size="80" /><br>

            <input type="submit" value="Добавить запись" class="selectH" /><br>

        </form>
        <form name="sick" action = "<%= request.getContextPath()%>/showSickList" >
            
            <input type="hidden" name="id_patient" value="<%=pa.getId_patient()%>" /> 
            <input type="submit" value="Больничные"  />
        </form>
        <%} else
                out.print("Для приема пациент должен взять талон!");%>
        <br>
        <% String hr = "-----------------------------------------";%>
        <b>Предыдущие посещения:</b><br><%=hr%><br>
        <%
            for (Journal j : jo) {

        %>
        <b>Число </b><%=j.getTicket().getD().getDaten()%> <b>Время </b><%=j.getTicket().getTime().getTime()%><br>
        <b>Врач: </b><%= j.getTicket().getDoctor().getSurname()%> <%= j.getTicket().getDoctor().getName()%>
        <%= j.getTicket().getDoctor().getPatronymic()%><br>
        <i><%=j.getTicket().getDoctor().getProfile()%></i><br>             
        <%= j.getDiagnosis()%><br>
        <b>Выписанные лекарства: </b><%= j.getMed()%>
        <form name="Journal Edit Form" action="/Registry/editJournalForm/">
            <input type="hidden" name="Id_journal" value="<%= j.getId_journal()%>" />
            <input type="hidden" name="id_patient" value="<%=pa.getId_patient()%>" /> <%-- Чтобы потом перенаправить сюда --%>
            <input type="submit" value="Редактировать" class="selectH" />
        </form><%=hr%><br>


        <%
            }
        %>
    </body>
</html>
