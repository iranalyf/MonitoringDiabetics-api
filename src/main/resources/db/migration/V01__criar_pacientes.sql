CREATE TABLE doenca (
	codigo BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
	nome VARCHAR(50) NOT NULL,
	descricao VARCHAR(200)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO doenca(nome) VALUES ('Diabete tipo 1 (DM1)');
INSERT INTO doenca(nome) VALUES ('Diabete tipo 2 (DM2)');
INSERT INTO doenca(nome) VALUES ('Diabete Gestacional');
INSERT INTO doenca(nome) VALUES ('Diabete tipo LADA');

CREATE TABLE paciente (
	codigo BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
	primeiro_nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf VARCHAR(15),
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(200) NOT NULL,
	telefone VARCHAR(20),
	situacao BOOLEAN DEFAULT true,
	ultimo_registro DATE,
	data_cadastro DATE,
	logradouro VARCHAR(50),
    numero VARCHAR(15),
    complemento VARCHAR(20),
    cep VARCHAR(15),
    cidade VARCHAR(40),
    estado VARCHAR(20),
    codigo_doenca BIGINT(20),
    FOREIGN KEY(codigo_doenca) REFERENCES doenca(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


