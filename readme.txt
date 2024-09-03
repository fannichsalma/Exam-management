🎯 Overview
This application is designed to streamline the management of personnel, pedagogical elements, and exam scheduling within an educational institution. It is built using Spring Boot, Spring Security, and Spring Data JPA, following a layered MVC architecture.

📋 Features
Personnel Management
Add, Remove, Update Personnel: Manage staff members identified by their name, surname, and role (administrator/teacher).
Group Management: Create and manage teacher groups based on departments, courses, or arbitrary criteria.
Pedagogical Elements Management
CRUD Operations: Add, remove, and modify pedagogical elements, defined by title, level (CP1, CP2, etc.), coordinator, and type (element/module).
Coordinator Assignment: Automatically assigns the subject teacher as the coordinator, with options to change it to the course or department coordinator.
Exam Scheduling
Comprehensive Exam Management: Plan and manage exams with details like date, start time, duration, and assigned rooms.
Staff and Room Assignment: Automatically assign invigilators and administrative personnel to rooms, with customization options for group-based or random assignment.
Post-Exam Reporting: Record actual exam duration, attach exam files, and generate reports on exam proceedings.
Historical Data Storage: Store and retrieve information from previous exams for reference and planning.
🎨 Design and Icons
The application features a clean and intuitive design with easy navigation and user-friendly interfaces. Icons are used throughout the application to enhance usability and guide users through different functionalities.

🛠️ Technology Stack
Spring Boot: Core framework for building the application.
Spring Security: For authentication and authorization.
Spring Data JPA: For database interactions.
MVC Architecture: Ensuring a clean separation of concerns between the user interface, business logic, and data access layers.
📦 Import and Installation
Create the Database:

Under MariaDB, create the database db_planexam.
Import and Build the Project:

Import the project and execute mvn install and mvn update.
Start the Application:

Verify that the tables are created correctly.
Insert Initial Data:

INSERT INTO role (idRole, nomRole) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_PROF'),
(3, 'ROLE_CADRE_ADMIN'),
(4, 'ROLE_STUDENT');

INSERT INTO personne (idPersonne, cin, email, nom, nomArabe, photo, prenom, prenomArabe, telephone) VALUES
(1, 'R1111', 'boudaa@aaa.fr', 'boudaa', 'aaaAr', '', 'aaa', 'tarikAr', '0600000'),
(2, 'R1121', 'boudaa1@aaa.fr', 'boudaa1', 'aaaAr1', '', 'aaa1', 'tarikAr1', '06100000'),
(3, 'R1123', 'boudaa3@aaa.fr', 'boudaa3', 'aaaAr3', '', 'aaa3', 'tarikAr3', '06300000'),
(4, 'R1124', 'boudaa4@aaa.fr', 'boudaa4', 'aaaAr4', '', 'aaa4', 'tarikAr4', '04400000');

INSERT INTO cadreadministrateur (grade, idCardreAdmin) VALUES
('ING', 1);
INSERT INTO enseignant (specialite, idEnseighant) VALUES
('math', 2);

INSERT INTO etudiant (cne, dateNaissance, idEtudiant) VALUES
('aaaa', NULL, 3);

INSERT INTO compte (idCompte, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, login, password, idUtilisateur, idRole) VALUES
(1, b'1', b'1', b'1', b'1', 'admin', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 1, 1);

INSERT INTO compte (idCompte, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, login, password, idType, idUtilisateur) VALUES
(1, b'1', b'1', b'1', b'1', 'admin', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 1, 1);

INSERT INTO compte (idCompte, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, login, password, idUtilisateur, idRole) VALUES
(2, b'1', b'1', b'1', b'1', 'student', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 4, 4);

INSERT INTO compte (idCompte, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, login, password, idUtilisateur, idRole) VALUES
(3, b'1', b'1', b'1', b'1', 'cadre_admin', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 3, 3);

INSERT INTO compte (idCompte, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled, login, password, idUtilisateur, idRole) VALUES
(4, b'1', b'1', b'1', b'1', 'prof', '{bcrypt}$2a$10$vsjRwUSUi2B/jlw4ATXEN.B2IIcVY8ourImFZnWcW1tLz3G6mLfpe', 2, 2);


5.Restart the Application:

Connect to http://localhost:8080/ using the following accounts:

Admin Account:

Login: admin
Password: admin
Student Account:

Login: student
Password: admin
Cadre Admin Account:

Login: cadre_admin
Password: admin
Professor Account:

Login: prof
Password: admin
