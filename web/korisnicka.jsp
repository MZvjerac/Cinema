<%-- 
    Document   : korisnicka
    Created on : Aug 13, 2020, 10:43:35 AM
    Author     : Mladen
--%>


<%@page import="beans.Film"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="beans.Repertoar"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page  import="java.sql.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Strana za registrovane korisnike</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"  crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5774a146ab.js" crossorigin="anonymous"></script>

        <style>
            body{background: url("slike/kino.jpg"); 
                 background-repeat: no-repeat;
                 background-attachment: fixed; }                
                           
            img{border-radius: 4px;}
            nav{height: 112px;}
            .navbar-brand{padding-left: 325px;}
            .table{display: flex; flex-wrap: wrap;}
            .row{padding-bottom: 15px;}
            .card{padding: 5px; width: 269px;}
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
                   <li class="nav-item active">
                     <a class="nav-link" href="uclanjenje.jsp">Učlanjenje u klubove</a>
                   </li>
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Bioskopi
                     </a>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                     <a class="dropdown-item" href="pocetna.jsp">Beograd</a>
                     <a class="dropdown-item" href="pocetnaNS.jsp">Novi Sad</a>
                    
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
        <h2 style="color:white"><u>POGLEDAJTE NAŠ REPERTOAR</u></h2>      
    <br>      
       
    
    <!-- RADNI DIO -->
    <!-- Filtriranje repertoara po datumu -->
    <table>
        <tr>
            <td width="200px;" align="center">
               <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Datum:
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <%
         try
         {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/lanacbioskopa2", "root", "");
             
             String upit="SELECT * FROM repertoar";             
             Statement stmt=konekcija.createStatement();             
             ResultSet rs=stmt.executeQuery(upit);
             
             while(rs.next())
             {%>                  
              <a class="dropdown-item" href="RepReg?ispis=<%=rs.getDate("datum") %>"><%=rs.getDate("datum") %></a>
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
            </td>
    <!-- Kraj filtriranja po datumu -->
    <!--Filter po žanru -->
    <td width="200px;" align="center">
               <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Žanr:
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <%
         try
         {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/lanacbioskopa2", "root", "");
             
             String upit1="SELECT DISTINCT zanr FROM film";             
             Statement stmt1=konekcija.createStatement();             
             ResultSet rs1=stmt1.executeQuery(upit1);
             
             while(rs1.next())
             {%>                  
              <a class="dropdown-item" href="RepReg?ispis2=<%=rs1.getString("zanr") %>"><%=rs1.getString("zanr") %></a>
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
            </td>
    <!-- Kraj filtera po žanru-->
    <!-- Filter po režiseru-->
        <td width="200px;" align="center">
               <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                Režiser:
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <%
         try
         {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/lanacbioskopa2", "root", "");
             
             String upit2="SELECT reziser FROM film ORDER BY reziser ASC";             
             Statement stmt2=konekcija.createStatement();             
             ResultSet rs2=stmt2.executeQuery(upit2);
             
             while(rs2.next())
             {%>                  
              <a class="dropdown-item" href="RepReg?ispis3=<%=rs2.getString("reziser") %>"><%=rs2.getString("reziser") %></a>
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
            </td>
    <!-- Kraj filtera po režiseru -->
        </tr>        
    </table>
          </center>
          <br><br>
          <%
           ArrayList<Film> lf=(ArrayList<Film>)request.getAttribute("filmovi");
           String ispis1=(String)request.getAttribute("ispis1");
           String ispis2=(String)request.getAttribute("ispis2");
           String ispis3=(String)request.getAttribute("ispis3");
          %>
          
           <% 
        if(lf!=null && ispis1!=null)
        {%> 
        <div class="table">        
            <% for(Film f:lf)
              {%>
           <div class="row" style="padding-left:40px;">
              <div class="col-sm-6 col-md-2" style="padding-left:20px;">
              <div class="card" style="width: 250px;">
                <img src="<%=f.getSlika()%>" class="card-img-top" alt="...">
              <div class="card-body">
                <h5 class="card-title"><%=f.getNazivFilma()%></h5>
                <p><b><%=f.getZanr()%></b></p>
                <p class="card-text"><%=f.getRecenzija()%></p>
                 <a href="<%=f.getTrejler() %>" class="btn btn-primary">Trejler</a>
                 <a href="kartaReg.jsp?idFilm=<%=f.getIdFilm()%>" class="btn btn-primary">Karta</a>
              </div>
              </div>
            </div>           
           </div>
     <% }%></div>
        <%}
        else if(lf!=null && ispis2!=null)
        {%> 
        <div class="table">  
            <% for(Film f:lf)
              {%>
              <div class="row" style="padding-left:40px;">
                <div class="col-sm-6 col-md-2" style="padding-left:20px;">
                 <div class="card" style="width: 250px;">
                    <img src="<%=f.getSlika()%>" class="card-img-top" alt="...">
                    <div class="card-body">
                    <h5 class="card-title"><%=f.getNazivFilma()%></h5>
                    <p><b><%=f.getZanr()%></b></p>
                     <p class="card-text"><%=f.getRecenzija()%></p>
                    <a href="<%=f.getTrejler() %>" class="btn btn-primary">Trejler</a>
                    <a href="kartaReg.jsp?idFilm=<%=f.getIdFilm()%>" class="btn btn-primary">Karta</a>
                   </div>
                 </div>
                </div>   
               </div>
      <% }%></div>
        <%}
        else if(lf!=null && ispis3!=null)
        {%> 
            <% for(Film f:lf)
              {%>
          <div class="table">  
           <div class="row" style="padding-left:40px;">
                <div class="col-sm-6 col-md-2" style="padding-left:20px;">
                <div class="card" style="width: 250px;">
                    <img src="<%=f.getSlika()%>" class="card-img-top" alt="...">
                <div class="card-body">
                    <h5 class="card-title"><%=f.getNazivFilma()%></h5>
                    <p><b><%=f.getZanr()%></b></p>
                     <p class="card-text"><%=f.getRecenzija()%></p>
                    <a href="<%=f.getTrejler() %>" class="btn btn-primary">Trejler</a>
                    <a href="kartaReg.jsp?idFilm=<%=f.getIdFilm()%>" class="btn btn-primary">Karta</a>
                </div>
                </div>
            </div>     
           </div>
    <% }%></div>
        <%}
          else
           {%>
           <center><p style="color:red; background-color: lightskyblue; width: 420px; border-radius: 4px; ">↑ Kliknite na neki od filtera ↑</p></center>
         <%}%>
        
           <br><br> 
           
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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"  crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"  crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"  crossorigin="anonymous"></script>
    </body>
</html>

