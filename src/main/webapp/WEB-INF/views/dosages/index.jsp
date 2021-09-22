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
        <title>Dosages | Adopt me</title>
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
                                Dosages
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
                                    <a href="<c:url value="/dosages"/>" class="list-group-item list-group-item-action active">Dosages</a>
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
                                <h3 class="table-header-title">Dosages</h3>
                            </header>
                            <div class="table-container">
                                <table class="table table-bordered table-striped">
                                    <thead>
                                        <tr>
                                            <th scope="col">MR ID</th>
                                            <th scope="col">Pet</th>
                                            <th scope="col">Vaccine</th>
                                            <th scope="col">Method</th>
                                            <th scope="col">Quantity</th>
                                            <th class="text-nowrap" scope="col">Dosage date</th>
                                            <th scope="col">Options</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:choose>
                                            <c:when test="${dosages.size() > 0}">
                                                <c:forEach var="dosage" items="${dosages}">
                                                    <tr>
                                                        <td>${dosage.medicalRecord.id}</td>
                                                        <td>${dosage.medicalRecord.pet.name}</td>
                                                        <td class="text-nowrap">${dosage.vaccine.name}</td>
                                                        <td>${dosage.method}</td>
                                                        <td>${dosage.quantity}</td>
                                                        <td>${dosage.dosageDate}</td>
                                                        <td>
                                                            <div class="form-row flex-nowrap">
                                                                <div class="col-auto">
                                                                    <a class="btn btn-primary" href="<c:url value="/dosages/${dosage.id.medicalRecordId}"/>">
                                                                        <i class="fa fa-eye"></i>
                                                                    </a>
                                                                </div>
                                                                <div class="col-auto">
                                                                    <a class="btn btn-info" href="<c:url value="/dosages/${dosage.id.medicalRecordId}/register"/>">
                                                                        <i class="fa fa-plus"></i>
                                                                        Vaccine
                                                                    </a>
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
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div class="root-footer">
                <%@ include file="/WEB-INF/views/shared/footer.jsp" %>
            </div>
        </div>
    </body>
</html>
