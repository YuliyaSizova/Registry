<%-- 
    Document   : profile
    Created on : 03.04.2014, 19:51:02
    Author     : ASUS
--%>

<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page import="Objects.Worktime"%>
<%@page import="Objects.Doctor"%>
<%@page import="java.util.List"%>
<%@page import="Dao.DoctorDao"%>
<%@page import="Access.AccessTableFactory"%>
<%@page import="fabric.TableFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Личная страница врача</title>
    </head>
    <body>
        <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER%>" />
        <%  Object profile = request.getAttribute("profile");
            Object worktime = request.getAttribute("worktime");

            if (profile == null) {
                out.print("Отсутствует личная информация");
                return;
            }
            Doctor doctor = (Doctor) profile;
            List<Worktime> worktimes = (List<Worktime>) worktime;%>

        <b>ФИО:</b> <%=doctor.getSurname()%> <%= doctor.getName()%> <%=doctor.getPatronymic()%> <br>
        <b>Дата рождения:</b> <%=doctor.getDbirthday()%><br>
        <b>Профиль:</b> <%=doctor.getProfile()%><br>
        <b>Время работы:</b><br>
        <%for (Worktime wk : worktimes) {%>
        <%=wk.getKindofday()%> с <%=wk.getBeginning_hour()%> до <%=wk.getEnding_hour()%><br>
        <%}%>
        <b>Кабинет:</b> <%=doctor.getCabinet()%><br>
        <b>Поликлиника:</b> <%=doctor.getPoliclinic().getName()%><br>
    </body>
</html>
