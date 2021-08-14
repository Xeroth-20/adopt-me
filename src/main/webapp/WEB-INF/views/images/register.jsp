<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <title>Register Image | Adopt Me</title>
    </head>
    <body>
        <div class="root">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <div class="container">
                    <a class="navbar-brand" href="<c:url value="/"/>">Adopt Me</a>
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/"/>">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/pets"/>">Pets</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/images"/>">Images</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main class="container py-5">
                <div class="row">
                    <div class="col-4">
                        <h1>Register image</h1>
                        <form:form modelAttribute="image" method="post" enctype="multipart/form-data">
                            <div class="form-group">
                                <input class="form-control" name="file" type="file"/>
                            </div>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col">
                                        <button class="btn btn-block btn-primary" type="submit">Register</button>
                                    </div>
                                    <div class="col-auto">
                                        <a class="btn btn-block btn-outline-info" href="<c:url value="/images"/>">
                                            Go back
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
