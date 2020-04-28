-- INITCAP() 함수

-- #4101
SELECT INITCAP('pretty girl')
FROM dual;

-- #4102
SELECT ID, INITCAP(ID) ID 
FROM T_STUDENT
WHERE DEPTNO1 = 201;

-- LOWER(), UPPER()
-- #4103
SELECT NAME, ID, UPPER(ID) 대문자, LOWER(ID) 소문자 
FROM T_STUDENT
WHERE deptno1 = 201;

-- LENGTH / LENGTHB
-- #4104
SELECT NAME, ID, LENGTH(ID) 글자수
FROM T_STUDENT 
WHERE LENGTH(ID) >= 9; -- 단일행 함수는 WHERE 조건절에서 사용 가능!

-- #4105
SELECT NAME, LENGTH(NAME) 길이, LENGTHB(NAME) 바이트
FROM T_STUDENT
WHERE DEPTNO1 = 201;

-- CONCAT() 함수
-- #4106
SELECT CONCAT(NAME, "POSITION") 교수님명단 
FROM T_PROFESSOR
WHERE DEPTNO = 101;

-- SUBSTR() 함수
SELECT SUBSTR('ABCDE', 2, 3) -- 'BCD' 문자열 인덱스 1부터 시작!
FROM DUAL;

SELECT SUBSTR('ABCDE', 20, 3) -- null (에러 아님) 
FROM DUAL;

SELECT SUBSTR('ABCDE', -2, 2) 
FROM DUAL;

-- #4107
SELECT NAME, SUBSTR(JUMIN, 1, 6) 생년월일
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4108
SELECT NAME, SUBSTR(JUMIN, 1, 6) 생년월일 
FROM T_STUDENT 
WHERE SUBSTR(JUMIN, 3, 2) = '08';
-- WHERE JUMIN LIKE '__08%';

-- INSTR() 함수
SELECT INSTR('A*B*C*', '*', 1, 1) FROM dual; -- 2
SELECT INSTR('A*B*C*', '*', 1, 2) FROM dual; -- 4
SELECT INSTR('A*B*C*', '*', 3, 2) FROM dual; -- 6
SELECT INSTR('A*B*C*', '*', -4, 1) FROM dual; -- 2 음수인덱스의 경우 검색도 음의 방향으로 진행 
SELECT INSTR('A*B*C*', '*', -4, 2) FROM dual; -- 0 없으면 0 리턴
SELECT INSTR('A*B*C*', '*', -2, 2) FROM dual; -- 2

-- #4109
-- t_student 테이블
-- 4학년 학생들중 ‘여학생’ 들의 이름과 주민번호 출력 / substr() 사용
SELECT NAME, JUMIN
FROM T_STUDENT 
WHERE GRADE = 4 AND SUBSTR(JUMIN, 7, 1) = '2'; 

-- #4110
-- t_student 테이블의 tel 칼럼을 사용하여
-- 101번 학과(deptno1) 의 학생의 이름과 전화번호, ‘)’ 가 나오는 위치 출력  / instr() 사용
-- SELECT NAME, TEL, INSTR(TEL , ')', 1, 1) AS 위치
SELECT NAME, TEL, INSTR(TEL , ')') AS 위치 -- 3번째 4번째 옵션 디폴트 값은 1 이다.
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- #4111
-- t_student 테이블
-- 1전공이 101 인 학생의 이름과 전화번호, 지역번호를 출력하세요. 지역번호는 숫자만!  / substr(), instr() 사용
SELECT NAME, TEL, SUBSTR(TEL, 1, INSTR(TEL, ')') - 1) 지역번호
FROM T_STUDENT 
WHERE DEPTNO1 = 101;

-- LTRIM(), RTRIM(), TRIM()
SELECT LTRIM('슈퍼슈퍼슈가맨', '슈퍼') LTRIM, 
	   LTRIM('슈퍼슈퍼슈가맨', '슈') LTRIM,
	   LTRIM('   슈퍼슈퍼슈가맨', ' ') LTRIM,
	   LTRIM('   슈퍼슈퍼슈가맨') LTRIM, -- 2번째 옵션 디폴트 값은 ' ' 이다.
	   RTRIM('우측 공백 제거   ') RTRIM,
	   TRIM('   슈가맨   ') TRIM
FROM DUAL; 

-- #4117
SELECT DNAME, RTRIM(DNAME, '부') RTRIM예제 
FROM T_DEPT2;

-- REPLACE 함수
SELECT REPLACE('슈퍼맨 슈퍼걸', '슈퍼', '파워') REPLACE
FROM DUAL;

SELECT REPLACE('아버지가 방에 들어간다', ' ', '')
FROM DUAL;

-- #4118
-- t_student 테이블에서 102번 학과(deptno1) 의 학생들의 이름을 출력하되 
-- 성 부분은 ‘#’  으로 표시되게 출력하세요 / replace() , substr()사용
SELECT name, REPLACE(name, SUBSTR(name, 1, 1), '#') 학생
FROM t_student WHERE deptno1 = 102;

-- #4119
-- t_student 테이블에서 101번 학과(deptno1) 의 학생들의 이름을 출력하되 
-- 가운데 글자만 ‘#’  으로 표시되게 출력하세요 / replace() , substr()사용
SELECT REPLACE(name, substr(name, 2, 1), '#') 학생
FROM t_student WHERE deptno1 = 101;

-- #4120
-- t_student 테이블에서 1전공(deptno1) 이 101번인 학생들의 
-- 이름과 주민등록번호를 출력하되 주민등록번호의 뒤 7자리는 ‘*’ 로 표시되게 출력
SELECT name, REPLACE(jumin, substr(jumin, 7, 7), '*******') 주민번호
FROM t_student WHERE deptno1 = 101;

-- #4121
-- t_student 테이블에서 다음 과 같이 1전공(deptno1) 이 102번인 학생들의 
-- 이름(name) 과 전화번호(tel), 
-- 전화번호에서 국번 부분만 ‘#’ 처리하여 출력하세요.  
-- 단 모든 국번은 3자리로 간주합니다.
-- 힌트) replace() / substr() / instr() 사용
SELECT name, tel, REPLACE(tel, SUBSTR(tel, INSTR(tel, ')') + 1, 3), '###') 전화번호
FROM t_student WHERE deptno1 = 102;