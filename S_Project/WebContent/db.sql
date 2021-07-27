create table account(
a_id varchar2 (20 char) primary key,
a_pw varchar2 (20 char) not null,
a_birth varchar2 (20 char) not null,
a_gender varchar2 (20 char) not null,
a_intro varchar2 (20 char) not null,
);

alter table account add a_pic varchar2 (100 char) not null;





create table post(
p_no number(3) primary key,
p_content varchar2 (20 char) not null,
p_img varchar2 (20 char) not null
);

create sequence post_seq;

insert into post values (post_seq.nextval, '안녕안녕', '이미지');
insert into post values (post_seq.nextval, '하이하이', '이미지1');

select * from post;




