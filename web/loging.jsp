<%-- 
    Document   : loging
    Created on : 26.03.2014, 21:45:22
    Author     : ASUS
--%>

<%@page import="Objects.House"%>
<%@page import="Objects.Street"%>
<%@page import="Dao.StreetDao"%>
<%@page import="Dao.HouseDao"%>
<%@page import="Access.AccessTableFactory"%>
<%@page import="fabric.TableFactory"%>
<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Регистрация нового пользователя</title>
    </head>
    <body>
        <%TableFactory factory = new AccessTableFactory(); %>
        <%@ include file="header.jsp" %>
        <form name="Data Input Form" action="AddStreet/" method="POST">
            Введите имя:<br>
            <input type="text" name="name" value="" />
            <br>
            Введите фамилию:<br>
            <input type="text" name="surname" value="" />
            <br>
            Введите отчество:<br>
            <input type="text" name="patronymic" value="" />
            <br>
            Введите номер полиса (десятизначный):<br>
            <input type="text" name="policy" value="" />
            <br>
            Введите дату рождения:<br>
            <input type="text" name="birthday" value="" />
            <br>
            Выберите улицу: <br>
            <script>
             //   function hi() { // Сюда нужно будет поместить запрос нужных значений из БД, желательно при помощи ДАО
               //     var sel = document.getElementById("street"); // Получаем наш список
                //    var val = sel.options[sel.selectedIndex].value; // Получаем значение выделенного элемента
                  //  document.getElementById("layer").innerHTML = "<%=//HtmlBuilder.makeHouseSelect(val) %>";// + val + ")" // Печатаем в layer2
              //  }
            </script>
            <%               
                StreetDao streetDao = factory.makeStreet();

                int id = 0;
                List<Street> streets = streetDao.getAllStreets();
                out.print("<select name=\"street\" id=\"street\" onchange=\"hi()\">");

                for (Street S : streets) {

                    out.print("<option value =" + S.getId_street() + ">" + S.getName() + "</option>");
                    id = S.getId_street();
                }

                out.print("</select>");
            %>
            <br>
            Выберите дом: <br>

            <div id="layer">
                <!-- Слой для печати в нём-->
            </div>

            <br>
            <input type="submit" value="Зарегистрироваться" />
        </form>
    </body>
</html>
