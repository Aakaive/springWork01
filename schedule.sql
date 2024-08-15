create table schedule
(
    id       bigint       not null auto_increment,
    contents varchar(500) not null,
    username varchar(255) not null,
    password varchar(255) not null,
    date DATETIME not null,
    primary key (id)
);
===테이블 생성 스키마===
