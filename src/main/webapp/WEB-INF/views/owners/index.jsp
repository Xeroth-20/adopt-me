<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <title>Owners | Adopt me</title>
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
                        <div class="h3 text-muted">Modules</div>
                        <div class="list-group">
                            <a href="<c:url value="/pets"/>" class="list-group-item list-group-item-action">Pets</a>
                            <a href="<c:url value="/animals"/>" class="list-group-item list-group-item-action">Animals</a>
                            <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action active">Owners</a>
                            <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                        </div>
                    </div>
                    <div class="col-9">
                        <header>
                            <div class="row">
                                <div class="col">
                                    <h3>Owners</h3>
                                </div>
                                <div class="col-auto">
                                    <a class="btn btn-primary" href="<c:url value="/owners/register"/>">Register owner</a>
                                </div>
                            </div>
                        </header>
                        <table class="table table-bordered">
                            <thead class="thead-dark">
                                <tr>
                                    <th scope="col">ID</th>
                                    <th scope="col">Firstname</th>
                                    <th scope="col">Lastname</th>
                                    <th scope="col">Email</th>
                                    <th scope="col">Phone</th>
                                    <th scope="col">Options</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${owners.size() > 0}">
                                        <c:forEach var="owner" items="${owners}">
                                            <tr>
                                                <td>${owner.id}</td>
                                                <td>${owner.firstname}</td>
                                                <td>${owner.lastname}</td>
                                                <td>${owner.email}</td>
                                                <td>${owner.phone}</td>
                                                <td>
                                                    <div class="form-row">
                                                        <div class="col-auto">
                                                            <a class="btn btn-success" href="<c:url value="/owners/${owner.id}/edit"/>">Edit</a>
                                                        </div>
                                                        <div class="col-auto">
                                                            <a class="btn btn-outline-danger" href="<c:url value="/owners/${owner.id}/delete"/>">Delete</a>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <tr>
                                            <td colspan="6">No available logs.</td>
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