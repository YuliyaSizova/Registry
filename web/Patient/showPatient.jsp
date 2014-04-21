

<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page import="Objects.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Работа с пациентом</title>
    </head>
    <body>
        <jsp:include page="<%= HtmlBuilder.CHECK_ACCEPT%>" flush="true"/>
        <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER %>" />
       
        <%            Object potentialPatient = request.getAttribute("patient");
            if (potentialPatient == null) {
                out.print(":(");
                return;
            }
            Patient patient = (Patient) potentialPatient;
        %>

        <b>Имя:</b> <%= patient.getName()%> <br>
        <b>Фамилия:</b> <%= patient.getSurname()%><br>
        <b>Отчество:</b> <%= patient.getPatronymic()%><br>
        <b>Дата рождения:</b> <%= patient.getBirthday()%><br>
        <b>Полис:</b> <%= patient.getPolicy()%><br>
        <b>Дом:</b> <%= patient.getHouse().getHouse_number() + " " + patient.getHouse().getBlock()%><br>
        <b>Улица:</b> <%= patient.getHouse().getStreet().getName()%>
    <center><table><tr><th>
            <form name="Show Patient Form" action="/Registry/history/" method="GET">
                        <input type="hidden" name="patient_id" value="<%= patient.getId_patient()%>" />
                        <input type="submit" value="Посмотреть историю посещения врачей" />
            </form></th><th>
                        <form name="Show Patient Form" action="/Registry/Patient/patientVisit.jsp" method="GET">
                        <input type="hidden" name="patient_id" value="<%= patient.getId_patient()%>" />
                        <input type="submit" value="Новый прием" />
                        </form></th></table></center>
    </body>
</html>
