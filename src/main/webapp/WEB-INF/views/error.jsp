<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"/>
        <title>Error | Adopt me</title>
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
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/pets"/>">Pets</a>
                        </li>
                    </ul>
                </div>
            </nav>
            <main class="container py-5">
                <header class="mb-3">
                    <h1>An error has occurred</h1>
                    <a href="<c:url value="/"/>">Go to home</a>
                </header>
                <div class="overflow-auto">
                    <table class="table table-bordered">
                        <tbody>
                            <tr>
                                <th class="text-nowrap" scope="row">Datetime</th>
                                <td>${timestamp}</td>
                            </tr>
                            <tr>
                                <th class="text-nowrap" scope="row">Error</th>
                                <td>${error}</td>
                            </tr>
                            <tr>
                                <th class="text-nowrap" scope="row">Status code</th>
                                <td>${status}</td>
                            </tr>
                            <tr>
                                <th class="text-nowrap" scope="row">Message</th>
                                <td>${message}</td>
                            </tr>
                            <tr>
                                <th class="text-nowrap" scope="row">Exception</th>
                                <td>${exception}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </main>
        </div>
    </body>
</html>
