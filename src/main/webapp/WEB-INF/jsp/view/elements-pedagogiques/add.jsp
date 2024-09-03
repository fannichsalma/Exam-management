<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Élément Pédagogique</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Ajouter un Élément Pédagogique</h1>


        <form:form modelAttribute="elementPedagogiqueForm" method="post" action="${pageContext.request.contextPath}/elements-pedagogiques/nouveau">
            <div class="form-group">
                <label for="titre">Titre :</label>
                <form:input path="titre" id="titre" class="form-control" required="true" />
            </div>

            <div class="form-group">
                <label for="niveauId">Niveau :</label>
                <form:select path="niveauId" id="niveauId" class="form-control" required="true">
                    <form:options items="${niveaux}" itemValue="id" itemLabel="titre"/>
                </form:select>
            </div>

            <div class="form-group">
                <label for="coordonnateurId">Coordonnateur :</label>
               <form:select path="coordonnateurId" id="coordonnateurId" class="form-control" required="true">
                   <form:options items="${enseignants}" itemValue="idPersonne" itemLabel="nomPrenom"/>
               </form:select>

            </div>

            <div class="form-group">
                <label for="typeElementId">Type :</label>
                <form:select path="typeElementId" id="typeElementId" class="form-control" required="true">
                    <form:options items="${typesElements}" itemValue="id" itemLabel="titre"/>
                </form:select>
            </div>

            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form:form>
    </div>
</body>
</html>
