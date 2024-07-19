create table aluno(
id bigint not null auto_increment,
nome varchar(100) not null,
matricula varchar(100) not null,
curso varchar(100) not null,
periodo varchar(100) not null,
idade int not null,
email varchar(100) not null,
CPF varchar(14) not null,

primary key(id)
);