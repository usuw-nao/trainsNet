create database mytrains_db
character set utf8mb4
collate utf8mb4_general_ci;

use mytrains_db;

create table users (
id int primary key auto_increment,
name varchar(30) not null,
email varchar(255) unique key not null,
pass char(60) not null
);
