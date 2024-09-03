<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create New Exam</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <script>
            function updateDureePrevue() {
                var typeElementSelect = document.getElementById("typeElementId");
                var dureePrevueInput = document.getElementById("dureePrevue");

                if (typeElementSelect) {
                    var selectedValue = typeElementSelect.options[typeElementSelect.selectedIndex].text;
                    if (selectedValue === "module") {
                        dureePrevueInput.value = 120;
                    } else if (selectedValue === "element de module") {
                        dureePrevueInput.value = 80;
                    }
                }
            }

            function limitCheckboxes() {
                var nombreSurveillants = parseInt(document.getElementById("nombreSurveillants").value, 10);
                var checkboxes = document.querySelectorAll('input[name="enseignantsIds"]');
                var max = nombreSurveillants ; // Limite = nombre de surveillants
                var checkedCount = 0;

                checkboxes.forEach(function(checkbox) {
                    if (checkbox.checked) {
                        checkedCount++;
                    }
                });

                checkboxes.forEach(function(checkbox) {
                    if (checkedCount >= max) {
                        if (!checkbox.checked) {
                            checkbox.disabled = true;
                        }
                    } else {
                        checkbox.disabled = false;
                    }
                });
            }

            window.onload = function() {
                var typeElementSelect = document.getElementById("typeElementId");
                if (typeElementSelect) {
                    typeElementSelect.addEventListener("change", updateDureePrevue);
                    updateDureePrevue();
                }

                var nombreSurveillantsInput = document.getElementById("nombreSurveillants");
                if (nombreSurveillantsInput) {
                    nombreSurveillantsInput.addEventListener("change", limitCheckboxes);
                    limitCheckboxes(); // Initial call to set limits based on default value
                }

                var checkboxes = document.querySelectorAll('input[name="enseignantsIds"]');
                checkboxes.forEach(function(checkbox) {
                    checkbox.addEventListener('change', limitCheckboxes);
                });
            }

               // Récupérer la date système
                 const currentDate = new Date();

                 // Déterminer le semestre en fonction de la date
                 let semestreId;
                 const currentMonth = currentDate.getMonth();

                 if (currentMonth >= 0 && currentMonth <= 2) {
                   // Semestre d'hiver (janvier à mars)
                   semestreId = 1;
                 } else if (currentMonth >= 3 && currentMonth <= 5) {
                   // Semestre de printemps (avril à juin)
                   semestreId = 2;
                 } else if (currentMonth >= 6 && currentMonth <= 8) {
                   // Semestre d'été (juillet à août)
                   semestreId = 3;
                 } else if (currentMonth >= 9 && currentMonth <= 11) {
                   // Semestre d'automne (septembre à décembre)
                   semestreId = 4;
                 }

                 // Définir la valeur par défaut du champ "Semestre"
                 document.addEventListener('DOMContentLoaded', (event) => {
                   document.getElementById("semestre").value = semestreId;
                 });

               function updateCoordonnateur() {
                          var elementPedagogiqueId = document.getElementById("elementPedagogiqueId").value;
                          if (elementPedagogiqueId) {
                              fetch('${pageContext.request.contextPath}/examens/elementPedagogique/' + elementPedagogiqueId)
                                  .then(response => response.text())
                                  .then(data => {
                                      document.getElementById("coordonnateur").value = data;
                                  });
                          }
                      }

                      document.addEventListener('DOMContentLoaded', function () {
                          document.getElementById("elementPedagogiqueId").addEventListener("change", updateCoordonnateur);
                      });

        </script>

</head>
<body>
    <div class="container">
        <h1>Create New Exam</h1>
        <form:form modelAttribute="examenForm" method="post" action="${pageContext.request.contextPath}/examens/nouveau">
            <div class="form-group">
                <label for="anneeUniversitaire">Annee Universitaire:</label>
                <form:input path="anneeUniversitaire" id="anneeUniversitaire" class="form-control" required="true" value="2024" />
                <form:errors path="anneeUniversitaire" cssClass="text-danger" />
            </div>
          <div class="form-group">
              <label for="semestre">Semestre:</label>
              <form:select path="semestreId" id="semestre" class="form-control">
                  <option value="1">hiver</option>
                  <option value="2">printemps</option>
                  <option value="3">ete</option>
                  <option value="4">automne</option>
              </form:select>
              <form:errors path="semestreId" cssClass="text-danger" />
          </div>
            <div class="form-group">
                <label for="session">Session:</label>
                <form:select path="sessionId" id="session" class="form-control">
                    <form:options items="${sessions}" itemValue="id" itemLabel="libelle"/>
                </form:select>
            </div>
            <div class="form-group">
                <label for="date">Date:</label>
                <form:input path="date" id="date" type="date" class="form-control" required="true" />
                <form:errors path="date" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="heureDebut">Heure de Debut:</label>
                <form:input path="heureDebut" id="heureDebut" type="time" class="form-control" required="true" />
                <form:errors path="heureDebut" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="typeElementId">Type d'Element:</label>
                <form:select path="typeElementId" id="typeElementId" class="form-control">
                    <form:options items="${typesElements}" itemValue="id" itemLabel="titre"/>
                </form:select>
                <form:errors path="typeElementId" cssClass="text-danger" />
            </div>
            <div class="form-group">
                <label for="dureePrevue">Duree Prevue (minutes) :</label>
                <form:input path="dureePrevue" id="dureePrevue" type="number" class="form-control" required="true" value="120" />
                <form:errors path="dureePrevue" cssClass="text-danger" />
            </div>
              <div class="form-group">
                            <label for="elementPedagogiqueId">Element Pedagogique:</label>
                            <form:select path="elementPedagogiqueId" id="elementPedagogiqueId" class="form-control">
                                <form:options items="${elementsPedagogiques}" itemValue="id" itemLabel="titre"/>
                            </form:select>
                            <form:errors path="elementPedagogiqueId" cssClass="text-danger" />
                        </div>
                        <div class="form-group">
                            <label for="coordonnateur">Coordonnateur:</label>
                            <form:input path="coordonnateur" id="coordonnateur" class="form-control" />
                            <form:errors path="coordonnateur" cssClass="text-danger" />
                        </div>

            <div class="form-group">
                <label for="typeExamen">Type d'Examen:</label>
                <form:select path="typeExamenId" id="typeExamen" class="form-control">
                    <form:options items="${typesExamens}" itemValue="id" itemLabel="libelle"/>
                </form:select>
                <form:errors path="typeExamenId" cssClass="text-danger" />
            </div>

            <!-- Gestion des salles et surveillants -->
                        <div id="salle-surveillants">
                            <h3>Salles et Surveillants</h3>
                            <div class="form-group">
                                <label>Salle:</label>
                                <c:forEach var="salle" items="${salles}">
                                    <div class="form-check">
                                        <input type="radio" class="form-check-input" name="salleId" id="salle${salle.id}" value="${salle.id}" required>
                                        <label class="form-check-label" for="salle${salle.id}">${salle.nom}</label>
                                    </div>
                                </c:forEach>
                            </div>
                            <div class="form-group">
                                <label for="nombreSurveillants">Nombre de Surveillants:</label>
                                <input type="number" name="nombreSurveillants" id="nombreSurveillants" value="2" min="2" max="5" class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group">
                            <label for="enseignants">Enseignants :</label>
                            <c:forEach items="${enseignants}" var="enseignant">
                                <div class="form-check">
                                    <form:checkbox path="enseignantsIds" value="${enseignant.idPersonne}" class="form-check-input" />
                                    <label class="form-check-label" for="enseignant-${enseignant.idPersonne}">
                                        ${enseignant.nom} ${enseignant.prenom} (ID: ${enseignant.idPersonne})
                                    </label>
                                </div>
                            </c:forEach>
                        </div>

            <button type="submit" class="btn btn-primary">Enregistrer</button>
        </form:form>
    </div>
</body>
</html>
