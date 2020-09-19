<%-- 
    Document   : registracija
    Created on : Aug 2, 2020, 11:25:30 AM
    Author     : Mladen
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registraciona forma</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"  crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5774a146ab.js" crossorigin="anonymous"></script>

        <!--JS za validaciju polja registracione forme-->
        <script type="text/javascript">
      
                function zabranaIme()
                {
                    var unos=/[^a-zA-Z]/;

                    var ime=document.forma1.ime.value;
                    
                    if(ime!="")
                     { 
                        if(unos.test(ime))
                        {
                            alert("MOGUĆ JE UNOS SAMO SLOVA! Izbrišite i krenite ispočetka.");
                            document.forma1.ime.focus();                            
                            return(false);
                        }
                     }                                           
                }
                
                function zabranaPrezime()
                {
                    var unos=/[^a-zA-Z]/;

                    var prezime=document.forma1.prezime.value;
                    
                    if(prezime!="")
                     { 
                        if(unos.test(prezime))
                        {
                            alert("MOGUĆ JE UNOS SAMO SLOVA! Izbrišite i krenite ispočetka.");
                            document.forma1.prezime.focus();                            
                            return(false);
                        }
                     }                                           
                }
                
                function zabranaAdresa()
                {
                    var unos=/[^a-zA-Z0-9]/;

                    var adresa=document.forma1.adresa.value;
                    
                    if(adresa!="")
                     { 
                        if(unos.test(adresa))
                        {
                            alert("ADRESA NE SMIJE SADRŽATI SPECIJALNE ZNAKE! Izbrišite i krenite ispočetka.");
                            document.forma1.adresa.focus();                            
                            return(false);
                        }
                     }   
                }
                
                function zabranaGrad()
                {
                    var unos=/[^a-zA-Z]/;

                    var grad=document.forma1.grad.value;
                    
                    if(grad!="")
                     { 
                        if(unos.test(grad))
                        {
                            alert("MOGUĆ JE UNOS SAMO SLOVA U NAZIV GRADA! Izbrišite i krenite ispočetka.");
                            document.forma1.grad.focus();                            
                            return(false);
                        }
                     }                                           
                }
                
                function zabranaTelefon()
                {
                    var unos=/[^0-9+\s]/;

                    var telefon=document.forma1.telefon.value;
                    
                    if(telefon!="")
                     { 
                        if(unos.test(telefon))
                        {
                            alert("MOGUĆ JE UNOS SAMO BROJEVA SA RAZMAKOM I PREDZNAKOM +! Ponovite unos.");
                            document.forma1.telefon.focus();                            
                            return(false);
                        }
                     }                                           
                }
                
                function pass()
                 {              

                    var password1=document.forma1.password1.value;
                    var ilegal=/[\W_]/;
                   
                   if((password1.length<4) || (password1.length>12))
                   {
                       alert("Dužina šifre mora biti između 4 i 12 karaktera!");
                       document.forma1.password1.focus();                            
                            return(false);
                   }
                   else if(ilegal.test(password1))
                   {
                       alert("Password sadrži nedozvoljene karaktere!");
                       document.forma1.password1.focus();                            
                            return(false);
                   }
                   
                  }
                
            
        </script>
        
        <style>
            body{background: url("slike/kino.jpg"); background-repeat: no-repeat;
                 background-attachment: fixed;}            
            img{border-radius: 4px;}
            nav{height: 112px;}
            .navbar-brand{padding-left: 425px;}
            #forma1{width: 500px; color: white; background-color: blue; border-radius: 8px; align-content: center; }
            .p1{
                color: white;
                font-family: Verdana;
                font-size: 18px;
                background-color: black;
                width: 350px;
                border-radius: 4px;
            }
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
                   
                  </ul>
                 <form class="form-inline my-2 my-lg-0" action="https://www.google.com/search" method="GET" >
                     <input class="form-control mr-sm-2" type="search" placeholder="Unesite ključnu riječ" aria-label="Search" name="q"  >
                     <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Pretraži" >
                 </form>
               </div>
            </nav>
<!--KRAJ NAVBARA-->    
        
   
<center>
    <h2 style="color:white"><u>REGISTRUJTE SE</u></h2> 
    <small style="color:white">Registracijom ostvarujete mogućnost rezervacije karata.</small>
    <br>      
    
     <% 
                  String info=(String)request.getAttribute("info");
           
                  if(info!=null && info.length()>0)
                    {%>
                       <p class="p1"><b><%=info%></b></p>
                  <%}%>
    
    <!--Registraciona forma-->
    <form action="RegistracijaServlet" method="POST" id="forma1" name="forma1">
      <div class="form-group">
       <label for="InputIme">Ime</label>
       <input type="text" class="form-control" id="ime" aria-describedby="ime" placeholder="Unesite ime" name="ime"  onkeypress="zabranaIme()"  required>
       
      </div>
      <div class="form-group">
       <label for="InputPrezime">Prezime</label>
       <input type="text" class="form-control" id="prezime" placeholder="Unesite prezime" name="prezime" onkeypress="zabranaPrezime()" required>
      </div>
         <div class="form-group">
       <label for="InputAdresa">Adresa</label>
       <input type="text" class="form-control" id="adresa" placeholder="Unesite adresu" name="adresa" onkeypress="zabranaAdresa()" required>
      </div>
         <div class="form-group">
       <label for="InputGrad">Grad</label>
       <input type="text" class="form-control" id="grad" placeholder="Unesite grad" name="grad" onkeypress="zabranaGrad()" required>
      </div>
         <div class="form-group">
       <label for="InputTelefon">Telefon</label>
       <input type="text" class="form-control" id="telefon" placeholder="Unesite telefon" name="telefon" onkeypress="zabranaTelefon()" required>
      </div>
      <div class="form-group">
       <label for="InputUsername">Username</label>
       <input type="text" class="form-control" id="username" placeholder="Unesite username" name="username" required>
      </div>
      <div class="form-group">
       <label for="InputPassword1">Password</label>
       <input type="text"  class="form-control" id="Password1" placeholder="Unesite password" name="password1"  required title="Password mora da ima najmanje 4 karaktera, a najviše 12. Može da sadrži mala i velia slova i brojeve" >
      </div>
      <div class="form-group">
       <label for="InputPassword2">Ponovite password</label>
       <input type="password" class="form-control" id="Password2" placeholder="Ponovite unos passworda" name="password2" required>
      </div>
     
        <button type="submit" class="btn btn-primary" onclick="return pass()" >POTVRDI</button>
        <button type="reset" name="reset" class="btn btn-secondary"  >OBRIŠI</button>
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

