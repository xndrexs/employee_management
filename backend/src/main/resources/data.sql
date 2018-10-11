INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (1, 'German', 'Bachelor', 'Andreas', 'Pöhler', 'Praktikant');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (2, 'German', 'Bachelor', 'Patrick', 'Notar', 'Team-Leiter');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (3, 'German', 'Bachelor', 'Fabian', 'Junkert', 'Napfen');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (4, 'German', 'Bachelor', 'Amelia', 'Wilewska', 'Baby');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (5, 'German', 'Bachelor', 'Constantin', 'Fülle', 'Consti');
INSERT INTO employeedb.employee (id, citizenship, degree, first_name, last_name, position) VALUES (6, 'German', 'Bachelor', 'Nils', 'Nispel', 'Nilsi');

INSERT INTO employeedb.qualification (id, name) VALUES (1, 'Java');
INSERT INTO employeedb.qualification (id, name) VALUES (2, 'Angular');
INSERT INTO employeedb.qualification (id, name) VALUES (3, 'MySQL');
INSERT INTO employeedb.qualification (id, name) VALUES (4, 'Scrum');
INSERT INTO employeedb.qualification (id, name) VALUES (5, 'C#');
INSERT INTO employeedb.qualification (id, name) VALUES (6, 'Swift');

INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 5);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 1);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 2);
INSERT INTO employeedb.employee_qualifications (employee_id, qualifications_id) VALUES (1, 6);

INSERT INTO employeedb.qualification_employees (qualification_id, employees_id) VALUES (1, 1);
INSERT INTO employeedb.qualification_employees (qualification_id, employees_id) VALUES (2, 1);
INSERT INTO employeedb.qualification_employees (qualification_id, employees_id) VALUES (5, 1);
INSERT INTO employeedb.qualification_employees (qualification_id, employees_id) VALUES (6, 1);