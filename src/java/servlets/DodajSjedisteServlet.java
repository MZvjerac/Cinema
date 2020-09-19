/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mladen
 */
public class DodajSjedisteServlet extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String rezervisanoStr=request.getParameter("rezervisano");
        String vrstaStr=request.getParameter("vrsta");
        String cijenaStr=request.getParameter("cijena");
        String listaStr=request.getParameter("lista");
        
        
        String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
        String user="root";
        String pass="";
        
        if(rezervisanoStr!=null && rezervisanoStr.length()>0 && vrstaStr!=null && vrstaStr.length()>0 && cijenaStr!=null && cijenaStr.length()>0 && listaStr!=null && listaStr.length()>0 )
        {
            try 
            {
               int rezervisano=Integer.parseInt(rezervisanoStr);
               int cijena=Integer.parseInt(cijenaStr);
               int lista=Integer.parseInt(listaStr);
                
               Class.forName("com.mysql.jdbc.Driver");
               
               Connection konekcija=DriverManager.getConnection(url, user, pass);               
               Statement stmt=konekcija.createStatement();
               
               String upit="INSERT INTO sjedista(rezervisano, vrsta, cijena, idListeSjedista) VALUES"+"('"+rezervisano+"','"+vrstaStr+"','"+cijena+"','"+lista+"')";
              
               stmt.executeUpdate(upit);              
               
               stmt.close();
               konekcija.close();
               
               request.setAttribute("info","Uspješno ste se ubacili novo sjedište u bazu!");
               request.getRequestDispatcher("dodajSjediste.jsp").forward(request, response);
            }
              catch(ClassNotFoundException ce){}
              catch(SQLException se)
                {
                String info=se.getMessage();
                 request.setAttribute("info",info);
                 request.getRequestDispatcher("error.jsp").forward(request, response);
                }
        }
        else
           {
               request.setAttribute("info","Morate popuniti sva polja!");
               request.getRequestDispatcher("dodajSjediste.jsp").forward(request, response);
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
