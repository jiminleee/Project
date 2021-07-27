-- select


select * from snack2;

-- ��ü ���� �̸�, ����, ����
select s_name,s_price,s_weight from snack2;

-- ��ü ���� �̸�, ������,���� ,�������
select s_name,s_maker,s_price,s_exp from snack2;

-- �ʵ���� ���� �ȵ�� as xx �ؼ� �ٲ� �� �ִ�.
select s_name,s_maker as jejosa,s_price,s_exp from snack2;


-- �ٽ� ���� �̸�, ����
select s_name,s_price from snack2;

-- �̻��¿��� �ΰ����� �ϰ����
select s_name,s_price, s_price * 0.1 as s_vat from snack2;

-- test
-- ��ü ���� �̸�, ������, ����, g�� ��(s_g)
--						hint - (���� �׶��� ���� ��� �Ի��ϴ��� �˾ƾ�)
select s_name,s_maker,s_price,round(s_price/s_weight) as s_g 
from snack2;

-- ��ü ���� ��� ����?
-- ���ݱ����� �����(��) �Ի��ε�
-- �̰� ���� �ʿ�
-- ����Ŭ�� *����Լ�*�� ���� : max,min,sum,avg,count,... 

select avg(s_price) from snack2;

-- ������ 
select min(s_price) from snack2;

-- aaaaaa

-- ������� ���� ���������� ����?
select max(s_exp) from snack2;


-- ���ڰ� �� � : count ���ڵ� ���� ���� Ư���� ���ᵵ �Ȱ���
select count(s_no) from snack2;

select count(*) from snack2;

-- ��ü ���� �̸�, ȸ���, ���ݸ�
-- ���� �̸��� Ȩ���� �ΰ�(����)
select s_name,s_maker,s_price
from snack2
where s_name = 'Ȩ����';

-- ��� ���� �̸�, ȸ���, ����
select s_name,s_maker,s_price
from snack2
where s_maker = '���';

-- ��� ���� ��հ�
select avg(s_price)
from snack2
where s_maker = '���';

-- ������ �ȵǴ�(������� ����) ������ �̸�, ȸ���, ����
select s_name,s_maker,s_price
from snack2
where s_exp < sysdate;

-- '%��' : ������ �����°�
-- '��%' : ������ �����ϴ°�
-- '%��%' : ���� �ִ°�

-- �� ���� ������ �ø��� ���� �̸�, ȸ���, ����
select s_name,s_maker,s_price
from snack2
where s_name like '��%';

--  test
-- ������ �ø����� ���� �̸�, ����
select s_name,s_price
from snack2
where s_name like '%������';

-- �� �ø��� �� �ְ�
select max(s_price)
from snack2
where s_name like '%��';

-- ���� ��� ����(�̸�,������,����) ���
select s_name,s_maker,s_price
from snack2
where s_price = max(s_price);
-- �� �Ѱ���, ���ۻ��� �ƴѵ� �ȵ�. ����
---------------------------------------
--  subquery ( ���� �� ���� )

-- ���� ���
select max(s_price)
from snack2;

-- ���� ��� ����(�̸�, ������, ����)
select s_name,s_maker,s_price
from snack2
where s_price = (select max(s_price)
from snack2);

-- ��հ� ���� ��� ����(�̸�, ����)
select avg(s_price)
from snack2;

select s_name,s_price
from snack2
where s_price > (select avg(s_price)
from snack2);

-- ���� ������ ����(�̸�, ����, ������)
select min(s_weight)
from snack2;

select s_name,s_price,s_maker
from snack2
where s_weight = (select min(s_weight)
from snack2);

-- ��� ������ ��հ����� ��� ���� ���� ��ü
select avg(s_price)
from snack2
where s_maker = '���';

select * from snack2
where s_price > (select avg(s_price)
from snack2
where s_maker = '���');

-- ���, ���� ���� ���� ��ü
select * from snack2
where s_maker = '���'or s_maker ='����';
 
-- 1000 < ���� < 2000�� ���� ���� ��ü
select * from snack2
where 1000 < s_price and s_price < 2000;

--------------------------------------------
-- ���� order by �÷�      desc(����)

-- ��ɰ��� ��ü �̸������� ����
select * from snack2
where s_maker = '���'
order by s_name desc;

-- ���� ��ü ������ ���ݼ�(��������)
select * from snack2
order by s_price,s_name;

-- 2000�� �����
-- ���� ����� �� �ִ� ����Ʈ
-- ��������� ª���� ����
select * from snack2
where s_price <= 2000
order by s_exp;








