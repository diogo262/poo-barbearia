use db_barbearia;

INSERT INTO tbl_funcionario VALUES 
(DEFAULT, 'Dioguito', 'Gabardito', '1140028922', 'dioguito@berserk.com.br', '12345', 1),
(DEFAULT, 'Dioguito', 'Suuuares', '1140028932', 'dioguito.suuuares@berserk.com.br', '12345', 0);

INSERT INTO tbl_funcionario_juridico VALUES 
(1, '13500019000149');

INSERT INTO tbl_cliente VALUES 
(DEFAULT, 'Eriku', 'Sakai', '1140028685', 'erikito@gmail.com.br', '12345'),
(DEFAULT, 'Eriku', 'Takahashi', '1140028989', 'erikito.takahashi@gmail.com.br', '12345');

INSERT INTO tbl_cliente_fisico VALUES 
(1, '89523872000148'), (2, '69720296003');

INSERT INTO tbl_status VALUES
(1, 'Na fila'), # somente marcou chegada
(2, 'Aguardando atendimento'), # um funcionario ja marcou q ira atende-lo
(3, 'Em atendimento'), # um funcionario esta cortando o cabelo dele
(4, 'Finalizado'),
(5, 'Cancelado');

INSERT INTO tbl_pedido VALUES
(3, 2, 1, 1, NOW(), NOW()), (default, 1, null, 1, NOW(), NOW());