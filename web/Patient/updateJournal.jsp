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
        <%           
            Journal journal = (Journal) request.getAttribute("journalToUpdate");
            if (journal == null) {
                out.print(":(");
                return;
            }
             Object p = request.getAttribute("patient");
            Patient pa = (Patient) p;
            %><br>
        <a class = other href ="http://localhost:8084/Registry/visit/?patient_id=<%=pa.getId_patient()%>">Вернуться назад</a>
        <form name="update journal form" action="/Registry/updateJournal/" method="POST">
            <input type="hidden" name="Id_journal" value="<%= journal.getId_journal()%>" />
            <input type="hidden" name="id_patient" value="<%= request.getParameter("id_patient")%>" />
            <input type="text" name="med" value="<%= journal.getMed()%>" />
            <input type="text" name="diagnosis" value="<%= journal.getDiagnosis()%>" />
            <input type="submit" value="Сохранить" />
        </form>
         
    </body>
</html>
