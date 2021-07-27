
/* account table */

create table account(
a_id varchar2 (20 char) primary key,
a_pw varchar2 (20 char) not null,
a_name varchar2 (20 char) not null,
a_birth varchar2 (20 char) not null,
a_gender varchar2 (20 char) not null,
a_intro varchar2 (200 char) not null
); 

alter table account add a_img varchar2(200 char) default'0' not null;

insert into account values ('jm','1004','jm','20001013','jm','jm','jm');

select * from account;





/* post table + bookmark table (post table과 bookmark table은 필드명, 필드순서 모두 같아야함)*/


create table post(
p_no number(3) primary key,
p_content varchar2 (200 char) not null,
p_img varchar2 (200 char) not null,
p_id varchar2(20 char)
);

create sequence post_seq;
select * from post;


create table bookmark(

    b_no number(3) primary key,
    b_content varchar2(200 char) not null,
    b_img varchar2(200 char) not null,
    b_id varchar2(20 char) not null

);

create sequence bookmark_seq;

select * from bookmark;



/*drop table*/

drop table account;
drop table bookmark;
drop table post;











