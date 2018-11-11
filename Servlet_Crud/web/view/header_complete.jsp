<%@page import="java.util.ResourceBundle"%>
<%@page import="java.util.Locale"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="language" value="${not empty param.ddlLanguage ? param.ddlLanguage : not empty language ? language : pageContext.request.locale}" scope="session"/>
<fmt:setLocale value="${language}"/>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/3.1.2/rollups/sha1.js"></script>

<!DOCTYPE html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="../css/bootstrap-datetimepicker.min.css" rel="stylesheet" type="text/css"/>
    <link href="../icons/estilos.css" rel="stylesheet" type="text/css"/>
    <link href="../css/estilos.css" rel="stylesheet" type="text/css"/>
    <link href="../datatable/jquery-ui.css" rel="stylesheet" type="text/css"/>
    <link href="../datatable/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css"/>
    <%
        //Get the client's Locale
        //response.setHeader("Content-Language", "en");
        response.setHeader("Content-Language", "en");
        Locale locale = request.getLocale();
        String language = locale.getLanguage();
        String country = locale.getCountry();
        ResourceBundle bundle = ResourceBundle.getBundle("resources.messages.message");
    %>
</head>
<body>
    <div class="header" style="background-color: #31b0d5">
        <center><h1> Java EE MVC</h1>
            <h3>CENEC COMMERCIAL OFFICE!</h3>
            <a href="../login.jsp">Login</a>
            <br>

            <a href="../aboutus.jsp">Obout us</a>
            <br>
            </div>





