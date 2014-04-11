

<%@page import="Objects.Patient"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Object potentialPatient = request.getAttribute("patient");
            if (potentialPatient == null) {
                out.print(":(");
                return;
            }
            Patient patient = (Patient) potentialPatient;
        %>
      
        Имя: <%= patient.getName()%> <br>
        Фамилия: <%= patient.getSurname()%><br>
        Отчество: <%= patient.getPatronymic()%><br>
        Дата рождения: <%= patient.getBirthday()%><br>
        Полис: <%= patient.getPolicy()%><br>
        Дом: <%= patient.getHouse().getHouse_number() + " " + patient.getHouse().getBlock()%><br>
    </body>
</html>