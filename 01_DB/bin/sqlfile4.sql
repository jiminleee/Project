-- select


select * from snack2;

-- 전체 과자 이름, 가격, 무게
select s_name,s_price,s_weight from snack2;

-- 전체 과자 이름, 제조사,가격 ,유통기한
select s_name,s_maker,s_price,s_exp from snack2;

-- 필드명이 맘에 안들면 as xx 해서 바꿀 수 있다.
select s_name,s_maker as jejosa,s_price,s_exp from snack2;


-- 다시 과자 이름, 가격
select s_name,s_price from snack2;

-- 이상태에서 부과세를 하고싶음
select s_name,s_price, s_price * 0.1 as s_vat from snack2;

-- test
-- 전체 과자 이름, 제조사, 가격, g당 얼마(s_g)
--						hint - (먼저 그람당 저걸 어떻게 게산하는지 알아야)
select s_name,s_maker,s_price,round(s_price/s_weight) as s_g 
from snack2;

-- 전체 과자 평균 가격?
-- 지금까지는 레고드(행) 게산인데
-- 이건 열이 필요
-- 오라클에 *통계함수*가 있음 : max,min,sum,avg,count,... 

select avg(s_price) from snack2;

-- 최저가 
select min(s_price) from snack2;

-- aaaaaa

-- 유통기한 제일 오래남은게 언제?
select max(s_exp) from snack2;


-- 과자가 총 몇개 : count 레코드 줄을 세는 특성상 뭘써도 똑같음
select count(s_no) from snack2;

select count(*) from snack2;

-- 전체 과자 이름, 회사명, 가격만
-- 과자 이름이 홈런볼 인거(조건)
select s_name,s_maker,s_price
from snack2
where s_name = '홈런볼';

-- 농심 과자 이름, 회사명, 가격
select s_name,s_maker,s_price
from snack2
where s_maker = '농심';

-- 농심 과자 평균가
select avg(s_price)
from snack2
where s_maker = '농심';

-- 먹으면 안되는(유통기한 지난) 과자의 이름, 회사명, 가격
select s_name,s_maker,s_price
from snack2
where s_exp < sysdate;

-- '%ㅋ' : ㅋ으로 끝나는거
-- 'ㅋ%' : ㅋ으로 시작하는거
-- '%ㅋ%' : ㅋ이 있는거

-- 깡 으로 끝나는 시리즈 과자 이름, 회사명, 가격
select s_name,s_maker,s_price
from snack2
where s_name like '깡%';

--  test
-- 빼빼로 시리즈의 과자 이름, 가격
select s_name,s_price
from snack2
where s_name like '%빼빼로';

-- 깡 시리즈 중 최고가
select max(s_price)
from snack2
where s_name like '%깡';

-- 제일 비싼 과자(이름,제조사,가격) 출력
select s_name,s_maker,s_price
from snack2
where s_price = max(s_price);
-- 잘 한거임, 나쁜생각 아닌데 안됨. 문법
---------------------------------------
--  subquery ( 쿼리 속 쿼리 )

-- 제일 비싼
select max(s_price)
from snack2;

-- 제일 비싼 과자(이름, 제조사, 가격)
select s_name,s_maker,s_price
from snack2
where s_price = (select max(s_price)
from snack2);

-- 평균가 보다 비싼 과자(이름, 가격)
select avg(s_price)
from snack2;

select s_name,s_price
from snack2
where s_price > (select avg(s_price)
from snack2);

-- 제일 가벼운 과자(이름, 가격, 제조사)
select min(s_weight)
from snack2;

select s_name,s_price,s_maker
from snack2
where s_weight = (select min(s_weight)
from snack2);

-- 농심 과자의 평균가보다 비싼 과자 정보 전체
select avg(s_price)
from snack2
where s_maker = '농심';

select * from snack2
where s_price > (select avg(s_price)
from snack2
where s_maker = '농심');

-- 농심, 해태 과자 정보 전체
select * from snack2
where s_maker = '농심'or s_maker ='해태';
 
-- 1000 < 가격 < 2000인 과자 정보 전체
select * from snack2
where 1000 < s_price and s_price < 2000;

--------------------------------------------
-- 정렬 order by 컬럼      desc(역순)

-- 농심과자 전체 이름순으로 정렬
select * from snack2
where s_maker = '농심'
order by s_name desc;

-- 과자 전체 정보를 가격순(오름차순)
select * from snack2
order by s_price,s_name;

-- 2000원 전재산
-- 내가 사먹을 수 있는 리스트
-- 유통기한이 짧은걸 위로
select * from snack2
where s_price <= 2000
order by s_exp;








