INSERT INTO USUARIO(nome, email, senha) VALUES('Jorge', 'jorgin@email.com', '$2a$10$XuUWDyueuxsI.UCyNsjyue5ONYyZWHksf6W2s5spZUTVUd1/shKaO');

INSERT INTO CARRO(marca,modelo) VALUES('Volkswagen', 'fox');
INSERT INTO CARRO(marca,modelo) VALUES('Honda', 'civic');

INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, carro_id) VALUES('Dúvida', 'Motor fazendo barulho', '2019-05-05 18:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, carro_id) VALUES('Dúvida 2', 'Carro trepidando', '2019-05-05 19:00:00', 'NAO_RESPONDIDO', 1, 1);
INSERT INTO TOPICO(titulo, mensagem, data_criacao, status, autor_id, carro_id) VALUES('Dúvida 3', 'Cambio ruim', '2019-05-05 20:00:00', 'NAO_RESPONDIDO', 1, 2);