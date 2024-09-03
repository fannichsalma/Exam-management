<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<title>Application</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">


</head>
<body>
	<div class="container">

<br />

		<div>
			<h3> Spring Web Java Application </h3>
			<p>Application de Gestion des Examens    </p>


		</div>
		<div>


		<p>Login Here
		<a href="${pageContext.request.contextPath}/showMyLoginPage"> by clicking here </a>  </p>


		</div>


	</div>
</body>
</html>