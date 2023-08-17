-- <JOIN함수 예제>
-- 1. DEPT 테이블과 EMP 테이블에서 사번, 사원명, 부서코드, 부서명을 검색하시오. (사원명 오름차순 정렬)
SELECT EMP_ID 사번, EMP_NAME 사원명, DEPT_CODE 부서코드, DEPT_TITLE 부서명 
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
ORDER BY EMP_ID ASC; -- 사원명 기준 오름차순 

-- 2. DEPT 테이블과 EMP 테이블에서 사번, 사원명, 급여, 부서명을 검색하시오. 단, 급여가 2000 이상인 사원에 대하여 급여기준으로 내림차순 정렬할 것.
SELECT EMP_ID 사번, EMP_NAME 사원명, SALARY 급여, DEPT_TITLE 부서명
FROM EMPLOYEE
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE SALARY >= 2000 -- 단, 급여가 2000이상인 사원
ORDER BY SALARY DESC; -- 급여 기준 내림차순 

-- 3. JOB 테이블과 DEPT 테이블과 EMP 테이블에서 사번, 사원명, 직급명, 급여, 부서명을 검색하시오. 단, 직급이 대리이며 급여가 2500 이상인 사원에 대해, 사번을 기준으로 오름차순 정렬할 것.
SELECT EMP_ID 사번, EMP_NAME 사원명, JOB_NAME 직급명, SALARY 급여, DEPT_TITLE
FROM EMPLOYEE
JOIN JOB USING(JOB_CODE)
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
WHERE JOB_NAME = '대리'
AND SALARY >= 2500
ORDER BY EMP_ID;

-- 4. EMP 테이블과 SALGRADE 테이블에서 사번, 사원명, 급여, 급여등급을 검색하시오. 단, 급여등급은 급여가 S2과 S4 범위에 포함되고 급여를 기준으로 내림차순 정렬할 것.
SELECT EMP_ID 사번, EMP_NAME 사원명, SALARY 급여, SAL_LEVEL 급여등급
FROM EMPLOYEE
WHERE SAL_LEVEL BETWEEN 'S2' AND 'S4'
ORDER BY SALARY DESC;

-- 5. DEPT 테이블, EMP 테이블, SALGRADE 테이블에서 사번, 사원명, 부서명, 급여, 급여등급 을 검색하시오. 단, 급여등급은 등급별 최고급여가 550만원 이하 이며 등급을 기준으로 내림차순 정렬할 것.
SELECT EMP_ID 사번, EMP_NAME 사원명, DEPT_CODE 부서명, SALARY 급여, SAL_LEVEL 급여등급
FROM EMPLOYEE
JOIN SAL_GRADE USING (SAL_LEVEL)
WHERE MAX_SAL <= 5500000
ORDER BY SAL_LEVEL DESC;

-- <서브쿼리 예제>

-- 1. EMP 테이블에서 유재식 보다 급여가 많은 사원들의 사번, 이름, 급여를 검색하시오.
SELECT EMP_ID 사번, EMP_NAME 이름, SALARY 급여
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '유재식');

-- 확인용
SELECT * FROM EMPLOYEE
ORDER BY SALARY DESC;

-- 2. EMP 테이블에서 하이유 보다 늦게 입사한 사원의 사번, 이름, 입사일을 검색하시오.
SELECT EMP_ID 사번, EMP_NAME 이름, TO_CHAR(HIRE_DATE,'YYYYMMDD') 입사일
FROM EMPLOYEE
WHERE SUBSTR(HIRE_DATE,1,4) > (SELECT SUBSTR(HIRE_DATE,1,4) FROM EMPLOYEE WHERE EMP_NAME = '하이유');

-- 확인용
SELECT EMP_NAME , HIRE_DATE
FROM EMPLOYEE
ORDER BY HIRE_DATE DESC;
-- 3. EMP 테이블에서 사원 전체 평균 급여보다 급여가 많은 사원들의 사번, 이름, 급여를 검색하시오.
SELECT EMP_ID 사번, EMP_NAME 이름, SALARY 급여
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 확인용
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
ORDER BY SALARY DESC;
-- 4. EMP 테이블에서 사번이 215인 직원의 급여보다 많은 급여를 받는 사원들의 사번, 이름, 급여를 검색하시오.
SELECT EMP_ID 사번, EMP_NAME 이름, SALARY 급여
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY 
                FROM EMPLOYEE 
                WHERE EMP_ID = '215');

CREATE TABLE JOB2 AS SELECT * FROM JOB;

SELECT * FROM JOB2; -- JOB2 테이블에 JOB에 있던 모든 컬럼값 들어 갔는지 확인

INSERT INTO JOB2 VALUES('J0', '이사');

SELECT * FROM JOB2; -- JOB2 테이블에 'J0','이사'가 INSERT 됬는지 확인

SELECT JOB_CODE 
FROM JOB2 
WHERE JOB_NAME = '이사';

DROP TABLE JOB2; -- TABLE이 삭제 되었는지 확인

ROLLBACK;

SELECT * FROM JOB2; -- ROLLBACK을 헀더니 추가했던 'J0', '이사'가 없어졌다.

INSERT INTO JOB2 (JOB_CODE) VALUES ('J8');

SELECT * FROM JOB2; -- 'J8'만 집어넣었더니 JOB_NAME엔 NULL이 들어감
                    -- 선택 안된 컬럼엔 NULL이 들어감 
                    -- JOB_NAME에 값을 넣고 싶었지만 제약조건에 NOT NULL 존재

--DEPARTMENT2 테이블에서 DEPT_ID가 'D3'인 부서 정보 조회
SELECT * FROM DEPARTMENT2
WHERE DEPT_ID = 'D3'; 

-- DEPARTMENT2 테이블에서 DEPT_ID가 'D3'인 행의 DEPT_TITLE을 '홍보부'로 수정
UPDATE DEPARTMENT2
SET DEPT_TITLE = '홍보부'
WHERE DEPT_ID = 'D3';

-- UPDATE 확인
SELECT * FROM DEPARTMENT2;

UPDATE DEPARTMENT2
SET DEPT_ID = 'D0',
DEPT_TITLE = '홍보부'
WHERE DEPT_ID = 'D3'
AND DEPT_TITLE = '마케팅부';

ROLLBACK;
-- 인사관리부가 해체되고 그 부서를 총무부 2팀으로 변경하기로 했다.(서브쿼리 사용)
SELECT DEPT_TITLE
FROM DEPARTMENT2
WHERE DEPT_TITLE = '인사관리부';

SELECT DEPT_ID 
FROM DEPARTMENT2
WHERE DEPT_ID = 'D1';

UPDATE DEPARTMENT2
SET DEPT_TITLE = '총무부 2팀',
DEPT_ID = 'D1'
WHERE DEPT_TITLE = (SELECT DEPT_TITLE FROM DEPARTMENT2 WHERE DEPT_TITLE = '인사관리부') 
AND DEPT_ID = (SELECT DEPT_ID FROM DEPARTMENT2 WHERE DEPT_ID = 'D1');

-- 변경 확인
SELECT * FROM DEPARTMENT2;

ROLLBACK;

-- 코로나로 인해 해외영업을 할 수 없게되어 해외영업 부서들이 국내영업부로 바뀜

SELECT * FROM DEPARTMENT2
WHERE DEPT_TITLE IN ('해외영업1부', '해외영업2부', '해외영업3부');

UPDATE DEPARTMENT2
SET DEPT_TITLE = '국내영업최강부'
WHERE DEPT_TITLE IN ('해외영업1부', '해외영업2부', '해외영업3부');

-- 변경 확인
SELECT * FROM DEPARTMENT2;

-- 아시아지역에 근무하는 직원의 보너스를 0.3으로 변경

-- 1) 아시아 지역에 근무하는 직원
-- EMPLOYEE2, DEPARTMENT, LOCATION
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, LOCAL_NAME, BONUS 
FROM EMPLOYEE2 
JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
WHERE LOCAL_NAME LIKE 'A%';
-- 2) 아시아 지역 근무 직원 보너스 0.5으로 변경
UPDATE EMPLOYEE2
SET BONUS = '0.5'
WHERE EMP_ID  IN (SELECT EMP_ID
                FROM EMPLOYEE2
                JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
                JOIN LOCATION ON (LOCATION_ID = LOCAL_CODE)
                WHERE LOCAL_NAME LIKE 'A%');

ROLLBACK;

SELECT * FROM EMPLOYEE2 WHERE EMP_NAME = '선동일';

DELETE FROM EMPLOYEE2
WHERE EMP_NAME = '선동일';

SELECT * FROM EMPLOYEE2;

ROLLBACK;

-- SQL 구문 작성 형식을 예전(11g) 오라클 SQL 형식을 사용하도록 변경
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER cyh_sample IDENTIFIED BY sample1234;
-- User CYH_SAMPLE이(가) 생성되었습니다.

GRANT CREATE SESSION TO cyh_sample; -- 접속 권한 부여

CREATE TABLE TB_TEST( -- cyh_sample 계정으로 해야한다. -- 근데 바로하면 오류 
                                                    --          왜? 아직 테이블을 만들 수 있는 권한이 없으니까~~
                                                    
    TEST_PK NUMBER PRIMARY KEY, -- PRIMARY KEY의 특징 NOT NULL + UNIQUE(중복불가) 
    TEST_CONTEST VARCHAR2(100)
);
DROP TABLE TB_TEST; -- 실수로 sys관리자계정으로 실행시켜서 테이블 지움 

-- 테이블 생성 권한이 없음
-- 권한 주자 꼭 !! 관리자 계정으로 줘야한다 !!
GRANT CREATE TABLE TO cyh_sample;
-- 권한 주고 테이블 생성 성공
-- 그러나 테이블에 객체 생성 공간을 할당해야 함 
-- !! 관리자 계정으로 할당하자 !!
ALTER USER cyh_sample DEFAULT TABLESPACE SYSTEM QUOTA UNLIMITED ON SYSTEM;

-- ROLE : 권한의 묶음으로 ROLE을 사용하면 한번에 많은 권한을 부여하거나 회수할 수 있다.
-- [sys 관리자 계정]

-- CONNECT : DB 접속 권한 
--> 담고 있는건 1개지만 의미적으로 쉽게 사용하기 위해서 사용한다?? 뭔말이야 이게;
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'CONNECT';

-- RESOURCE : DB 사용을 위한 기본 객체 생성 권한 묶음
SELECT * FROM ROLE_SYS_PRIVS
WHERE ROLE = 'RESOURCE';

--ROLE을 이용해서 샘플 계정에 권한 부여 해보자
GRANT CONNECT, RESOURCE TO cyh_sample;

--- 1. [샘플 계정] cyh계정의 DEPARTMENT 테이블 조회
SELECT * FROM cyh.DEPARTMENT;
-- 2. [이니셜 계정] 샘플 계정에 DEPARTMENT 테이블 조회 권한 부여
GRANT SELECT ON DEPARTMENT TO cyh_sample;
-- 3. [샘플 계정] 다시 DEPARTMENT 테이블 조회
SELECT * FROM cyh.DEPARTMENT;
-- 4. [이니셜 계정] 부여했던 SELECT 권한 회수 
REVOKE SELECT ON DEPARTMENT FROM cyh_sample;

