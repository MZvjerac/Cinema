<%-- 
    Document   : uclanjenje
    Created on : Aug 22, 2020, 5:50:35 PM
    Author     : Mladen
--%>

<%@page  import="java.sql.*" %>
<%@page import="beans.Korisnik"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forma za učlanjenje u klub</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"  crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5774a146ab.js" crossorigin="anonymous"></script>

        <style>
            body{background: url("slike/kino.jpg"); background-repeat: no-repeat;
                 background-attachment: fixed;}            
            img{border-radius: 4px;}
            nav{height: 112px;}
            .navbar-brand{padding-left: 425px;}
            #forma1{width: 350px; color: white; background-color: blue; border-radius: 8px; align-content: center; }
            .p1{
                color: white;
                font-family: Verdana;
                font-size: 18px;
                background-color: black;
                width: 350px;
                border-radius: 4px;
            }
            #dropdownMenuButton{width: 250px;}
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
                  
                   <li class="nav-item dropdown">
                     <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                     Dropdown
                     </a>
                     <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                     <a class="dropdown-item" href="#">Action</a>
                     <a class="dropdown-item" href="#">Another action</a>
                     <div class="dropdown-divider"></div>
                       <a class="dropdown-item" href="#">Something else here</a>
                     </div>
                    </li>
                   <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                  </li>
                  </ul>
                 <form class="form-inline my-2 my-lg-0" action="https://www.google.com/search" method="GET" >
                     <input class="form-control mr-sm-2" type="search" placeholder="Unesite ključnu riječ" aria-label="Search" name="q"  >
                     <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Pretraži" >
                 </form>
               </div>
            </nav>
<!--KRAJ NAVBARA-->    
        
   
<center>
    <h2 style="color:white"><u>UČLANITE SE U NEKI OD KLUBOVA</u></h2> 
    
    <br>      
    
     <% 
                  String info=(String)request.getAttribute("info");
           
                  if(info!=null && info.length()>0)
                    {%>
                       <p class="p1"><b><%=info%></b></p>
                  <%}%>
                       
                       <%
                           Korisnik k=(Korisnik)request.getSession().getAttribute("korisnik");
                           %>
    
                          
    <form action="UclanjenjeServlet" method="POST" id="forma1">
        <p style="color:white; font-size: 18px;"><b>Ja:</b></p> 
         <div class="form-group">
       <label for="InputId">Id</label>
       <input type="text" class="form-control" id="id" aria-describedby="id"  name="id" value="<%=k.getIdKorisnika() %>">       
      </div>
      <div class="form-group">
       <label for="InputIme">Ime</label>
       <input type="text" class="form-control" id="Username1" aria-describedby="ime"  name="ime" value="<%=k.getIme() %>">
       
      </div>
      <div class="form-group">
       <label for="InputPrezime">Prezime</label>
       <input type="text" class="form-control" id="Password1" placeholder="Unesite prezime" name="prezime" value="<%=k.getPrezime() %>">
      </div>
         <div class="form-group">
       <label for="InputAdresa">Adresa</label>
       <input type="text" class="form-control" id="Password1" placeholder="Unesite adresu" name="adresa" value="<%=k.getAdresa() %>">
      </div>
         <div class="form-group">
       <label for="InputGrad">Grad</label>
       <input type="text" class="form-control" id="Password1" placeholder="Unesite grad" name="grad" value="<%=k.getGrad() %>">
      </div>
         <div class="form-group">
       <label for="InputTelefon">Telefon</label>
       <input type="text" class="form-control" id="Password1" placeholder="Unesite telefon" name="telefon" value="<%=k.getTelefon() %>">
      </div>
     
      <p style="color:white; font-size: 18px;"><b>želim da se učlanim u klub:</b></p>
      <div class="form-group">
      
          <select name="klub" id="klub">
      
        <%
       try
         {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/lanacbioskopa2", "root", "");
             
             String upit="SELECT * FROM klub";             
             Statement stmt=konekcija.createStatement();             
             ResultSet rs=stmt.executeQuery(upit);
             
             while(rs.next())
             {%>                  
             <option class="form-control" value="<%=rs.getString("idKluba") %>" ><%=rs.getString("nazivKluba") %></option>
             <%          
             }               
            }
          catch(Exception ex)
          {
              out.println("Exception:"+ex.getMessage());
              ex.printStackTrace();
          }
          %>
      
          </select> 
      </div>
       <br>
        <button type="submit" class="btn btn-primary">POTVRĐUJEM</button>
               
   </form>    
</center>
    <br><br><br><br>
    
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


