<%-- 
    Document   : acceptDoctor
    Created on : 16.04.2014, 19:11:46
    Author     : ASUS
--%>


<%@page import="security.SecurityBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="security" class="security.SecurityBean" scope="request" />
<jsp:setProperty name="security" property="role" value="<%= SecurityBean.DOCTOR%>" />

