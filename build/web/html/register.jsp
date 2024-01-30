<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
    <link rel="stylesheet" href="./inc/css/bootstrap.min.css"/>
    <script type="text/javascript"  src="./inc/js/bootstrap.bundle.min.js"></script>
    <link rel="stylesheet" href="./product.css">
    <style>
        .gradient-custom-3 {
            /* fallback for old browsers */
            background: #84fab0;
            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));
            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right, rgba(132, 250, 176, 0.5), rgba(143, 211, 244, 0.5));
        }
        .gradient-custom-4 {
            /* fallback for old browsers */
            background: #84fab0;
            /* Chrome 10-25, Safari 5.1-6 */
            background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));
            /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
            background: linear-gradient(to right, rgba(132, 250, 176, 1), rgba(143, 211, 244, 1));
        }
        .custom-form {
            background-color: rgba(255, 255, 255, 0.8);
            border-radius: 15px;
            padding: 20px;
        }
    </style>
</head>
<body>
    <section class="vh-100 bg-image"
        style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
        <div class="mask d-flex align-items-center h-100 gradient-custom-3">
            <div class="container h-100">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-12 col-md-9 col-lg-7 col-xl-6">
                        <div class="card custom-form">
                            <div class="card-body p-5">
                                <h2 class="text-uppercase text-center mb-5">Create an account</h2>
                                <form action="register" method="POST">
                                    <c:if test="${Error!=null}">
                                        <h2 class="text-uppercase text-center mb-5">${Error}</h2>   
                                    </c:if>
                                    <div class="form-outline mb-4">
                                        <input name="full_name" type="text" id="form3Example1cg" class="form-control form-control-lg" />
                                        <label class="form-label" for="form3Example1cg">Your Name</label>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input  name="email" type="mail" id="form3Example3cg" class="form-control form-control-lg" />
                                        <c:if test="${errol==1}">
                                            <label style="color:red;" class="form-label" for="form3Example3cg">Your Email</label>
                                        </c:if>
                                        <c:if test="${errol!=1}">
                                             <label class="form-label" for="form3Example3cg">Your Email</label>
                                        </c:if>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input  name="phone" type="number" id="form3Example3cg" class="form-control form-control-lg" />
                                        <label class="form-label" for="form3Example3cg">PHONE</label>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <input name="pass" type="password" id="form3Example4cg" class="form-control form-control-lg" />
                                        <label class="form-label" for="form3Example4cg">Password</label>
                                    </div>
                                    <div class="form-outline mb-4">
                                        <c:if test="${errol_pass==1}">  
                                            <input name="repass" type="password" id="form3Example4cdg" class="form-control form-control-lg" />
                                            <label style="color:red;"  class="form-label" for="form3Example4cdg">Repeat your password</label>
                                            
                                        </c:if>
                                        <c:if test="${errol_pass!=1}">
                                               <input name="repass" type="password" id="form3Example4cdg" class="form-control form-control-lg" />
                                                <label class="form-label" for="form3Example4cdg">Repeat your password</label>
                                        </c:if>
                                      
                                    </div>
                                    <div class="d-flex justify-content-center">
                                        <button type="submit" class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">Create</button>
                                    </div>
                                </form>
                                    <p class="text-center text-muted mt-5 mb-0">Have already an account? 
                                        <a href="/LeThiNgocAnh/login" class="fw-bold text-body"><u>Login here</u></a></p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
