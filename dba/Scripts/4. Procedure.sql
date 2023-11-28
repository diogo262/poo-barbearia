use db_barbearia;

/* Procedure para consultar o código do funcionário que irá se logar */

DELIMITER $$
	CREATE PROCEDURE sp_consultaLoginFuncionario 
		(
			vEmailFuncionario varchar(65), 
            vSenha varchar(65)
		)
	BEGIN
		SELECT 
			cd_funcionario
		FROM
			tbl_funcionario
		WHERE 
			email_funcionario = vEmailFuncionario
			AND 
			senha_funcionario = vSenha
		LIMIT 1;
	END $$
DELIMITER ;;

call sp_consultaLoginFuncionario ('dioguito@berserk.com.br', '12345');

/* Procedure para consultar o código do funcionário que irá se logar */

DELIMITER $$
	CREATE PROCEDURE sp_consultaLoginCliente
		(
			vEmailCliente varchar(65), 
            vSenha varchar(65)
		)
	BEGIN
		SELECT 
			cd_cliente
		FROM
			tbl_cliente
		WHERE 
			email_cliente = vEmailCliente
			AND 
			senha_cliente = vSenha
		LIMIT 1;
	END $$
DELIMITER ;;

call sp_consultaLoginCliente ('erikito@gmail.com.br', '12345');

/* Procedure para inserir um cliente físico */

DELIMITER $$
	CREATE PROCEDURE sp_insereClienteFisico
		(
            vCdCliente int,
			vCPFCliente varchar(11)
		)
	BEGIN
		INSERT INTO 
			tbl_cliente_fisico
		VALUES
			(vCdCliente, vCPFCliente);
	END $$
DELIMITER ;;

call sp_insereClienteFisico (1, '12345678901');

/* Procedure para inserir um cliente juridico */

DELIMITER $$
	CREATE PROCEDURE sp_insereClienteJuridico
		(
            vCdCliente int,
			vCNPJCliente varchar(14)
		)
	BEGIN
		INSERT INTO 
			tbl_cliente_juridico
		VALUES
			(vCdCliente, vCNPJCliente);
	END $$
DELIMITER ;;

call sp_insereClienteJuridico (2, '12345678901234');