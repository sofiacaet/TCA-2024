CREATE TABLE Estoque_Usuario
(
    id int auto_increment primary key,
    email varchar(50) not null unique,
    senha_hash varchar(255) not null
)



