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
	logradouro VARCHAR(50),
    numero VARCHAR(15),
    complemento VARCHAR(20),
    cep VARCHAR(15),
    cidade VARCHAR(40),
    estado VARCHAR(10),
    codigo_doenca BIGINT(20)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


