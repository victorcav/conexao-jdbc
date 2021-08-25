# conexao-jdbc
Aprendendo a Conectar o Java com o Banco de Dados

----- Script do Banco para o exercicio de Produtos -----

create database store;

use store;

create table produto(
		id int not null auto_increment primary key,
		nome		varchar(40),
		codigo		int(4),
		preco		float(8,2),
		quantidade	int(3),
		tipo		varchar(20),
		ativo		boolean);
		
select * from produto;

--------------------------------------------------------
