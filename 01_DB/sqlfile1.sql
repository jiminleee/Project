-- �ּ�
-- ������ ������� -> alt + x
-- ���� ���� : �� �ٿ� Ŀ�� ���� -> alt + s

-- ���̺� ����
create table product(
p_name varchar2(10 char),
p_age number(4)
);
-- ���̺� ����
insert into PRODUCT values('����',1000);
insert into PRODUCT values('����2',2000);
-- ��ȸ
select * from PRODUCT;
-- ���̺� ����
drop table product cascade constraint purge;
-----------------------------------------------
-- ��, row, �� �ϳ��� ������ 1��. record ��� ��.
-- ��, field, �Ӽ�, colum
-- oracle ��/�ҹ��� ����x �� �빮��

-- DBA : ������������, ���/����, ��������

-- DBP : CRUD (�츮�Ǹ�ǥ)(Create Read Update Delete)

-- SQL (Structured Query Language) : DB�� �����ϴ� ���
	-- �ٸ� ����Ŀ DB, 98.99%���
	-- ; ���� ��
----------------------------------------------
-- 1)���̺� �����

create table student(
	s_name varchar2(10 char),
	s_age number(3),
	s_kor number(3),
	s_eng number(3),
	s_jp number(3)
);

-- 2) ������ �ֱ� -C (CRUD)
insert into student(s_name,s_age,s_kor,s_engs_jp)
values ('����',20,100,100,100);

insert into student(s_name,s_age)
values ('�ּ���',30);

select * from student;
-- �Ⱦ���? �̻������ִ� => Null
-- �ʵ� ������ �� �ٲٴ���, ������ �ȳ־ null�� �ּ� ��¿����
-- 0���̸� 0���ΰ��� ����θ�(null) ���߿� ��갰���� �Ҷ� ��ġ����
-- �׷��� ���̺��� ���鶧 �ɼ��� �� �� ����.

create table student2(
	s_no number(2) primary key,	
	s_name varchar2(10 char) not null,
	s_age number(3)not null,
	s_kor number(3)not null,
	s_eng number(3)not null,
	s_jp number(3)not null
);

-- �ɼ�
-- not null : ��ǻ� �⺻, �ʼ�
-- primary key : not null + �ߺ�����
--  �� ���̺��� ��ǥ�ϴ� �� => ���̺� �ϳ��� pk�ϳ� �ִ°� ����
-- id�� mz ->ȥ��

-- ��ǻ� �̷��� ���
insert into student2 values(3,'��������',20,100,100,100)
insert into student2 values(4,'��������',20,100,100)

-- 3) ��ȸ - R (CRUD)
select * from STUDENT2;

select �ʵ��, �ʵ��,...
from ���̺��;

-- student2 ���̺��� �л� �̸���
select s_name from STUDENT2;
-- student2 ���̺��� �л� �̸�,����,�Ͼ�����
select s_name,s_age,s_jp from STUDENT2;

--  4) ������ ���� U (CRUD)
-- 2�� �л��� �̸��� '����'���� ����
update STUDENT2
set s_name ='����'
where s_no = 2;

-- 3�� �л� ����(���۸�)
delete from STUDENT2
where s_no = 3;

-- 5) ���̺� ���� (������ �������� ����⸸)
drop table student2 --�̷��Ը� �ϸ� ���(������) ����. �뷮 ���� 
					-- �����뿡 �ȳְ�, ���̺� �ɸ� ���� ������ ���� ����
cascade constraint purge;