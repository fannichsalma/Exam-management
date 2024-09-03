<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/adminHeader.jsp" />

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <jsp:include page="../fragments/menu.jsp" />
        </div>
    </nav>

    <h3>List of Groups</h3>
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nom du groupe</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${groups}" var="group">
                <tr>
                    <td>${group.idGroupe}</td>
                    <td>${group.nomGroupe}</td>
                    <td>${group.typeGroupe}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/admin/viewGroup/${group.idGroupe}" class="btn btn-info">View</a>
                        <a href="${pageContext.request.contextPath}/admin/editGroup/${group.idGroupe}" class="btn btn-warning">Edit</a>
                        <a href="${pageContext.request.contextPath}/admin/deleteGroup/${group.idGroupe}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this group?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

<jsp:include page="../fragments/adminfooter.jsp" />
