-- 회원가입 SQL 구문 
INSERT INTO MEMBER
VALUES (이름, 이메일, 닉네임, 비밀번호, 전화번호, 주소, 탈퇴여부('N'), 관리자여부('N'), 펫시터여부('N'), 프로필이미지(NULL가능));

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

commit;


DROP TABLE MEMBER;


ALTER TABLE MEMBER add ENROLL_DATE DATE DEFAULT SYSDATE NOT NULL ; 

COMMIT;


SELECT COUNT(*)
		FROM "MEMBER"
		WHERE MEMBER_NM = 'dydgur'
		AND MEMBER_TEL = '123123';

