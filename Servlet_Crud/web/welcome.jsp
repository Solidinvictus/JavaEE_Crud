<%-- 
    Document   : welcome
    Created on : 02-nov-2018, 12:14:27
    Author     : Ali
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%--<%@ include file="header_login.jsp" %>
<%@ include file="intern.jsp" %>--%>
  
        <%
            //If user not logued, we redirect to Login
            if(session.getAttribute("name")== null){
                
                response.sendRedirect("login.jsp");
            }      
        %>
            <style>
        .welc{
            text-align: center;
             margin-bottom: 300px;
        }
        a,h2{
         
            color:wheat;
            padding: auto;
            margin-top: 20px;
            text-align: center;
           
        }
        .out{
            margin-top: 50px;
            padding: auto;
        }
       
    </style>
     <div class="welc">
        <h2>Welcome ${name}!</h2>
        <center ><a href ="index.jsp" style="color:orange;" >The main content of the app is in this link</a>
        
        <form action="Logout" class="out">
            <input type="submit" value="Logout">
        </form>
            </center>
        </div>
        
<%--<%@ include file="view/footer.jsp" %>--%>
