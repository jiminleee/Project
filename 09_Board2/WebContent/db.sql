create table movie(
	m_no number(3) primary key,
	m_title varchar2(30 char) not null,
	m_actor varchar2(30 char) not null,
	m_img varchar2(100 char) not null,
	m_story varchar2(100 char) not null
);

create sequence movie_seq;

insert into movie values (movie_seq.nextval,'제목','배우','이미지','줄거리');
insert into movie values (movie_seq.nextval,'제목2','배우2','이미지2','줄거리2');
insert into movie values (movie_seq.nextval,'제목3','배우3','이미지3','줄거리3');

select * from movie;