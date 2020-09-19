<%-- 
    Document   : rezervacijaKarte
    Created on : Aug 20, 2020, 6:26:31 PM
    Author     : Mladen
--%>


<%@page import="beans.Sjedista"%>
<%@page import="beans.Projekcija"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="beans.Repertoar"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Rezervacija karata</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"  crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5774a146ab.js" crossorigin="anonymous"></script>

        <style>
            body{background: url("slike/kino.jpg"); 
                 background-repeat: no-repeat;
                 background-attachment: fixed; }                
                           
            img{border-radius: 4px;}
            nav{height: 112px;}
            .navbar-brand{padding-left: 425px;}
           
            .row{padding-bottom: 15px;}
            .card{padding: 5px; width: 269px;}
            .form-group{width: 220px;  margin-bottom: 15px; padding-left: 15px;}
            .form-control{margin-bottom: 10px;}
            .fas.fa-chair{color:yellowgreen; width: 25px;}
            #thTabele{padding-left:79px; }
           
            .table{width: auto;  display: flex; flex-wrap: wrap; }
           .cell{width: 78px; padding-left: 18px;}
           #kut{width:69px; padding-left: 5px; }
        </style>
        
    </head>
    <body>
          
       
 <!--POČETAK NAVBARA-->            
           <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
               <img src="slike/logo.jpg"/>
               <a class="navbar-brand" href="pocetna.jsp">Početna</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                  <ul class="navbar-nav mr-auto">
                   <li class="nav-item active">
                     <a class="nav-link" href="login.jsp">Logovanje<span class="sr-only">(current)</span></a>
                   </li>
                   <li class="nav-item">
                     <a class="nav-link" href="registracija.jsp">Registracija</a>
                   </li>
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Bioskopi
                     </a>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                     <a class="dropdown-item" href="pocetna.jsp">Beograd</a>
                     <a class="dropdown-item" href="pocetnaNS.jsp">Novi Sad</a>                     
                    
                     </div>
                    </li>
                  
                  </ul>
                 <form class="form-inline my-2 my-lg-0" action="https://www.google.com/search" method="GET" >
                     <input class="form-control mr-sm-2" type="search" placeholder="Unesite ključnu riječ" aria-label="Search" name="q"  >
                     <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Pretraži" >
                 </form>
               </div>
</nav>
<!--KRAJ NAVBARA-->    
        
   <%
       String info=(String)request.getAttribute("info");
       
       if(info!=null)
       {%>
       <p style="color:white;"><%=info%></p>
       <%}%>
    <center>
        <h2 style="color:white"><u>REZERVIŠITE KARTU</u></h2>
        
       
    </center>     
    <br>      
       
    
    
    <!-- RADNI DIO -->
    <!-- Početak projekcije -->
    <div class="row">
    <div class="col-md-2">
    <div class="form-group"> 
               
                    <%
                      try
                        {
                         String idFilmStr=request.getParameter("idFilm");             
                         int idFilm=Integer.parseInt(idFilmStr);
             
                        Class.forName("com.mysql.jdbc.Driver").newInstance();
                        Connection konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/lanacbioskopa2", "root", "");
             
                        String upit="SELECT * FROM projekcija WHERE idFilm="+idFilm;             
                        Statement stmt=konekcija.createStatement();             
                        ResultSet rs=stmt.executeQuery(upit);
             
                        while(rs.next())
                    {%>    
                        <label style="color:white; padding-left:15px; ">Početak projekcije:</label>
                        <input class="form-control" type="text" value="<%=rs.getTime("početak") %>" />
                        <a href="RezervacijaServlet?ispis1=<%=rs.getInt("idFilm")%>" class="form-control btn btn-secondary" >POGLEDAJTE SJEDIŠTA ►</a>
                        <br><br>
                     <%          
                        }               
                    }
                    catch(Exception ex)
                    {
                    out.println("Exception:"+ex.getMessage());
                    ex.printStackTrace();
                    }
                    %>
            
                          
            
          </div>
          </div> 
           <!--Odabir sjedista-->         
          <div class="col-md-8">
              <br>
              <center>
                <form action="RezervisiKartuServlet" method="POST">
                    <button type="submit" class="btn btn-secondary" name="submit">Izvršite rezervaciju</button>
                    <button type="reset" class="btn btn-secondary" name="reset">Obrišite izbor</button>
                  <div class="table" style="color:white; background-color:blue;   border-radius: 8px; border-color: black;">  
                      
                        <% ArrayList<Sjedista> lS=(ArrayList<Sjedista>)request.getAttribute("listaSjedista");
                              String ispis1=(String)request.getAttribute("ispis1");                             
                             
                            %>
                      
                    <div class="row">
                        <div class="cell" id="kut">KOL.→ RED ↓</div>
                        <div class="cell">A</div> 
                        <div class="cell">B</div>
                        <div class="cell">C</div>
                        <div class="cell">D</div>
                        <div class="cell">E</div>
                        <div class="cell">F</div>
                        <div class="cell">G</div>
                        <div class="cell">H</div>
                        <div class="cell">I</div>
                        <div class="cell">J</div>
                        <div class="cell">K</div>
                                               
                    </div>
                      <div class="row">
                          <div class="col-sm-1">
                              1
                          </div>
                           <%
                                    if(lS!=null && ispis1!=null)
                                        {%>
                                            <% for(Sjedista s:lS )
                                        {%>
                                            <% if(s.getRezervisano()==false)
                                            {%>
                                                <div class="col-sm-1">                                     
                                             <i class="fas fa-chair"><input id="s" type="checkbox" name="sjedista" value="Sjediste=<%=s.getIdSjedista()%>, cijena-<%=s.getCijena()%>/din." ></i><p><%=s.getCijena()%>din</p>
                                            </div> 
                                            <%}%>          
                                            
                                        <%}%> 
                                    
                                    <%}%> 
                          
                      </div>                          
                    </div>                              
                  </form>
               </center>
           </div>
         </div> 
          
          
           
        <!-- FOOTER-->
           <footer class="footer mt-auto py-3">                 
               <div class="row" style="padding-left:15px;">
                <div class="col-md-4">
                    <div class="page-header">
                    <h4 style="color:white;"><b>O nama</b></h4>
                    </div>
                    <p style="color:white;">Kino Pobjeda je lanac bioskopa osnovan sa ciljem da pobjedi konzumerizam u filmskoj kulturi i obezbijedi gledaocima repertoar koji će ih oplemeniti.</p>
                </div>
               <div class="col-md-4">
                <div class="page-header">
                    <h4 style="color:white;"><b>Kontakt</b></h4>

                </div>
                <p style="color:white;"><i class="fas fa-map-marked-alt"></i> Nedeljka Gvozdenovića 22b, 11070 N.Beograd</p>
                <p style="color:white;"><i class="fas fa-mobile-alt"></i> +381 63 377745 </p>
                <p style="color:white;"><i class="fas fa-envelope-open-text"></i>  mz.tool2882@gmail.com</p>
               </div>
                   
             <div class="col-md-4">
                <div class="page-header">
                    <h4 style="color:white;"><b>Pratite nas na:</b></h4>
                </div>
                <a href="https://www.facebook.com/" class="btn btn-primary" role="button">
                    <i class="fab fa-facebook fa-3x"></i>
                </a>
                <a href="https://www.twitter.com" class="btn btn-primary" role="button">
                    <i class="fab fa-twitter fa-3x"></i>
                </a>
                <a href="https://www.youtube.com" class="btn btn-primary" role="button">
                    <i class="fab fa-youtube fa-3x"></i>
                </a>
                <a href="https://www.linkedin.com" class="btn btn-primary" role="button">
                    <i class="fab fa-linkedin-in fa-3x"></i>
                </a>

              </div>
             </div>                  
             
            </footer>
           <br>
            <footer>
            <p style="color:white;  padding-left: 15px;">&copy; 2020 - Java Web Application; Author: Mladen Zvjerac</p>
            </footer>
           
           

<!-- JS  --> 

<!--<script>
    
document.getElementById('s').onclick = function() {
    
    if ( this.checked ) {  
        for(Sjedista s:lS ){
            this.id=
        }
        
    } else {
        
    }
};-->
</script>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"  crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"  crossorigin="anonymous"></script>
    </body>
</html>


