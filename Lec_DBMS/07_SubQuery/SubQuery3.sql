CREATE TABLE TEST_EMP_A (
	EMP_ID NUMBER,
	EMP_NAME VARCHAR2(100)
);

CREATE TABLE TEST_EMP_B (
	EMP_ID NUMBER,
	EMP_NAME VARCHAR2(100)
);

DELETE FROM TEST_EMP_A;
DELETE FROM TEST_EMP_B;

-- 한 ROW 씩 INSERT
INSERT INTO TEST_EMP_A VALUES(101, '장윤성');
INSERT INTO TEST_EMP_B VALUES(201, '고유성');

SELECT * FROM TEST_EMP_A;
SELECT * FROM TEST_EMP_B;

-- 동시에 여러개 테이블에 INSERT 하기
-- 다중 테이블 INSERT 구문에 SUB QUERY 필요
INSERT ALL
	INTO TEST_EMP_A VALUES(102, '조현주')
	INTO TEST_EMP_B VALUES(202, '최현주')
SELECT * FROM DUAL;

-- SUB QUERT 로 INSERT 기능
INSERT INTO TEST_EMP_A (SELECT 400, '안성원' FROM DUAL);
INSERT INTO TEST_EMP_B (SELECT 400, '김성원' FROM DUAL);

-- 테이블 묻고 더블로
INSERT INTO TEST_EMP_A (SELECT * FROM TEST_EMP_A);
SELECT * FROM TEST_EMP_A;

INSERT INTO TEST_EMP_B(EMP_NAME) (SELECT EMP_NAME FROM TEST_EMP_A);
SELECT * FROM TEST_EMP_B;