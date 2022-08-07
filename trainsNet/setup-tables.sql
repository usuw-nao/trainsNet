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

0806
create table adult_quiz (
id int primary key auto_increment,
content varchar(255) not null,
choice1 varchar(50) not null,
choice2 varchar(50) not null
);
insert into adult_quiz values(
1,'北海道の県庁所在地は？','札幌','函館');