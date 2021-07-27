create table snack2(
	-- pk 딱히 써먹을게 없을때 no
	s_no number(3) primary key,
	s_name varchar2(10 char)not null,
	s_maker varchar2(10 char)not null,
	s_weight number(5,1)not null,
	s_price number(4)not null,
	s_exp date
);

-- 숫자 자동으로 올리기 : sequence (테이블과 무관) - 오라클 기능
create sequence 시퀀스명;
create sequence snack2_seq;
-- 시퀀스명.nextval로 사용

-- 시퀀스는 실패해도 숫자 올라감. 이상할거 없음
-- 이빨 나가도? 안겹치면 그만
-- 조회 순서 멋대로인거도 이상할거 없음

insert into snack2 values(snack2_seq.nextval,'양파링','농심',50,1500,sysdate);
insert into snack2 values(snack2_seq.nextval,'새우깡','해태',60,1200,sysdate);
insert into snack2 values(snack2_seq.nextval,'감자깡','롯데',70,1300,sysdate);
insert into snack2 values(snack2_seq.nextval,'홈런볼','농심',80,1600,sysdate);
insert into snack2 values(snack2_seq.nextval,'꼬북칩','해태',65,2000,sysdate);
insert into snack2 values(snack2_seq.nextval,'포카칩','농심',75,1400,sysdate);
insert into snack2 values(snack2_seq.nextval,'포스틱','롯데',73,1700,sysdate);
insert into snack2 values(snack2_seq.nextval,'프링글스','농심',85,1900,sysdate);
insert into snack2 values(snack2_seq.nextval,'빼빼로','농심',85,1900,sysdate);
insert into snack2 values(snack2_seq.nextval,'누드빼빼로','농심',85,1900,sysdate);
insert into snack2 values(snack2_seq.nextval,'아몬드빼빼로','농심',85,1900,sysdate);


-- 이제 했던 그 SNACK2 테이블에 데이터를 3~5개 정도 넣어주세요.
select * from snack2;