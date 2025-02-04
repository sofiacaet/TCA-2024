CREATE TABLE Estoque_Usuario
(
    id int auto_increment primary key,
    email varchar(50) not null unique,
    senha_hash varchar(255) not null
);

CREATE TABLE Estoque_Livro
(
    id varchar(5) primary key,
    nome varchar(50) not null,
    quantidade int not null,
    categoria varchar(50) not null,
    preco float not null,
    status enum('disponivel para venda', 'indisponivel', 'reservado' ) default 'disponivel para venda'
);

CREATE TABLE Estoque_Venda
(
    id varchar(50) primary key,
    idLivro varchar(5) not null,
    quantidadeVendida int not null,
    valorTotal  float not null,
    cpfCliente varchar(14) not null,
    dataVenda date not null
);

CREATE TABLE Estoque_Cliente
(
    cpf varchar(14) primary key,
    nome varchar(50) not null,
    numero varchar(11) not null
);



tela transações: CERTO e IMPLEMENTADO

CREATE VIEW Transacoes AS
SELECT 
    c.nome AS cliente_nome,
    c.cpf AS cliente_cpf,
    l.nome AS livro_nome,
    v.quantidadeVendida,
    v.valorTotal,
    v.dataVenda
FROM 
    Estoque_Cliente c
JOIN 
    Estoque_Venda v ON c.cpf = v.cpfCliente
JOIN 
    Estoque_Livro l ON v.idLivro = l.id;



CREATE VIEW Clientes_LivrosDisponiveis AS
SELECT 
    c.nome AS cliente_nome,
    c.cpf AS cliente_cpf,
    l.nome AS livro_nome,
    l.quantidade AS quantidade_disponivel, -- Adicionando a quantidade aqui
    l.id AS livro_id
FROM 
    Estoque_Cliente c
CROSS JOIN 
    Estoque_Livro l
WHERE 
    l.status = 'disponivel para venda';

