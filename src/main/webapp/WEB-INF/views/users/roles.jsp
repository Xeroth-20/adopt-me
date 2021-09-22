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
        <title>User Roles | Adopt Me</title>
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
                                <a href="<c:url value="/users"/>">Users</a>
                            </li>
                            <li class="breadcrumb-item active">
                                Roles
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
                            <header>
                                <div class="row">
                                    <div class="col">
                                        <h3>User ${user.username}</h3>
                                    </div>
                                    <div class="col-auto">
                                        <a class="btn btn-outline-secondary" href="<c:url value="/users"/>">
                                            Go back
                                        </a>
                                    </div>
                                </div>
                            </header>
                            <div class="row">
                                <div class="col-8">
                                    <div style="margin-bottom: .5rem">Roles</div>
                                    <ul class="list-group">
                                        <c:choose>
                                            <c:when test="${user.roles.size() > 0}">
                                                <c:forEach var="role" items="${user.roles}">
                                                    <li class="list-group-item">
                                                        <div class="row">
                                                            <div class="col">
                                                                    ${role.name}
                                                            </div>
                                                            <div class="col-auto">
                                                                <form id="form-delete-role" name="form-delete-role" class="mb-0"
                                                                      action="<c:url value="/users-roles/delete?userId=${user.id}&roleId=${role.id}"/>"
                                                                      method="post">
                                                                    <button class="btn btn-confirm btn-outline-danger" type="submit">
                                                                        <i class="fa fa-trash-alt"></i>
                                                                        Delete
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
                                    <form id="form-register-animal" name="form-register-role"
                                          action="<c:url value="/users-roles/register"/>"
                                          method="post">
                                        <div class="form-group d-none">
                                            <label for="userId">User</label>
                                            <input id="userId" name="userId" class="form-control" value="${user.id}" readonly/>
                                        </div>
                                        <div class="form-group">
                                            <label for="roleId">Role</label>
                                            <select id="roleId" name="roleId" class="form-control">
                                                <option value="">--Select a role--</option>
                                                <c:forEach var="role" items="${roles}">
                                                    <option value="${role.id}">${role.name}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-block btn-primary" type="submit">
                                                <i class="fa fa-check"></i>
                                                Assign role
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
                <%@ include file="/WEB-INF/views/shared/footer.jsp" %>
            </div>
        </div>
        <script type="application/javascript" src="<c:url value="/js/index.js"/>"></script>
    </body>
</html>