SELECT * FROM
(SELECT Rownum AS rnum, t.* FROM (SELECT * from test_write ORDER BY wr_UID DESC) T)
WHERE RNUM >= 1 AND RNUM < 10;

SELECT 
	wr_uid "uid",
	wr_subject subject,
	wr_content content,
	wr_name name,
	wr_viewcnt viewcnt,
	wr_regdate regdate
FROM 
	test_write
ORDER BY 
	wr_uid DESC;

SELECT 
	rnum,
	wr_uid "uid",
	wr_subject subject,
	wr_content content,
	wr_name name,
	wr_viewcnt viewcnt,
	wr_regdate regdate
FROM
	(SELECT Rownum AS rnum, t.* FROM (SELECT * from test_write ORDER BY wr_UID DESC) T)
	WHERE RNUM >= 1 AND RNUM <= 700;

DELETE FROM
	test_write
WHERE
	wr_uid IN (689, 688);
