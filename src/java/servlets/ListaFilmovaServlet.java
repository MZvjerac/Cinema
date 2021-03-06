
package servlets;

import beans.Film;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mladen
 */
public class ListaFilmovaServlet extends HttpServlet 
{

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Connection konekcija=null;
        Statement stmt=null;
        ResultSet rs=null;
        String url="jdbc:mysql://localhost/lanacbioskopa2";
        String user="root";
        String pass="";
        
        ArrayList<Film> listaFilmova=new ArrayList<Film>();
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            konekcija=DriverManager.getConnection(url, user, pass);
            stmt=konekcija.createStatement();
            
            String upit1="SELECT * FROM film";
            
            rs=stmt.executeQuery(upit1);
            
            while(rs.next())
            {
                listaFilmova.add(new Film(rs.getInt("idFilm"), rs.getString("nazivFilma"), rs.getString("reziser"), rs.getString("zanr"), rs.getTime("trajanje"), rs.getString("recenzija"), rs.getString("slika"), rs.getString("trejler"), rs.getInt("Idl"), rs.getInt("IdListeSjedista")));
            }
            request.setAttribute("listaFilmova", listaFilmova);
            request.getRequestDispatcher("crudFilm.jsp").forward(request, response);
            
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
