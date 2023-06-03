create database  jdbclock;
create table datas
(
    id      bigint primary key auto_increment,
    data    bigint not null,
    version int    not null
);

insert into datas values (1, 10, 1), (2, 15, 1), (3, 20, 1);