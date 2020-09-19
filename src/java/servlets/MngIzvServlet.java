
package servlets;

import beans.Izvjestaj;
import beans.Prijedlozi;
import beans.Prodaja;
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
public class MngIzvServlet extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Connection konekcija=null;       
        Statement stmt2=null;  
        ResultSet rs2=null;
        Statement stmt4=null;
        
        ResultSet rs4=null;
        String url="jdbc:mysql://localhost/lanacbioskopa2";
        String user="root";
        String pass="";
        
        
        ArrayList<Izvjestaj> rezultati=new ArrayList<Izvjestaj>();    
        
        ArrayList<Prijedlozi> listaPrijedloga=new ArrayList<Prijedlozi>();
        
         try  
        {
            Class.forName("com.mysql.jdbc.Driver");
            konekcija=DriverManager.getConnection(url, user, pass);
            
            stmt2=konekcija.createStatement();                
            stmt4=konekcija.createStatement();  
            
            String upit2="SELECT DISTINCT datum, SUM(promet) as sumirano FROM prodaja GROUP BY datum";              
            String upit4="SELECT * FROM prijedlozi";           
                           
                rs4=stmt4.executeQuery(upit4);
                
                while(rs4.next())
                {
                    listaPrijedloga.add(new Prijedlozi(rs4.getInt("idPrijedloga"), rs4.getString("prijedlog")));
                }                  
               
            
            rs2=stmt2.executeQuery(upit2);             
           
            while(rs2.next())
             {
               rezultati.add(new Izvjestaj(rs2.getDate("datum"), rs2.getInt("sumirano")));
             }
            
            request.setAttribute("rezultati", rezultati);
            request.setAttribute("listaPrijedloga", listaPrijedloga);            
            request.getRequestDispatcher("izvmng.jsp").forward(request, response);
            
             stmt4.close();
             stmt2.close();
             konekcija.close();
            
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
