create table snack(
	s_no number(3) primary key,
	s_name varchar2(10 char)not null,
	s_maker varchar2(10 char)not null,
	s_weight number(5,1)not null,
	s_price number(4)not null,
	s_exp date
);

-- sysdate : ���� �ð� ��¥ (�ڹ� : date)
insert into snack values (1, '���ĸ�', '���',60,1000,sysdate);
insert into snack values (2, '�ɰԶ�', '����',70,1200,sysdate);

-- Ư�� �ð� ��¥ :
-- to_date('��','����')
-- 			   'YYYY MM DD HH:MI:SS'
-- 			   'YYYY MM DD PM HH:MI:SS'

insert into snack values (3,'������','�Ե�',70.5,1300,to_date('2021-08-10','YYYY-MM-DD'));

select * from snack;

drop table snack cascade constraint purge;
