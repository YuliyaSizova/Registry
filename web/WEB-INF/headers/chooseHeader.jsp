
<%@page import="HtmlBuild.HtmlBuilder"%>
<%@page import="security.SecurityBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="user" scope="session" class="Objects.User" />
<%
    switch(user.getId_role()) {
        case SecurityBean.ADMIN : {
            %><jsp:include page="<%= HtmlBuilder.ADMIN_HEADER %>" flush="true"/><%
            break;
        }
        case SecurityBean.DOCTOR : {
            %><jsp:include page="<%= HtmlBuilder.DOCTOR_HEADER %>" flush="true"/><%
            break;
        }
      
        default : {
            %><jsp:include page="<%= HtmlBuilder.DEFAULT_HEADER %>" flush="true"/><%
            break;
        }
    }
%>