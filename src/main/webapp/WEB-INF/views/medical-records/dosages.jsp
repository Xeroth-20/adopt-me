<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/fontawesome.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
        <title>Medical Record Dosages | Adopt Me</title>
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
                                <a href="<c:url value="/medical-records"/>">Medical records</a>
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
                                    <a href="<c:url value="/medical-records"/>" class="list-group-item list-group-item-action active">Medical
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
                            <h3>${medicalRecord.pet.name}'s medical record</h3>
                            <div class="row">
                                <div class="col-8">
                                    <div style="margin-bottom: .5rem">Dosages</div>
                                    <table class="table table-bordered table-striped">
                                        <thead>
                                            <tr>
                                                <th scope="col">Vaccine</th>
                                                <th scope="col">Method</th>
                                                <th scope="col">Quantity</th>
                                                <th scope="col">Options</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:choose>
                                                <c:when test="${medicalRecord.dosages.size() > 0}">
                                                    <c:forEach var="dosage" items="${medicalRecord.dosages}">
                                                        <tr>
                                                            <td>${dosage.vaccine.name}</td>
                                                            <td>${dosage.method}</td>
                                                            <td>${dosage.quantity}</td>
                                                            <td>
                                                                <form id="form-delete-dosage" name="form-delete-dosage" class="mb-0"
                                                                      action="<c:url value="/dosages/delete?medicalRecordId=${dosage.id.medicalRecordId}&vaccineId=${dosage.id.vaccineId}"/>"
                                                                      method="post">
                                                                    <button class="btn btn-confirm btn-outline-danger" type="submit">
                                                                        <i class="fa fa-trash-alt"></i>
                                                                        Delete
                                                                    </button>
                                                                </form>
                                                            </td>
                                                        </tr>
                                                    </c:forEach>
                                                </c:when>
                                                <c:otherwise>
                                                    <tr>
                                                        <td colspan="4">Empty table</td>
                                                    </tr>
                                                </c:otherwise>
                                            </c:choose>
                                        </tbody>
                                    </table>
                                </div>
                                <div class="col-4">
                                    <c:set var="dosagesRegisterUri">
                                        <c:url value="/dosages/register"/>
                                    </c:set>
                                    <form:form modelAttribute="dosage"
                                               action="${dosagesRegisterUri}"
                                               method="post">
                                        <div class="form-group d-none">
                                            <form:label path="medicalRecord.id">Medical record</form:label>
                                            <form:input path="medicalRecord.id" class="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="vaccine.id">Vaccine</form:label>
                                            <form:select path="vaccine.id" cssClass="form-control">
                                                <form:option value="" label="--Select a vaccine--"/>
                                                <form:options items="${vaccines}" itemValue="id" itemLabel="name"/>
                                            </form:select>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="method">Method</form:label>
                                            <form:input path="method" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="quantity">Quantity</form:label>
                                            <form:input path="quantity" class="form-control"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="dosageDate">Dosage date</form:label>
                                            <form:input path="dosageDate" class="form-control" type="date"/>
                                        </div>
                                        <div class="form-group">
                                            <button class="btn btn-block btn-primary" type="submit">
                                                <i class="fa fa-plus"></i>
                                                Register dosage
                                            </button>
                                        </div>
                                    </form:form>
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