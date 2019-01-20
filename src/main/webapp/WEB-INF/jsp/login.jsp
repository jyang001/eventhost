<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>

<head>
    <title>Eventhost: Login</title>
    <link rel="stylesheet" href='/webjars/bootstrap/3.3.6/css/bootstrap.css'>
</head>

<body>
    <div class="container">
        <form action="#" th:action="/user/signup" method="POST">
            <button class="btn btn-lg btn-warning" type="button">Register</button>
        </form>

        <div th:if="${param.error}" align="center">
            <p style="font-size: 20; color: #FF1C19;">Email or Password invalid, please verify</p>
        </div>

        <form th:action="@{/user/login}" method="POST" class="form-signin">
            <h3 class="form-signin-heading" th:text="Welcome"></h3>
            <br/>

            <input type="text" id="email" name="email"  th:placeholder="Email"
                   class="form-control" /> <br/>
            <input type="password"  th:placeholder="Password"
                   id="password" name="password" class="form-control" /> <br />

            <button class="btn btn-lg btn-primary btn-block" name="Submit" value="Login" type="Submit" th:text="Login"></button>
        </form>
    </div>

<%@ include file="common/footer.jsp" %>