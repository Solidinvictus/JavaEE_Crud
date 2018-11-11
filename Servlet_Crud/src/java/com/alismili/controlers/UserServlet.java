/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.controlers;

import com.alismili.dao.ServiceUserImpl;
import com.alismili.models.User;
import com.alismili.service.ServiceUsers;
import com.alismili.utils.Convert;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ali
 */
@WebServlet({"/User", "/view/User"})
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        String message = null;
        String redirect = null;

        ServiceUsers service = new ServiceUserImpl();

        switch (action) {

            case "QRY":
                List<User> list = service.usersQry();

                if (list != null) {
                    request.setAttribute("list", list);
                } else {
                    message = service.getMessage();
                }
                redirect = "userQry.jsp";   //**

                break;

            case "INS":
                User user = new User();
                message = check(request, user);

                if (message == null) {
                    service.userIns(user);
                    message = service.getMessage();

                    if (message != null) {
                        request.setAttribute("user", user);
                        redirect = "userIns.jsp";   //**
                    } else {
                        redirect = "User?accion=QRY";
                    }

                } else {
                    request.setAttribute("user", user);
                    redirect = "userIns.jsp";  //**
                }
                break;

            case "FND":
                user = null;
                String name = request.getParameter("name");

                if (name != null) {
                    user = service.userFnd(name);

                    if (user != null) {

                        request.setAttribute("user", user);

                        redirect = "userUpd.jsp";   //**
                    } else {
                        message = service.getMessage();
                        redirect = "User?action=QRY";
                    }

                } else {
                    message = "Name of user not received.";
                    redirect = "User?action=QRY";
                }
                break;

            case "UPD":
                user = new User();
                message = check(request, user);

                if (message == null) {
                    service.userUpd(user);
                    message = service.getMessage();

                    if (message != null) {
                        request.setAttribute("user", user);
                        redirect = "userUpd.jsp";    //**
                    } else {
                        redirect = "User?action=QRY";
                    }

                } else {
                    request.setAttribute("user", user);
                    redirect = "userUpd.jsp";
                }
                break;

            case "DEL":
                name = request.getParameter("name");

                if (name != null) {
                    service.userDel(name);
                    message = service.getMessage();

                } else {
                    message = "Name of user not received";
                    redirect = "User?action=QRY";
                }

                redirect = "User?action=QRY";
                break;

            default:
                message = "Action not reconized";

        }

        if (message != null) {
            String msg = "<div class=\"col-md-5 col-md-offset-3\" style=\"text-align: center\">";
            msg += "<div class=\"alert alert-danger\">";
            msg += "<button class=\"close\" data-dismiss=\"alert\"><span>&times;</span></button>";
            msg += "<strong>Alerta!!</strong><br/>";
            msg += message;
            msg += "</div></div>";
            request.setAttribute("message", msg);
        }

        RequestDispatcher despachador = request.getRequestDispatcher(redirect);
        despachador.forward(request, response);

    }

    private String check(HttpServletRequest request, User user) {

        String message = "<ul>";
        //        System.out.println("tamano " + mensaje.length());
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        Integer levelAccess = Convert.toInteger(request.getParameter("level_access"));
        Boolean baned = Boolean.parseBoolean(request.getParameter("baned"));

        if ((name == null) || (name.trim().length() == 0)) {
            message += "<li>Verify that you type a correct name</li>";
        }
        if ((password == null) || (password.trim().length() == 0)) {
            message += "<li>Verify that you type a correct password</li>";
        }
        if ((email == null) || (email.trim().length() == 0)) {
            message += "<li>Verify that you type a correct email</li>";
        }
        if ((levelAccess == null)) {
            message += "<li>Verify that you select a level access</li>";
        }

        if ((baned == null)) {
            message += "<li>Verify that you select if the user is baned or not</li>";
        }

        user.setName(name);
        user.setPassword(password);
        user.setEmail(email);
        user.setLevelAccess(levelAccess);
        user.setBaned(baned);

        if (message.equals("<ul>")) {
            message = null;
        } else {
            message += "</ul>";
        }

        return message;
    }
}
