<%-- 
    Document   : administrator
    Created on : Aug 2, 2020, 12:33:04 PM
    Author     : Mladen
--%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Administratorova strana</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"  crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5774a146ab.js" crossorigin="anonymous"></script>

        <style>
            body{background: url("slike/kino.jpg");background-repeat: no-repeat;
                 background-attachment: fixed;}            
            img{border-radius: 4px;}
            nav{height: 112px;}
            .navbar-brand{padding-left: 525px;}
            #forma1{width: 500px; color: white; background-color: blue; border-radius: 8px; align-content: center; }
            .p1{
                color: white;
                font-family: Verdana;
                font-size: 18px;
                background-color: black;
                width: 350px;
                border-radius: 4px;}
            #img2{ border-radius: 8px; vertical-align: top;  float:left; }
            .row{padding-left: 15px; }
            
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
                   
                  </ul>
                 <form class="form-inline my-2 my-lg-0" action="https://www.google.com/search" method="GET" >
                     <input class="form-control mr-sm-2" type="search" placeholder="Unesite ključnu riječ" aria-label="Search" name="q"  >
                     <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Pretraži" >
                 </form>
               </div>
            </nav>
<!--KRAJ NAVBARA-->    
        
   
<center>
    <h2 style="color:white" ><u>ADMINISTRATOROVA POSLA</u></h2> 
        <% String info=(String)request.getAttribute("info");
           
                  if(info!=null && info.length()>0)
                    {%>
                       <p class="p1"><b><%=info%></b></p>
                    <%}%>   
                       
    
    <br>      
       
    <!--Administratorova forma-->
      <div class="row">
        <!--1. posao-->
        <div class="col-sm-6 col-md-4">
        <div class="card" style="width: 28rem;">
            <img src="slike/crud.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">C.R.U.D. Film</h5>
            <p class="card-text">C- Ubacivanje novog filma u bazu, R- Pregled svih filmova iz baze,   U- Ažuriranje podataka o filmu, D- Brisanje filma iz baze</p>
            <a href="ListaFilmovaServlet" class="btn btn-primary">KRENI</a>
          </div>
        </div>
        </div>
       <!--2. posao-->
        <div class="col-sm-6 col-md-4">
        <div class="card" style="width: 28rem;">
            <img src="slike/rud.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">R.U.D. Korisnik</h5>
            <p class="card-text">R- Pregled podataka registrovanog korisnika, U- Ažuriranje podataka o korisniku, D- Brisanje korisnika iz baze</p>
            <a href="ListaKorisnikaServlet" class="btn btn-primary">KRENI</a>
          </div>
        </div>
        </div>
        <!--3. posao-->
        <div class="col-sm-6 col-md-4">
        <div class="card" style="width: 28rem;">
            <img src="slike/report.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">Izvještaj za menadžera</h5>
            <p class="card-text">Kreiranje izvještaja o poslovanju bioskopa za menadžera.</p>
            <br><br>
            <a href="ProdajaServlet" class="btn btn-primary">KRENI</a>
          </div>
        </div>
        </div>
      </div><!--RED-->
      <br>
      <!--2.  RED POSLOVA-->
      <div class="row">
        <!--4. posao
        <div class="col-sm-6 col-md-4">
        <div class="card" style="width: 28rem;">
            <img src="slike/crud.jpg" class="card-img-top" alt="...">
          <div class="card-body">
            <h5 class="card-title">SJEDIŠTA U SALI</h5>
            <p class="card-text">Oslobađanje </p>
            <a href="ListaFilmovaServlet" class="btn btn-primary">KRENI</a>
          </div>
        </div>
        </div>-->
       
      
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


