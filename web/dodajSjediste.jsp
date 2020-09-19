<%-- 
    Document   : dodajSjediste
    Created on : Aug 23, 2020, 1:28:11 PM
    Author     : Mladen
--%>

<%@page  import="java.sql.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forma za dodavanje sjedišta</title>
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
                width: 505px;
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
                     <a class="nav-link" href="ListaSjedistaServlet">C.R.U.D. sjedišta<span class="sr-only">(current)</span></a>
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
    <h2 style="color:white"><u>KREIRAJ NOVO SJEDIŠTE</u></h2> 
    
    <br>      
         <% 
                  String info=(String)request.getAttribute("info");
           
                  if(info!=null && info.length()>0)
                    {%>
                       <p class="p1"><b><%=info%></b></p>
                    <%}%> 
    <!--Forma-->
    <form action="DodajSjedisteServlet" method="POST" id="forma1">
      <div class="form-group">
       <label for="InputRezervisano">Rezervisano</label>
       <input type="text" class="form-control" id="rezervisano" aria-describedby="rezervisano" placeholder="0 - nije , 1 - jeste rezervisano" name="rezervisano">
       
      </div>
      <div class="form-group">
       <label for="InputVrsta">Vrsta sjedišta</label>
       <br>
       <select name="vrsta" id="vrsta" style="width:500px; height: 35px; border-radius: 4px;">
           <option class="form-control" value="economy">economy</option>
           <option class="form-control" value="exclusive">exclusive</option>
           <option class="form-control" value="cushy">cushy</option>
       </select>
      </div>
      <div class="form-group">
       <label for="InputCijena">Cijena</label>
       <input type="text" class="form-control" id="cijena" placeholder="Cijena po sjedištu (din.)" name="cijena">
      </div>
      <div class="form-group">
       <label for="InputIdListeSjedista">Lista sjedišta</label>
       <br>
         <select name="lista" id="lista" style="width:500px; height: 35px; border-radius: 4px;">
      
        <%
       try
         {
             Class.forName("com.mysql.jdbc.Driver").newInstance();
             Connection konekcija=DriverManager.getConnection("jdbc:mysql://localhost:3306/lanacbioskopa2", "root", "");
             
             String upit="SELECT * FROM listasjedista";             
             Statement stmt=konekcija.createStatement();             
             ResultSet rs=stmt.executeQuery(upit);
             
             while(rs.next())
             {%>                  
             <option class="form-control" value="<%=rs.getInt("idListeSjedista") %>" ><%=rs.getInt("idListeSjedista") %></option>
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
      
        <button type="submit" class="btn btn-primary">POTVRDI</button>
        <button type="reset" name="reset" class="btn btn-secondary">OBRIŠI</button>
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



