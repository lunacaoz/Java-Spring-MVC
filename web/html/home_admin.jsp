<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html><!--
* CoreUI - Free Bootstrap Admin Template
* @version v4.2.2
* @link https://coreui.io/product/free-bootstrap-admin-template/
* Copyright (c) 2023 creativeLabs ?ukasz Holeczek
* Licensed under MIT (https://github.com/coreui/coreui-free-bootstrap-admin-template/blob/main/LICENSE)
--><!-- Breadcrumb-->
<html lang="en">
  <head>
    <base href="./">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <meta name="description" content="CoreUI - Open Source Bootstrap Admin Template">
    <meta name="author" content="?ukasz Holeczek">
    <meta name="keyword" content="Bootstrap,Admin,Template,Open,Source,jQuery,CSS,HTML,RWD,Dashboard">
    <title>CoreUI Free Bootstrap Admin Template</title>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
   
    <link rel="manifest" href="./inc/admin/assets/favicon/manifest.json">
    <meta name="msapplication-TileColor" content="#ffffff">
    <meta name="msapplication-TileImage" content="./inc/admin/assets/favicon/ms-icon-144x144.png">
    <meta name="theme-color" content="#ffffff">
    <!-- Vendors styles-->
    <link rel="stylesheet" href="./inc/admin/vendors/simplebar/css/simplebar.css">
    <link rel="stylesheet" href="./inc/admin/css/vendors/simplebar.css">
    <!-- Main styles for this application-->
    <link href="./inc/admin/css/style.css" rel="stylesheet">
    <!-- We use those styles to show code examples, you should remove them in your application.-->
    <link href="./inc/admin/css/examples.css" rel="stylesheet">
    <link href="./inc/admin/vendors/@coreui/chartjs/css/coreui-chartjs.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
         body {
            font-family: 'Open Sans', sans-serif;
          }
    .product-card {
            display: flex;
            align-items: center;
            margin-bottom: 10px;
            border-radius: 20px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
          }
          .product-image {
            flex: 0 0 auto;
            width: 80px;
            height: 80px;
            border-radius: 20px 0 0 20px;
            overflow: hidden;
            margin-right: 15px;
          }
          .product-image img {
            width: 100%;
            height: auto;
          }
          .product-details {
            flex: 1;
            display: flex;
            justify-content: space-between;
            align-items: center;
          }
          .product-name {
            margin: 0;
          }
          .product-price {
            font-weight: bold;
          }
          .update-button {
            flex: 0 0 auto;
            border-radius: 20px;
          }
          .custom-form .form-control {
            background-color: #e9ecef;
            border: none;
            border-radius: 20px;
            margin-bottom: 10px; /* Spacing between fields */
          }
          .custom-form .btn-custom {
            border-radius: 20px;
            border: none;
            color: white;
            padding: 5px 25px; /* Adjust padding to your preference */
          }
          .btn-blue {
            background-color: #007bff; /* Bootstrap primary color */
          }
          .btn-gray {
            background-color: #6c757d; /* Bootstrap secondary color */
          }
          .custom-table .thead-dark th {
            background-color: #007bff; /* Bootstrap primary color */
            color: white;
            border: none;
          }
          .custom-table .table-striped tbody tr:nth-of-type(odd) {
            background-color: rgba(0,0,0,.05);
          }
          .custom-table th, .custom-table td {
            border: none;
            border-radius: 10px;
          }
          .rounded-corners tr, .rounded-corners th, .rounded-corners td {
            border-radius: 0.75rem !important;
          }
        </style>
  </head>

  
  <body>
    <div class="sidebar sidebar-dark sidebar-fixed" id="sidebar">
      <div class="sidebar-brand d-none d-md-flex">
        <svg class="sidebar-brand-full" width="118" height="46" alt="CoreUI Logo">
          <use xlink:href="./inc/admin/assets/brand/coreui.svg#full"></use>
        </svg>
        <svg class="sidebar-brand-narrow" width="46" height="46" alt="CoreUI Logo">
          <use xlink:href="./inc/admin/assets/brand/coreui.svg#signet"></use>
        </svg>
      </div>
      <ul class="sidebar-nav" data-coreui="navigation" data-simplebar="">
        <li class="nav-item">
            <svg class="nav-icon">
            </svg> ADMIN</li>
        <li class="nav-title">Components</li>
        <li class="nav-group"><a class="nav-link nav-group-toggle" href="#">
            <svg class="nav-icon">
              <use xlink:href="./inc/admin/vendors/@coreui/icons/svg/free.svg#cil-cursor"></use>
            </svg> Function</a>
          <ul class="nav-group-items">
            <li class="nav-item"><a class="nav-link" href="./home_admin?id=2"><span class="nav-icon"></span>Add Product</a></li>
            <li class="nav-item"><a class="nav-link" href="./login"><span class="nav-icon"></span> Log Out</a></li>
          </ul>
        </li>
    </div>
    <div class="wrapper d-flex flex-column min-vh-100 bg-light">
      <header class="header header-sticky mb-4">
        <div class="container-fluid">
          <button class="header-toggler px-md-0 me-md-3" type="button" onclick="coreui.Sidebar.getInstance(document.querySelector('#sidebar')).toggle()">
            <svg class="icon icon-lg">
              <use xlink:href="./inc/admin/vendors/@coreui/icons/svg/free.svg#cil-menu"></use>
            </svg>
          </button><a class="header-brand d-md-none" href="#">
            <svg width="118" height="46" alt="CoreUI Logo">
              <use xlink:href="./inc/admin/assets/brand/coreui.svg#full"></use>
            </svg></a>
          <ul class="header-nav d-none d-md-flex">
            <li class="nav-item"><a class="nav-link" href="./home_admin?id=0">Product</a></li>
            <li class="nav-item"><a class="nav-link" href="./home_admin?id=1">List Oder</a></li>
          </ul>
          <ul class="header-nav ms-auto">
            <li class="nav-item"><a class="nav-link" href="#">
                <svg class="icon icon-lg">
                  <use xlink:href="./inc/admin/vendors/@coreui/icons/svg/free.svg#cil-bell"></use>
                </svg></a></li>
         
            
          </ul>
        </div>
   
    
      </header>
      <!-- body -->
      <!--product-->
      <c:if test="${id==null||id==0}">
              <div class="body flex-grow-1 px-3">
                  <div class="container mt-5">
                <h2 class="mb-4">LIST ALL PRODUCT</h2>
                <c:forEach var="s" items="${listProduct}">
                <div class="product-list">
                  <div class="product-card bg-light p-2">
                    <div class="product-image">
                      <img src="${s.getImg()}" alt="Product Image">
                    </div>
                    <div class="product-details">
                    <form action="updateprice" method="POST">
                        <input name="name" class="product-name" value="${s.getProduct_name()}">
                      <input name="price" type="number" class="product-price-input" value="${s.getPrice()}">
                      <input name="id" type="hidden" class="product-price-input" value="${s.getProduct_id()}">
                      <button type="submit" class="btn btn-primary update-button">Update</button>
                     </form>
                    </div>
                  </div>
                </div>
                </c:forEach>
              </div>
              </div>
        </c:if>
      
        <!--product-->
        
        <!--Add to Cart-->
        <c:if test="${id=='2'}">
        <div class="container mt-5">
          <div class="row">
            <div class="col-md-8 offset-md-2">
              <div class="text-center mb-3">
                <h2>Thêm sản phẩm</h2>
              </div>
                <form action="AddProduct" method="POST" class="custom-form" enctype="multipart/form-data">
                <div class="form-row">
                  <div class="form-group col-md-6">
                    <input name="product_name" type="text" class="form-control" placeholder="Tên sản phẩm">
                  </div>
                  <div class="form-group col-md-6">
                    <input name="year_sx" type="text" class="form-control" placeholder="Năm sản xuất">
                  </div>
                </div>
                <div class="form-row">
                  <div class="form-group col-md-6">
                    <input name="brand_id" type="text" class="form-control" placeholder="Tên Brand">
                  </div>
                  <div class="form-group col-md-6">
                    <input name="xuatsu" type="text" class="form-control" placeholder="Xuất xứ">
                  </div>
                </div>
                <div class="form-row">
                  <div class="form-group col-md-6">
                    <input name="chatlieu" type="text" class="form-control" placeholder="Chất liệu">
                  </div>
                  <div class="form-group col-md-6">
                    <input name="baohanh" type="text" class="form-control" placeholder="Bảo hành">
                  </div>
                </div>
                <div class="form-row">
                  <div class="form-group col-md-6">
                    <input name="price" type="text" class="form-control" placeholder="Giá">
                  </div>
                <div class="form-group">
                  <input name="img" type="file" class="form-control-file" placeholder="Image">
                </div>
                <div class="text-center">               
                  <button type="submit" class="btn btn-custom btn-blue">Xác nhận</button>
                </div>
              </form>
            </div>
          </div>
        </div>
        </c:if>
        
        <!--Add to Cart-->
        <!--List_odder-->
        <c:if test="${id=='1'}">
                <div class="container mt-5">
          <h2 class="text-center mb-4">List Oder</h2>
          <table class="table custom-table table-striped rounded-corners">
            <c:forEach var="s" items="${listOder}">
            <thead class="thead-dark">
              <tr>
                <th scope="col">${s.getUser_cart()}</th>
                <th scope="col">${s.getPlace()}</th>
                <th scope="col">Quantity: ${s.getSl()}</th>
                <th scope="col">id_product:${s.getProduct_sz_sl_id()}</th>
              </tr>
            </thead>
            </c:forEach>
          </table>
        </div>
        </c:if>
        <!--List_odder-->
      <!-- body -->
    </div>
    <!-- CoreUI and necessary plugins-->
    <script src="./inc/admin/vendors/@coreui/coreui/js/coreui.bundle.min.js"></script>
    <script src="./inc/admin/vendors/simplebar/js/simplebar.min.js"></script>
    <!-- Plugins and scripts required by this view-->
    <script src="./inc/admin/vendors/chart.js/js/chart.min.js"></script>
    <script src="./inc/admin/vendors/@coreui/chartjs/js/coreui-chartjs.js"></script>
    <script src="./inc/admin/vendors/@coreui/utils/js/coreui-utils.js"></script>
    <script src="./inc/admin/js/main.js"></script>
    <script>
    </script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.7.19/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.7.19/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  </body>
</html>