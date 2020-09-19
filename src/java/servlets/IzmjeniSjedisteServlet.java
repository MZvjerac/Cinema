
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
public class IzmjeniSjedisteServlet extends HttpServlet 
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String idSjedistaStr=request.getParameter("idSjedista");
        String rezervacijaStr=request.getParameter("rezervisano");
        String vrstaStr=request.getParameter("vrsta");
        String cijenaStr=request.getParameter("cijena");
        String idListeStr=request.getParameter("lista");
        
        String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
        String user="root";
        String pass="";
        
        int idSjedista=Integer.parseInt(idSjedistaStr);
        int rezervacija=Integer.parseInt(rezervacijaStr);
        int cijena=Integer.parseInt(cijenaStr);
        int idListeSjedista=Integer.parseInt(idListeStr);
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");               
            Connection konekcija=DriverManager.getConnection(url, user, pass);
            
            String upit="UPDATE sjedista SET rezervisano=?, vrsta=?, cijena=?, idListeSjedista=? WHERE idSjedista="+idSjedista;
            
            PreparedStatement ps=konekcija.prepareStatement(upit);
            
            ps.setInt(1, rezervacija);
            ps.setString(2, vrstaStr);
            ps.setInt(3, cijena);
            ps.setInt(4, idListeSjedista);
            
            ps.executeUpdate();
               
            request.setAttribute("info","Uspješno izmjenjeni podaci sjedišta!");
            request.getRequestDispatcher("ListaSjedistaServlet").forward(request, response);
            
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
