create database db_barbearia;

use db_barbearia;

create table tbl_funcionario (
	cd_funcionario int primary key auto_increment,
	nome_funcionario varchar(65) not null,
    sobrenome_funcionario varchar(120) not null,
    telefone_funcionario varchar(11) not null,
    email_funcionario varchar(65) not null,
    senha_funcionario varchar(65) not null,
    adm_funcionario bit not null
);

create table tbl_funcionario_juridico (
	cd_funcionario int not null,
    cnpj_funcionario char(14) not null,
    foreign key(cd_funcionario) references tbl_funcionario(cd_funcionario)
);

create table tbl_funcionario_fisico (
	cd_funcionario int not null,
    cpf_funcionario char(11) not null,
    foreign key(cd_funcionario) references tbl_funcionario(cd_funcionario)
);

create table tbl_cliente (
	cd_cliente int primary key auto_increment,
	nome_cliente varchar(65) not null,
    sobrenome_cliente varchar(120) not null,
    telefone_cliente varchar(11) not null,
    email_cliente varchar(65) not null,
    senha_cliente varchar(65) not null
);

create table tbl_cliente_juridico (
	cd_cliente int not null,
    cnpj_cliente char(14) not null,
    foreign key(cd_cliente) references tbl_cliente(cd_cliente)
);

create table tbl_cliente_fisico (
	cd_cliente int not null,
    cpf_cliente char(11) not null,
    foreign key(cd_cliente) references tbl_cliente(cd_cliente)
);

create table tbl_avaliacao (
	cd_cliente int not null,
    cd_funcionario int not null,
	qntd_estrela int not null,
	texto_avaliacao varchar(255) not null,
    foreign key(cd_cliente) references tbl_cliente(cd_cliente),
    foreign key(cd_funcionario) references tbl_funcionario(cd_funcionario)
);

create table tbl_status (
	cd_status int primary key auto_increment,
    nome_status varchar(35) not null
);

create table tbl_pedido (
	cd_pedido int primary key auto_increment,
    cd_cliente int null,
    cd_funcionario int null, 
    cd_status int null, 
    hora_pedido time not null,
    data_pedido date not null,
	foreign key(cd_status) references tbl_status(cd_status),
    foreign key(cd_cliente) references tbl_cliente(cd_cliente),
    foreign key(cd_funcionario) references tbl_funcionario(cd_funcionario)
);