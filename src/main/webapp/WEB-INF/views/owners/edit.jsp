<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.min.css"/>"/>
        <link rel="stylesheet" type="text/css" href="<c:url value="/css/styles.css"/>"/>
        <title>Edit Owner | Adopt Me</title>
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
                                <a href="<c:url value="/dosages"/>" class="list-group-item list-group-item-action">Dosages</a>
                                <a href="<c:url value="/vaccines"/>" class="list-group-item list-group-item-action">Vaccines</a>
                                <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action active">Owners</a>
                                <a href="<c:url value="/adoptions"/>" class="list-group-item list-group-item-action">Adoptions</a>
                                <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                            </div>
                        </div>
                    </div>
                    <div class="col-9">
                        <h3>Edit owner</h3>
                        <form:form modelAttribute="owner" method="post">
                            <div class="form-group d-none">
                                <form:label path="id">ID</form:label>
                                <form:input path="id" readonly="true"/>
                            </div>
                            <div class="form-group border rounded p-3">
                                <div class="form-row">
                                    <div class="col-4">
                                        <form:label path="firstname">
                                            Firstname
                                        </form:label>
                                        <form:input path="firstname" cssClass="form-control"/>
                                    </div>
                                    <div class="col-4">
                                        <form:label path="lastname">
                                            Lastname
                                        </form:label>
                                        <form:input path="lastname" cssClass="form-control"/>
                                    </div>
                                    <div class="col-4">
                                        <form:label path="age">
                                            Age
                                        </form:label>
                                        <form:input path="age" cssClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group border rounded p-3">
                                <div class="form-row">
                                    <div class="col-4">
                                        <form:label path="email">
                                            Email
                                        </form:label>
                                        <form:input path="email" cssClass="form-control"/>
                                    </div>
                                    <div class="col-4">
                                        <form:label path="phone">
                                            Phone
                                        </form:label>
                                        <form:input path="phone" cssClass="form-control"/>
                                    </div>
                                    <div class="col-4">
                                        <form:label path="address">
                                            Address
                                        </form:label>
                                        <form:input path="address" cssClass="form-control"/>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-auto">
                                        <button class="btn btn-block btn-primary px-5" type="submit">Save changes
                                        </button>
                                    </div>
                                    <div class="col-auto">
                                        <a class="btn btn-block btn-outline-info" href="<c:url value="/owners"/>">
                                            Go back
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </form:form>
                    </div>
                </div>
            </main>
        </div>
    </body>
</html>
