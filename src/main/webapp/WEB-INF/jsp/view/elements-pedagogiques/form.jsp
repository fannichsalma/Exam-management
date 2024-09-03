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
            <form:options items="${enseignants}" itemValue="id" itemLabel="nomPrenom"/>
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
