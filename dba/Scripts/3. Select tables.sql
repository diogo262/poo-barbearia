use db_barbearia;

/* Consultando todos os registros da tabela funcionario */

SELECT 
	*
FROM
	tbl_funcionario;
    
/* Consultando o código do funcionário que irá se logar */

SELECT 
	cd_funcionario
FROM
	tbl_funcionario
WHERE 
	email_funcionario = 'dioguito@berserk.com.br' 
    AND 
    senha_funcionario = '12345';
    
/* Consultando dados na tabela cliente */

SELECT 
	*
FROM
	tbl_cliente;

SELECT 
	*
FROM
	tbl_cliente_fisico;
    
SELECT 
	*
FROM
	tbl_cliente_juridico;
    
/* Consultando para ver se um usuario X esta na fila HOJE */

SELECT 
	*
FROM	
	tbl_pedido
WHERE
	data_pedido = DATE(NOW())
    AND 
    cd_status = 1
    AND 
    cd_cliente = 1;
    
/* Consultando para ver a quantidade de usuarios na fila hoje */

SELECT 
	*
FROM	
	tbl_pedido
WHERE
	data_pedido = DATE(NOW())
    AND 
    cd_status = 1