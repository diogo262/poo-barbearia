use db_barbearia;

CREATE VIEW 
	vw_consultaInformacoesPedido
AS
SELECT 
	p.cd_pedido,
    p.cd_cliente,
    p.cd_funcionario,
    p.cd_status,
    p.hora_pedido,
    p.data_pedido,
    c.nome_cliente,
    c.sobrenome_cliente, 
    c.telefone_cliente,
    c.email_cliente,
    c.senha_cliente,
    coalesce(cf.cpf_cliente, cj.cnpj_cliente) as 'inscricaoNacionalCliente',
    f.nome_funcionario,
    f.sobrenome_funcionario, 
    f.telefone_funcionario,
    f.email_funcionario,
    f.senha_funcionario,
    f.adm_funcionario,
    coalesce(ff.cpf_funcionario, fj.cnpj_funcionario) as 'inscricaoNacionalFuncionario',
    s.nome_status
FROM 
	tbl_pedido as p
INNER JOIN 
	tbl_cliente as c
ON
	p.cd_cliente = c.cd_cliente
LEFT JOIN 
	tbl_cliente_fisico as cf
ON
	c.cd_cliente = cf.cd_cliente
LEFT JOIN 
	tbl_cliente_juridico as cj
ON
	c.cd_cliente = cj.cd_cliente
LEFT JOIN 
	tbl_funcionario as f
ON 
	p.cd_funcionario = f.cd_funcionario
LEFT JOIN 
	tbl_funcionario_fisico as ff
ON
	f.cd_funcionario = ff.cd_funcionario
LEFT JOIN 
	tbl_funcionario_juridico as fj
ON
	f.cd_funcionario = fj.cd_funcionario
INNER JOIN 
	tbl_status as s
ON 
	p.cd_status = s.cd_status;
    
SELECT * FROM vw_consultaInformacoesPedido;

/* View para consultar os pedidos que ainda estao na fila */

CREATE VIEW 
	vw_consultaPedidosNaFila
AS
SELECT 
    p.cd_pedido,
    p.cd_cliente,
    p.cd_funcionario,
    p.cd_status,
    s.nome_status,
    p.hora_pedido,
    p.data_pedido,
    c.nome_cliente,
    c.sobrenome_cliente,
    c.telefone_cliente,
    c.email_cliente,
    coalesce(cf.cpf_cliente, cj.cnpj_cliente) as inscricao_nacional_cliente
FROM 
    tbl_pedido as p
INNER JOIN 
    tbl_cliente as c 
ON 
	p.cd_cliente = c.cd_cliente
LEFT JOIN 
    tbl_cliente_fisico as cf 
ON 
	c.cd_cliente = cf.cd_cliente
LEFT JOIN 
    tbl_cliente_juridico as cj 
ON 
	c.cd_cliente = cj.cd_cliente
INNER JOIN 
    tbl_status as s 
ON 
	p.cd_status = s.cd_status;