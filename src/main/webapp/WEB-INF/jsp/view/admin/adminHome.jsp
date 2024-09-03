<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<style>
    body {
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 0;
        background-image: url('<c:url value="/resources/img/ensahnight.jpg" />');
        background-size: cover;
        background-position: center;
        height: 100vh;
    }

    .container {

        padding: 20px;

    }

    .admin-content {
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        height: calc(100vh - 80px);
        color: white;
    }

    .admin-content h3 {
        margin-bottom: 10px;
        font-size: 24px;
    }

    .admin-content p {
        margin-bottom: 20px;
        font-size: 18px;
    }
</style>

<jsp:include page="../fragments/adminHeader.jsp" />

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <jsp:include page="../fragments/menu.jsp" />
        </div>
    </nav>

    <section class="main">
        <div class="admin-content">
            <h3>Administration home page</h3>
            <p>Hello and welcome to your application</p>

            <s:authorize access="isAuthenticated()">
                You are connected with:
                <s:authentication property="principal.username" />
            </s:authorize>
        </div>
    </section>

    <div id="search-results"></div>

</div>

<jsp:include page="../fragments/adminfooter.jsp" />