DROP TABLE "MEMBER";

CREATE TABLE "MEMBER" (
	"MEMBER_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"MEMBER_ID"	VARCHAR2(50)		NOT NULL,
	"MEMBER_PW"	VARCHAR2(100)		NOT NULL,
	"MEMBER_NM"	VARCHAR2(30)		NOT NULL,
	"MEMBER_PNO"	VARCHAR2(30)		NOT NULL,
	"MEMBER_TEL"	VARCHAR2(30)		NOT NULL,
	"MEMBER_EMAIL"	VARCHAR2(50)		NOT NULL,
	"MEMBER_ADD"	VARCHAR2(300)		NOT NULL,
	"SECESSION_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_ADMIN"	CHAR(1)	DEFAULT 'N'	NOT NULL
);

COMMENT ON COLUMN "MEMBER"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_ID" IS '회원아이디';

COMMENT ON COLUMN "MEMBER"."MEMBER_PW" IS '회원비밀번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_NM" IS '회원이름';

COMMENT ON COLUMN "MEMBER"."MEMBER_PNO" IS '주민등록번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_TEL" IS '전화번호';

COMMENT ON COLUMN "MEMBER"."MEMBER_EMAIL" IS '이메일';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADD" IS '주소';

COMMENT ON COLUMN "MEMBER"."SECESSION_FL" IS '탈퇴Y''회원N';

COMMENT ON COLUMN "MEMBER"."MEMBER_ADMIN" IS '관리자Y''회원N';

DROP TABLE "RESERVATION";

CREATE TABLE "RESERVATION" (
	"BOOK_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"CHECKIN_DT"	DATE		NOT NULL,
	"CHECKOUT_DT"	DATE		NOT NULL,
	"BOOK_PERSON"	NUMBER	DEFAULT 0	NOT NULL,
	"CHECK_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"ROOM_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "RESERVATION"."BOOK_NO" IS '예약번호(시퀀스)';

COMMENT ON COLUMN "RESERVATION"."CHECKIN_DT" IS '체크인 날짜';

COMMENT ON COLUMN "RESERVATION"."CHECKOUT_DT" IS '체크아웃 날짜';

COMMENT ON COLUMN "RESERVATION"."BOOK_PERSON" IS '인원';

COMMENT ON COLUMN "RESERVATION"."CHECK_FL" IS '체크인 여부';

COMMENT ON COLUMN "RESERVATION"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "RESERVATION"."ROOM_NO" IS '객실 번호(시퀀스)';

DROP TABLE "ROOM";

CREATE TABLE "ROOM" (
	"ROOM_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"ROOM_NM"	VARCHAR2(30)		NOT NULL,
	"ROOM_PRICE"	NUMBER		NOT NULL,
	"ROOM_IMG"	VARCHAR2(4000)		NOT NULL,
	"ROOM_INFO"	VARCHAR2(4000)		NOT NULL,
	"ROOM_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"HOTEL_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "ROOM"."ROOM_NO" IS '객실 번호(시퀀스)';

COMMENT ON COLUMN "ROOM"."ROOM_NM" IS '객실명';

COMMENT ON COLUMN "ROOM"."ROOM_PRICE" IS '객실 가격';

COMMENT ON COLUMN "ROOM"."ROOM_IMG" IS '객실 사진';

COMMENT ON COLUMN "ROOM"."ROOM_INFO" IS '객실 소개';

COMMENT ON COLUMN "ROOM"."ROOM_FL" IS '객실 예약 여부';

COMMENT ON COLUMN "ROOM"."HOTEL_NO" IS '호텔번호';

DROP TABLE "BOARD";

CREATE TABLE "BOARD" (
	"BOARD_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"BOARD_TITLE"	VARCHAR2(150)		NOT NULL,
	"BOARD_CONTENT"	VARCHAR2(4000)		NOT NULL,
	"BOARD_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"BOARD_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
    "REVIEW_STAR"	NUMBER		NOT NULL,
	"BOARD_CD"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "BOARD"."BOARD_NO" IS '게시글번호(시퀀스)';

COMMENT ON COLUMN "BOARD"."BOARD_TITLE" IS '게시글제목';

COMMENT ON COLUMN "BOARD"."BOARD_CONTENT" IS '게시글내용';

COMMENT ON COLUMN "BOARD"."BOARD_DT" IS '작성일';

COMMENT ON COLUMN "BOARD"."BOARD_ST" IS '게시글상태(정상N,삭제Y)';

COMMENT ON COLUMN "BOARD"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "BOARD"."REVIEW_STAR" IS '별점';

DROP TABLE "BOARD_TYPE";

CREATE TABLE "BOARD_TYPE" (
	"BOARD_CD"	NUMBER	PRIMARY KEY	NOT NULL,
	"BOARD_NM"	VARCHAR2(100)		NOT NULL
);

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_CD" IS '게시판 코드';

COMMENT ON COLUMN "BOARD_TYPE"."BOARD_NM" IS '게시판 이름';

DROP TABLE "EVENT";

CREATE TABLE "EVENT" (
	"EVENT_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"EVENT_TITLE"	VARCHAR2(100)		NOT NULL,
	"EVENT_CONTENT"	VARCHAR2(100)		NULL,
	"EVENT_IMG"	VARCHAR2(4000)		NOT NULL,
	"EVENT_ST"	CHAR(1)	DEFAULT 'Y'	NOT NULL,
	"BINGO_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"UPDOWN_FL"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "EVENT"."EVENT_NO" IS '이벤트 번호 (시퀀스)';

COMMENT ON COLUMN "EVENT"."EVENT_TITLE" IS '이벤트 제목';

COMMENT ON COLUMN "EVENT"."EVENT_CONTENT" IS '이벤트 내용';

COMMENT ON COLUMN "EVENT"."EVENT_IMG" IS '이벤트 사진';

COMMENT ON COLUMN "EVENT"."EVENT_ST" IS '진행Y''종료N';

COMMENT ON COLUMN "EVENT"."BINGO_FL" IS '빙고참여여부';

COMMENT ON COLUMN "EVENT"."UPDOWN_FL" IS '업다운참여여부';

COMMENT ON COLUMN "EVENT"."MEMBER_NO" IS '회원번호';

DROP TABLE "REPLY";

CREATE TABLE "REPLY" (
	"REPLY_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"REPLY_CONTENT"	VARCHAR2(1000)		NOT NULL,
	"CREATE_DT"	DATE	DEFAULT SYSDATE	NOT NULL,
	"REPLY_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "REPLY"."REPLY_NO" IS '댓글 번호(시퀀스)';

COMMENT ON COLUMN "REPLY"."REPLY_CONTENT" IS '댓글 내용';

COMMENT ON COLUMN "REPLY"."CREATE_DT" IS '댓글 작성일';

COMMENT ON COLUMN "REPLY"."REPLY_ST" IS '댓글 상태';

COMMENT ON COLUMN "REPLY"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "REPLY"."BOARD_NO" IS '게시글번호(시퀀스)';

DROP TABLE "LIKELIST";

CREATE TABLE "LIKELIST" (
	"ROOM_NO"	NUMBER		NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "LIKELIST"."ROOM_NO" IS '객실 번호(시퀀스)';

COMMENT ON COLUMN "LIKELIST"."MEMBER_NO" IS '회원번호';

DROP TABLE "CALCULATE";

CREATE TABLE "CALCULATE" (
	"CALCULATE_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"CALCULATE_WAY"	VARCHAR2(30)		NOT NULL,
	"CALCULATE_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL,
	"CALCULATE_PRICE"	NUMBER		NOT NULL,
	"ACCOUNT_NUMBER"	VARCHAR2(100)		NOT NULL,
	"BOOK_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "CALCULATE"."CALCULATE_NO" IS '결제번호';

COMMENT ON COLUMN "CALCULATE"."CALCULATE_WAY" IS '결제수단';

COMMENT ON COLUMN "CALCULATE"."CALCULATE_ST" IS '결제여부';

COMMENT ON COLUMN "CALCULATE"."CALCULATE_PRICE" IS '결제금액';

COMMENT ON COLUMN "CALCULATE"."ACCOUNT_NUMBER" IS '입금계좌';

COMMENT ON COLUMN "CALCULATE"."BOOK_NO" IS '예약번호(시퀀스)';

DROP TABLE "REVIEW_IMG";

CREATE TABLE "REVIEW_IMG" (
	"IMG_REVIEW_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"IMG_REVIEW_RENAME"	VARCHAR2(4000)		NOT NULL,
	"IMG_REVIEW_LEVEL"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "REVIEW_IMG"."IMG_REVIEW_NO" IS '이미지 번호';

COMMENT ON COLUMN "REVIEW_IMG"."IMG_REVIEW_RENAME" IS '이미지 저장 경로+ 변경명';

COMMENT ON COLUMN "REVIEW_IMG"."IMG_REVIEW_LEVEL" IS '이미지 위치 지정 번호';

COMMENT ON COLUMN "REVIEW_IMG"."BOARD_NO" IS '게시글번호(시퀀스)';

DROP TABLE "EVENT_IMG";

CREATE TABLE "EVENT_IMG" (
	"IMG_EVENT_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"IMG_EVENT_RENAME"	VARCHAR2(4000)		NOT NULL,
	"IMG_EVENT_LEVEL"	NUMBER		NOT NULL,
	"EVENT_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "EVENT_IMG"."IMG_EVENT_NO" IS '이미지 번호';

COMMENT ON COLUMN "EVENT_IMG"."IMG_EVENT_RENAME" IS '이미지 저장 경로+ 변경명';

COMMENT ON COLUMN "EVENT_IMG"."IMG_EVENT_LEVEL" IS '이미지 위치 지정 번호';

COMMENT ON COLUMN "EVENT_IMG"."EVENT_NO" IS '이벤트 번호 (시퀀스)';

DROP TABLE "COUPON";

CREATE TABLE "COUPON" (
	"COUPON_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"MEMBER_NO"	NUMBER		NOT NULL,
	"COUPON_NM"	VARCHAR2(100)		NOT NULL,
	"COUPON_SALE"	NUMBER	DEFAULT 30000	NOT NULL,
	"COUPON_DT"	DATE	DEFAULT '2023-12-31'	NOT NULL,
	"COUPON_ST"	CHAR(1)	DEFAULT 'N'	NOT NULL
);

COMMENT ON COLUMN "COUPON"."COUPON_NO" IS '쿠폰 번호';

COMMENT ON COLUMN "COUPON"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "COUPON"."COUPON_NM" IS '쿠폰명';

COMMENT ON COLUMN "COUPON"."COUPON_SALE" IS '할인금액';

COMMENT ON COLUMN "COUPON"."COUPON_DT" IS '유효기간';

COMMENT ON COLUMN "COUPON"."COUPON_ST" IS '사용Y''사용안함N';

DROP TABLE "HOTEL";

CREATE TABLE "HOTEL" (
	"HOTEL_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"HOTEL_TITLE"	VARCHAR2(100)		NOT NULL
);

COMMENT ON COLUMN "HOTEL"."HOTEL_NO" IS '호텔번호';

COMMENT ON COLUMN "HOTEL"."HOTEL_TITLE" IS '호텔 지점';

DROP TABLE "TAG";

CREATE TABLE "TAG" (
	"TAG_NO"	NUMBER	PRIMARY KEY	NOT NULL,
	"TAG_CONTENT"	VARCHAR2(100)		NULL,
	"BOARD_NO"	NUMBER		NOT NULL
);

COMMENT ON COLUMN "TAG"."TAG_NO" IS '태그번호';

COMMENT ON COLUMN "TAG"."TAG_CONTENT" IS '태그내용';

COMMENT ON COLUMN "TAG"."BOARD_NO" IS '게시글번호(시퀀스)';

DROP TABLE "REPORT";

CREATE TABLE "REPORT" (
	"MEMBER_NO"	NUMBER		NOT NULL,
	"BOARD_NO"	NUMBER		NOT NULL,
	"REPORT_CONTENT"	VARCHAR2(4000)		NULL
);

COMMENT ON COLUMN "REPORT"."MEMBER_NO" IS '회원번호';

COMMENT ON COLUMN "REPORT"."BOARD_NO" IS '게시글번호(시퀀스)';

COMMENT ON COLUMN "REPORT"."REPORT_CONTENT" IS '신고내용';

CREATE SEQUENCE SEQ_MEMBER_NO; -- 회원 번호 시퀀스

CREATE SEQUENCE SEQ_BOOK_NO; -- 예약 번호 시퀀스

CREATE SEQUENCE SEQ_ROOM_NO; -- 객실 번호 시퀀스

CREATE SEQUENCE SEQ_BOARD_NO; -- 게시길 번호 시퀀스

CREATE SEQUENCE SEQ_BOOK_TYPE_NO; -- 게시판 코드 시퀀스

CREATE SEQUENCE SEQ_EVENT_NO; -- 이벤트 번호 시퀀스

CREATE SEQUENCE SEQ_REPLY_NO; -- 댓글 번호 시퀀스

CREATE SEQUENCE SEQ_CALCULATE_NO; -- 결제 번호 시퀀스

CREATE SEQUENCE SEQ_IMG_REVIEW_NO; -- 댓글 이미지 번호 시퀀스

CREATE SEQUENCE SEQ_IMG_EVENT_NO; -- 이벤트 이미지 번호 시퀀스

CREATE SEQUENCE SEQ_COUPON_NO; -- 쿠폰 번호 시퀀스

CREATE SEQUENCE SEQ_HOTEL_NO; -- 호텔 번호 시퀀스

CREATE SEQUENCE SEQ_TAG_NO; -- 태그 번호 시퀀스

CREATE SEQUENCE SEQ_REPORT_NO; -- 신고 번호 시퀀스

----------------------------------------------------------------------------------------

-- 객실 번호 가져오기
SELECT ROOM_NO 
FROM ROOM
JOIN HOTEL USING(HOTEL_NO)
WHERE HOTEL_TITLE = 'GANGNAM'
AND ROOM_NM = 'DELUXE';

-- 객실 가격 가져오기 (객실 번호 가져온 후)
SELECT ROOM_PRICE
FROM ROOM
WHERE ROOM_NO = 1;

-- 예약 가능한 객실인지 확인하기
SELECT ROOM_NO, TO_CHAR(CHECKIN_DT,'YYYY-MM-DD'),  TO_CHAR(CHECKOUT_DT,'YYYY-MM-DD')
FROM RESERVATION
WHERE CHECKIN_DT = ?
AND CHECKOUT_DT = ?
AND ROOM_NO = ?;

-- 관리자 예약 현황 조회하기
	SELECT BOOK_NO, TO_CHAR(CHECKIN_DT,'YYYY-MM-DD') CHECKIN_DT, TO_CHAR(CHECKOUT_DT,'YYYY-MM-DD') CHECKOUT_DT ,ROOM_NM, MEMBER_NM, HOTEL_TITLE
	FROM RESERVATION
	JOIN MEMBER USING(MEMBER_NO)
	JOIN ROOM USING(ROOM_NO)
	JOIN HOTEL USING(HOTEL_NO)
	WHERE CHECK_FL != 'N'
    AND CHECKOUT_DT >= SYSDATE
	ORDER BY BOOK_NO;

-- 관리자 이전 예약 조회
	SELECT BOOK_NO, TO_CHAR(CHECKIN_DT,'YYYY-MM-DD') CHECKIN_DT, TO_CHAR(CHECKOUT_DT,'YYYY-MM-DD') CHECKOUT_DT ,ROOM_NM, MEMBER_NM, HOTEL_TITLE
	FROM RESERVATION
	JOIN MEMBER USING(MEMBER_NO)
	JOIN ROOM USING(ROOM_NO)
	JOIN HOTEL USING(HOTEL_NO)
	WHERE CHECK_FL != 'N'
    AND MEMBER_NO = 3
    AND CHECKOUT_DT < SYSDATE
	ORDER BY BOOK_NO;
    
    SELECT BOOK_NO, TO_CHAR(CHECKIN_DT,'YYYY-MM-DD') CHECKIN_DT, TO_CHAR(CHECKOUT_DT,'YYYY-MM-DD') CHECKOUT_DT ,ROOM_NM, MEMBER_NM, HOTEL_TITLE
	FROM RESERVATION
	JOIN MEMBER USING(MEMBER_NO)
	JOIN ROOM USING(ROOM_NO)
	JOIN HOTEL USING(HOTEL_NO)
	WHERE CHECK_FL != 'N'
    AND CHECKOUT_DT < SYSDATE
	ORDER BY BOOK_NO;
    
    DELETE FROM RESERVATION
    WHERE BOOK_NO = ?
    AND MEMBER_NO = ?;
    
-- 게시글 작성
INSERT INTO BOARD VALUES(SEQ_BOARD_NO.NEXTVAL,'이거맞나?','왜 안돼?',DEFAULT,DEFAULT,2,2,NULL);
    
-- 게시글 수정
UPDATE BOARD
SET BOARD_TITLE = '업데이트 구문 연습', BOARD_CONTENT = '업데이트 구문 연습 중입니다.'
WHERE BOARD_NO = 11
AND BOARD_CD = 2 ;

UPDATE BOARD
SET BOARD_TITLE = 'DB연습타이틀', BOARD_CONTENT = 'DB연습하려고 작성한 것'
WHERE BOARD_NO = 20
AND BOARD_CD = 'N';

-- 쿠폰 리스트
SELECT * FROM (
        SELECT ROWNUM RNUM, A.* FROM(
            SELECT COUPON_NM, TO_CHAR(COUPON_DT,'YYYY-MM-DD') COUPON_DT
            FROM COUPON
            WHERE MEMBER_NO = 2
            AND COUPON_ST = 'N' 
        ) A 
    )
    WHERE RNUM BETWEEN ? AND ?;
    
    
    
    SELECT * FROM(
            SELECT ROWNUM RNUM, A.* FROM(
		        SELECT BOARD_NO, BOARD_TITLE, MEMBER_ID, 
		                TO_CHAR(BOARD_DT,'YYYY-MM-DD') AS BOARD_DT
		        FROM BOARD
		        JOIN MEMBER USING (MEMBER_NO)
		        WHERE BOARD_CD = ?
		        AND BOARD_ST = 'N'
		        ORDER BY BOARD_NO DESC
		    ) A
		)
		WHERE RNUM BETWEEN ? AND ? ;
    
    
    
    
-- 로그인한 사람이 쿠폰을 가지고 있는지 확인
SELECT COUNT(*)
FROM COUPON
JOIN MEMBER USING(MEMBER_NO)
WHERE MEMBER_NO = ?;


SELECT COUPON_SALE
FROM COUPON;
    
commit;




