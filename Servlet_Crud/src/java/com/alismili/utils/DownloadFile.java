/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.alismili.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.activation.MimetypesFileTypeMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ali
 */
@WebServlet("/DownloadFile")
public class DownloadFile extends HttpServlet {

    private static final long serialVersionUID = 4440011247408877539L;
 
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
  throws ServletException, IOException {
    
    resp.setContentType("text/xml");

      // Actual logic goes here.
      String message ="Download in 5 s…";
      
     
      /*PrintWriter outP = resp.getWriter();
      outP.println("<h1>" + message + "</h1>");*/
      //RequestDispatcher dispatcher = req.getRequestDispatcher("generarXML");  //Si uso el requestDispacher, no me deja descargar
      //dispatcher.forward(req, resp);
      //resp.setHeader("Refresh", "5; URL=http://localhost:8080/Servlet_Project/servlets/descargarArchivo");

    
      
     downloadFile(resp,
     this.getServletContext().getRealPath("/WEB-INF/hola.xml"));
      
}
 
protected void downloadFile(HttpServletResponse response, String filePath)
  throws ServletException, IOException {
  
    
 File fileToDownload = new File(filePath);
        try (FileInputStream fileInputStream = new FileInputStream(fileToDownload);
             ServletOutputStream out = response.getOutputStream()) {
            String mimeType =  new MimetypesFileTypeMap().getContentType(filePath);
            
            response.setContentType(mimeType);
            response.setContentLength(fileInputStream.available());
            response.setHeader( "Content-Disposition", "attachment; filename=\""
                    + fileToDownload.getName() + "\"" );
            
            int c;
            while((c=fileInputStream.read()) != -1){
                out.write(c);
            }
            out.flush();
            
    
        }
}

}
