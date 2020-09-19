/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mladen
 */
public class RegistracijaServlet extends HttpServlet 
{

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        
           String ime=request.getParameter("ime");
           String prezime=request.getParameter("prezime");
           String adresaStr=request.getParameter("adresa");
           String gradStr=request.getParameter("grad");
           String telefonStr=request.getParameter("telefon");
           String username=request.getParameter("username");
           String password1=request.getParameter("password1");
           String password2=request.getParameter("password2");
           
           String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
           String user="root";
           String pass="";
           
           try
           {
               Class.forName("com.mysql.jdbc.Driver");
               
               Connection konekcija=DriverManager.getConnection(url, user, pass);
               
               Statement stmt=konekcija.createStatement();
               
               ResultSet rezultat=null;
               String upit="SELECT username FROM korisnik";
               
               rezultat=stmt.executeQuery(upit);
               
               while(rezultat.next())
               {
                   if(username.equals(rezultat.getString("username")))
                   {
                       request.setAttribute("info", "Korisničko ime već postoji!");
                       request.getRequestDispatcher("registracija.jsp").forward(request, response);
                   }
               }
               stmt.close();
               konekcija.close();
           }       
           catch(ClassNotFoundException ce){}
           catch(SQLException se)
           {
               String info=se.getMessage();
               request.setAttribute("info",info);
               request.getRequestDispatcher("error.jsp").forward(request, response);
           }
           
           if(ime!=null && ime.length()>0 && prezime!=null && prezime.length()>0 && adresaStr!=null && adresaStr.length()>0 && gradStr!=null && gradStr.length()>0 && telefonStr!=null && telefonStr.length()>0 && username!=null && username.length()>0 && password1!=null && password1.length()>0 && password2!=null && password2.length()>0)
           {
               if(password1.equals(password2))
               {
                   try
                   {
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection kon=DriverManager.getConnection(url, user, pass);
                       Statement st=kon.createStatement();
                       
                       String upit1="INSERT INTO korisnik(ime, prezime, adresa, grad, telefon, poeni, username, password) VALUES"+"('"+ime+"','"+prezime+"','"+adresaStr+"','"+gradStr+"','"+telefonStr+"','"+0+"','"+username+"','"+password2+"')";
                       
                       st.executeUpdate(upit1);
                       
                       st.close();
                       kon.close();
                       
                       request.setAttribute("info","Uspješno ste se registrovali!");
                       request.getRequestDispatcher("registracija.jsp").forward(request, response);
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
                   request.setAttribute("info","Šifre se ne poklapaju!");
                   request.getRequestDispatcher("registracija.jsp").forward(request, response);
               }
           }
           else
           {
               request.setAttribute("info","Morate popuniti sva polja!");
               request.getRequestDispatcher("registracija.jsp").forward(request, response);
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
