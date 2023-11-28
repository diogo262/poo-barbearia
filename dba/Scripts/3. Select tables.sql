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