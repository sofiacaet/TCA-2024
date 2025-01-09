CREATE TABLE Estoque_Usuario
(
    id int auto_increment primary key,
    email varchar(50) not null unique,
    senha_hash varchar(255) not null
)

CREATE TABLE Estoque_Livro
(
    id varchar(5) primary key,
    nome varchar(50) not null,
    quantidade int not null,
    categoria varchar(50) not null,
    preco float not null
)

CREATE TABLE Estoque_Venda
(
    id varchar(50) primary key,
    idLivro varchar(5) not null,
    quantidadeVendida int not null,
    valorTotal  float not null,
    cpfCliente varchar(14) not null,
    dataVenda date not null
)





