<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Modify Exam</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Modify Exam</h1>
        <form:form modelAttribute="examen" method="post" action="${pageContext.request.contextPath}/examens/${examen.id}/modifier" enctype="multipart/form-data">
            <!-- Champ caché pour l'ID de l'examen -->
            <form:hidden path="id"/>

            <div class="form-group">
                <label for="rapportTextuel">Rapport Textuel:</label>
                <form:textarea path="rapportTextuel" id="rapportTextuel" class="form-control" rows="5"/>
                <form:errors path="rapportTextuel" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="pv">PV:</label>
                <form:input type="file" path="pv" id="pv" class="form-control"/>
                <form:errors path="pv" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="epreuve">Épreuve:</label>
                <form:input type="file" path="epreuve" id="epreuve" class="form-control"/>
                <form:errors path="epreuve" cssClass="text-danger" />
            </div>

            <button type="submit" class="btn btn-primary">Save</button>
        </form:form>
    </div>
</body>
</html>
