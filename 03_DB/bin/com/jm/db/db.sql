-- RDB (Relation)
-- ���̺��� ���踦 �߽����� ����..

-- DB
-- ���� ȫ����� ¥��� 5000�� 1
-- ���� ������ ¥��� 6000�� 2
-- ���ﵿ�� �ִ� ���ٹ濡�� 3000�� �� 3
-- ��ġ���� �ִ� ��Ÿ�������� 6000�� ��ü�� 4
-- ���ο� �ִ� ��Ÿ�������� 6000�� ��ü�� 4

create table menu(
	m_no number(3) primary key,	
	m_name varchar2 (20 char) not null,
	m_price number(6) not null,
	m_place number(3)not null
);

create table restaurant(
r_no number(3) primary key,
r_name varchar2 (20 char) not null,
r_place varchar2 (10 char) not null
);

create table human(
h_no number(3)primary key,
h_name varchar2(20 char)not null, 
h_birth date not null
);

create table owner(
o_no number(3)primary key,
o_ceo number(3)not null,
o_restaurant number(3)not null
);

create sequence menu_seq;
create sequence restaurant_seq;
create sequence human_seq;
create sequence owner_seq;

insert into MENU values (menu_seq.nextval,'������â',10000,1);
insert into MENU values (menu_seq.nextval,'�Ұ�â',15000,1);
insert into MENU values (menu_seq.nextval,'��ä��â',9000,2);
insert into MENU values (menu_seq.nextval,'ī���',6000,3);
insert into MENU values (menu_seq.nextval,'�Ƹ޸�ī��',4000,3);
insert into MENU values (menu_seq.nextval,'��ü��',7000,4);

update MENU
set m_price = 4000
where m_name = '�Ƹ޸�ī��';
-- �޴��߰�
-- ���� ��ȭ������ ü����ν� ���� �߰�
-- ���� ������ 2�� ��������� �߰�
insert into MENU values (menu_seq.nextval,'ü����ν�',7500,500);
insert into MENU values (menu_seq.nextval,'���⽺����',5500,2);

-- �� 2�� ������ ������ �ִ��� �ľ�
update MENU
set m_place = 3
where m_name = '���⽺����';

-- �װ� �����
-- ü����ν浵
 delete from MENU
 where m_name = '���⽺����' or m_name = 'ü����ν�';


insert into RESTAURANT values(restaurant_seq.nextval,'Ȳ�Ұ�â','����');
insert into RESTAURANT values(restaurant_seq.nextval,'���빮 ��â','���빮');
insert into RESTAURANT values(restaurant_seq.nextval,'��Ÿ����','����');
insert into RESTAURANT values(restaurant_seq.nextval,'��Ÿ����','����');


insert into HUMAN values(human_seq.nextval,'��',to_date('1980-05-05','YYYY-MM-DD'));
insert into HUMAN values(human_seq.nextval,'��',to_date('1985-06-05','YYYY-MM-DD'));
insert into HUMAN values(human_seq.nextval,'��',to_date('1980-07-05','YYYY-MM-DD'));
insert into HUMAN values(human_seq.nextval,'��',to_date('1985-08-05','YYYY-MM-DD'));

insert into OWNER values(owner_seq.nextval,1,1);
insert into OWNER values(owner_seq.nextval,2,2);
insert into OWNER values(owner_seq.nextval,3,3);
insert into OWNER values(owner_seq.nextval,4,4);

-- �� �����͸� �߰��ϰڴٴ°� � �ǹ�?
insert into OWNER values(owner_seq.nextval,4,500);

select * from menu;
select * from restaurant;
select * from human;
select * from owner;

drop table menu cascade constraint purge;
drop sequence menu_seq;
drop table restaurant cascade constraint purge;
drop sequence restaurant_seq;
drop table human cascade constraint purge;
drop sequence human_seq;
drop table owner cascade constraint purge;
drop sequence owner_seq;
-- sql
-- select ����. �����Ұ� ����.

-- ���� �˰� �ִ� ���� �̸�, ��ġ(���� ��ȸ) - �̸� �����ټ�
select r_name,r_place
from RESTAURANT
order by r_name;

-- �޴��߿� ���� ��� ����
select max(m_price) from MENU;

select *from MENU
where m_price = (select max(m_price) from MENU);

-- �� ������ ����

select * from HUMAN
where h_birth = (
select min(h_birth) from HUMAN
);

-- ��â �ø��� ��հ�
select avg(m_price)
from MENU
where m_name like '%��â%';

-- ���� ���� ����
select * from RESTAURANT
where r_place = '����';

-- ���� �� �޴��� �Ĵ� �Ĵ��� �̸���, ��ġ
select m_place
	from menu
	where m_price=(
	select min(m_price)
	from MENU
);



select r_name,r_place
from RESTAURANT
where r_no = 
(
	select m_place
	from MENU
	where m_price=(
		select min(m_price)
		from MENU
		)
);

-- ���빮���� ���� �� �ִ� ������ �̸�, ����
-- ���빮�� �ִ� ��������� �����ѹ�
 select r_no
 from RESTAURANT
 where r_place = '���빮';

select m_name,m_price
from MENU
where m_place = ( 
	select r_no
 	from RESTAURANT
 	where r_place = '���빮'
 	);

 -- ��â �ø���� ��� ������ ���� ���� �� ������? (�������?)
 
 -- ��â�� �޴����� ���������ȣ
select m_place
from MENU
where m_name like '%��â%';
 	
 	
 select r_place,r_name
 from RESTAURANT
 where r_no in (
 	select m_place
	from MENU
	where m_name like '%��â%'
 );
 
 -- ���� �� Ŀ�Ǹ� �Ĵ� ������ �̸�, ����
 
select min(price)
from menu
where m_place = 3 or m_place = 4

select r_name,r_place
 from RESTAURANT
 where r_no = (
 	select m_place
 	from MENU
 	where m_price =(
 		select min(m_price)
		from MENU
		-- ����ó��, �ùٸ��� �ƴ�
		where m_name like '%��%' or m_name like '%ī��%'
 	)
 );
 
 ----------------------------------------------
 
 -- join
 -- �ڼ��� �ٸ� ���̺��� �����Ҷ� �� ���踦 ����� ��
 select m_name,m_price,r_name,r_place
 from menu,RESTAURANT
 where m_place = r_no
 
 -- ��Ÿ���� ���������� �̸� ����,(������� ������)
 
 -- ������ ���� ����...
 select m_name,m_price,r_name,r_place
 from MENU,RESTAURANT
 where r_name = '��Ÿ����' and r_place = '����';

 -- ���� ������ �����ô� ����
 select m_name,m_price,r_name,r_place
 from MENU,RESTAURANT
 where m_place = (
 				select r_no
 				from RESTAURANT
 				where r_name = '��Ÿ����' and r_place = '����'
 				);
 
 -- �� ���̺� �� ���� ���ִϱ� ������ �� �����°�			
 select m_name,m_price,r_name,r_place
 from MENU,RESTAURANT
 where m_place = r_no and m_place = (
 				select r_no
 				from RESTAURANT
 				where r_name = '��Ÿ����' and r_place = '����'
 				);
 				
 -- ��Ÿ���� ���������� �޴��̸� ����,(������� ������)
 -- ���� �����ϰ�, ���� �̾��ִ°Ÿ� �Ű�Ἥ
 -- ��������
 				
 select m_name,m_price,r_name,r_place
 from MENU,RESTAURANT
 where m_place = r_no and r_name = '��Ÿ����' and r_place = '����'; 
 				
 -- ���� ���� ����� ������ �����, ��ġ, ����� �̸�, ����, �޴���, ����				
 
 select r_name,r_place,h_name,h_birth,m_name,m_price
 from RESTAURANT,HUMAN,MENU,OWNER
 where r_no = m_place
 	and h_no = o_ceo
 	and o_restaurant = r_no
 	and h_birth = (
 	select max(h_birth)
 	from HUMAN
 	);
 				
 -- �ֿ����� �������� �޴���, �޴� ����
 select m_name,m_price
 from MENU,RESTAURANT,HUMAN,OWNER
 where m_place = r_no
 	and o_ceo = h_no
 	and o_restaurant = r_no
 	and h_birth = (
 	select min(h_birth)
 	from HUMAN
 );
 
 select m_name, m_price
from HUMAN, MENU, OWNER
where o_restaurant = m_place
	and h_no = o_ceo 
	and h_birth = (
		select min(h_birth)
		from HUMAN
	);

 
 select m_name, m_price
from menu
where m_place in (
	select r_no
	from RESTAURANT
	where r_no = (
		select o_ceo
		from owner
		where o_ceo = (
			select h_no
			from HUMAN
				where h_birth =(
				select min(h_birth)
				from human
				)
		)
	)
);

select m_name, m_price
from MENU
where m_place = (
	select r_no
	from RESTAURANT
	where r_no = (
		select o_restaurant
		from owner
		where o_ceo = (
			select h_no
			from human
			where h_birth = (
				select min(h_birth)
				from human
			)
		)
	)
);

-----------------------------------------------

-- Ȳ�� ��â ������ ��ü �޴���, ����, ������ġ
select m_name,m_price,r_place
from MENU,RESTAURANT
where m_place = r_no
	and r_name ='Ȳ�Ұ�â';
	
-- ���� �Ѱ� �Ĵ� �����, ��ġ, �޴���, ����
select r_name,r_place,m_name,m_price
from MENU,RESTAURANT
where m_place = r_no
	and m_price = (
	select min(m_price)
	from MENU
	);
	
---------------------------------------------------
-- CR Update Delete

-- ������â ���� �λ� (13000)
update MENU
set m_price = 13000
where m_name = '������â';

select * from MENU;
-- ���� �� �޴� ���� �̺�Ʈ
update MENU
set m_price = 0
where m_price = (
select min(m_price)
from MENU
);
	
select * from MENU;
-- �޴� ��ü�� ��պ��� ��� �޴��� 10% ����	
update MENU
set m_price = m_price - (m_price*0.1)
where m_price > (
select avg(m_price)
from MENU
);

update MENU
set m_price = m_price * 0.9
where m_price > (
select avg(m_price)
from MENU
);
	
select * from MENU;
-- ���빮 ���� �޴��� 1000�� �λ�
update MENU
set m_price = m_price + 1000
where m_place = (
select r_no
from RESTAURANT
where r_place = '���빮'
);
	
select * from MENU;
-- Ŀ�� �� '��' ������ ������ 500�� �λ� (�������� �ö�)
update MENU
set m_price = m_price + 500
where m_name like '%��%';
	
select * from MENU;

-----------------------------------------------

-- drop => ���̺�, ������
-- delete => ���ڵ�(����Ŀ, ��) ���ﶧ

-- '��' ��� ���ڰ� �� �޴� �� ����
delete MENU
where m_name like '%��%';

select * from MENU;

-- ���� ���� (�޴� �� ����)

delete MENU
where m_place = (
select r_no
from RESTAURANT
where r_name = '��Ÿ����' and r_place = '����'
);

select * from MENU;

-- ���� ���� (����)

delete RESTAURANT
where r_name = '��Ÿ����' and r_place = '����';

select * from RESTAURANT;

-- '��â' �� ������ �޴� �� ����
delete MENU
where m_place in (
select r_no
from RESTAURANT
where r_name like '%��â%'
);
-- in : �������� ���� �������϶�
select * from MENU;

