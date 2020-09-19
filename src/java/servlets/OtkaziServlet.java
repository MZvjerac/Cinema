/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import beans.Sjedista;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mladen
 */
public class OtkaziServlet extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
         ArrayList<String> sjedista=(ArrayList<String>)request.getSession().getAttribute("korpa3");  
        try 
        {
                 
           
           String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
           String user="root";
           String pass="";
            
           for(String s : sjedista)
           {
               int id=Integer.parseInt(s.substring(s.indexOf('=') + 1, s.indexOf(',')));
               
               //int id=s.getIdSjedista();
               
               if(s!=null)
               {               
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection kon=DriverManager.getConnection(url, user, pass);
                Statement st=kon.createStatement();               
                                       
                String upit="UPDATE sjedista SET rezervisano=0 WHERE idSjedista="+id;
                st.executeUpdate(upit);           
                
                request.setAttribute("info", "Rezervacija je otkazana!");   
                request.getRequestDispatcher("Rezervista.jsp").forward(request, response);                   
                
                 st.close();
                 kon.close();              
                          
                }  
               else
               {
                   request.setAttribute("info", "Nema rezervisanih sjedišta");   
                   request.getRequestDispatcher("Rezervista.jsp").forward(request, response);
               }
               
           }
            
        }
         catch(ClassNotFoundException ce){}
                 catch(SQLException se)
                    {
                     String info=se.getMessage();
                     request.setAttribute("info",info);
                     request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
               
        
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
