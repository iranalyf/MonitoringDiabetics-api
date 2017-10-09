CREATE TABLE usuario (
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    senha VARCHAR(120) NOT NULL,
    path_foto VARCHAR(120),
    data_nascimento DATE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE grupo (
    codigo BIGINT(20) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
    codigo BIGINT(20) PRIMARY KEY,
    nome VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_grupo (
    codigo_usuario BIGINT(20) NOT NULL,
    codigo_grupo BIGINT(20) NOT NULL,
    PRIMARY KEY (codigo_usuario, codigo_grupo),
    FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
    FOREIGN KEY (codigo_grupo) REFERENCES grupo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE grupo_permissao (
    codigo_grupo BIGINT(20) NOT NULL,
    codigo_permissao BIGINT(20) NOT NULL,
    PRIMARY KEY (codigo_grupo, codigo_permissao),
    FOREIGN KEY (codigo_grupo) REFERENCES grupo(codigo),
    FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into usuario(nome,email,senha,data_nascimento) values ('Jose', 'jose@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Joao', 'joao@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Marcos', 'marcos@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Aline', 'aline@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Maria', 'maria@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Joana', 'joana@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Jordana', 'jordana@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Jessica', 'Jessica', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Poliana', 'poliana@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('Franciele', 'franciele@gmail.com', 'admin', '2000-10-10');
insert into usuario(nome,email,senha,data_nascimento) values ('admin', 'admin@gmail.com', 'admin', '2000-10-10');
