
package servlets;

import beans.Izvjestaj;
import beans.Prodaja;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.ZoneId;


/**
 *
 * @author Mladen
 */
public class ProdajaServlet extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Connection konekcija=null;
        Statement stmt=null;
        Statement stmt2=null;
        ResultSet rs=null;
        ResultSet rs2=null;
        String url="jdbc:mysql://localhost/lanacbioskopa2";
        String user="root";
        String pass="";
        
        ArrayList<Prodaja> listaProdatog=new ArrayList<Prodaja>();
        ArrayList<Izvjestaj> rezultati=new ArrayList<Izvjestaj>();
        
        try  
        {
            Class.forName("com.mysql.jdbc.Driver");
            konekcija=DriverManager.getConnection(url, user, pass);
            stmt=konekcija.createStatement();
            stmt2=konekcija.createStatement();
            
            String upit1="SELECT * FROM prodaja";
            
            String upit2="SELECT DISTINCT datum, SUM(promet) as sumirano FROM prodaja GROUP BY datum";         
            
            rs=stmt.executeQuery(upit1);
            rs2=stmt2.executeQuery(upit2);
            
            while(rs.next())
            {
                listaProdatog.add(new Prodaja(rs.getInt("idProdaje"), rs.getDate("datum"), rs.getInt("promet")));               
            }
           
            while(rs2.next())
             {
               rezultati.add(new Izvjestaj(rs2.getDate("datum"), rs2.getInt("sumirano")));
             }
            
            request.setAttribute("rezultati", rezultati);
            request.setAttribute("listaProdatog", listaProdatog);
            request.getRequestDispatcher("izvjestajProdaje.jsp").forward(request, response);
            
            stmt.close();
            
            
        }
        catch(ClassNotFoundException ce){}
        catch(SQLException se)
        {
            String info=se.getMessage();
            request.setAttribute("info", info);
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
