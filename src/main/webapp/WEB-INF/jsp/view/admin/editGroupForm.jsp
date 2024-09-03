<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>

<jsp:include page="../fragments/adminHeader.jsp" />

<div class="container">

    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <jsp:include page="../fragments/menu.jsp" />
        </div>
    </nav>

    <h2>Edit Group</h2>
    <form:form action="${pageContext.request.contextPath}/admin/editGroup" method="post" modelAttribute="groupForm">
        <form:hidden path="idGroupe" />
        <div class="form-group">
            <label for="nomGroupe">Nom du groupe :</label>
            <form:input path="nomGroupe" class="form-control" id="nomGroupe" />
        </div>
        <div class="form-group">
            <label for="typeGroupe">Type de groupe :</label>
            <form:radiobutton path="typeGroupe" value="Filiere" /> Filiere
            <form:radiobutton path="typeGroupe" value="Departement" /> Departement
        </div>

        <c:choose>
            <c:when test="${groupForm.typeGroupe == 'Filiere'}">
                <div class="form-group" id="filiere-container">
                    <label for="filiere">Filière :</label>
                    <form:select path="filiereId" class="form-control" id="filiere">
                        <form:option value="0">Selectionnez une filiere</form:option>
                        <c:forEach items="${filieres}" var="filiere">
                            <form:option value="${filiere.idFiliere}">${filiere.nomFiliere}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </c:when>
            <c:when test="${groupForm.typeGroupe == 'Departement'}">
                <div class="form-group" id="departement-container">
                    <label for="departement">Département :</label>
                    <form:select path="departementId" id="departement" class="form-control">
                        <form:option value="0">Sélectionnez un département</form:option>
                        <c:forEach items="${departements}" var="departement">
                            <form:option value="${departement.idDepartement}">${departement.nomDepartement}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </c:when>
        </c:choose>

        <div id="enseignants-container">
            <c:forEach items="${allEnseignants}" var="enseignant">
                <div class="form-check">
                    <form:checkbox path="enseignantsIds" value="${enseignant.idPersonne}" class="form-check-input" />
                    <label class="form-check-label" for="enseignant-${enseignant.idPersonne}">
                        ${enseignant.nom} ${enseignant.prenom} (ID: ${enseignant.idPersonne})
                    </label>
                </div>
            </c:forEach>
        </div>
        <button type="submit" class="btn btn-primary">Update Group</button>
    </form:form>

</div>

<jsp:include page="../fragments/adminfooter.jsp" />

<script>
    document.addEventListener("DOMContentLoaded", function() {
        var departementField = document.getElementById("departement-container");
        var filiereField = document.getElementById("filiere-container");

        var typeGroupeRadios = document.querySelectorAll("input[name='typeGroupe']");
        typeGroupeRadios.forEach(function(radio) {
            radio.addEventListener("change", function() {
                if (this.value === "Departement") {
                    departementField.style.display = "block";
                    filiereField.style.display = "none";
                } else {
                    departementField.style.display = "none";
                    filiereField.style.display = "block";
                }
            });
        });
    });
</script>