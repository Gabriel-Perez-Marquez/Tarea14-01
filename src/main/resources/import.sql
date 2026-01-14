-- Insertar Profesionales
INSERT INTO profesional (nombre, especialidad) VALUES ('Dr. Gregorio Marañón', 'Cardiología');
INSERT INTO profesional (nombre, especialidad) VALUES ('Dra. Margarita Salas', 'Biología Molecular');
INSERT INTO profesional (nombre, especialidad) VALUES ('Dr. Santiago Ramón y Cajal', 'Neurología');

-- Insertar Pacientes
INSERT INTO paciente (nombre, email, fecha_nacimiento) VALUES ('Juan Pérez', 'juan.perez@example.com', '1985-06-15');
INSERT INTO paciente (nombre, email, fecha_nacimiento) VALUES ('María García', 'maria.garcia@example.com', '1992-11-23');
INSERT INTO paciente (nombre, email, fecha_nacimiento) VALUES ('Luis Rodríguez', 'luis.rod@example.com', '1978-03-10');

-- Insertar Citas (IDs generados: 1, 2, 3, 4)
INSERT INTO cita (fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES ('2030-01-01 10:00:00', 'PROGRAMADA', 1, 1, NULL);
INSERT INTO cita (fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES ('2025-10-01 09:30:00', 'CANCELADA', 2, 2, NULL);
INSERT INTO cita (fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES ('2025-11-15 11:00:00', 'ATENDIDA', 3, 3, NULL);
INSERT INTO cita (fecha_hora, estado, paciente_id, profesional_id, consulta_id) VALUES ('2025-12-01 16:00:00', 'ATENDIDA', 1, 2, NULL);

-- Insertar Consultas (IDs generados: 1, 2)
INSERT INTO consulta (fecha, diagnostico, observaciones, cita_id) VALUES ('2025-11-15 11:30:00', 'Migraña crónica', 'Paciente reporta dolor intenso', 3);
INSERT INTO consulta (fecha, diagnostico, observaciones, cita_id) VALUES ('2025-12-01 16:20:00', 'Gripe estacional', 'Se prescribe reposo y líquidos', 4);

-- Actualizar Citas para bidireccionalidad
UPDATE cita SET consulta_id = 1 WHERE id = 3;
UPDATE cita SET consulta_id = 2 WHERE id = 4;