
package servlets;

import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import sat.sat;

/**
 *
 * @author Mladen
 */
public class AutomatskiReset extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        String postavka=request.getParameter("postavka");
        
        //LocalTime reset= LocalTime.parse(postavka, DateTimeFormatter.ISO_TIME);
        
        sat s=new sat();
        
        
        
        //LocalTime trenutnoVri=LocalTime.parse(s.toString(), DateTimeFormatter.ISO_TIME);
        
        String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
        String user="root";
        String pass="";
        
        try 
        {
            if(postavka!=null)
               {               
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection kon=DriverManager.getConnection(url, user, pass);
                Statement st=kon.createStatement();               
                                       
                String upit="UPDATE sjedista SET rezervisano=0";
                st.executeUpdate(upit);           
                
                request.setAttribute("info", "Sve rezervacije su resetovane!");   
                request.getRequestDispatcher("podesavanjeVremena.jsp").forward(request, response);                   
                
                 st.close();
                 kon.close();              
                           
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
