<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <title>Pets | Adopt me</title>
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
                    </ul>
                </div>
            </nav>
            <main class="container py-5">
                <header>
                    <div class="row">
                        <div class="col">
                            <h1>Pets</h1>
                        </div>
                        <div class="col-auto">
                            <a class="btn btn-primary" href="<c:url value="/pets/register"/>">Register pet</a>
                        </div>
                    </div>
                </header>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Name</th>
                            <th scope="col">Animal</th>
                            <th scope="col">Breed</th>
                            <th scope="col">Age</th>
                            <th scope="col">Available adoption</th>
                            <th scope="col">Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:choose>
                            <c:when test="${pets.size() > 0}">
                                <c:forEach var="pet" items="${pets}">
                                    <tr>
                                        <td>${pet.id}</td>
                                        <td>${pet.name}</td>
                                        <td>${pet.animal}</td>
                                        <td>${pet.breed}</td>
                                        <td>${pet.age}</td>
                                        <td>${pet.availableAdoption ? "Yes" : "No"}</td>
                                        <td>
                                            <div class="form-row">
                                                <div class="col-auto">
                                                    <a class="btn btn-primary" href="<c:url value="/pets/${pet.name}"/>">Detail</a>
                                                </div>
                                                <div class="col-auto">
                                                    <a class="btn btn-success" href="<c:url value="/pets/${pet.id}/edit"/>">Edit</a>
                                                </div>
                                                <div class="col-auto">
                                                    <a class="btn btn-outline-danger" href="<c:url value="/pets/${pet.id}/delete"/>">Delete</a>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:when>
                            <c:otherwise>
                                <tr>
                                    <td colspan="7">No available logs.</td>
                                </tr>
                            </c:otherwise>
                        </c:choose>
                    </tbody>
                </table>
            </main>
        </div>
    </body>
</html>
