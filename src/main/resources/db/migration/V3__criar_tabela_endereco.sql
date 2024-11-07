CREATE TABLE endereco (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    logradouro varchar(255) NOT NULL,
    bairro varchar(255) NOT NULL,
	uf varchar(255) NOT NULL,
	cidade varchar(255) NOT NULL,
    cep varchar(8) NOT NULL,
    tipo_endereco INTEGER,
    contato_id bigint
);