
-------------------------------------멤버 ---------------------------------------
CREATE TABLE "MEMBER" (
   "MEMBER_NO"   NUMBER      NOT NULL,
   "MEMBER_NM"   VARCHAR2(30)      NOT NULL,
   "MEMBER_EMAIL"   VARCHAR2(100)      NOT NULL,
   "MEMBER_NICKNAME"   VARCHAR2(100)      NOT NULL,
   "MEMBER_PW"   VARCHAR2(100)      NOT NULL,
   "MEMBER_TEL"   VARCHAR2(30)      NOT NULL,
   "MEMBER_ADDRESS"   VARCHAR2(500)      NOT NULL,
   "ENROLL_DATE"   DATE   DEFAULT SYSDATE   NOT NULL,
   "SECESSION_FL"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "MEMBER_ADMIN"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "MEMBER_PETSITTER"   CHAR(1)   DEFAULT 'N'   NOT NULL,
   "PROFILE_IMG"   VARCHAR2(4000)      NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_NM" IS '회원이름';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '이메일';

COMMENT ON COLUMN "MEMBER"."MEMBER_NICKNAME" IS '닉네임';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원비밀번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADDRESS" IS '주소';

COMMENT ON COLUMN "MEMBER"."ENROLL_DATE" IS '가입일';

COMMENT ON COLUMN "MEMBER"."SECESSION_FL" IS '탈퇴(N,Y)';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADMIN" IS '관리자(N,Y)';

COMMENT ON COLUMN "MEMBER"."MEMBER_PETSITTER" IS '펫시터(N,Y)';

COMMENT ON COLUMN "MEMBER"."PROFILE_IMG" IS '프로필 이미지';

CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;  

ALTER TABLE MEMBER add ENROLL_DATE DATE DEFAULT SYSDATE NOT NULL ; 

--------------------------------------------------------------------------------

----------------------------------신청 코드 --------------------------------------
CREATE TABLE "APPLICATION_TYPE" (
	"APPLICATION_CD"	NUMBER		NOT NULL,
	"APPLICATION_NM"	VARCHAR2(100)		NOT NULL
);

COMMENT ON COLUMN "APPLICATION_TYPE"."APPLICATION_CD" IS '신청 코드';

COMMENT ON COLUMN "APPLICATION_TYPE"."APPLICATION_NM" IS '신청 이름';


--------------------------------------------------------------------------------

--------------------------------- 신청 ------------------------------------------ 
CREATE TABLE "APPLICATION" (
	"APPLICATION_NO"	NUMBER		NOT NULL,
	"APPLICATION_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"APPLICATION_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"APPLICATION_LOCATION"	VARCHAR2(300)		NULL,
	"APPLICATION_EX"	CHAR(1)		NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"APPLICATION_CD"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "APPLICATION"."APPLICATION_NO" IS '신청 번호(시퀀스)';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_CONTENT" IS '신청 내용';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_DT" IS '신청일';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_LOCATION" IS '신청지역';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_EX" IS '반려경험';

COMMENT ON COLUMN "APPLICATION"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "APPLICATION"."APPLICATION_CD" IS '신청 코드';

--------------------------------------------------------------------------------

----------------------------신청과 신청 코드 연결 ---------------------------------
ALTER TABLE "APPLICATION_TYPE" ADD CONSTRAINT "PK_APPLICATION_TYPE" PRIMARY KEY (
	"APPLICATION_CD"
);

ALTER TABLE "APPLICATION" ADD CONSTRAINT "PK_APPLICATION" PRIMARY KEY (
	"APPLICATION_NO"
);
---------------------------------------------------------------------------------

CREATE SEQUENCE SEQ_APPLICATION_NO NOCACHE;  


INSERT INTO APPLICATION
VALUES (SEQ_APPLICATION_NO.NEXTVAL, '테스트용', SYSDATE, '여긴 지역명', 'O', 5, 1);

ROLLBACK;

-- 회원가입 SQL 구문 
INSERT INTO MEMBER
VALUES (이름, 이메일, 닉네임, 비밀번호, 전화번호, 주소, 탈퇴여부('N'), 관리자여부('N'), 펫시터여부('N'), 프로필이미지(NULL가능));

SELECT APPLICATION_NO, APPLICATION_CONTENT, 
        TO_CHAR(APPLICATION_DT,'YYYY"년"MM"월"DD"일"') APPLICATION_DT, 
        APPLICATION_LOCATION, APPLICATION_EX, MEMBER_NO, APPLICATION_CD, MEMBER_EMAIL
FROM APPLICATION
JOIN MEMBER USING(MEMBER_NO)
WHERE APPLICATION_CD = 1;

INSERT INTO APPLICATION
VALUES (SEQ_APPLICATION_NO.NEXTVAL, '신청 내용이 길면 어떻게 나올지가 너무너무 궁금하구만?', SYSDATE, '서울특별시 송파구' , 'O' , 5 , 1);

COMMIT;
