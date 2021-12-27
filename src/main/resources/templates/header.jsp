<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://www.thymeleaf.org"
  xmlns:sec="http://www.thymeleaf.org/extras/spring-security">
<head>
    <meta charset="UTF-8"/>
    <link th:href="@{../../static/style.css}" rel="stylesheet" />
</head>
<body>

        <div sec:authorize="isAuthenticated()" th:fragment="navbar" th:with="uri=${#httpServletRequest.requestURI}" class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
                  <h5 class="my-0 mr-md-auto font-weight-normal">ECOMMERCE COMPANY</h5>

                  <nav class="my-2 my-md-0 mr-md-3 mr-md-auto">
                       <a class="p-2 text-dark" th:if="${uri} !='/products'" href="/products">Products</a>
                       <a class="p-2 text-dark" th:if="${uri} !='/getCart'" href="/getCart">Cart</a>
                       <a class="p-2 text-dark" th:if="${uri} !='/orderspage'" href="/orderspage">Checkout</a>
                  </nav>
                  <nav sec:authorize="hasRole('ROLE_ADMIN') or hasRole('ROLE_SELLER')" class="my-2 my-md-0 mr-md-3 mr-md-auto">
                     <a class="p-2 text-dark" th:if="${uri} !='/productadd'" href="/productadd">Add Product</a>
                  </nav>
                  <a sec:authorize="hasRole('ROLE_ADMIN')" class="p-2 text-dark" href="/sellers">Seller Status Handler</a>
                  <a class="btn btn-outline-primary" href="/logout">Log out</a>

            </div>
            <div sec:authorize="isAnonymous()" th:fragment="navbar"  th:with="uri=${#httpServletRequest.requestURI}" class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom box-shadow">
                              <h5 class="my-0 mr-md-auto font-weight-normal">ECOMMERCE COMPANY</h5>

                              <nav class="my-2 my-md-0 mr-md-3 mr-md-auto">
                                   <a class="p-2 text-dark" th:if="${uri} !='/products'" href="/products">Products</a>
                                   <a class="p-2 text-dark" th:if="${uri} !='/getCart'" href="/getCart">Cart</a>
                              </nav>
                              <a class="btn btn-outline-primary" th:if="${uri} !='/signin'" href="/signin">Sign In</a>
                              <a class="btn btn-outline-primary" th:if="${uri} !='/registration'" href="/registration">New User? Sign Up</a>


            </div>
</body>
</html>