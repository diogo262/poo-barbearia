use db_barbearia;

INSERT INTO tbl_funcionario VALUES 
(1, 'Dioguito', 'Gabardito', '1140028922', 'dioguito@berserk.com.br', '12345', 1),
(2, 'Rafael', 'Suuuares', '1140028932', 'rafael.suuuares@berserk.com.br', '12345', 0),
(3, 'Maven', 'Fu', '1140803023', 'mavenfu@gmail.com.br', '12345', 0);

INSERT INTO tbl_funcionario_juridico VALUES 
(1, '13500019000149'), (3, '11972095000121');

INSERT INTO tbl_funcionario_fisico VALUES 
(2, '84149859043');

INSERT INTO tbl_cliente VALUES 
(1, 'Eriku', 'Sakai', '1140028685', 'erikito@gmail.com.br', '12345'),
(2, 'Diogo', 'Takahashi', '1140028989', 'diogo.takahashi@gmail.com.br', '12345'),
(3, 'Eriku', 'Pou', '1140046335', 'eriku.takahashi@gmail.com.br', '12345'),
(4, 'Mauricio', 'Salon', '1140028976', 'mauricio.salon@gmail.com.br', '12345'),
(5, 'Napolei', 'Bom', '1140028976', 'nada.fazer@gmail.com.br', '12345');

INSERT INTO tbl_cliente_fisico VALUES 
(1, '16658689024'), (2, '69720296003'), (3, '88405082018');

INSERT INTO tbl_cliente_juridico VALUES 
(4, '89523872000148'), (5, '61400874000120');

INSERT INTO tbl_status VALUES
(1, 'Na fila'), # somente marcou chegada
(2, 'Aguardando atendimento'), # um funcionario ja marcou q ira atende-lo
(3, 'Em atendimento'), # um funcionario esta cortando o cabelo dele
(4, 'Finalizado'),
(5, 'Cancelado');

INSERT INTO tbl_pedido VALUES
(default, 1, null, 1, TIME(NOW()), DATE(NOW())), 
(default, 2, 2, 2, TIME(NOW()), DATE(NOW())),
(default, 3, 2, 3, TIME(NOW()), DATE(NOW())),
(default, 4, 3, 4, TIME(NOW()), DATE(NOW())),
(default, 1, 1, 4, TIME(NOW()), DATE(NOW())),
(default, 2, 2, 5, TIME(NOW()), DATE(NOW()));