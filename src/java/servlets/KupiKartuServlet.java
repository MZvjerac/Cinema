
package servlets;

import beans.Korisnik;
import java.sql.*;
import beans.Sjedista;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.time.Instant;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.joda.time.DateTime;
import java.sql.Timestamp;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;

/**
 *
 * @author Mladen
 */
public class KupiKartuServlet extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {     

        // Kupljenje podataka sa forme "karta.jsp"
        String[]sjedista=request.getParameterValues("sjedista");
        
        //Kupljenje registrovanog korisnika iz sesija koji je pristupio kupovini zarad davanja mu poena
        Korisnik kor=(Korisnik)request.getSession().getAttribute("korisnik");       
        
        LocalDate trenutno=LocalDate.now( ZoneId.of( "Europe/Paris" )  );
        
        String msg="";
                
        String url="jdbc:mysql://localhost:3306/lanacbioskopa2";
        String user="root";
        String pass="";  
              
        
        HttpSession sesija2=request.getSession();
        
        ArrayList<String> korpa2=new ArrayList<String>();        
        int ukCijena=0;
        
        if(sjedista!=null)
        {
            for(String s:sjedista)
            {  
                korpa2.add(s);   
                int id=Integer.parseInt(s.substring(s.indexOf('=') + 1, s.indexOf(',')));
                int ci=Integer.parseInt(s.substring(s.indexOf('-') + 1, s.indexOf('/')));
                
                ukCijena=ukCijena+ci;
                
                if(s!=null)
                {
                  try
                  {
                  Class.forName("com.mysql.jdbc.Driver");
                  Connection kon=DriverManager.getConnection(url, user, pass);
                  Statement st=kon.createStatement();
                                       
                  String upit1="UPDATE sjedista SET rezervisano=1 WHERE idSjedista="+id;
                  st.executeUpdate(upit1);              
                           
                   st.close();                
                   kon.close();
                   }
                   catch(ClassNotFoundException ce){}
                   catch(SQLException se)
                    {
                     String info=se.getMessage();
                     request.setAttribute("info",info);
                     request.getRequestDispatcher("error.jsp").forward(request, response);
                    }
                   }  
                      // Za više od 1000 din registrovani korisnik dobija 10 poena
                if(ukCijena>1000 && ukCijena<=2000)
                {
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection kon=DriverManager.getConnection(url, user, pass);
                        Statement st1=kon.createStatement();
                        
                        if(kor!=null)
                        {
                            int poeni=kor.getPoeni()+10;        
                        
                        
                        String upit1="UPDATE korisnik SET poeni="+poeni+" WHERE idKorisnika="+kor.getIdKorisnika();
                        st1.executeUpdate(upit1);
                       
                        
                        st1.close();
                        kon.close();
                        
                        msg="Poštovani "+kor.getIme()+", osvojili ste dodatnih 10 poena!";    
                         }
                        else
                        {
                            msg="Poštovani kupče možete osvojiti poene ako se registrujete";  
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
                // Za više od 2000 din registrovani korisnik dobija 20 poena
                if( ukCijena>2000 && ukCijena<=2500)
                {
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection kon=DriverManager.getConnection(url, user, pass);
                        Statement st2=kon.createStatement();
                        
                        if(kor!=null)
                        {
                        int poeni=kor.getPoeni()+20;
                        
                        String upit2="UPDATE korisnik SET poeni="+poeni+" WHERE idKorisnika="+kor.getIdKorisnika();
                        st2.executeUpdate(upit2);
                        
                        st2.close();
                        kon.close();
                        
                        msg="Poštovani "+kor.getIme()+", osvojili ste dodatnih 20 poena!";   
                           }
                        else
                        {
                            msg="Poštovani kupče možete osvojiti poene ako se registrujete";  
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
                // Za više od 2500 din registrovani korisnik dobija 30 poena
                if( ukCijena>2500)
                {
                    try
                    {
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection kon=DriverManager.getConnection(url, user, pass);
                        Statement st3=kon.createStatement();
                        
                        if(kor!=null)
                        {
                        int poeni=kor.getPoeni()+30;
                        
                        String upit3="UPDATE korisnik SET poeni="+poeni+" WHERE idKorisnika="+kor.getIdKorisnika();
                        st3.executeUpdate(upit3);
                        
                        st3.close();
                        kon.close();
                        
                        msg="Poštovani "+kor.getIme()+", osvojili ste dodatnih 30 poena!";  
                           }
                        else
                        {
                            msg="Poštovani kupče možete osvojiti poene ako se registrujete";  
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
            } // kraj for petlje  
           
        }   
        
        try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection konekcija=DriverManager.getConnection(url, user, pass);
               
                Statement stmt=konekcija.createStatement();          
                
                String upit4="INSERT INTO prodaja (datum, promet) VALUES"+"('"+trenutno+"','"+ukCijena+"')";  
                stmt.executeUpdate(upit4);                
                 
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
        
        sesija2.setAttribute("korpa2", korpa2);             
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
             out.println("<!DOCTYPE html>");
             out.println("<html>");
             
             out.println("<head>");
             out.println("<meta charset=\"utf-8\">");
             out.println("<title>KupiKartuServlet</title>");    
       
      
        out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\"  crossorigin=\"anonymous\">");
        out.println("<script src=\"https://kit.fontawesome.com/5774a146ab.js\" crossorigin=\"anonymous\"></script>");

        out.println("<style>");
            out.println(" body {");           
            out.println("background: url(\"slike/kino.jpg\");"); 
            out.println("background-repeat: no-repeat"); 
            out.println("background-color: blue");
            out.println("background-attachment: fixed");                
            out.println("}");              
            out.println("img{");            
            out.println("border-radius: 4px;");
            out.println("}"); 
            out.println("nav{"); 
            out.println("height: 112px;");             
            out.println("}");
            out.println(".navbar-brand{");
            out.println("padding-left: 425px;");
            out.println("}");
            out.println(".table{");
            out.println("display: flex;");
            out.println("flex-wrap: wrap;");
            out.println("}") ;
            out.println(".row{");
            out.println("padding-bottom: 15px;");
            out.println("}");            
       out.println("</style>");      
       
    out.println("</head>");
    out.println("<body>");         
       
           
           out.println("<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">");
           out.println("<img src=\"slike/logo.jpg\"/>");    
           out.println(" <a class=\"navbar-brand\" href=\"pocetna.jsp\">Početna</a>");   
           out.println("<button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">");     
           out.println("<span class=\"navbar-toggler-icon\"></span>");     
           out.println("</button>");     

            out.println("<div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">");
            out.println("<ul class=\"navbar-nav mr-auto\">");   
             out.println("<li class=\"nav-item active\">");     
                  out.println(" <a class=\"nav-link\" href=\"login.jsp\">Logovanje<span class=\"sr-only\">(current)</span></a>"); 
                   out.println("</li>"); 
                   out.println("<li class=\"n</liav-item\">");
                   out.println("<a class=\"nav-link\" href=\"registracija.jsp\">Registracija</a>");
                   out.println("</li>");  
                   out.println("<li class=\"nav-item dropdown\">");
                   out.println("<a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">");
                   out.println("Bioskopi");  
                     out.println("</a>");
                    out.println(" <div class=\"dropdown-menu\" aria-labelledby=\"navbarDropdown\">"); 
                    out.println(" <a class=\"dropdown-item\" href=\"pocetna.jsp\">Beograd</a>");
                    out.println(" <a class=\"dropdown-item\" href=\"pocetnaNS.jsp\">Novi Sad</a>");
                                      
                    out.println(" </div>"); 
                    out.println("</li>");
                    
                  out.println("</ul>");
                  out.println("<form class=\"form-inline my-2 my-lg-0\">");
                 out.println("<input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Unesi kjučnu riječ\" aria-label=\"Search\">");
                  out.println(" <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Pretraži</button>");   
                   out.println("</form>"); 
                 out.println(" </div>");
              
            out.println("</nav>");       
   
        
           out.println("<br><br>");                   
            
            out.println("<center><h2 style=\"color:white;\">ODABRANA SJEDIŠTA</h2></center>");
            out.println("<center>");
            out.println("<p style=\"color:white; font-weight:bold; \">"+msg+"</p>");
            if(korpa2.isEmpty())
            {
                out.println("<p style=\"color:white;\"><b><i>Niste ništa odabrali!</i></b></p>");
                out.println("<p><a  href=\"korisnicka.jsp\">Vratite se na stranu za kupovinu karte</a></p>");
            }
            else
            {out.println("<form action=\"prikazKorpe.jsp\" method=\"POST\">"); 
               out.println("<table border=\"1\" style=\"background-color:blue; color:white; border-color:black; border-radius:4px;\" >");
                
                for(String k:korpa2)
                {
                    out.println("<tr><td> Sjedište="+k+" din.</td></tr>");                    
                }
                if(ukCijena<=1000)
                {
                    out.println("<tr><td>Ukupna cijena=" +ukCijena+" din.</td></tr>");
                }
                else if(ukCijena>1000 && ukCijena<3000)
                {
                    out.println("<tr><td style=\"color:orange; background-color:white; font-size:22; font-weight:bold;\">Ukupna cijena sa popustom od 10%="+(ukCijena-ukCijena*0.1)+" din.</td></tr>");
                }
                else if(ukCijena>3000)
                {
                    out.println("<tr><td style=\"color:red; background-color:white; font-size:22; font-weight:bold; \">Ukupna cijena sa popustom od 20%="+(ukCijena-ukCijena*0.2)+" din.</td></tr>");
                }
                
                out.println("</table>");
                      
                    out.println("<input type=\"submit\" name=\"submit\" value=\"Dodaj u korpu\" style=\"background-color: grey; color:white; border-radius: 4px;\">"); 
                               
                    out.println("</form>");
                    out.println("</center>");
                    out.println("<br><br><br>");
            }  
            
           
           
        out.println(" <footer class=\"footer mt-auto py-3\">");
          out.println("<div class=\"row\" style=\"padding-left:15px;\">");                 
            out.println("<div class=\"col-md-4\">");   
                out.println(" <div class=\"page-header\">");
                  out.println("<h4 style=\"color:white;\"><b>O nama</b></h4>"); 
                   out.println("</div>"); 
                    out.println(" <p style=\"color:white;\">Kino Pobjeda je lanac bioskopa osnovan sa ciljem da pobjedi konzumerizam u filmskoj kulturi i obezbijedi gledaocima repertoar koji će ih oplemeniti.</p>");
                   out.println(" </div>");
               out.println("<div class=\"col-md-4\">");
               out.println("<div class=\"page-header\">");
                out.println("<h4 style=\"color:white;\"><b>Kontakt</b></h4>");
               out.println("</div>");     
               out.println("<p style=\"color:white;\"><i class=\"fas fa-map-marked-alt\"></i> Nedeljka Gvozdenovića 22b, 11070 N.Beograd</p>");
               out.println("<p style=\"color:white;\"><i class=\"fas fa-mobile-alt\"></i> +381 63 377745 </p>"); 
               out.println("<p style=\"color:white;\"><i class=\"fas fa-envelope-open-text\"></i>  mz.tool2882@gmail.com</p>"); 
                out.println(" </div>");
                out.println(" <div class=\"col-md-4\">");
              out.println("<div class=\"page-header\">");
                   
            out.println("<h4 style=\"color:white;\"><b>Pratite nas na:</b></h4>");
                out.println(" </div>");
                  out.println(" <a href=\"https://www.facebook.com/\" class=\"btn btn-primary\" role=\"button\">");  
               out.println("<i class=\"fab fa-facebook fa-3x\"></i>");
               out.println("</a>");
                out.println(" <a href=\"https://www.twitter.com\" class=\"btn btn-primary\" role=\"button\">");    
               out.println("<i class=\"fab fa-twitter fa-3x\"></i>");
               out.println("</a>");
                out.println(" <a href=\"https://www.youtube.com\" class=\"btn btn-primary\" role=\"button\">");    
                out.println("<i class=\"fab fa-youtube fa-3x\"></i>");
               out.println("</a>");
                  out.println("<a href=\"https://www.linkedin.com\" class=\"btn btn-primary\" role=\"button\">"); 
                out.println("<i class=\"fab fa-linkedin-in fa-3x\"></i>");
                out.println("</a>");
                 out.println("</div>");   
                out.println("</div>");

              out.println(" </footer>");
                  out.println("<br>");             
             out.println("<footer>");
             out.println(" <p style=\"color:white;  padding-left: 15px;\">&copy; 2020 - Java Web Application; Author: Mladen Zvjerac</p>");
             out.println("</footer>");
            
           out.println("<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"  crossorigin=\"anonymous\"></script>");
            out.println("<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\"  crossorigin=\"anonymous\"></script>");
           out.println(" <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\"  crossorigin=\"anonymous\"></script>");
            out.println("</body>");
            
            out.println("</html>");
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
