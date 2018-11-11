/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.utils;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ali Formatting all the web pages from servlets it's totally possible,
 * but not recomended if we have a lot of fmtl and javasript code in the middle
 * --> This is a use for the simpliest page in the web site
 */
@WebServlet("/FormaterWelcome")
public class Formater extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        format(request, response, "welcome.jsp");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        format(request, response, "welcome.jsp");

    }

    public void format(HttpServletRequest request,
            HttpServletResponse response, String pagina) throws IOException, ServletException {

        response.setContentType("text/html");

        RequestDispatcher dispatcher = request.getRequestDispatcher("header_login.jsp");
        dispatcher.include(request, response);

        //Calling from Servlet, the traslations occurs but the content name of button appears with simbols
        //--> Hard to fix if we dont use include from jsp directly
        /*dispatcher = request.getRequestDispatcher("intern.jsp");
    dispatcher.include(request, response);*/
        dispatcher = request.getRequestDispatcher("download.jsp");
        dispatcher.include(request, response);

        dispatcher = request.getRequestDispatcher(pagina);
        dispatcher.include(request, response);

        dispatcher = request.getRequestDispatcher("footer_login.jsp");
        dispatcher.include(request, response);

  }
  

}
