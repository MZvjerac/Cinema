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
public class IzmjeniKorisnikaServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String idKorisnikaStr=request.getParameter("idKorisnika");
        String imeStr=request.getParameter("ime");
        String prezimeStr=request.getParameter("prezime");
        String adresaStr=request.getParameter("adresa");
        String gradStr=request.getParameter("grad");
        String telefonStr=request.getParameter("telefon");
        //String idKlubaStr=request.getParameter("idKluba");
        String poeniStr=request.getParameter("poeni");
        String usernameStr=request.getParameter("username");
        String passwordStr=request.getParameter("password");
        
        
        String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
        String user="root";
        String pass="";
        
         int idKorisnika=Integer.parseInt(idKorisnikaStr);
         //int idKluba=Integer.parseInt(idKlubaStr);
         int poeni=Integer.parseInt(poeniStr);
         int telefon=Integer.parseInt(telefonStr);
           
        
        try  
        {
            Class.forName("com.mysql.jdbc.Driver");
               
               Connection konekcija=DriverManager.getConnection(url, user, pass);               
               
               String upit="UPDATE korisnik SET  ime=?, prezime=?, adresa=?, grad=?, telefon=?, poeni=?, username=?, password=? WHERE idKorisnika="+idKorisnika;
               
               PreparedStatement ps=konekcija.prepareStatement(upit);               
                  
                  ps.setString(1, imeStr);
                  ps.setString(2, prezimeStr);
                  ps.setString(3, adresaStr);
                  ps.setString(4, gradStr);
                  ps.setInt(5, telefon);
                  ps.setInt(6, poeni);
                  ps.setString(7, usernameStr);
                  ps.setString(8, passwordStr);                
                  
                  ps.executeUpdate();
               
               request.setAttribute("info","Uspješno izmjenjeni podaci korisnika.");
               request.getRequestDispatcher("ListaKorisnikaServlet").forward(request, response);
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
