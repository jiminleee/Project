create table account(
a_id varchar2 (20 char) primary key,
a_pw varchar2 (20 char) not null,
a_name varchar2 (20 char) not null,
a_birth varchar2 (20 char) not null,
a_gender varchar2 (20 char) not null,
a_intro varchar2 (100 char) not null
); 

alter table account add a_img varchar2(100 char) default'0' not null;

insert into account values ('jm','1004','지민','20001013','여','하이');
delete from ACCOUNT;

insert into account values ('jm','1004','지민','20001013','여','하이','사진');


select * from account;