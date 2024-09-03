<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Exam Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <h1>Exam Management</h1>
        <a href="${pageContext.request.contextPath}/examens/nouveau" class="btn btn-primary">Ajouter Examen</a>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Annee Universitaire</th>
                    <th>Semestre</th>
                    <th>Session</th>
                    <th>Type Examen</th>
                    <th>Date</th>
                    <th>Heure de Debut</th>
                    <th>Duree Prevue</th>
                    <th>Duree Reelle</th>
                    <th>Coordonnateur</th>
                    <th>Epreuve</th>
                    <th>PV</th>
                    <th>Rapport Textuel</th>
                    <th>Type Element</th>
                    <th>Element Pedagogique</th>
                    <th>Salles et Surveillants</th>
                    <th>Actions</th> <!-- Nouvelle colonne pour les actions -->
                </tr>
            </thead>
            <tbody>
                <c:forEach var="examen" items="${examens}">
                    <tr>
                        <td>${examen.id}</td>
                        <td>${examen.anneeUniversitaire}</td>
                        <td>${examen.semestre.libelle}</td>
                        <td>${examen.session.libelle}</td>
                        <td>${examen.type.libelle}</td>
                        <td>${examen.date}</td>
                        <td>${examen.heureDebut}</td>
                        <td>${examen.dureePrevue}</td>
                        <td>${examen.dureeReelle}</td>
                        <td>${examen.coordonnateur}</td>
                        <td>${examen.epreuve}</td>
                        <td>${examen.pv}</td>
                        <td>${examen.rapportTextuel}</td>
                        <td>${examen.elementPedagogique.typeElement.titre}</td>
                        <td>${examen.elementPedagogique.titre}</td>

                        <td>
                            <c:forEach var="salleSurveillant" items="${examen.salleSurveillants}">
                                <div>Salle: ${salleSurveillant.salle.nom}, Surveillants: ${salleSurveillant.nombreSurveillants}</div>
                            </c:forEach>
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath}/examens/${examen.id}/modifier" class="btn btn-warning btn-sm">Modifier</a>
                            <a href="${pageContext.request.contextPath}/examens/supprimer/${examen.id}" class="btn btn-danger btn-sm" onclick="return confirm('Êtes-vous sûr de vouloir supprimer cet examen ?');">Supprimer</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>