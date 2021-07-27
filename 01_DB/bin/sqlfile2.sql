create table snack(
	s_no number(3) primary key,
	s_name varchar2(10 char)not null,
	s_maker varchar2(10 char)not null,
	s_weight number(5,1)not null,
	s_price number(4)not null,
	s_exp date
);

-- sysdate : 현재 시간 날짜 (자바 : date)
insert into snack values (1, '양파링', '농심',60,1000,sysdate);
insert into snack values (2, '꽃게랑', '해태',70,1200,sysdate);

-- 특정 시간 날짜 :
-- to_date('값','패턴')
-- 			   'YYYY MM DD HH:MI:SS'
-- 			   'YYYY MM DD PM HH:MI:SS'

insert into snack values (3,'꼬깔콘','롯데',70.5,1300,to_date('2021-08-10','YYYY-MM-DD'));

select * from snack;

drop table snack cascade constraint purge;
