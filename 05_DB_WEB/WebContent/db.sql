create table test111(
t_name varchar2(10 char) primary key,
t_age number(2) not null
);

insert into TEST111 values('±è',1);
insert into TEST111 values('ÀÌ',2);
insert into TEST111 values('¹Ú',3);

select*from TEST111;

