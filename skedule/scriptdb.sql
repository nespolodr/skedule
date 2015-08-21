--DROP TABLE funcionario;

-- 0 - Funcionario
-- 1 - Medico
CREATE TABLE funcionario
(
	id INTEGER NOT NULL,
	tipo INTEGER NOT NULL DEFAULT 0,
	nome VARCHAR(100) NOT NULL,
	rg VARCHAR(20),
	cpf VARCHAR(20),
	PRIMARY KEY(id)
);
--INSERT INTO funcionario(tipo, id, cpf, nome, rg) VALUES (1,nextval('seq_funcionario'),'7722463', 'Dr. Jonas Marcolino', '727447');

--drop table paciente;
CREATE TABLE paciente
(
	id INTEGER NOT NULL,
	idMedico INTEGER NOT NULL,
	nome VARCHAR(100) NOT NULL,
	rg VARCHAR(20),
	cpf VARCHAR(20),
	PRIMARY KEY(id)
);
ALTER TABLE paciente ADD CONSTRAINT fk_paciente_medico FOREIGN KEY (idMedico) REFERENCES funcionario(id);


