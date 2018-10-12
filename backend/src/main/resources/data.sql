INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (1, 'German', 'Bachelor', 'Andreas', 'Pöhler', 'Praktikant');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (2, 'German', 'Bachelor', 'Patrick', 'Notar', 'Team-Leiter');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (3, 'German', 'Bachelor', 'Fabian', 'Junkert', null);
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (4, 'German', 'Bachelor', 'Amelia', 'Wilewska', 'Baby');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (5, 'German', 'Bachelor', 'Constantin', 'Fülle', 'Consti');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (6, 'German', 'Bachelor', 'Nils', 'Nispel', 'Nilsi');

INSERT INTO employeedb.qualification (id, name, img) VALUES (1, 'Java', 'https://www.detim.de/wp-content/uploads/2017/03/JAVA-original-wordmark-162x300.png');
INSERT INTO employeedb.qualification (id, name, img) VALUES (2, 'Angular', 'https://www.detim.de/wp-content/uploads/2017/03/ANGULAR_js-original-284x300.png');
INSERT INTO employeedb.qualification (id, name, img) VALUES (3, 'MySQL', 'https://www.detim.de/wp-content/uploads/2017/03/MYSQL-original-wordmark-300x157.png');
INSERT INTO employeedb.qualification (id, name, img) VALUES (4, 'Scrum', 'https://www.detim.de/wp-content/uploads/2017/03/GIT-original-wordmark-300x127.png');
INSERT INTO employeedb.qualification (id, name, img) VALUES (5, 'C#', 'https://pluralsight.imgix.net/paths/path-icons/csharp-e7b8fcd4ce.png');
INSERT INTO employeedb.qualification (id, name, img) VALUES (6, 'Swift', 'https://developer.apple.com/swift/images/swift-og.png');
INSERT INTO employeedb.qualification (id, name, img) VALUES (7, 'IntellJ', 'https://www.detim.de/wp-content/uploads/2017/03/INTELLIJ.png');
INSERT INTO employeedb.qualification (id, name, img) VALUES (8, 'HTML', 'https://www.detim.de/wp-content/uploads/2017/03/HTML5-original-wordmark-213x300.png');
INSERT INTO employeedb.qualification (id, name, img) VALUES (9, 'CSS', 'https://www.detim.de/wp-content/uploads/2017/03/CSS3-original-wordmark-213x300.png');


INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 5);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 1);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 2);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 6);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 3);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 8);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 7);

INSERT INTO employeedb.qualification_employees (qualification_id, employees_id) VALUES (1, 1);
INSERT INTO employeedb.qualification_employees (qualification_id, employees_id) VALUES (2, 1);
INSERT INTO employeedb.qualification_employees (qualification_id, employees_id) VALUES (5, 1);
INSERT INTO employeedb.qualification_employees (qualification_id, employees_id) VALUES (6, 1);