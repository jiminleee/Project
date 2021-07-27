create table db_test(
	d_no number(2) primary key,
	d_name varchar2(5 char) not null,
	d_age number(2)not null
);

create sequence db_test_seq;

-- 데이터 2~3개 넣기
insert into db_test values(db_test_seq.nextval,'지민',22);
insert into db_test values(db_test_seq.nextval,'지은',22);

insert into db_test values(db_test_seq.nextval,'놀자',22);

-- 전체조회
select * from db_test;