<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fontawesome.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
        <title>Users | Adopt me</title>
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
                            <li class="breadcrumb-item active">
                                Users
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
                                    <a href="<c:url value="/areas"/>" class="list-group-item list-group-item-action">Areas</a>
                                    <a href="<c:url value="/areas-animals"/>" class="list-group-item list-group-item-action">Areas
                                        animals</a>
                                    <a href="<c:url value="/medical-records"/>" class="list-group-item list-group-item-action">Medical
                                        records</a>
                                    <a href="<c:url value="/dosages"/>" class="list-group-item list-group-item-action">Dosages</a>
                                    <a href="<c:url value="/vaccines"/>" class="list-group-item list-group-item-action">Vaccines</a>
                                    <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action">Owners</a>
                                    <a href="<c:url value="/adoptions"/>" class="list-group-item list-group-item-action">Adoptions</a>
                                    <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                                    <a href="<c:url value="/users"/>" class="list-group-item list-group-item-action active">Users</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-9">
                            <header class="table-header">
                                <div class="row">
                                    <div class="col">
                                        <h3 class="table-header-title">
                                            USERS
                                        </h3>
                                    </div>
                                    <div class="col-auto">
                                        <a class="btn btn-primary" href="<c:url value="/users/register"/>">
                                            <i class="fa fa-plus"></i>
                                            Register user
                                        </a>
                                    </div>
                                </div>
                            </header>
                            <table class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Username</th>
                                        <th scope="col">Roles</th>
                                        <th scope="col">Active</th>
                                        <th scope="col">Options</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:choose>
                                        <c:when test="${users.size() > 0}">
                                            <c:forEach var="user" items="${users}">
                                                <tr>
                                                    <td>${user.id}</td>
                                                    <td>${user.username}</td>
                                                    <td>${user.roles.size() > 0 ? f:join(user.roles.toArray(), ", " ) : "NONE"}</td>
                                                    <td>${user.active ? "Yes" : "No"}</td>
                                                    <td>
                                                        <div class="dropdown">
                                                            <button id="dropdownMenuUser${user.id}" class="btn btn-block btn-outline-primary"
                                                                    type="button" data-toggle="dropdown">
                                                                <i class="text-primary fa fa-cog"></i>
                                                                Options
                                                            </button>
                                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuUser${user.id}">
                                                                <a class="dropdown-item" href="<c:url value="/users/${user.id}/roles"/>">
                                                                    <div class="icon-dd-container">
                                                                        <i class="text-primary fa fa-user-cog"></i>
                                                                    </div>
                                                                    Roles
                                                                </a>
                                                                <a class="dropdown-item" href="<c:url value="/users/${user.id}/change-password"/>">
                                                                    <div class=icon-dd-container>
                                                                        <i class="text-success fa fa-key"></i>
                                                                    </div>
                                                                    Change password
                                                                </a>
                                                                <div class="dropdown-divider"></div>
                                                                <c:choose>
                                                                    <c:when test="${user.active}">
                                                                        <a class="dropdown-item btn-confirm" href="<c:url value="/users/${user.id}/disable"/>">
                                                                            <div class="icon-dd-container">
                                                                                <i class="text-danger fa fa-user-alt-slash"></i>
                                                                            </div>
                                                                            Disable account
                                                                        </a>
                                                                    </c:when>
                                                                    <c:otherwise>
                                                                        <a class="dropdown-item" href="<c:url value="/users/${user.id}/enable"/>">
                                                                            <div class="icon-dd-container">
                                                                                <i class="text-info fa fa-user-check"></i>
                                                                            </div>
                                                                            Enable account
                                                                        </a>
                                                                    </c:otherwise>
                                                                </c:choose>
                                                            </div>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </c:when>
                                        <c:otherwise>
                                            <tr>
                                                <td colspan="5">No available logs.</td>
                                            </tr>
                                        </c:otherwise>
                                    </c:choose>
                                </tbody>
                            </table>
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
        <script type="application/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
        <script type="application/javascript" src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
        <script type="application/javascript" src="<c:url value="/js/index.js"/>"></script>
    </body>
</html>
