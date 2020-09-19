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
public class BrisiKorisnikaServlet extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
        String user="root";
        String pass="";
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
               
               Connection konekcija=DriverManager.getConnection(url, user, pass);           
               
               String upit="DELETE FROM korisnik WHERE idKorisnika= ?";
               
               PreparedStatement ps=konekcija.prepareStatement(upit);
               
               int idKorisnika=Integer.parseInt(request.getParameter("idKorisnika"));
               
               ps.setInt(1, idKorisnika);               
               ps.executeUpdate();
               
               request.setAttribute("info","Uspješno izbrisan korisnik iz baze.");
               request.getRequestDispatcher("ListaKorisnikaServlet").forward(request, response);
              /* ps.close();
               konekcija.close();*/
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
