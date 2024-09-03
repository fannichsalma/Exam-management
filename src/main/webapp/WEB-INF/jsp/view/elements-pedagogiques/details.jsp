<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Détails de l'Élément Pédagogique</title>
</head>
<body>
    <h1>Détails de l'Élément Pédagogique</h1>
    <p>Titre : ${elementPedagogique.titre}</p>
    <p>Niveau : ${elementPedagogique.niveau.titre}</p>
    <p>Coordonnateur : ${elementPedagogique.coordonnateur.nom} ${elementPedagogique.coordonnateur.prenom}</p>
    <p>Type : ${elementPedagogique.typeElement.titre}</p>
    <a href="${pageContext.request.contextPath}/elements-pedagogiques/${elementPedagogique.id}/modifier">Modifier</a>
    <a href="${pageContext.request.contextPath}/elements-pedagogiques/${elementPedagogique.id}/supprimer">Supprimer</a>
    <a href="${pageContext.request.contextPath}/elements-pedagogiques">Retour à la liste</a>
</body>
</html>
