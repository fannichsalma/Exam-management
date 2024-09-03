<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Éléments Pédagogiques</title>
</head>
<body>
    <h1>Liste des Éléments Pédagogiques</h1>
    <table>
        <thead>
            <tr>
                <th>Titre</th>
                <th>Niveau</th>
                <th>Coordonnateur</th>
                <th>Type</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${elementsPedagogiques}" var="element">
                <tr>
                    <td>${element.titre}</td>
                    <td>${element.niveau.titre}</td>
                    <td>${element.coordonnateur.nom} ${element.coordonnateur.prenom}</td>
                    <td>${element.typeElement.titre}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/elements-pedagogiques/${element.id}">Détails</a>
                        <a href="${pageContext.request.contextPath}/elements-pedagogiques/${element.id}/modifier">Modifier</a>
                        <a href="${pageContext.request.contextPath}/elements-pedagogiques/${element.id}/supprimer">Supprimer</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="${pageContext.request.contextPath}/elements-pedagogiques/nouveau">Ajouter un élément pédagogique</a>
</body>
</html>
