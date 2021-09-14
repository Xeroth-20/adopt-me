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
        <title>Allowed Animals | Adopt Me</title>
    </head>
    <body>
        <div class="root">
            <div class="root-header">
                <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                    <div class="container justify-content-start">
                        <a class="navbar-brand" href="<c:url value="/"/>">
                            <img class="d-inline-block align-top" src="<c:url value="/image/brand.png"/>"
                                 alt="brand" width="30" height="30"/>
                            Adopt Me
                        </a>
                        <ul class="navbar-nav mr-auto">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value="/"/>">Home</a>
                            </li>
                        </ul>
                        <a class="btn btn-outline-info" href="<c:url value="/logout"/>">
                            <i class="fa fa-sign-out-alt"></i>
                            Logout
                        </a>
                    </div>
                </nav>
            </div>
            <div class="root-body">
                <main class="container py-3">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="<c:url value="/"/>">Home</a>
                            </li>
                            <li class="breadcrumb-item">
                                <a href="<c:url value="/areas"/>">Areas</a>
                            </li>
                            <li class="breadcrumb-item active">
                                Allowed animals
                            </li>
                        </ol>
                    </nav>
                    <div class="mb-3"></div>
                    <div class="row">
                        <div class="col-3">
                            <div class="sidebar">
                                <div class="h3 text-muted">Modules</div>
                                <div class="list-group">
                                    <a href="<c:url value="/pets"/>" class="list-group-item list-group-item-action">Pets</a>
                                    <a href="<c:url value="/animals"/>" class="list-group-item list-group-item-action">Animals</a>
                                    <a href="<c:url value="/areas"/>" class="list-group-item list-group-item-action active">Areas</a>
                                    <a href="<c:url value="/areas-animals"/>" class="list-group-item list-group-item-action">Areas
                                        animals</a>
                                    <a href="<c:url value="/medical-records"/>" class="list-group-item list-group-item-action">Medical
                                        records</a>
                                    <a href="<c:url value="/dosages"/>" class="list-group-item list-group-item-action">Dosages</a>
                                    <a href="<c:url value="/vaccines"/>" class="list-group-item list-group-item-action">Vaccines</a>
                                    <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action">Owners</a>
                                    <a href="<c:url value="/adoptions"/>" class="list-group-item list-group-item-action">Adoptions</a>
                                    <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                                    <a href="<c:url value="/users"/>" class="list-group-item list-group-item-action">Users</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-9">
                            <header>
                                <div class="row">
                                    <div class="col">
                                        <h3>Area ${area.name}</h3>
                                    </div>
                                    <div class="col-auto">
                                        <a class="btn btn-outline-secondary" href="<c:url value="/areas"/>">
                                            Go back
                                        </a>
                                    </div>
                                </div>
                            </header>
                            <div class="row">
                                <div class="col-8">
                                    <div style="margin-bottom: .5rem">Allowed animals</div>
                                    <ul class="list-group">
                                        <c:choose>
                                            <c:when test="${area.animals.size() > 0}">
                                                <c:forEach var="animal" items="${area.animals}">
                                                    <li class="list-group-item">
                                                        <div class="row">
                                                            <div class="col">
                                                                    ${animal.name}
                                                            </div>
                                                            <div class="col-auto">
                                                                <form id="form-disallow-animal" name="form-disallow-animal" class="mb-0"
                                                                      action="<c:url value="/area-animals/delete?areaId=${area.id}&animalId=${animal.id}"/>"
                                                                      method="post">
                                                                    <button class="btn btn-confirm btn-outline-danger" type="submit">
                                                                        <i class="fa fa-ban"></i>
                                                                        Disallow
                                                                    </button>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </li>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <li class="list-group-item">Empty list</li>
                                            </c:otherwise>
                                        </c:choose>
                                    </ul>
                                </div>
                                <div class="col-4">
                                    <form id="form-allow-animal" name="form-allow-animal"
                                          action="<c:url value="/area-animals/register"/>"
                                          method="post">
                                        <div class="form-group d-none">
                                            <label for="areaId">Area</label>
                                            <input id="areaId" name="areaId" class="form-control" value="${area.id}" readonly/>
                                        </div>
                                        <div class="form-group">
                                            <label for="animalId">Animal</label>
                                            <select id="animalId" name="animalId" class="form-control">
                                                <option value="">--Select an animal--</option>
                                                <c:forEach var="animal" items="${animals}">
                                                    <option value="${animal.id}">${animal.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-block btn-primary" type="submit">
                                                <i class="fa fa-check"></i>
                                                Allow animal
                                            </button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div class="root-footer">
                <footer class="bg-dark">
                    <p class="text-center text-light py-3 mb-0">
                        Adopt Me &copy;2021
                    </p>
                </footer>
            </div>
        </div>
        <script type="application/javascript" src="<c:url value="/js/index.js"/>"></script>
    </body>
</html>