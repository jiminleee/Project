-- 주석
-- 여러줄 블록지정 -> alt + x
-- 한줄 실행 : 그 줄에 커서 놓고 -> alt + s

-- 테이블 생성
create table product(
p_name varchar2(10 char),
p_age number(4)
);
-- 테이블 삽입
insert into PRODUCT values('볼펜',1000);
insert into PRODUCT values('볼펜2',2000);
-- 조회
select * from PRODUCT;
-- 테이블 삭제
drop table product cascade constraint purge;
-----------------------------------------------
-- 행, row, 행 하나가 데이터 1개. record 라고 함.
-- 열, field, 속성, colum
-- oracle 대/소문자 구분x 다 대문자

-- DBA : 서버전원관리, 백업/복구, 계정관리

-- DBP : CRUD (우리의목표)(Create Read Update Delete)

-- SQL (Structured Query Language) : DB를 제어하는 언어
	-- 다른 메이커 DB, 98.99%비슷
	-- ; 문장 끝
----------------------------------------------
-- 1)테이블 만들기

create table student(
	s_name varchar2(10 char),
	s_age number(3),
	s_kor number(3),
	s_eng number(3),
	s_jp number(3)
);

-- 2) 데이터 넣기 -C (CRUD)
insert into student(s_name,s_age,s_kor,s_engs_jp)
values ('선진',20,100,100,100);

insert into student(s_name,s_age)
values ('최선진',30);

select * from student;
-- 안쓴건? 이빨빠져있다 => Null
-- 필드 순서를 왜 바꾸는지, 데이터 안넣어서 null로 둬서 어쩔껀지
-- 0점이면 0점인거지 비워두면(null) 나중에 계산같은거 할때 골치아픔
-- 그래서 테이블을 만들때 옵션을 쓸 수 있음.

create table student2(
	s_no number(2) primary key,	
	s_name varchar2(10 char) not null,
	s_age number(3)not null,
	s_kor number(3)not null,
	s_eng number(3)not null,
	s_jp number(3)not null
);

-- 옵션
-- not null : 사실상 기본, 필수
-- primary key : not null + 중복불허
--  그 테이블을 대표하는 값 => 테이블 하나에 pk하나 있는게 좋음
-- id가 mz ->혼자

-- 사실상 이렇게 사용
insert into student2 values(3,'선진선진',20,100,100,100)
insert into student2 values(4,'선진선진',20,100,100)

-- 3) 조회 - R (CRUD)
select * from STUDENT2;

select 필드명, 필드명,...
from 테이블명;

-- student2 테이블의 학생 이름들
select s_name from STUDENT2;
-- student2 테이블의 학생 이름,나이,일어점수
select s_name,s_age,s_jp from STUDENT2;

--  4) 데이터 수정 U (CRUD)
-- 2번 학생의 이름을 '수민'으로 수정
update STUDENT2
set s_name ='수민'
where s_no = 2;

-- 3번 학생 삭제(구글링)
delete from STUDENT2
where s_no = 3;

-- 5) 테이블 삭제 (실행은 하지말고 써놓기만)
drop table student2 --이렇게만 하면 찌꺼기(휴지통) 남음. 용량 먹음 
					-- 휴지통에 안넣고, 테이블에 걸린 각종 규제들 같이 삭제
cascade constraint purge;