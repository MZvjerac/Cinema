<%-- 
    Document   : podesavanjeVremena
    Created on : Aug 26, 2020, 10:04:37 AM
    Author     : Mladen
--%>



<%@page import="sat.sat"%>
<%@page import="java.time.Clock"%>
<%@page import="java.time.LocalTime"%>
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
        <title>Reset rezervacija</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"  crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5774a146ab.js" crossorigin="anonymous"></script>

        <script>
            function rad()
            {
                var rtSat =new Date();
                
                var sati=rtSat.getHours();
                var minuti=rtSat.getMinutes();
                var sekunde=rtSat.getSeconds();
                
                sati=("0"+ sati).slice(-2);
                minuti=("0" + minuti).slice(-2);
                sekunde=("0" + sekunde).slice(-2);
                
                document.getElementById('sat').innerHTML = sati +" : "+minuti+" : "+sekunde ;
                
                var t=setTimeout(rad, 500);
            }
        </script>
        
        <style>
            body{background: url("slike/kino.jpg"); 
                 background-repeat: no-repeat;
                 background-attachment: fixed; }                
                           
            img{border-radius: 4px;}
            nav{height: 112px;}
            .navbar-brand{padding-left: 525px;}
           
            #forma1{width: 350px; color: white; background-color: blue; border-radius: 8px; align-content: center; }
            .p1{
                color: white;
                font-family: Verdana;
                font-size: 18px;
                background-color: black;
                width: 350px;
                border-radius: 4px;}
            
            #sat{
                background-color: white;
                color:red;
                width:350px;
                border-radius: 4px;
            }
        </style>
        
    </head>
    <body onload="rad()">
          
       
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
                     <a class="nav-link" href="menadzer.jsp">Menadžerska<span class="sr-only">(current)</span></a>
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
   <%
       String info=(String)request.getAttribute("info");
       
       if(info!=null)
       {%>
       <p style="color:white;"><%=info%></p>
       <%}%>
       
     
       
   
        <h2 style="color:white"><u>PODESI VRIJEME RESETA</u></h2> 
       
        <label style="color:red; font-weight: bold; ">TRENUTNO VRIJEME:</label> 
        
            <div class="main-container">
                <div id="sat"></div>
            </div>
          
        <form action="AutomatskiReset" method="POST" id="forma1">
          <div class="form-group">
          <label for="exampleInputVrijeme" style="font-size:22px;" >Vrijeme reseta</label>
       <input type="text" class="form-control" id="postavka" aria-describedby="postavka" placeholder="Unesite - hh:mm:ss - reseta" name="postavka">
       <br>      
         <button type="submit" class="btn btn-primary">POTVRDI</button>
         <button type="reset" name="reset" class="btn btn-secondary">OBRIŠI</button>
    </form>
        
    </center>     
    <br>                
           
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



