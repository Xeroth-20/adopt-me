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
        <title>Pets | Adopt me</title>
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
                                Pets
                            </li>
                        </ol>
                    </nav>
                    <div class="mb-3"></div>
                    <div class="row">
                        <div class="col-3">
                            <div class="sidebar">
                                <div class="h3 text-muted">Modules</div>
                                <div class="list-group">
                                    <a href="<c:url value="/pets"/>" class="list-group-item list-group-item-action active">Pets</a>
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
                                    <a href="<c:url value="/users"/>" class="list-group-item list-group-item-action">Users</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-9">
                            <header class="table-header">
                                <div class="row">
                                    <div class="col">
                                        <img class="table-header-icon" src="<c:url value="/image/pet.png"/>" alt="pet"/>
                                        <h3 class="table-header-title">
                                            PETS
                                        </h3>
                                    </div>
                                    <div class="col-auto">
                                        <a class="btn btn-primary" href="<c:url value="/pets/register"/>">
                                            <i class="fa fa-plus"></i>
                                            Register pet
                                        </a>
                                    </div>
                                </div>
                            </header>
                            <form id="table-options" name="table-options" class="table-options" method="get"
                                  autocomplete="off" novalidate>
                                <div class="table-toolbar">
                                    <div class="form-row">
                                        <div class="col-3">
                                            <label for="id">ID</label>
                                            <input id="id" name="id" class="form-control form-control-sm cleanable"
                                                   type="text" value="${petSearchParams.id}">
                                        </div>
                                        <div class="col-3">
                                            <label for="name">Name</label>
                                            <input id="name" name="name" class="form-control form-control-sm cleanable"
                                                   type="text" value="${petSearchParams.name}"/>
                                        </div>
                                        <div class="col-3">
                                            <label for="age">Age</label>
                                            <input id="age" name="age" class="form-control form-control-sm cleanable"
                                                   type="text" value="${petSearchParams.age}"/>
                                        </div>
                                        <div class="col-3 d-flex align-items-end">
                                            <button class="btn align-bottom btn-block btn-sm btn-info">
                                                <i class="fa fa-search"></i>
                                                Search
                                            </button>
                                        </div>
                                    </div>
                                </div>
                                <div class="table-toolbar">
                                    <div class="form-row">
                                        <div class="col-3">
                                            <label for="sort">
                                                Order by
                                            </label>
                                            <select id="sort" name="sort" class="form-control form-control-sm cleanable">
                                                <option
                                                        value="id"
                                                        <c:if test="${sort.equals('id')}">selected</c:if>>
                                                    ID
                                                </option>
                                                <option value="name"
                                                        <c:if test="${sort.equals('name')}">selected</c:if>>
                                                    Name
                                                </option>
                                                <option value="age"
                                                        <c:if test="${sort.equals('age')}">selected</c:if>>
                                                    Age
                                                </option>
                                            </select>
                                        </div>
                                        <div class="col-3">
                                            <label for="direction">
                                                Direction
                                            </label>
                                            <select id="direction" name="direction" class="form-control form-control-sm cleanable">
                                                <option value="ASC"
                                                        <c:if test="${direction.toString().equals('ASC')}">selected</c:if>>
                                                    ASC
                                                </option>
                                                <option value="DESC"
                                                        <c:if test="${direction.toString().equals('DESC')}">selected</c:if>>
                                                    DESC
                                                </option>
                                            </select>
                                        </div>
                                        <div class="col-3">
                                        </div>
                                        <div class="col-3 d-flex align-items-end">
                                            <button class="btn btn-block btn-sm btn-outline-secondary btn-clean"
                                                    type="button" data-target="#table-options">
                                                <i class="fa fa-broom"></i>
                                                Clean fields
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </form>
                            <table class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th scope="col">ID</th>
                                        <th scope="col">Name</th>
                                        <th scope="col">Age</th>
                                        <th scope="col">Image</th>
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
                                                    <td>${pet.age}</td>
                                                    <td>
                                                        <img class="img-thumbnail" src="${pet.image.src}" alt="${pet.image.name}" width="120"/>
                                                    </td>
                                                    <td>${pet.availableAdoption ? "Yes" : "No"}</td>
                                                    <td>
                                                        <div class="dropdown">
                                                            <button id="dropdownMenuPet${pet.id}" class="btn btn-block btn-outline-primary"
                                                                    type="button" data-toggle="dropdown">
                                                                <i class="fa fa-cog"></i>
                                                                Options
                                                            </button>
                                                            <div class="dropdown-menu" aria-labelledby="dropdownMenuPet${pet.id}">
                                                                <a class="dropdown-item" href="<c:url value="/pets/${pet.id}"/>">
                                                                    <div class="icon-dd-container">
                                                                        <i class="text-primary fa fa-info-circle"></i>
                                                                    </div>
                                                                    Details
                                                                </a>
                                                                <a class="dropdown-item" href="<c:url value="/pets/${pet.id}/edit"/>">
                                                                    <div class="icon-dd-container">
                                                                        <i class="text-success fa fa-pen"></i>
                                                                    </div>
                                                                    Edit
                                                                </a>
                                                                <div class="dropdown-divider"></div>
                                                                <a class="dropdown-item" href="<c:url value="/pets/${pet.id}/delete"/>">
                                                                    <div class="icon-dd-container">
                                                                        <i class="text-danger fa fa-trash-alt"></i>
                                                                    </div>
                                                                    Delete
                                                                </a>
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
                                    <tr class="text-secondary">
                                        <td colspan="6">
                                            <div class="row">
                                                <div class="col">
                                                    Page ${petPage.number + 1} of ${petPage.totalPages}
                                                </div>
                                                <div class="col-auto">
                                                    Rows: ${petPage.numberOfElements}
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                            <nav class="d-flex justify-content-center" aria-label="pagination">
                                <ul class="pagination">
                                    <c:forEach var="i" begin="${beginPage}" end="${endPage}">
                                        <c:url var="paginationUri"
                                               value="/pets?id=${petSearchParams.id}&name=${petSearchParams.name}&age=${petSearchParams.age}&sort=${sort}&direction=${direction}&page=${i}"/>
                                        <c:if test="${i == beginPage}">
                                            <c:set var="existsPreviousPage" value="${beginPage - 1 > -1}"/>
                                            <li class="page-item <c:if test="${!existsPreviousPage}">disabled</c:if>">
                                                <c:choose>
                                                    <c:when test="${existsPreviousPage}">
                                                        <a class="page-link" href="${paginationUri}">
                                                            Previous
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="page-link">Previous</div>
                                                    </c:otherwise>
                                                </c:choose>
                                            </li>
                                        </c:if>
                                        <li class="page-item <c:if test="${i == petPage.number}">active</c:if>">
                                            <a class="page-link" href="${paginationUri}">${i + 1}</a>
                                        </li>
                                        <c:if test="${i == endPage}">
                                            <c:set var="existsNextPage" value="${endPage + 1 < petPage.number}"/>
                                            <li class="page-item <c:if test="${!existsNextPage}">disabled</c:if>">
                                                <c:choose>
                                                    <c:when test="${existsNextPage}">
                                                        <a class="page-link" href="${paginationUri}">
                                                            Next
                                                        </a>
                                                    </c:when>
                                                    <c:otherwise>
                                                        <div class="page-link">Next</div>
                                                    </c:otherwise>
                                                </c:choose>
                                            </li>
                                        </c:if>
                                    </c:forEach>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </main>
            </div>
            <div class="root-footer">
                <%@ include file="/WEB-INF/views/shared/footer.jsp" %>
            </div>
        </div>
        <script type="application/javascript" src="<c:url value="/js/jquery.min.js"/>"></script>
        <script type="application/javascript" src="<c:url value="/js/bootstrap.bundle.min.js"/>"></script>
        <script type="application/javascript" src="<c:url value="/js/index.js"/>"></script>
    </body>
</html>
