<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
        <title>Adoptions | Adopt me</title>
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
                        <div class="sidebar">
                            <div class="h3 text-muted">Modules</div>
                            <div class="list-group">
                                <a href="<c:url value="/pets"/>" class="list-group-item list-group-item-action">Pets</a>
                                <a href="<c:url value="/animals"/>" class="list-group-item list-group-item-action">Animals</a>
                                <a href="<c:url value="/areas"/>" class="list-group-item list-group-item-action">Areas</a>
                                <a href="<c:url value="/areas-animals"/>" class="list-group-item list-group-item-action">Areas
                                    animals</a>
                                <a href="<c:url value="/medical-records"/>" class="list-group-item list-group-item-action">Medical
                                    records</a>
                                <a href="<c:url value="/dosages"/>" class="list-group-item list-group-item-action">Dosages</a>
                                <a href="<c:url value="/vaccines"/>" class="list-group-item list-group-item-action">Vaccines</a>
                                <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action">Owners</a>
                                <a href="<c:url value="/adoptions"/>" class="list-group-item list-group-item-action active">Adoptions</a>
                                <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-9">
                        <header>
                            <div class="row">
                                <div class="col">
                                    <h3>Adoptions</h3>
                                </div>
                                <div class="col-auto">
                                    <a class="btn btn-primary" href="<c:url value="/adoptions/register"/>">
                                        Register adoption
                                    </a>
                                </div>
                            </div>
                        </header>
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Owner</th>
                                    <th scope="col">Pet</th>
                                    <th scope="col">Adoption Date</th>
                                    <th scope="col">Options</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${adoptions.size() > 0}">
                                        <c:forEach var="adoption" items="${adoptions}">
                                            <tr>
                                                <td>${adoption.id}</td>
                                                <td>${adoption.owner.fullname}</td>
                                                <td>${adoption.pet.name}</td>
                                                <td>${adoption.adoptionDate}</td>
                                                <td>
                                                    <div class="form-row">
                                                        <div class="col-auto">
                                                            <a class="btn btn-success" href="<c:url value="/adoptions/${adoption.id}/edit"/>">Edit</a>
                                                        </div>
                                                        <div class="col-auto">
                                                            <a class="btn btn-outline-danger" href="<c:url value="/adoptions/${adoption.id}/delete"/>">Delete</a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="4">No available logs.</td>
                                        </tr>
                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
