<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Utils.API"%>
<!doctype html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="./inc/css/bootstrap.min.css"/>
        <script type="text/javascript"  src="./inc/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="./inc/mycss/cart.css">
        
    </head>
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
      <a class="navbar-brand mt-2 mt-sm-0" >
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
            <%
                int sl = (int)session.getAttribute("slhang");
                int id_user = (int)session.getAttribute("id_user");
                session.setAttribute("id_user", id_user);
                session.setAttribute("slhang", sl);
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
      <a class="nav-link me-3" href="./login">
        <image src="./assets/icon/logout.jpg" width="30" height="30"/>
      </a>
      
    </div>
    <!-- Right elements -->
    
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->
         <div class="container" style=" margin-top: 100px;"></div>
       <div class="container bootdey">
       <div class="row bootstrap snippets">
           <div class="col-lg-3 col-md-3 col-sm-12">
               <!-- Best Seller -->
               <div class="col-lg-12 col-md-12 col-sm-12 hidden-xs">
                   <div class="no-padding">
                   </div>

                       </div>
               </div>
               <!-- End Best Seller -->
           </div>
           <div class="clearfix visible-sm"></div>

           <!-- Cart -->
           <div class="col-lg-9 col-md-9 col-sm-12">
               <div class="col-lg-12 col-sm-12">
                   <span class="title">SHOPPING CART</span>
                   <span class="title"><a href="./cart?id=${id_user}">Empitycart</a></span>
               </div>
               <div class="col-lg-12 col-sm-12 hero-feature">
                   <div class="table-responsive">
                       <table class="table table-bordered tbl-cart">
                           <thead>
                               <tr>
                                   <td class="hidden-xs">Image</td>
                                   <td>Product Name</td>
                                   <td>Size</td>
                                   <td>Color</td>
                                   <td class="td-qty">Quantity</td>
                                   <td>Unit Price</td>
                                   <td>Sub Total</td>
                                   <!--<td>Remove</td>-->
                               </tr>
                           </thead>
                           <tbody>
                                <c:forEach var="s" items="${listCart}">
                               <tr >
                                   <td class="hidden-xs" >
                                       <a href="#">
                                           <img src="${s.getImg()}" alt="Adidas Men Red Printed T-shirt" title="" width="47" height="47">
                                       </a>
                                   </td>
                                   <td><a href="#">${s.getProduct_name()}</a>
                                   </td>
                                   <td>
                                       <select name="">
                                           <option value="">${s.getSz()}</option>
                                       </select>
                                   </td>
                                   <td>
                                       <select name="">
                                           <option value="" selected="selected">${s.getColor()}</option>
                                       </select>
                                   </td>
                                   <td>
                                       <div class="input-group bootstrap-touchspin">
                                           <span class="input-group-addon bootstrap-touchspin-prefix" style="display: none;"></span>
                                           <a class="input-qty form-control text-center" style="display: block;">${s.getSl()}</a>
                                           <span class="input-group-addon bootstrap-touchspin-postfix" style="display: none;"></span>
                                       </div>
                                   </td>
                                   <td class="price">$ ${s.getPrice()}</td>
                                   <td>$ ${s.getPrice() * s.getSl()}</td>
<!--                                   <td class="text-center">
                                       <a href="#" class="remove_cart" rel="1">
                                           <i class="fa fa-trash-o"></i>
                                       </a>
                                   </td>-->
                               </tr>
                               </c:forEach>
                               <tr>
                                   <td colspan="6" align="right">Total</td>
                                   <td class="total" colspan="2"><b>$ ${tong}</b>
                                   </td>
                               </tr>
                           </tbody>
                       </table>
                   </div>
                   <div class="btn-group btns-cart">
                        <a href="/LeThiNgocAnh/bar"><button type="button" class="btn btn-primary" ><i class="fa fa-arrow-circle-left" ></i>Continue Shopping</button></a>
                        <a href="/LeThiNgocAnh/pay"><button type="button" class="btn btn-primary">Checkout <i class="fa fa-arrow-circle-right"></i></button></a>
                   </div>

               </div>
           </div>
           <!-- End Cart -->
       </div>
       </div>
       <script>
            var price = parseFloat("${s.getPrice()}");
            var quantity = parseInt("${s.getSl()}");
            var total = price * quantity;
            document.getElementById("totalPrice").innerHTML = "$ " + total.toFixed(2); // ??nh d?ng s? v?i hai ch? s? th?p phân
        </script>
    </body>
</html>

        
