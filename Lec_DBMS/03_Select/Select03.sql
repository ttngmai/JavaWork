-- DB03
-- p25 ~ p27 12개 SELECT 쿼리

-- t_student 테이블에서 키(height)가 180 보다 크거나 같은 사람 이름, 키 출력
SELECT *
FROM T_STUDENT
WHERE HEIGHT >= 180;

-- t_student 테이블에서 몸무게(weight)가 
-- 60~80 인 사람의 이름과 체중 출력
SELECT NAME, WEIGHT
FROM T_STUDENT
WHERE WEIGHT BETWEEN 60 AND 80;

-- t_student 테이블에서는 제1전공이 101번 학과(deptno1) 학생과 201번 학과 학생들을 모두 출력하세요 (in 연산자 활용)
SELECT * 
FROM T_STUDENT
WHERE DEPTNO1 IN (101, 201);

-- LIKE 연산자 사용:  
-- t_student 테이블에서 성이 ‘김’ 씨인 사람 조회
SELECT *
FROM T_STUDENT
WHERE NAME LIKE '김%';

-- t_student 테이블에서 4학년 학생중에 키 가 170cm 이상인 사람의 
-- '이름'과 '학년'과 '키'를 조회하세요
SELECT NAME, GRADE, HEIGHT
FROM T_STUDENT 
WHERE GRADE = 4 AND HEIGHT >= 170;

-- t_student 테이블에서 1학년이거나 또는 몸무게가 80kg 이상인 학생들의 
-- '이름'과 '키'와 '학년'과 '몸무게'를 출력하세요
SELECT NAME, HEIGHT, GRADE, WEIGHT
FROM T_STUDENT 
WHERE GRADE = 1 OR WEIGHT >= 80;

-- t_student 테이블을 사용해서 2학년 중에서 키가 180cm 보다 크면서 
-- 몸무게가 70kg 보다 큰 학생들의 
-- 이름과 학년과 키와 몸무게를 출력하세요
SELECT NAME, GRADE, HEIGHT, WEIGHT
FROM T_STUDENT
WHERE GRADE = 2 AND HEIGHT > 180 AND WEIGHT > 70;

-- t_student 테이블: 2학년 학생중에서 키가 180cm보다 크거나 
-- 또는 몸무게가 70kg 보다 큰 학생들의 
-- 이름과 학년과 키와 몸무게를 출력하세요
SELECT NAME, GRADE, HEIGHT, WEIGHT
FROM T_STUDENT 
WHERE GRADE = 2 AND (HEIGHT > 180 OR WEIGHT > 70);

-- t_emp 테이블에서 고용일(hiredate)이 1992년 이전인 사람들의 
-- 이름(ename) 과 고용일을 출력하세요
SELECT ENAME, HIREDATE 
FROM T_EMP 
WHERE HIREDATE < '1993-01-01';

-- t_student 테이블: 1학년 학생의 이름과 생일과 키와 몸무게를 출력하세요, 
-- 단 생일이 빠른 사람 순서대로 정렬하세요.
SELECT NAME, BIRTHDAY, HEIGHT, WEIGHT 
FROM T_STUDENT 
WHERE GRADE = 1
ORDER BY BIRTHDAY;

-- student 테이블: 1학년 학생의 이름과 키를 출력하세요, 
-- 별명은 ‘이름’, ‘키’ 로 출력.  
-- 단 이름은 오름차순으로 정렬하세요
SELECT NAME 이름, HEIGHT 키
FROM T_STUDENT 
WHERE GRADE = 1
ORDER BY NAME;

-- t_emp2 직원 테이블에서
-- 생일(birthday) 가 1980년대생인 사람들의 이름과 생일만 출력하세요
-- 즉 1980/01/01 ~ 1989/12/31
SELECT NAME, BIRTHDAY 
FROM T_EMP2
WHERE BIRTHDAY BETWEEN '1980-01-01' AND '1989-12-31';