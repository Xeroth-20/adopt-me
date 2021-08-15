<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>"/>
        <title>Home | Adopt me</title>
    </head>
    <body>
        <div class="root">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container">
                    <a class="navbar-brand" href="<c:url value="/"/>">Adopt Me</a>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" href="<c:url value="/"/>">Home</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main class="container py-4">
                <div class="row">
                    <div class="col-3">
                        <div class="h3 text-muted">Modules</div>
                        <div class="list-group">
                            <a href="<c:url value="/pets"/>" class="list-group-item list-group-item-action">Pets</a>
                            <a href="<c:url value="/animals"/>" class="list-group-item list-group-item-action">Animals</a>
                            <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action">Owners</a>
                            <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                        </div>
                    </div>
                    <div class="col-9">
                        <h3>Welcome to Adopt Me</h3>
                        <img class="img-thumbnail" src="<c:url value="/image/homepage.png"/>" alt="HomePageImage"/>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
