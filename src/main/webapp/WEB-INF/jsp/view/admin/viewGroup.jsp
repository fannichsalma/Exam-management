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

    <h3>Groupe: ${group.nomGroupe}</h3>
    <h4>Type: ${group.typeGroupe}</h4>
    <h4>Filière: ${group.filiere.nomFiliere}</h4>
    <h4>Département: ${group.departement.nomDepartement}</h4>
    <h4>Enseignants:</h4>
    <ul>
        <c:forEach items="${enseignants}" var="enseignant">
            <li>${enseignant.nom} ${enseignant.prenom} (ID: ${enseignant.idPersonne})</li>
        </c:forEach>
    </ul>

</div>

<jsp:include page="../fragments/adminfooter.jsp" />
