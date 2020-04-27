SELECT * FROM t_professor;
SELECT COUNT(*), COUNT(hpage) FROM t_professor; -- 그룹함수에서는 NULL 값은 계산에서 제외
SELECT count(bonus), sum(bonus), avg(bonus) FROM t_professor;
SELECT max(hiredate), min(hiredate) FROM t_emp;

-- null 허용 컬럼의 그룹함수 적용시 
-- nvl, nvl2 사용해야 함
SELECT avg(bonus), avg(nvl(bonus, 0))
FROM t_professor;


-- t_professor 테이블에서 '학과별'로 교수들의 평균 보너스를 출력하세요

-- ★★ 불가능하다!  SELECT 절에 group 함수와 group 함수가 아닌 것과는 같이 출력 불가★★
-- SELECT deptno, avg(bonus)
-- FROM t_professor;

SELECT deptno, round(avg(nvl(bonus, 0)), 1) 보너스평균
FROM t_professor
GROUP BY DEPTNO;

-- #5101
SELECT deptno, POSITION, avg(pay) 평균급여
FROM t_professor
GROUP BY deptno, POSITION  -- 1.학과별 그룹핑,  2.직급별 그룹핑
ORDER BY deptno ASC, POSITION ASC;

 -- 부서별 평균급여를 출력하되, 평균급여가 450 보다 많은 학과만 출력
SELECT deptno, avg(pay) 평균급여
FROM t_professor
WHERE avg(pay) > 450   -- 그룹함수는 WHERE 절에서 사용불가!!!
GROUP BY deptno;

-- HAVING : 그룹함수 결과에 대한 조건절
SELECT deptno, avg(pay) 평균급여
FROM t_professor
GROUP BY deptno
HAVING avg(pay) > 300;

-- <SELECT 쿼리문 순서>
-- SELECT
-- FROM
-- WHERE
-- GROUP BY
-- HAVING
-- ORDER BY

-- #5102
SELECT MGR 매니저,
	COUNT(EMPNO) 직원수,
	SUM(SAL) 급여총액,
	TRUNC(AVG(SAL), 1) 급여평균,
	AVG(NVL(COMM, 0)) 교통비평균
FROM T_EMP
WHERE JOB <> 'PRESIDENT'
GROUP BY MGR;

-- #5103
SELECT DEPTNO,
	COUNT(*) 총인원,
	ROUND(AVG(SYSDATE - HIREDATE), 1) 근속평균,
	AVG(PAY) 급여평균,
	AVG(NVL(BONUS, 0)) 보너스평균
FROM T_PROFESSOR
WHERE POSITION IN ('정교수', '조교수')
GROUP BY DEPTNO;

-- #5104
SELECT DEPTNO1 학과, MAX(WEIGHT) - MIN(WEIGHT) 최대최소몸무게차
FROM T_STUDENT
GROUP BY DEPTNO1;

-- #5105
SELECT DEPTNO1 학과, MAX(WEIGHT) - MIN(WEIGHT) 최대최소몸무게차
FROM T_STUDENT
GROUP BY DEPTNO1
HAVING MAX(WEIGHT) - MIN(WEIGHT) >= 30;




