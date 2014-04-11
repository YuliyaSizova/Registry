<%-- 
    Document   : profile
    Created on : 03.04.2014, 19:51:02
    Author     : ASUS
--%>

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
        <%@ include file="headerDoc.jsp" %>
        <% TableFactory factory = new AccessTableFactory();
            DoctorDao doctorDao = factory.makeDoctor();
            Doctor doctor = doctorDao.getById_Doctor(7);
            out.print(doctor.getName());
       
            
        %>

    </body>
</html>
