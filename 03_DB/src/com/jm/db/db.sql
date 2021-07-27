-- RDB (Relation)
-- 테이블간의 관계를 중심으로 뭔가..

-- DB
-- 강남 홍콩반점 짜장면 5000원 1
-- 종로 만보성 짜장면 6000원 2
-- 역삼동에 있는 빽다방에서 3000원 라떼 3
-- 대치동에 있는 스타벅스에서 6000원 돌체라떼 4
-- 종로에 있는 스타벅스에서 6000원 돌체라떼 4

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

insert into MENU values (menu_seq.nextval,'돼지곱창',10000,1);
insert into MENU values (menu_seq.nextval,'소곱창',15000,1);
insert into MENU values (menu_seq.nextval,'야채곱창',9000,2);
insert into MENU values (menu_seq.nextval,'카페라떼',6000,3);
insert into MENU values (menu_seq.nextval,'아메리카노',4000,3);
insert into MENU values (menu_seq.nextval,'돌체라떼',7000,4);

update MENU
set m_price = 4000
where m_name = '아메리카노';
-- 메뉴추가
-- 스벅 광화문점에 체리블로썸 음료 추가
-- 딸기 스무디 2번 레스토랑에 추가
insert into MENU values (menu_seq.nextval,'체리블로썸',7500,500);
insert into MENU values (menu_seq.nextval,'딸기스무디',5500,2);

-- 위 2개 문제중 문제점 있는지 파악
update MENU
set m_place = 3
where m_name = '딸기스무디';

-- 그거 지우기
-- 체리블로썸도
 delete from MENU
 where m_name = '딸기스무디' or m_name = '체리블로썸';


insert into RESTAURANT values(restaurant_seq.nextval,'황소곱창','종로');
insert into RESTAURANT values(restaurant_seq.nextval,'동대문 곱창','동대문');
insert into RESTAURANT values(restaurant_seq.nextval,'스타벅스','종로');
insert into RESTAURANT values(restaurant_seq.nextval,'스타벅스','강남');


insert into HUMAN values(human_seq.nextval,'김',to_date('1980-05-05','YYYY-MM-DD'));
insert into HUMAN values(human_seq.nextval,'나',to_date('1985-06-05','YYYY-MM-DD'));
insert into HUMAN values(human_seq.nextval,'박',to_date('1980-07-05','YYYY-MM-DD'));
insert into HUMAN values(human_seq.nextval,'이',to_date('1985-08-05','YYYY-MM-DD'));

insert into OWNER values(owner_seq.nextval,1,1);
insert into OWNER values(owner_seq.nextval,2,2);
insert into OWNER values(owner_seq.nextval,3,3);
insert into OWNER values(owner_seq.nextval,4,4);

-- 이 데이터를 추가하겠다는건 어떤 의미?
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
-- select 좀더. 생각할게 많음.

-- 내가 알고 있는 맛집 이름, 위치(매장 조회) - 이름 가나다순
select r_name,r_place
from RESTAURANT
order by r_name;

-- 메뉴중에 제일 비싼 정보
select max(m_price) from MENU;

select *from MENU
where m_price = (select max(m_price) from MENU);

-- 최 연장자 정보

select * from HUMAN
where h_birth = (
select min(h_birth) from HUMAN
);

-- 곱창 시리즈 평균가
select avg(m_price)
from MENU
where m_name like '%곱창%';

-- 종로 가게 정보
select * from RESTAURANT
where r_place = '종로';

-- 제일 싼 메뉴를 파는 식당의 이름과, 위치
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

-- 동대문에서 먹을 수 있는 음식의 이름, 가격
-- 동대문에 있는 레스토랑의 고유넘버
 select r_no
 from RESTAURANT
 where r_place = '동대문';

select m_name,m_price
from MENU
where m_place = ( 
	select r_no
 	from RESTAURANT
 	where r_place = '동대문'
 	);

 -- 곱창 시리즈는 어느 지역에 가면 먹을 수 있을까? (어느가게?)
 
 -- 곱창인 메뉴에서 매장고유번호
select m_place
from MENU
where m_name like '%곱창%';
 	
 	
 select r_place,r_name
 from RESTAURANT
 where r_no in (
 	select m_place
	from MENU
	where m_name like '%곱창%'
 );
 
 -- 제일 싼 커피를 파는 매장의 이름, 지역
 
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
		-- 땜빵처리, 올바른거 아님
		where m_name like '%라떼%' or m_name like '%카노%'
 	)
 );
 
 ----------------------------------------------
 
 -- join
 -- ★서로 다른 테이블을 연결할때 그 관계를 명시할 것
 select m_name,m_price,r_name,r_place
 from menu,RESTAURANT
 where m_place = r_no
 
 -- 스타벅스 종로지점의 이름 가격,(레스토랑 정보도)
 
 -- 관계명시 전혀 없음...
 select m_name,m_price,r_name,r_place
 from MENU,RESTAURANT
 where r_name = '스타벅스' and r_place = '종로';

 -- 역시 여전히 관계명시는 없음
 select m_name,m_price,r_name,r_place
 from MENU,RESTAURANT
 where m_place = (
 				select r_no
 				from RESTAURANT
 				where r_name = '스타벅스' and r_place = '종로'
 				);
 
 -- 두 테이블 잘 연결 해주니까 이제야 잘 나오는거			
 select m_name,m_price,r_name,r_place
 from MENU,RESTAURANT
 where m_place = r_no and m_place = (
 				select r_no
 				from RESTAURANT
 				where r_name = '스타벅스' and r_place = '종로'
 				);
 				
 -- 스타벅스 종로지점의 메뉴이름 가격,(레스토랑 정보도)
 -- 위에 무시하고, 관계 이어주는거만 신경써서
 -- 서브쿼리
 				
 select m_name,m_price,r_name,r_place
 from MENU,RESTAURANT
 where m_place = r_no and r_name = '스타벅스' and r_place = '종로'; 
 				
 -- 제일 젊은 사장님 가게의 매장명, 위치, 사장님 이름, 생일, 메뉴명, 가격				
 
 select r_name,r_place,h_name,h_birth,m_name,m_price
 from RESTAURANT,HUMAN,MENU,OWNER
 where r_no = m_place
 	and h_no = o_ceo
 	and o_restaurant = r_no
 	and h_birth = (
 	select max(h_birth)
 	from HUMAN
 	);
 				
 -- 최연장자 아저씨네 메뉴명, 메뉴 가격
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

-- 황소 곱창 가게의 전체 메뉴명, 가격, 매장위치
select m_name,m_price,r_place
from MENU,RESTAURANT
where m_place = r_no
	and r_name ='황소곱창';
	
-- 제일 싼거 파는 매장명, 위치, 메뉴명, 가격
select r_name,r_place,m_name,m_price
from MENU,RESTAURANT
where m_place = r_no
	and m_price = (
	select min(m_price)
	from MENU
	);
	
---------------------------------------------------
-- CR Update Delete

-- 돼지곱창 가격 인상 (13000)
update MENU
set m_price = 13000
where m_name = '돼지곱창';

select * from MENU;
-- 제일 싼 메뉴 무료 이벤트
update MENU
set m_price = 0
where m_price = (
select min(m_price)
from MENU
);
	
select * from MENU;
-- 메뉴 전체의 평균보다 비싼 메뉴를 10% 할인	
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
-- 동대문 지역 메뉴들 1000원 인상
update MENU
set m_price = m_price + 1000
where m_place = (
select r_no
from RESTAURANT
where r_place = '동대문'
);
	
select * from MENU;
-- 커피 중 '라떼' 종류의 가격을 500원 인상 (우유값이 올라서)
update MENU
set m_price = m_price + 500
where m_name like '%라떼%';
	
select * from MENU;

-----------------------------------------------

-- drop => 테이블, 시퀀스
-- delete => 레코드(데이커, 값) 지울때

-- '라떼' 라는 글자가 들어간 메뉴 다 삭제
delete MENU
where m_name like '%라떼%';

select * from MENU;

-- 강남 스벅 (메뉴 다 삭제)

delete MENU
where m_place = (
select r_no
from RESTAURANT
where r_name = '스타벅스' and r_place = '강남'
);

select * from MENU;

-- 강남 스벅 (폐점)

delete RESTAURANT
where r_name = '스타벅스' and r_place = '강남';

select * from RESTAURANT;

-- '곱창' 들어간 매장의 메뉴 다 삭제
delete MENU
where m_place in (
select r_no
from RESTAURANT
where r_name like '%곱창%'
);
-- in : 서브쿼리 값이 여러개일때
select * from MENU;

