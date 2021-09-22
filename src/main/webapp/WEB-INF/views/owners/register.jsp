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
        <title>Register Owner | Adopt Me</title>
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
                                <a href="<c:url value="/owners"/>">Owners</a>
                            </li>
                            <li class="breadcrumb-item active">
                                Register
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
                                    <a href="<c:url value="/owners"/>" class="list-group-item list-group-item-action active">Owners</a>
                                    <a href="<c:url value="/adoptions"/>" class="list-group-item list-group-item-action">Adoptions</a>
                                    <a href="<c:url value="/images"/>" class="list-group-item list-group-item-action">Images</a>
                                    <a href="<c:url value="/users"/>" class="list-group-item list-group-item-action">Users</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-9">
                            <h3>Register owner</h3>
                            <form:form modelAttribute="owner" method="post">
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
                                            <button class="btn btn-block btn-primary px-5" type="submit">
                                                <i class="fa fa-plus"></i>
                                                Register
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
            <div class="root-footer">
                <%@ include file="/WEB-INF/views/shared/footer.jsp" %>
            </div>
        </div>
    </body>
</html>
