<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <title>${pet.name} | Adopt Me</title>
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
                    <small class="text-muted">Pet</small>
                    <h1 class="text-primary">${pet.name}</h1>
                </header>
                <div class="info">
                    <div class="row">
                        <div class="col-auto">
                            <div class="info-item">
                                    <small class="text-muted">ID</small>
                                    <p>${pet.id}</p>
                            </div>
                        </div>
                        <div class="col-auto">
                            <div class="info-item">
                                <small class="text-muted">Name</small>
                                <p>${pet.name}</p>
                            </div>
                        </div>
                        <div class="col-auto">
                            <div class="info-item">
                                <small class="text-muted">Animal</small>
                                <p>${pet.animal}</p>
                            </div>
                        </div>
                        <div class="col-auto">
                            <div class="info-item">
                                <small class="text-muted">Breed</small>
                                <p>${pet.breed}</p>
                            </div>
                        </div>
                        <div class="col-auto">
                            <div class="info-item">
                                <small class="text-muted">Age</small>
                                <p>${pet.age}</p>
                            </div>
                        </div>
                        <div class="col-auto">
                            <div class="info-item">
                                <small class="text-muted">City</small>
                                <p>${pet.city}</p>
                            </div>
                        </div>
                        <div class="col-auto">
                            <div class="info-item">
                                <small class="text-muted">Available adoption</small>
                                <p>${pet.availableAdoption ? "Yes" : "No"}</p>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>