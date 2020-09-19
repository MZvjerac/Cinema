
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
public class IzmjeniFilmServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String idFilmStr=request.getParameter("idFilm");
        String nazivFilmaStr=request.getParameter("nF");
        String reziserStr=request.getParameter("rez");
        String zanrStr=request.getParameter("zan");
        String trajanjeStr=request.getParameter("traj");
        String recenzijaStr=request.getParameter("rec");
        String slikaStr=request.getParameter("sli");
        String trejlerStr=request.getParameter("trej");
        String IDLStr=request.getParameter("ID");
        String IdSStr=request.getParameter("IdS");        
        
        String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
        String user="root";
        String pass="";
         int idFilm=Integer.parseInt(idFilmStr);
            Time trajanje=Time.valueOf(trajanjeStr);
            int IDL=Integer.parseInt(IDLStr); 
            int idListeSjedista=Integer.parseInt(IdSStr);
        try  
        {               
            Class.forName("com.mysql.jdbc.Driver");
               
               Connection konekcija=DriverManager.getConnection(url, user, pass);               
               
               String upit="UPDATE film SET nazivFilma=?, reziser=?, zanr=?, trajanje=?, recenzija=?, slika=?, trejler=?, IDL=?, idListeSjedista=?  WHERE idFilm="+idFilm;
               
               PreparedStatement ps=konekcija.prepareStatement(upit);
               
                  //ps.setInt(1, idFilm);
                  ps.setString(1, nazivFilmaStr);
                  ps.setString(2, reziserStr);
                  ps.setString(3, zanrStr);
                  ps.setTime(4, trajanje);
                  ps.setString(5, recenzijaStr);
                  ps.setString(6, slikaStr);
                  ps.setString(7, trejlerStr);
                  ps.setInt(8, IDL);
                  ps.setInt(9, idListeSjedista);
                  
                  ps.executeUpdate();
               
               request.setAttribute("info","Uspješno izmjenjeni podaci filma.");
               request.getRequestDispatcher("ListaFilmovaServlet").forward(request, response);
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
