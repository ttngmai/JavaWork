-- JOIN

-- FROM 절에 테이블에도 별칭 (alias)를 줄 수 있다!

-- 20 레코드
SELECT S.STUDNO, S.NAME, S.DEPTNO1
FROM T_STUDENT S;

-- 12 레코드
SELECT D.DEPTNO, D.DNAME
FROM T_DEPARTMENT D;

-- 카티션곱 (Cartesian Product)
-- 두개의 테이블을 JOIN 하게 되면, 
-- 각 테이블의 레코드들의 모든 조합이 출력된다.
-- WHERE 나 ON 등으로 JOIN 조건이 주어지지 않으면 
-- 모든 카티션곱이 출력된다. 

-- 240 개
SELECT S.STUDNO, S.NAME, S.DEPTNO1,
	D.DEPTNO, D.DNAME
FROM T_STUDENT S, T_DEPARTMENT D;

SELECT S.STUDNO, S.NAME, S.DEPTNO1,
	D.DEPTNO, D.DNAME
FROM T_STUDENT S
	CROSS JOIN T_DEPARTMENT D; -- ANSI 방식

-- # 6101
-- Equi 조인 (등가 Join)
-- Oracle Join 방식
SELECT S.NAME "학생이름", S.DEPTNO1 "학과번호", D.DNAME "학과이름"
FROM T_STUDENT S, T_DEPARTMENT D
WHERE S.DEPTNO1 = D.DEPTNO; -- 조건 (Equi JOIN)

-- ANSI 방식
SELECT S.NAME "학생이름", S.DEPTNO1 "학과번호", D.DNAME "학과이름"
FROM T_STUDENT S JOIN T_DEPARTMENT D
ON S.DEPTNO1 = D.DEPTNO; -- 조건 (Equi JOIN)

SELECT * FROM T_STUDENT;

-- 제2전공은? deptno2
SELECT S.NAME "학생이름", S.DEPTNO2 "제2학과", D.DNAME "제2학과이름"
FROM T_STUDENT S, T_DEPARTMENT D
WHERE S.DEPTNO2 = D.DEPTNO; 

-- #6102
SELECT S.NAME 학생이름, S.PROFNO 지도교수, P.NAME 지도교수이름 
FROM T_STUDENT S, T_PROFESSOR P
WHERE S.PROFNO = P.PROFNO;

SELECT S.NAME 학생이름, S.PROFNO 지도교수, P.NAME 지도교수이름 
FROM T_STUDENT S JOIN T_PROFESSOR P
ON S.PROFNO = P.PROFNO;

-- #6103
SELECT S.NAME "학생이름", D.DNAME "학과이름", P.NAME "교수이름"
FROM T_STUDENT S, T_DEPARTMENT D, T_PROFESSOR P
WHERE S.DEPTNO1 = D.DEPTNO AND S.PROFNO = P.PROFNO;

SELECT S.NAME "학생이름", D.DNAME "학과이름", P.NAME "교수이름"
FROM T_STUDENT S 
	JOIN T_DEPARTMENT D ON S.DEPTNO1  = D.DEPTNO 
	JOIN T_PROFESSOR P ON S.PROFNO = P.PROFNO;

-- #6104
SELECT * FROM T_EMP2;
SELECT * FROM T_POST;

SELECT E.NAME 사원이름,
	E.POST 직급,
	E.PAY 현재연봉,
	P.S_PAY 하안금액,
	P.E_PAY 상한금액
FROM T_EMP2 E, T_POST P
WHERE E.POST = P.POST;

SELECT E.NAME 사원이름,
	E.POST 직급,
	E.PAY 현재연봉,
	P.S_PAY 하안금액,
	P.E_PAY 상한금액
FROM T_EMP2 E JOIN T_POST P ON E.POST = P.POST;

-- #6105
SELECT  S.NAME "학생이름", P.NAME "교수이름"
FROM T_STUDENT S, T_PROFESSOR P
WHERE 
	S.PROFNO = P.PROFNO   -- join 조건 
	AND S.DEPTNO1  = 101; -- 검색 조건
	
SELECT  S.NAME "학생이름", P.NAME "교수이름"
FROM T_STUDENT S JOIN T_PROFESSOR P ON S.PROFNO = P.PROFNO -- join 조건 
WHERE S.DEPTNO1  = 101; -- 검색 조건
