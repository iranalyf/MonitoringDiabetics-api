CREATE TABLE paciente (
	codigo BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
	primeiro_nome VARCHAR(20) NOT NULL,
	sobrenome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	cpf VARCHAR(15),
	situacao BOOLEAN DEFAULT true,
	codigo_endereco BIGINT(20) NOT NULL,
	codigo_doenca BIGINT(20) NOT NULL,
	FOREIGN KEY (codigo_endereco) REFERENCES endereco(idEndereco),
	FOREIGN KEY (codigo_doenca) REFERENCES doenca(codigo)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
