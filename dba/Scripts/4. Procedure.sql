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

/* Procedure para consultar o nome do usuario por chave primaria */

DELIMITER $$
	CREATE PROCEDURE sp_consultaClientePorCdCliente
		(
            vCdCliente int
		)
	BEGIN
		SELECT 
			nome_cliente
		FROM 
			tbl_cliente
		WHERE 
			cd_cliente = vCdCliente;
	END $$
DELIMITER ;;

/* Procedure para ver se cliente esta X esta na fila hoje */

DELIMITER $$
	CREATE PROCEDURE sp_consultaClienteNaFilaHojePorCdCliente
		(
            vCdCliente int
		)
	BEGIN
		SELECT 
			*
		FROM	
			tbl_pedido
		WHERE
			data_pedido = DATE(NOW())
			AND 
			cd_status = 1
            AND 
            cd_cliente = vCdCliente;
	END $$
DELIMITER ;;

/* Procedure para entrar na fila */

DELIMITER $$
	CREATE PROCEDURE sp_entrarNaFila
		(
            vCdCliente int
		)
	BEGIN
		INSERT INTO tbl_pedido VALUES
		(default, vCdCliente, null, 1, TIME(NOW()), DATE(NOW()));
	END $$
DELIMITER ;;

/* Procedure para consultar a quantidade de clientes na fila */

DELIMITER $$
	CREATE PROCEDURE 
		sp_clientesNaFila()
	BEGIN
		SELECT 
			*
		FROM	
			tbl_pedido
		WHERE
			data_pedido = DATE(NOW())
			AND 
			cd_status = 1
		GROUP BY 
			data_pedido,
            hora_pedido;
	END $$
DELIMITER ;;

/* Consultando pedidos na fila hoje, sem funcionarios atribuidos */

DELIMITER $$
	CREATE PROCEDURE 
		sp_consultaPedidosNaFila()
	BEGIN
		SELECT 
			* 
		FROM 
			vw_consultaPedidosNaFila
		WHERE 
			cd_funcionario is null
			AND 
			cd_status = 1
			AND 
			data_pedido = DATE(NOW());
	END $$
DELIMITER ;;

/* Consulta pedidos que funcionario X esta responsavel */

DELIMITER $$
	CREATE PROCEDURE sp_consultaPedidosPorStatusEFuncionario
		(
			vCdFuncionario int,
            vCdStatus int
        )
	BEGIN
		SELECT 
			* 
		FROM 
			vw_consultaPedidosNaFila
		WHERE 
			cd_funcionario = vCdFuncionario
			AND 
			cd_status = vCdStatus
			AND 
			data_pedido = DATE(NOW());
	END $$
DELIMITER ;;

/* Procedure para sair da fila */

DELIMITER $$
	CREATE PROCEDURE sp_saiDaFila
		(
            vCdPedido int
		)
	BEGIN
		UPDATE 
			tbl_pedido
		SET
			cd_status = 5
		WHERE 
			cd_pedido = vCdPedido;
	END $$
DELIMITER ;;

/* Pedido finalizado */

DELIMITER $$
	CREATE PROCEDURE sp_finalizarAtendimento
		(
            vCdPedido int
		)
	BEGIN
		UPDATE 
			tbl_pedido
		SET
			cd_status = 4
		WHERE 
			cd_pedido = vCdPedido;
	END $$
DELIMITER ;;

/* Pedido aguardando atendimento */

DELIMITER $$
	CREATE PROCEDURE sp_pedidoAguardandoAtendimento
		(
            vCdPedido int,
            vCdFuncionario int
		)
	BEGIN
		UPDATE 
			tbl_pedido
		SET
			cd_status = 2,
			cd_funcionario = vCdFuncionario
		WHERE 
			cd_pedido = vCdPedido;
	END $$
DELIMITER ;;

/* Pedido em atendimento */

DELIMITER $$
	CREATE PROCEDURE sp_atenderPedido
		(
            vCdPedido int
		)
	BEGIN
		UPDATE 
			tbl_pedido
		SET
			cd_status = 3
		WHERE 
			cd_pedido = vCdPedido;
	END $$
DELIMITER ;;


/* Cancelar pedido */

DELIMITER $$
	CREATE PROCEDURE sp_CancelarPedido
		(
            vCdPedido int
		)
	BEGIN
		UPDATE 
			tbl_pedido
		SET
			cd_status = 5
		WHERE 
			cd_pedido = vCdPedido;
	END $$
DELIMITER ;;