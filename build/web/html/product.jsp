<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Utils.API"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet"href="./inc/mycss/product.css">
    <title>JSP Page</title>
    <link rel="stylesheet" href="./inc/css/bootstrap.min.css"/>
    <script type="text/javascript"  src="./inc/js/bootstrap.bundle.min.js"></script>
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
            <a class="nav-link " href="./bar">Continue Shopping</a>
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
        <image src="${listDetail.get(0).getColor_img()}" width="30" height="30"/>
      </a>
      
    </div>
    <!-- Right elements -->
    
  </div>
  <!-- Container wrapper -->
</nav>
<!-- Navbar -->
    <div class="all">
    <!-- hình ảnh sản phẩm -->
    <div class="IMG_PRODUCT">
        <img src="./assets/img/nikeair1.webp" alt="anh" sizes="50px">
    </div>
     <!-- hình ảnh sản phẩm -->
     <!-- Thông tin sản phẩm -->
    <div>
    <div class="INFORMATION_PRODUCT">
        <section class="all_description">
            <h1 id="tieude">Decription </h1>
            <div class="description">
                <label class="mucluc">Chất Liệu :</label>
                <div> ${all.getChatlieu()} </div>
            </div>
            <div class="description">
                <label class="mucluc">Năm sản xuất :</label>
                <div> ${all.getYear_sx()}</div>
            </div>
            <div class="description">
                <label class="mucluc">Xuất sứ :</label>
                <div> ${all.getXuatsu()}</div>
            </div>
            <div class="description">
                <label class="mucluc">Bảo Hành :</label>
                <div>${all.getBaohanh()} Năm</div>
            </div>
        </section>
        <section class="select">
            <section class="img_select">
                <c:forEach var="s" items="${listDetail}">
                    <div class="imgg"><a href="./product?product_id_color=${s.getProduct_color_id()}">
                            <button class="khunganh"><img src="${s.getColor_img()}" alt="2" ></button></a></div>
                </c:forEach>
            </section>
             <form action="product" method="post">   
                 <select name="id2">
                <c:forEach var="s" items="${listSize}">
                    <c:if test="${product_id_color == s.product_color_id}">
                        <option value="${s.product_sz_sl_id}">${s.sz}</option>
                    </c:if>
                </c:forEach>
            </select>    
            <section class="pay">          
                <input type="hidden" name="id1" value="${user.id_user}">                                
                <button type="submit" id="add">
                    <img src="./assets/img/giohang.jpg" alt="giohang"> Thêm vào giỏ hàng
                </button>
            </form>
            </section>
        </section>
    </div>
    </div>
</div>
     <!-- Thông tin sản phẩm -->
</body>
</html>