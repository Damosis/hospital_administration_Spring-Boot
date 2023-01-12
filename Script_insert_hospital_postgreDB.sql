DELETE FROM consultation;
DELETE FROM appointment;
DELETE FROM doctor;
DELETE FROM patient;

ALTER SEQUENCE doctor_id_doctor_seq RESTART WITH 1;
ALTER SEQUENCE patient_id_patient_seq RESTART WITH 1;
ALTER SEQUENCE appointment_id_appointment_seq RESTART WITH 1;
ALTER SEQUENCE appointment_id_appointment_seq RESTART WITH 1;

INSERT INTO doctor (firstname, lastname)
VALUES
('doctorFirst1','doctorLast1'),
('doctorFirst2','doctorLast2'),
('doctorFirst3','doctorLast3'),
('doctorFirst4','doctorLast4'),
('doctorFirst5','doctorLast5');

INSERT INTO patient (firstname, lastname)
VALUES
('patientFirst1','patientLast1'),
('patientFirst2','patientLast2'),
('patientFirst3','patientLast3'),
('patientFirst4','patientLast4'),
('patientFirst5','patientLast5'),
('patientFirst6','patientLast6'),
('patientFirst7','patientLast7'),
('patientFirst8','patientLast8'),
('patientFirst9','patientLast9');

INSERT INTO appointment (date_appointment, fk_id_doctor, fk_id_patient)
values
('2023-01-01 08:00:00',1,1),
('2023-01-01 14:00:00',1,2),
('2023-01-01 08:00:00',2,3),
('2023-01-01 14:00:00',2,4),
('2023-01-01 08:00:00',3,5),
('2023-01-01 14:00:00',3,6),
('2023-01-01 08:00:00',4,7),
('2023-01-01 14:00:00',4,8),
('2023-01-01 08:00:00',5,9),
('2023-01-01 16:00:00',5,8);

INSERT INTO consultation (price, report, fk_id_appointment)
values
(25.00,'blah blah 1',1),
(25.00,'blah blah 2',2),
(25.00,'blah blah 3',3),
(25.00,'blah blah 4',4),
(25.00,'blah blah 5',5),
(25.00,'blah blah 6',6),
(25.00,'blah blah 7',7),
(25.00,'blah blah 8',8),
(25.00,' blah blah 9',9),
(25.00,'blah blah 10',10);

