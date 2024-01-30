<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Impl.BrandImpl" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!--Main layout-->
    <main style="background-color: #ffff">
    <div class="container" style=" margin-top: 80px;"></div>
<nav class="navbar navbar-expand-lg navbar-dark mt-3 mb-5 shadow p-2" style="background-color: #607D8B">
            <!-- Container wrapper -->
            <div class="container-fluid">
                <a class="navbar-brand navbar-brand-all" href="./bar?idBrand=0" data-brand-id="all">All</a>
                <!-- Navbar brand -->
                <c:forEach items="${listBrand}" var="s">
                    <a class="navbar-brand" href="./bar?idBrand=${s.brand_id}" data-brand-id="${s.getBrand_id()}">${s.getBrand_name()}</a>
                </c:forEach>

                <!-- Toggle button -->
                <button 
                    class="navbar-toggler" 
                    type="button" 
                    data-mdb-toggle="collapse" 
                    data-mdb-target="#navbarSupportedContent2" 
                    aria-controls="navbarSupportedContent2" 
                    aria-expanded="false" 
                    aria-label="Toggle navigation">
                    <i class="fas fa-bars"></i>
                </button>

                <!-- Collapsible wrapper -->
                <div class="collapse navbar-collapse" id="navbarSupportedContent2">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0"></ul>

                    <!-- Search -->
                    <form class="w-auto py-1" style="max-width: 12rem">
                        <input type="search" class="form-control rounded-0" placeholder="Search" aria-label="Search" style="background-color: #ccc">
                    </form>
                </div>
            </div>
            <!-- Container wrapper -->
        </nav>
        <!-- Navbar -->

        <section style="border-radius: 20px;" class="banner">
            <div id="carouselExample" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="./assets/img/slide1.png" class="d-block w-100" alt="First slide">
                    </div>
                    <div class="carousel-item">
                        <img src="./assets/img/slide2.png" class="d-block w-100" alt="Second slide">
                    </div>
                    <div class="carousel-item">
                        <img src="./assets/img/slide3.png" class="d-block w-100" alt="Third slide">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExample" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExample" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </section>
        <!-- Banner -->
        <c:if test="${idBrand==0}">
        <!-- Products -->
        <section style="margin-top: 50px; margin-left: 50px; background-color: #ecebeb;border-radius: 20px;" >
            <div class="text-center">
                <div class="row">                  
                    <c:forEach items="${listProduct}" var="s">
                        <div class="col-lg-3 col-md-6 mb-4 card" data-brand-id="${s.getBrand_id()}">
                            <div style="margin-left: 50px; margin-top: 50px; margin-right: 20px;border-radius: 20px;" class="card">
                                <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                                    data-mdb-ripple-color="light">
                                    <img src=${s.getImg()} class="w-100"/ alt="anh">
                                    <a href="#!">
                                        <div class="hover-overlay">
                                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                        </div>
                                    </a>
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title mb-2">${s.getPrice()}$</h5>
                                    <a href="/LeThiNgocAnh/product?id_product=${s.getProduct_id()}" class="text-reset ">
                                        <p>MORE</p>
                                    </a>
                                    <h6 class="mb-3 price">${s.getProduct_name()} </h6>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Products -->
        </c:if>
        
        <c:if test="${idBrand!=0}">
        <!-- Products -->
        <section style="margin-top: 50px; margin-left: 50px; background-color: #ecebeb;border-radius: 20px;" >
            <div class="text-center">
                <div class="row">                  
                    <c:forEach items="${listProduct}" var="s">
                         <c:if test="${s.brand_id==idBrand}">
                        <div class="col-lg-3 col-md-6 mb-4 card" data-brand-id="${s.getBrand_id()}">
                            <div style="margin-left: 50px; margin-top: 50px; margin-right: 20px;border-radius: 20px;" class="card">
                                <div class="bg-image hover-zoom ripple ripple-surface ripple-surface-light"
                                    data-mdb-ripple-color="light">
                                    <img src=${s.getImg()} class="w-100"/ alt="anh">
                                    <a href="#!">
                                        <div class="hover-overlay">
                                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.15);"></div>
                                        </div>
                                    </a>
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title mb-2">${s.getPrice()}$</h5>
                                    <a href="/LeThiNgocAnh/product?id_product=${s.getProduct_id()}" class="text-reset ">
                                        <p>MORE</p>
                                    </a>
                                    <h6 class="mb-3 price">${s.getProduct_name()} </h6>
                                </div>
                            </div>
                        </div>
                                   </c:if>
                    </c:forEach>
                </div>
            </div>
        </section>
        <!-- Products -->
        </c:if>
        
    </main>
</body>
</html>
