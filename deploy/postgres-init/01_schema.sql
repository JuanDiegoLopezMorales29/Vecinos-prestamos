-- Tablas base
CREATE TABLE IF NOT EXISTS objetos (
  id SERIAL PRIMARY KEY,
  nombre VARCHAR(120) NOT NULL,
  tipo VARCHAR(80) NOT NULL,
  estado VARCHAR(60) NOT NULL
);

CREATE TABLE IF NOT EXISTS prestamos (
  id SERIAL PRIMARY KEY,
  prestador VARCHAR(160) NOT NULL,
  receptor VARCHAR(160) NOT NULL,
  objeto_id INT REFERENCES objetos(id) ON DELETE SET NULL,
  fecha_prestamo DATE NOT NULL
);

-- Datos demo
INSERT INTO objetos (nombre, tipo, estado) VALUES
  ('Taladro Eléctrico', 'Herramienta', 'Disponible'),
  ('Escalera de Aluminio', 'Herramienta', 'Prestado'),
  ('Cortadora de Césped', 'Jardinería', 'Disponible'),
  ('Aspiradora Industrial', 'Limpieza', 'Disponible')
ON CONFLICT DO NOTHING;

INSERT INTO prestamos (prestador, receptor, objeto_id, fecha_prestamo) VALUES
  ('Carlos Rodríguez', 'María López', 1, '2025-12-01'),
  ('Ana Martínez', 'Pedro García', 2, '2025-12-03'),
  ('Luis Fernández', 'Sofia Torres', 3, '2025-12-02')
ON CONFLICT DO NOTHING;
