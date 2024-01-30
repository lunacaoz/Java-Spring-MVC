<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Utils.API"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./inc/css/bootstrap.min.css"/>
        <script type="text/javascript"  src="./inc/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="./inc/mycss/bar.css">
        <link rel="stylesheet"href="./inc/mycss/product.css">
        <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
        <script>
            $(document).ready(function() {
                $(".navbar-brand").on("click", function() {
                    var selectedBrandId = $(this).data("brand-id");

                    // ?n t?t c? các s?n ph?m
                    $(".card").hide();

                    if (selectedBrandId === "all") {
                        // N?u ch?n "All", hi?n th? t?t c? s?n ph?m
                        $(".card").show();
                    } else {
                        // Hi?n th? ch? s?n ph?m thu?c v? th??ng hi?u ???c ch?n
                        $(".card[data-brand-id='" + selectedBrandId + "']").show();
                    }
                });
            });
        </script>
    </head>
<body> 
<!-- Navbar -->
<nav class="navbar fixed-top navbar-expand-lg navbar-light bg-white">
  <!-- Container wrapper -->
  <div class="container">    
    <!-- Toggle button -->
    <button
      class="navbar-toggler"
      type="button"
      data-mdb-toggle="collapse"
      data-mdb-target="#navbarSupportedContent1"
      aria-controls="navbarSupportedContent1"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <i class="fas fa-bars"></i>
    </button>

    <!-- Collapsible wrapper -->
    <div class="collapse navbar-collapse" id="navbarSupportedContent1">      
      <!-- Navbar brand -->
      <a class="navbar-brand mt-2 mt-sm-0">
        <img
          src="./assets/icon/logo.png"
          height="70"
          alt="MDB Logo"
          loading="lazy"
        />
      </a>
      <!-- Left links -->
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item active">
          <a class="nav-link ">SNEAKER NUMBERONE . LIFT YOUR LEGS</a>
        </li>
      </ul>
      <!-- Left links -->      
    </div>
    <!-- Collapsible wrapper -->
    
    <!-- Right elements -->
    <div class="d-flex align-items-center">
      <!-- Icon -->
      <a class="nav-link me-3" href="cart">
         <image src="./assets/icon/giohang.jpg" width="25" height=" 25"/>
         <c:set var="p" value="${user.getId_user()}"></c:set>
            <%
                int id_user = (int)pageContext.getAttribute("p");
                session.setAttribute("id_user",id_user);
                session.setAttribute("slhang",(Dao.Database.getCart().showall(id_user)).size());
                response.sendRedirect("/cart");
            %>
            <i>${slhang}</i>
      </a>

      <a class="nav-link me-3" href="#">
          <c:set var="s" value="${user.getFull_name()}"></c:set>
          <%
              String name = (String)pageContext.getAttribute("s");
              out.print(API.getName(name));
          %>
      </a>
      <a class="nav-link me-3" href="/LeThiNgocAnh/login">
        <image src="./assets/icon/logout.jpg" width="30" height="30"/>
      </a>
      
    </div>
    <!-- Right elements -->
    
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->