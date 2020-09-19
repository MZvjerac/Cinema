<%-- 
    Document   : izvjestajProdaje
    Created on : Aug 24, 2020, 6:51:52 PM
    Author     : Mladen
--%>



<%@page import="beans.Izvjestaj"%>
<%@page import="beans.Prodaja"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.Gson"%>
<%@ page import="com.google.gson.JsonObject"%>

<%
Gson gsonObj = new Gson();
Map<Object,Object> map = null;

ArrayList<Prodaja> lk=(ArrayList<Prodaja>)request.getAttribute("listaProdatog");
ArrayList<Izvjestaj> izv=(ArrayList<Izvjestaj>)request.getAttribute("rezultati");


List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
   

       for(Izvjestaj iz:izv)
       {
         
             map = new HashMap<Object,Object>(); map.put("label", iz.getDatum());   map.put("y",iz.getSumirano()); list.add(map);
                   
       }
 
String dataPoints = gsonObj.toJson(list);
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <script type="text/javascript">
            window.onload = function() { 
 
            var chart = new CanvasJS.Chart("chartContainer", {
            title: {
                    text: "Prodaja karata po danima"
                    },
                axisX: {
		title: "Datumi"
                        },
                axisY: {
		title: "Prodato (din.)",
		includeZero: true
                },
                data: [{
		type: "column",
		yValueFormatString: "din#,##0.0# ",
		dataPoints: <%out.print(dataPoints);%>
                }]
});
chart.render();
 
}
</script>
        
        
        <title>Izvještaj prodatih karata</title>
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
                   
                   
                  </ul>
                 <form class="form-inline my-2 my-lg-0" action="https://www.google.com/search" method="GET" >
                     <input class="form-control mr-sm-2" type="search" placeholder="Unesite ključnu riječ" aria-label="Search" name="q"  >
                     <input class="btn btn-outline-success my-2 my-sm-0" type="submit" value="Pretraži" >
                 </form>
               </div>
            </nav>
<!--KRAJ NAVBARA-->    
        

    <center>    
    <h2 style="color:white"><u>PREGLED PRODAJE</u></h2> <br> 
    </center>
    
    <% String info=(String)request.getAttribute("info");
           
                  if(info!=null && info.length()>0)
                    {%>
                       <p class="p1"><b><%=info%></b></p>
                    <%}%>   
                       
    <%        
    
    if(lk!=null)
        {%>
        <div class="row">
        <div class="col-sm-6 col-md-3">     
        <table class="table table-bordered table-dark" style="width:320px; padding-left: 15px;">
                <thead>
                    <tr>
                        <th scope="col">ID PRODAJE</th>
                        <th scope="col" >DATUM</th>
                        <th scope="col">PROMET (din.)</th>                        
                    </tr>
                </thead>
           <tbody>
     
          <% for(Prodaja k:lk)
          {%>
          <tr>
              <td><%=k.getIdProdaje() %></td>              
              <td><%=k.getDatum() %></td>
              <td><%=k.getPromet() %></td>              
          </tr>
          <%} %>   
      </tbody>
      <tr>
              
      </tr>
    </table>
      </div>
       <% }
       else
         {%>
    <p style="color:white;">Nije ništa prodato!</p>      
       
       <%}%>    
       
       <!--DIJAGRAM PRODAJE-->
      <div class="col-sm-6 col-md-9">
           <div id="chartContainer" style="height: 470px; width: 770px;"></div>
           <br>
           <p style="color:white;">Prijedlozi za poboljšanje prodaje</p>
           <form action="UbaciPrijedlog" method="POST">
               <textarea  name="prijedlozi" cols="103" rows="15" style="border:2px; border-color: black; border-radius: 8px;">                  
               </textarea>
               <br>
               <input type="submit" class="btn btn-secondary" value="POŠALJI" >
           </form>
           
      </div>                         
    </div>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>      
    
    
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

