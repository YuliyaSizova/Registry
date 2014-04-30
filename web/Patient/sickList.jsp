

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
         <jsp:include page="<%= HtmlBuilder.CHOOSE_HEADER%>" />
         <jsp:include page="<%= HtmlBuilder.CHECK_ACCEPT%>" flush="true"/>
               <%            Object l= request.getAttribute("list");
              Object t = request.getAttribute("ticket");
            if (l == null) {
                out.print(":(");
                return;
            }
            List<Sick_list> list = (List<Sick_list>) l;
             Integer ticket = (Integer)t;             
               
         %>
      ID докторов: 7, 8<br>
        ID пациентов: 2, 3, 4<br><br>
        Доавить больничный лист:
        <form name="add list" action="<%= request.getContextPath()%>/addSickList" method="POST">
            idDoctor: <input type="text" value="7" name="id_doctor"/>
            idPatient: <input type="text" value="2" name="id_patient" />
            DateBegin: <input type="text" value="27.04.2014" name="date_begin" 
                               onfocus="this.select();lcs(this);"
    onclick="event.cancelBubble=true;this.select();lcs(this);" readonly/>
            Date end: <input type="text" value="30.04.2014" name="date_end" 
                              onfocus="this.select();lcs(this);"
    onclick="event.cancelBubble=true;this.select();lcs(this);" readonly/>
            Diagnosis: <input type="text" value="Диагзно" name="diagnosis" />
            <input type="submit" value="Добавить" />
        </form>

        <br><br>
        
      
       
             <%
            for (Sick_list li : list) {

        %>
      
        <% if (li.getDate_end().after(new java.util.Date())){ %>
         <form name="update date" action="<%= request.getContextPath()%>/updateSickList" method="POST">
             <br>   Изменить дату окончания:<br>
             <input type="hidden" value="<%=li.getId_sick_list()%>" name="id_sick_list" >
            Date end: <input type="text" value="" name="date_end"
                              onfocus="this.select();lcs(this);"
    onclick="event.cancelBubble=true;this.select();lcs(this);" readonly/>
            <input type="submit" value="обновить" />
             </form>
        <%}%>
        <b>Выписал врач: </b><%=li.getDoctor().getSurname()%> <%=li.getDoctor().getName()%> <%=li.getDoctor().getPatronymic()%><br>
        <b> Профиль</b><%=li.getDoctor().getProfile()%><br>
        С <%=li.getDate_begin()%> по <%=li.getDate_end()%><br>
        <b>Диагноз: </b><%=li.getDiagnosis()%> <br>
        <%}%>
       
    </body>
</html>
