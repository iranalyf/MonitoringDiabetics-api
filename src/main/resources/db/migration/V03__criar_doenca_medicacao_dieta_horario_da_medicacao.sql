CREATE TABLE medicacao (
	codigo INTEGER AUTO_INCREMENT PRIMARY KEY,
	descricao VARCHAR(255) NOT NULL,
	data_medicacao DATE NOT NULL,
	observacao VARCHAR(255),
	codigo_paciente BIGINT(20),
	FOREIGN KEY (codigo_paciente) REFERENCES paciente(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE dieta (
	codigo INTEGER AUTO_INCREMENT PRIMARY KEY,
	data_inicio DATE NOT NULL,
	cafe_manha VARCHAR(100),
	lanche_manha VARCHAR(100),
	almoco VARCHAR(100),
	sobremesa_almoco VARCHAR(100),
	lanche_tarde VARCHAR(100),
	janta VARCHAR(100),
	lanche_noite VARCHAR(100),
	data_fim DATE NOT NULL,
	descricao VARCHAR(255) NOT NULL,
	qtde_agua_diaria VARCHAR(20),
	observacao VARCHAR(255),
	codigo_paciente BIGINT(20),
	FOREIGN KEY (codigo_paciente) REFERENCES paciente(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE horario_medicacao (
	codigo INTEGER AUTO_INCREMENT PRIMARY KEY,
	horario VARCHAR(50) NOT NULL,
	data_fim DATE NOT NULL,
	codigo_medicacao INTEGER,
	FOREIGN KEY (codigo_medicacao) REFERENCES medicacao (codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
