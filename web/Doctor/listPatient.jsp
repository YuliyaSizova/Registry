<%-- 
    Document   : listPatient
    Created on : 03.04.2014, 19:43:06
    Author     : ASUS
--%>

<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page import="Objects.Patient"%>
<%@page import="java.util.List"%>
<%@page import="Access.AccessTableFactory"%>
<%@page import="Dao.PatientDao"%>
<%@page import="fabric.TableFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список пациентов, закрепленных за данных врачом</title>
    </head>
    <body>
        <jsp:useBean id="user" class="Objects.User" scope="session" />
        <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER%>" />
        <jsp:include page="<%= HtmlBuilder.CHECK_ACCEPT%>" flush="true"/>

        <%  /*StringBuilder builder = new StringBuilder();
             TableFactory factory = new AccessTableFactory();
             PatientDao patientDao = factory.makePatient();
             List<Patient> patients = patientDao.getByDoctorId_Patient(7);*/


            Object perhapsListOfPatients = request.getAttribute("patientList");
            // patientList - то имя, которое указали в setAttribute (см. код сервлета)
            if (perhapsListOfPatients == null) {
                out.print("Закрепленные пациенты отсутствуют");
                return;
            }
            List<Patient> patients = (List<Patient>) perhapsListOfPatients;

        %>
        <br> <br>
    <center> <table border=1><tr><th>Фамилия</th><th>Имя</th><th>Отчество</th><th>№ полиса OMC</th><th>Действия</th></tr>
            <tr>
            <form name="Filter Form" action="/Registry/ShowFilteredPatientList/" method = "GET">
                <td>
                    <input type="text" name="surname" value="" />
                </td>
                <td>
                    <input type="text" name="name" value="" />
                </td>
                <td>
                    <input type="text" name="patronymic" value="" />
                </td>
                <td>
                    <input type="text" name="policy" value="" />
                </td>
                <td>
                    <input type="hidden" name="doctor_id" value="<%= request.getParameter("doctor_id")%>" />
                    <input type="submit" value="Поиск">
                </td>
            </form>
            </tr>
            <%
                for (Patient patient : patients) {
            %>
            <tr>
                <td> <%= patient.getSurname()%> </td>
                <td> <%= patient.getName()%> </td>
                <td> <%= patient.getPatronymic()%> </td>
                <td> <%= patient.getPolicy()%> </td>
                <td> 
                    <form name="Show Patient Form" action="/Registry/showPatient/" method="GET">
                        <input type="hidden" name="patient_id" value="<%= patient.getId_patient()%>" />
                        <input type="submit" value="Посмотреть" />
                    </form>
                </td>
            </tr>
            <%
                }
            %>
        </table></center>
</body>
</html>
