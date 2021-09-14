<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fontawesome.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
        <title>Login | Adopt me</title>
    </head>
    <body class="login">
        <div class="root">
            <div class="root-body d-flex justify-content-center align-items-start py-5 px-3">
                <div class="card">
                    <div class="card-header pt-5 pb-4">
                        <div class="text-center">
                            <img class="img-fluid login-img" src="<c:url value="/image/brand.png"/>" alt="brand"/>
                            <h1 class="text-primary display-4 lead mb-0">ADOPT ME</h1>
                        </div>
                    </div>
                    <div class="card-body">
                        <form id="form-login" name="form-login" class="mb-0" method="post" autocomplete="off" novalidate>
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <label class="input-group-text" for="username">
                                            <i class="fa fa-user"></i>
                                        </label>
                                    </div>
                                    <input id="username" name="username" class="form-control" placeholder="Username" type="text"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <label class="input-group-text" for="password">
                                            <i class="fa fa-lock"></i>
                                        </label>
                                    </div>
                                    <input id="password" name="password" class="form-control" placeholder="Password" type="password"/>
                                </div>
                                <c:if test="${error}">
                                    <div class="text-center">
                                        <small class="text-danger">Invalid username or password</small>
                                    </div>
                                </c:if>
                            </div>
                            <div class="form-group">
                                <button class="btn btn-block btn-primary" type="submit">
                                    <i class="fa fa-sign-in-alt"></i>
                                    LOGIN
                                </button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
