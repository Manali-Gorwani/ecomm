<!doctype html>
<html lang="en" xmlns:th="www.thymeleaf.com">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Session Manager Project</title>
</head>


<body>
<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
-->

<!-- Header -->
<div th:insert="/header :: navbar">  </div>

<div class="container text-center">
    <div th:if="${msg}" th:text="${msg}"  th:class="${'alert ' + alertClass}"/>
</div>

<div class="container">
    <div class="row">
        <h1>Sign In Page</h1>
    </div>
</div>

<form th:action="@{/dologin}" method="post">
    <div th:if="${param.error}" class="text-warning">
        Invalid Credentials
    </div>
    <div class="mb-3">
        <label for="inputUsername" class="form-label">Username</label>
        <input name="username" type="text" class="form-control" id="inputUsername">
    </div>
    <div class="mb-3">
        <label for="inputPassword" class="form-label">Password</label>
        <input name="password" type="password" class="form-control" id="inputPassword">
    </div>

    <button type="submit" class="btn btn-primary">Submit</button>
</form>


</body>
</html>