
package servlets;

import java.sql.*;
import beans.Korisnik;
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
public class PodaciRezervisteServlet extends HttpServlet 
{


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        String vPString=(String)request.getParameter("vriProjekcije");
        
        Time rez=Time.valueOf(vPString);
        
        String info=(String)request.getAttribute("info");
        
        Korisnik k=(Korisnik)request.getSession().getAttribute("korisnik"); 
        
        
        try (PrintWriter out = response.getWriter()) 
        {
           
            
             out.println("<!DOCTYPE html>");
             out.println("<html>");
             
             out.println("<head>");
             out.println("<meta charset=\"utf-8\">");
             out.println("<title>Podaci rezerviste Servlet</title>");           
      
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
            out.println("padding-left: 525px;");
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
                  out.println(" <a class=\"nav-link\" href=\"prikazKorpe.jsp\">Račun<span class=\"sr-only\">(current)</span></a>"); 
                   out.println("</li>"); 
                   
                  out.println("</ul>");
                  out.println("<form class=\"form-inline my-2 my-lg-0\">");
                 out.println("<input class=\"form-control mr-sm-2\" type=\"search\" placeholder=\"Unesi kjučnu riječ\" aria-label=\"Search\">");
                  out.println(" <button class=\"btn btn-outline-success my-2 my-sm-0\" type=\"submit\">Pretraži</button>");   
                   out.println("</form>"); 
                 out.println(" </div>");
              
            out.println("</nav>");       
           out.println("<br><br>");                   
            
            out.println("<center><h2 style=\"color:white;\"><u>REZERVACIJA</u></h2></center>");
            out.println("<center>");
            if(info!=null)
            {
                 out.println("<h4 style=\"color:white; \">"+info+"</h4>");
            }
           
            out.println("<form action=\"RezervisanoNa\" method=\"POST\" >");
        
             out.println("<h3 style=\"color:white;\">Rezervacija glasi na:</h3>");
            out.println("<form action=\"servletKupac\"  method=\"POST\">");
            out.println("<table border=\"1\" align=\"center\"  style=\"background-color:blue; color:white; border-color:black; border-radius:4px;\">");
            out.println("<tr>");
            out.println("<td align=\"center\">IME</td><td align=\"center\">PREZIME</td><td align=\"center\">ADRESA</td><td align=\"center\">GRAD</td><td align=\"center\">TELEFON</td><td align=\"center\">REZERVACIJA VAŽI DO</td>");            
            out.println("</tr>");
            out.println("<tr ><td><input type=\"text\" name=\"ime\" value="+k.getIme()+"></td>"            
                    +"<td><input type=\"text\" name=\"prezime\" value="+k.getPrezime()+" /></td>"
                    +"<td style=\"width:65px;\"><input type=\"text\" name=\"adresa\" value="+k.getAdresa()+" /></td>"
                    + "<td><input type=\"text\" name=\"grad\" value="+k.getGrad() +" /></td>"
                    + "<td><input type=\"text\" name=\"telefon\" value="+k.getTelefon()+" /></td>"
                    + "<td><input type=\"text\" name=\"rezervacija\"  value="+rez+"></td>");           
            out.println("</tr>");
            out.println("<tr>");
            out.println("<td colspan=\"6\" align=\"center\"><input type=\"submit\" value=\"Potvrdi rezervaciju\"  style=\"background-color: grey; color:white; border-radius: 4px;\"/> </td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("</form>");
             out.println("<br><br>");
            
            out.println("</center>");       
           
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
