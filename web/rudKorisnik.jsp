<%-- 
    Document   : rudKorisnik
    Created on : Aug 12, 2020, 4:29:22 PM
    Author     : Mladen
--%>

<%@page import="beans.Korisnik"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>R.U.D. korisnik</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"  crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/5774a146ab.js" crossorigin="anonymous"></script>

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
                border-radius: 4px; }
            
            td{align-items: center; font-size: 10px; width: 100%;}
            
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
                     <a class="nav-link" href="administrator.jsp">Administratorska<span class="sr-only">(current)</span></a>
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
    
    <h2 style="color:white"><u>PREGLED KORISNIKA</u></h2> <br> 
    
    
    <% String info=(String)request.getAttribute("info");
           
                  if(info!=null && info.length()>0)
                    {%>
                       <p class="p1"><b><%=info%></b></p>
                    <%}%>   
                       
    <% ArrayList<Korisnik> lk=(ArrayList<Korisnik>)request.getAttribute("listaKorisnika");       
    
    if(lk!=null)
        {%>
             <table class="table table-bordered table-dark" style="width:770px; ">
                <thead>
                    <tr>
                        <th scope="col">ID KORISNIKA</th>
                        <th scope="col" >IME</th>
                        <th scope="col">PREZIME</th>
                        <th scope="col">ADRESA</th>
                        <th scope="col">GRAD</th>
                        <th scope="col">TELEFON</th>
                        <th scope="col">ID KLUBA</th>
                        <th scope="col">POENI</th>
                        <th scope="col">USERNAME</th>
                        <th scope="col">PASSWORD</th>                      
                        <th scope="col">IZMJENI</th>
                        <th scope="col">BRIŠI</th>
                    </tr>
                </thead>
           <tbody>
     
          <% for(Korisnik k:lk)
          {%>
          <tr>
              <td><%=k.getIdKorisnika() %></td>              
              <td><%=k.getIme() %></td>
              <td><%=k.getPrezime() %></td>
              <td><%=k.getAdresa() %></td>
              <td><%=k.getGrad() %></td>
              <td><%=k.getTelefon() %></td>
              <td><%=k.getIdKluba() %></td>
              <td><%=k.getPoeni() %></td>              
              <td ><%=k.getUsername() %></td>
              <td><%=k.getPassword() %></td>
              <td align="center"><a href="izmjeniKorisnika.jsp?idKorisnika=<%=k.getIdKorisnika() %>" ><i class="far fa-edit"></i></a></td>
              <td align="center" ><a href="BrisiKorisnikaServlet?idKorisnika=<%=k.getIdKorisnika() %>"><i class="far fa-trash-alt"></i></a></td>
          </tr>
          <%} %>   
      </tbody>
    </table>
       <% }
       else
         {%>
    <p style="color:white;">U bazi nema filmova!</p>      
       
       <%}%>                    
                             
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
