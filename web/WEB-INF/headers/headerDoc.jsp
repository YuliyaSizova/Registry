<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page import="Objects.Doctor"%>
<%@page import="Objects.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    User loginParol = (User) session.getAttribute("user");

    Doctor doctorForHeader = loginParol.getDoctor();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <% String ROOT = request.getContextPath();%>
        <%= HtmlBuilder.includeCSS(ROOT)%>
    </head>
    <body>
        <table class="selectH" border=1 ><tr><th class="selectH" width="25%"> <img src="/Registry/pics/logo.gif" alt=":("/> <h3>Электронная регистратура</h3></th></tr> 
</table>
<center>   
    <p  align="right"><b>Врач</b> <%= doctorForHeader.getSurname() + " "
                       + doctorForHeader.getName() + " "
                       + doctorForHeader.getPatronymic()%> 
        <a class="headerlink" href="/Registry/LogoutUser/">Выйти</a>
    </p>
    <table ><tr>
            <td><center><a class="headerlink" href="/Registry/ShowPatientList/">Список пациентов</a></center></td><td><center><a class="headerlink" href="/Registry/ShowProfile/">Личная страница врача</a></center></td>
    </table>
</center>

</body>
</html>
