<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
        <title>Dosages Register | Adopt Me</title>
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
                                <a href="<c:url value="/areas-animals"/>" class="list-group-item list-group-item-action">Areas
                                    animals</a>
                                <a href="<c:url value="/medical-records"/>" class="list-group-item list-group-item-action">Medical
                                    records</a>
                                <a href="<c:url value="/dosages"/>" class="list-group-item list-group-item-action active">Dosages</a>
                                <a href="<c:url value="/vaccines"/>" class="list-group-item list-group-item-action">Vaccines</a>
                                <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action">Owners</a>
                                <a href="<c:url value="/adoptions"/>" class="list-group-item list-group-item-action">Adoptions</a>
                                <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-9">
                        <header>
                            <div class="row">
                                <div class="col">
                                    <h3>${medicalRecord.pet.name}'s dosages</h3>
                                </div>
                                <div class="col-auto">
                                    <a class="btn btn-outline-secondary" href="<c:url value="/dosages"/>">Go back</a>
                                </div>
                            </div>
                        </header>
                        <div class="row">
                            <div class="col-8">
                                <div style="margin-bottom: .5rem">Dosages</div>
                                <div class="table-container">
                                    <table class="table table-bordered">
                                        <thead>
                                            <tr>
                                                <th scope="col">Vaccine</th>
                                                <th scope="col">Method</th>
                                                <th scope="col">Quantity</th>
                                                <th class="text-nowrap" scope="col">Dosage date</th>
                                            </tr>
                                        </thead>
                                        <c:choose>
                                            <c:when test="${mrDosages.size() + dosagesCart.size() > 0}">
                                                <c:forEach var="mrDosage" items="${mrDosages}">
                                                    <tr>
                                                        <td class="text-nowrap">${mrDosage.vaccine.name}</td>
                                                        <td>${mrDosage.method}</td>
                                                        <td>${mrDosage.quantity}</td>
                                                        <td>${mrDosage.dosageDate}</td>
                                                    </tr>
                                                </c:forEach>
                                                <c:forEach var="dosageCart" items="${dosagesCart}">
                                                    <tr class="table-secondary">
                                                        <td class="text-nowrap">${dosageCart.vaccine.name}</td>
                                                        <td>${dosageCart.method}</td>
                                                        <td>${dosageCart.quantity}</td>
                                                        <td>${dosageCart.dosageDate}</td>
                                                    </tr>
                                                </c:forEach>
                                            </c:when>
                                            <c:otherwise>
                                                <tr>
                                                    <td colspan="4">
                                                        Empty table
                                                    </td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                    </table>
                                </div>
                            </div>
                            <div class="col-4">
                                <c:set var="addDosageUri">
                                    <c:url value="/dosages/add-dosage"/>
                                </c:set>
                                <form:form modelAttribute="dosage"
                                           action="${addDosageUri}"
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
                                        <button class="btn btn-block btn-info" type="submit">Add dosage</button>
                                    </div>
                                </form:form>
                                <form action="<c:url value="/dosages/${medicalRecord.id}/register"/>" method="post">
                                    <div class="form-group">
                                        <button class="btn btn-block btn-primary" type="submit">Save changes</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
        <script type="application/javascript" src="<c:url value="/js/index.js"/>"></script>
    </body>
</html>