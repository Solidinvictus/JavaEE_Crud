/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet("/GenerateXML")
public class GenerateXML extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        createFile();
        RequestDispatcher dispatcher = request.getRequestDispatcher("info.jsp");
        /*Formater fmt = new Formater();
        fmt.format(request, response,"info.jsp");*/
       
        dispatcher.forward(request, response);
        
    }

  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        //createFile();
        createFileOutPutStream();
        
        //We create XML file
    }
    
    public void createFile(){
         String fileSeparator = System.getProperty("file.separator");
             //relative path
        String relativePath = fileSeparator+"hola.xml";
        File file;
        file = new File(relativePath);
        try {
            if(file.createNewFile()){
                System.out.println(relativePath+" File Created in Project root directory");
            }else System.out.println("File "+relativePath+" already exists in project root directory");
        } catch (IOException ex) {
            Logger.getLogger(GenerateXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createFileOutPutStream(){
        String data = "<raiz>hola</raiz>";

        FileOutputStream out = null;
        try {
            //  hay que crear una carpeta "temp" por ejemplo en tu unidad c:
            out = new FileOutputStream("c://temp//hola.xml");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GenerateXML.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            out.write(data.getBytes());
        } catch (IOException ex) {
            Logger.getLogger(GenerateXML.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(GenerateXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        createFile();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
