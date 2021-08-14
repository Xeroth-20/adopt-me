<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <title>Register Pet | Adopt Me</title>
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
                    </ul>
                </div>
            </nav>
            <main class="container py-4">
                <div class="row">
                    <div class="col-3">
                        <div class="h3">Modules</div>
                        <div class="list-group">
                            <a href="<c:url value="/pets"/>" class="list-group-item list-group-item-action active">Pets</a>
                            <a href="<c:url value="/animals"/>" class="list-group-item list-group-item-action">Animals</a>
                            <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action">Owners</a>
                            <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                        </div>
                    </div>
                    <div class="col-9">
                        <div class="row">
                            <div class="col-4">
                                <h3>Register pet</h3>
                                <form:form modelAttribute="pet" method="post">
                                    <div class="form-group">
                                        <form:label path="name">
                                            Name
                                        </form:label>
                                        <form:input path="name" cssClass="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <form:label path="age">
                                            Age
                                        </form:label>
                                        <form:input path="age" cssClass="form-control"/>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-check">
                                            <form:checkbox path="availableAdoption" cssClass="form-check-input"/>
                                            <form:label path="availableAdoption" for="availableAdoption1" cssClass="form-check-label">
                                                Available adoption
                                            </form:label>
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="form-row">
                                            <div class="col">
                                                <button class="btn btn-block btn-primary" type="submit">Register</button>
                                            </div>
                                            <div class="col-auto">
                                                <a class="btn btn-block btn-outline-info" href="<c:url value="/pets"/>">
                                                    Go back
                                                </a>
                                            </div>
                                        </div>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
