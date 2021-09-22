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
        <title>Change Password | Adopt Me</title>
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
                                Change password
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
                            <div class="row">
                                <div class="col-12 col-sm-10 col-md-8 col-lg-6 col-xl-5">
                                    <h3>Change password</h3>
                                    <form:form modelAttribute="user" method="post">
                                        <div class="form-group d-none">
                                            <form:label path="id">
                                                ID
                                            </form:label>
                                            <form:input path="id" cssClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group d-none">
                                            <form:label path="active">
                                                Active
                                            </form:label>
                                            <form:input path="active" cssClass="form-control" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="username">
                                                Username
                                            </form:label>
                                            <form:input path="username" cssClass="form-control disabled" readonly="true"/>
                                        </div>
                                        <div class="form-group">
                                            <form:label path="password">
                                                New password
                                            </form:label>
                                            <form:input path="password" cssClass="form-control" type="password"/>
                                            <form:errors path="password" cssClass="text-danger"/>
                                        </div>
                                        <div class="form-group">
                                            <label for="confirmPassword">
                                                Confirm password
                                            </label>
                                            <input id="confirmPassword" name="confirmPassword" class="form-control" type="password"/>
                                        </div>
                                        <div class="form-group">
                                            <div class="form-row">
                                                <div class="col">
                                                    <button class="btn btn-block btn-primary">
                                                        <i class="fa fa-save"></i>
                                                        Save changes
                                                    </button>
                                                </div>
                                                <div class="col-auto">
                                                    <a class="btn btn-outline-info" href="<c:url value="/users"/>">
                                                        Go back
                                                    </a>
                                                </div>
                                            </div>
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
    </body>
</html>
