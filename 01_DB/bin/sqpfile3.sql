create table snack2(
	-- pk ���� ������� ������ no
	s_no number(3) primary key,
	s_name varchar2(10 char)not null,
	s_maker varchar2(10 char)not null,
	s_weight number(5,1)not null,
	s_price number(4)not null,
	s_exp date
);

-- ���� �ڵ����� �ø��� : sequence (���̺�� ����) - ����Ŭ ���
create sequence ��������;
create sequence snack2_seq;
-- ��������.nextval�� ���

-- �������� �����ص� ���� �ö�. �̻��Ұ� ����
-- �̻� ������? �Ȱ�ġ�� �׸�
-- ��ȸ ���� �ڴ���ΰŵ� �̻��Ұ� ����

insert into snack2 values(snack2_seq.nextval,'���ĸ�','���',50,1500,sysdate);
insert into snack2 values(snack2_seq.nextval,'�����','����',60,1200,sysdate);
insert into snack2 values(snack2_seq.nextval,'���ڱ�','�Ե�',70,1300,sysdate);
insert into snack2 values(snack2_seq.nextval,'Ȩ����','���',80,1600,sysdate);
insert into snack2 values(snack2_seq.nextval,'����Ĩ','����',65,2000,sysdate);
insert into snack2 values(snack2_seq.nextval,'��īĨ','���',75,1400,sysdate);
insert into snack2 values(snack2_seq.nextval,'����ƽ','�Ե�',73,1700,sysdate);
insert into snack2 values(snack2_seq.nextval,'�����۽�','���',85,1900,sysdate);
insert into snack2 values(snack2_seq.nextval,'������','���',85,1900,sysdate);
insert into snack2 values(snack2_seq.nextval,'���廩����','���',85,1900,sysdate);
insert into snack2 values(snack2_seq.nextval,'�Ƹ�廩����','���',85,1900,sysdate);


-- ���� �ߴ� �� SNACK2 ���̺� �����͸� 3~5�� ���� �־��ּ���.
select * from snack2;