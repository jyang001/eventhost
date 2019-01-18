<nav class ="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="/" class="navbar-brand">HomePage</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="#">Link</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right ml-auto">
                <li><a href="#">Link</a></li>
                <c:choose>
                    <c:when test="${not logstatus}">
                        <a href="/user/login" button type="button" class="btn btn-primary">Log In</a>
                        <a href="/user/signup" button type="button" class="btn btn-primary">Sign Up</a>
                    </c:when>

                    <c:otherwise>
                        <li>
                            <div class="dropdown">
                                <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    My Account
                                    <span class="caret"></span>
                                </button>
                                <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <li><a href="#">Info</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Logout</a></li>
                                </ul>
                            </div>
                        </li>
                    </c:otherwise>
                </c:choose>


            </ul>

        </div>
    </div>
</nav>