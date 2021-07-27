create table movie(
	m_no number(3) primary key,
	m_title varchar2(30 char) not null,
	m_actor varchar2(30 char) not null,
	m_img varchar2(100 char) not null,
	m_story varchar2(100 char) not null
);

create sequence movie_seq;

insert into movie values (movie_seq.nextval,'����','���','�̹���','�ٰŸ�');
insert into movie values (movie_seq.nextval,'����2','���2','�̹���2','�ٰŸ�2');
insert into movie values (movie_seq.nextval,'����3','���3','�̹���3','�ٰŸ�3');

select * from movie;