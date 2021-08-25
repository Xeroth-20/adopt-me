<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
        <title>Medical Record Dosages | Adopt Me</title>
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
                                <a href="<c:url value="/medical-records"/>" class="list-group-item list-group-item-action active">Medical
                                    records</a>
                                <a href="<c:url value="/vaccines"/>" class="list-group-item list-group-item-action">Vaccines</a>
                                <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action">Owners</a>
                                <a href="<c:url value="/adoptions"/>" class="list-group-item list-group-item-action">Adoptions</a>
                                <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-9">
                        <h3>${medicalRecord.pet.name}'s Medical Record</h3>
                        <div class="row">
                            <div class="col-8">
                                <div style="margin-bottom: .5rem">Dosages</div>
                                <table class="table">
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
                                <c:set var="dosageRegisterUri">
                                    <c:url value="/dosages/register"/>
                                </c:set>
                                <form:form modelAttribute="dosage"
                                           action="${dosageRegisterUri}"
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
                                        <button class="btn btn-block btn-primary" type="submit">Register dosage</button>
                                    </div>
                                </form:form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
        <script type="application/javascript" src="<c:url value="/js/index.js"/>"></script>
    </body>
</html>