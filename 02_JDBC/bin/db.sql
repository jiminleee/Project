create table db_test(
	d_no number(2) primary key,
	d_name varchar2(5 char) not null,
	d_age number(2)not null
);

create sequence db_test_seq;

-- ������ 2~3�� �ֱ�
insert into db_test values(db_test_seq.nextval,'����',22);
insert into db_test values(db_test_seq.nextval,'����',22);

insert into db_test values(db_test_seq.nextval,'����',22);

-- ��ü��ȸ
select * from db_test;