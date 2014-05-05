

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Objects.User"%>
<%@page import="Objects.Doctor"%>
<%@page import="Objects.Sick_list"%>
<%@page import="java.util.List"%>
<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Больничные</title>
        <script src="<%= request.getContextPath()%>/calendar_ru.js" type="text/javascript"></script>
    </head>
    <body>
        <jsp:useBean id="user" class="Objects.User" scope="session" />
        <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER%>" />
        <jsp:include page="<%= HtmlBuilder.CHECK_ACCEPT%>" flush="true"/>
        <%  Object l = request.getAttribute("list");
          
            Object p = request.getAttribute("id_patient");
             Object o = request.getAttribute("open");

            if (p == null) {
                out.print(":(");
                return;
            }
            List<Sick_list> list = (List<Sick_list>) l;
         
            Integer open = (Integer) o;
            User us = (User) session.getAttribute("user");
            Integer patient = (Integer) p;
            %>
<a class="other" href="http://localhost:8084/Registry/visit/?patient_id=<%=patient.intValue()%>">Вернуться на страницу приема</a><br>
 <jsp:useBean id="addAnswer" scope="session" class="fabric.AnswerBean" />
        <%
            String answer = addAnswer.getMessage();
            // Мы пытаемся считать сообщение о том, была или не была
            // добавлена запись. Если сообщение равно null, то ничего не пишем.
            if (answer != null) {
                %><font color = "Red"><%out.println(answer);%></font><%
                addAnswer.setMessage(null);
            }
        %> <br>        
<%
if (open.intValue() == 0)
{        %>
        
        

        Добавить больничный лист:
        <form name="add list" action="<%= request.getContextPath()%>/addSickList" method="POST">
            <input type="hidden" value="<%=us.getDoctor().getId_doctor()%>" name="id_doctor"/>
            <input type="hidden" value="<%=patient.intValue()%>" name="id_patient" />
            Дата начала: <input type="text"  name="date_begin" 
                                onfocus="this.select();
                                      lcs(this);"
                                onclick="event.cancelBubble = true;
                                      this.select();
                                      lcs(this);" readonly/>
            Дата окончания: <input type="text" name="date_end" 
                                   onfocus="this.select();
                                     lcs(this);"
                                   onclick="event.cancelBubble = true;
                                     this.select();
                                     lcs(this);" readonly/><br>
          Причина больничного: <input type="text" name="diagnosis" size="46"/>
            <input type="submit" value="Добавить" />
        </form>
<%}%>
        <br><br>



        <%
            for (Sick_list li : list) {

        %>
        <br>
        <b>Выписал врач: </b><%=li.getDoctor().getSurname()%> <%=li.getDoctor().getName()%> <%=li.getDoctor().getPatronymic()%><br>
        <i> <%=li.getDoctor().getProfile()%></i><br>
        С <%=li.getDate_begin()%> по <%=li.getDate_end()%><br>
        <b>Причина больничного: </b><%=li.getDiagnosis()%> <br>
        <% if (li.getDate_end().after(new java.util.Date())) {%>
        <form name="update date" action="<%= request.getContextPath()%>/updateSickList" method="GET">
            <br>   Продлить больничный:<br>
            <% SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        formatter.setLenient(false);%>
        <input type="hidden" value="<%=formatter.format(li.getDate_begin())  %>" name="date_begin" />
            <input type="hidden" value="<%=patient.intValue()%>" name="id_patient" />
            <input type="hidden" value="<%=li.getId_sick_list()%>" name="id_sick_list" >
            Дата окончания: <input type="text"  name="date_end"
                             onfocus="this.select();
                                     lcs(this);"
                             onclick="event.cancelBubble = true;
                                     this.select();
                                     lcs(this);" readonly/>
            <input type="submit" value="Продлить" />
        </form>
        <%}%>
 -----------------------------------------------
        <%}%>

    </body>
</html>
