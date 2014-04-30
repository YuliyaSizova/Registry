<%-- 
    Document   : PatientHistory
    Created on : 15.04.2014, 21:36:48
    Author     : ASUS
--%>

<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
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
            String profile = request.getParameter("profile");
            Set<String> profiles = new HashSet<String>(); // Кладём все профили Set для того,
                                                          //чтобы повторов не было (List допускает повторы).
            // Set<String> profiles = new HashSet<>(); - так писать нельзя, так как Tomcat, похоже, не знает о Java 7
            for (Journal j : jo) {
                profiles.add(j.getTicket().getDoctor().getProfile()); // Заполняем Set профилями
            }
         %>
         <form name="select profile" action="<%= request.getContextPath() %>/history/" method="GET">
             Отобразить посещения специалиста:
             <input type="hidden" value="<%= request.getParameter("patient_id")%>" name="patient_id" />
             <select onchange="this.form.submit();" name="profile"> 
                 <%-- onchange="this.form.submit();" - при изменении значения имитируем нажатие кнопки submit (функция JavaScript)--%>
                 <%-- Если никакой специалист не выбран, то делаем выделенным пункт "Все специалисты" --%>           
                <option value="" <%= (profile == null || profile.isEmpty()) ? "selected" : "" %>>Все специалисты</option>
                <%
                    for (String currentProfile : profiles) {
                        %>
                        <%-- Если какой-то специалист выбран, то делаем выделенным соответствующий пункт.
                           currentProfile.equals(profile)  - если profile==null, то nullPointerException'а не будет,
                           будет false, что и требуется --%>
                        <option value="<%= currentProfile %>" <%= (currentProfile.equals(profile) ? "selected" : "") %>>
                            <%= currentProfile %>
                        </option>
                        <%
                    }
                %>
            </select><br><br>
         </form>
        <%
            for (Journal j : jo) {
                if (profile != null && !profile.isEmpty() && !profile.equals(j.getTicket().getDoctor().getProfile())) {
                    // Если выбран какой-то специалист и он не совпадает с текущим, то пропускаем
                    continue;
                }
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
