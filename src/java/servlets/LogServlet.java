
package servlets;


import beans.Korisnik;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mladen
 */
public class LogServlet extends HttpServlet {

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
        
        String username=request.getParameter("username");
        String password=request.getParameter("password");       
        
        // Sesija u koju se smiješta logovani korisnik
        HttpSession sesija=request.getSession();
        
        Korisnik korisnik=new Korisnik();
        korisnik.setUsername(username);
        korisnik.setPassword(password);
        
        sesija.setAttribute("korisnik", korisnik);
        
        if(username.isEmpty() || password.isEmpty())
        {
            request.setAttribute("info", "Morate popuniti sva polja!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
        else
        {
           Statement stmt1=null;
           Statement stmt2=null;
           Statement stmt3=null;
           ResultSet rs1=null;
           ResultSet rs2=null;
           ResultSet rs3=null;
           Connection konekcija=null;
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/lanacbioskopa2", "root", "");
                stmt1=konekcija.createStatement();
                stmt2=konekcija.createStatement();
                stmt3=konekcija.createStatement();
                
                String upit1="SELECT * FROM korisnik WHERE username='"+username+"' and password='"+password+"'";
                
                String upit2="SELECT * FROM administrator WHERE username='"+username+"' and password='"+password+"'";
                
                String upit3="SELECT * FROM menadzer WHERE username='"+username+"' and password='"+password+"'";
                
                rs1=stmt1.executeQuery(upit1);
                rs2=stmt2.executeQuery(upit2);
                rs3=stmt3.executeQuery(upit3);               
                
                if(rs1.next())
                {
                    String idKorisnikaStr=rs1.getString("idKorisnika");
                    String ime=rs1.getString("ime");
                    String prezime=rs1.getString("prezime");
                    String adresaStr=rs1.getString("adresa");
                    String gradStr=rs1.getString("grad");
                    String telefonStr=rs1.getString("telefon");
                    String idKlubaStr=rs1.getString("idKluba");
                    String poeniStr=rs1.getString("poeni");                   
                    
                    int  idKorisnika=Integer.parseInt(idKorisnikaStr);
                    int  idKluba=Integer.parseInt(idKlubaStr);
                    int poeni=Integer.parseInt(poeniStr);
                    int telefon=Integer.parseInt(telefonStr);
                    
                    
                    korisnik.setIdKorisnika(idKorisnika);
                    korisnik.setIme(ime);
                    korisnik.setPrezime(prezime);
                    korisnik.setAdresa(adresaStr);
                    korisnik.setGrad(gradStr);
                    korisnik.setTelefon(telefon);
                    korisnik.setIdKluba(idKluba);
                    korisnik.setPoeni(poeni);
                    
                    stmt1.close();
                    konekcija.close();
                    //request.setAttribute("info","Dobrodošli!");
                    request.setAttribute("korisnik",korisnik);                   
                    response.sendRedirect("korisnicka.jsp");                    
                    
                }
                else if(rs2.next())
                {
                    response.sendRedirect("administrator.jsp");
                }
                else if(rs3.next())
                {
                    response.sendRedirect("menadzer.jsp");
                }
                else
                {
                    request.setAttribute("info", "Neispravan username ili password!");
                    stmt1.close();
                    konekcija.close();
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }                
            }
            catch(ClassNotFoundException ce){}
            catch(SQLException se)
            {
                sesija.invalidate();
                String errormsg=se.getMessage();
                
                if(konekcija!=null)
                   try
                   {
                       konekcija.close();
                   }
                    catch(Exception ex)
                    {
                        errormsg+=ex.getMessage();
                    }
                request.setAttribute("errormsg",errormsg);
                request.getRequestDispatcher("error.jsp").forward(request, response);
            }
            
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
