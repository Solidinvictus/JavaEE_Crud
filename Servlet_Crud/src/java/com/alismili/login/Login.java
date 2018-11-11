/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.login;

import com.alismili.dao.ServiceUserImpl;
import com.alismili.models.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Ali
 */
@WebServlet("/Login")

public class Login extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String uname = request.getParameter("name");
        String password = request.getParameter("password");
        
        //Here, we check from BBDD, but i will make it simple first
        /*if(uname.equals("Ali") && password.equals("2345"))
        {
            //First we set a session
            HttpSession session = request.getSession();
            session.setAttribute("name", uname);
            response.sendRedirect("welcome.jsp");
            
        }
        else
        {
             response.sendRedirect("login.jsp");
        }*/
        
        ServiceUserImpl servUser = new ServiceUserImpl();
        User user = null;
        user = servUser.userFnd(uname);
        if(user != null && user.getName().equals(uname) && user.getPassword().equals(password)){
            HttpSession session = request.getSession();
            session.setAttribute("name", uname);
            
            //We call the servlet to permorm the formating in welcome.jsp
            
            response.sendRedirect("FormaterWelcome");
        }else{
            servUser = null;
            response.sendRedirect("login.jsp");
        }
        
        
    }

    
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
