<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>


<head>
    <title>EventHost: User Registration Page</title>
    <link rel="stylesheet" href='/webjars/bootstrap/3.3.6/css/bootstrap.css'>
</head>

<body>
<div class="container">
    <h1>User Sign Up Form</h1>
    <form:form method = "post" modelAttribute="user">
        <form:hidden path="id"/>
        <fieldset class="form-group">
            <form:label path="firstName">First Name</form:label>
            <form:input path="firstName" type="text"
                        class="form-control" required="required"/>
            <form:errors path="firstName" cassClass="text-warning"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="lastName">Last Name</form:label>
            <form:input path="lastName" type="text"
                        class="form-control" required="required"/>
            <form:errors path="lastName" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="email">Email</form:label>
            <form:input path="email" type="text"
                        class="form-control" required="required"/>
            <form:errors path="email" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="userName">Username</form:label>
            <form:input path="userName" type="text"
                        class="form-control" required="required"/>
            <form:errors path="userName" cssClass="text-warning"/>
        </fieldset>

        <fieldset class="form-group">
            <form:label path="password">Password</form:label>
            <form:input path="password" type="password"
                        class="form-control" required="required"/>
            <form:errors path="password" cssClass="text-warning"/>
        </fieldset>

        <button type="submit" class="btn btn-success"/>Add</button>
    </form:form>
</div>

<%@ include file="common/footer.jsp" %>
