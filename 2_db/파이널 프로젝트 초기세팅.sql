-- 회원가입 SQL 구문 
INSERT INTO MEMBER
VALUES (이름, 이메일, 닉네임, 비밀번호, 전화번호, 주소, 탈퇴여부('N'), 관리자여부('N'), 펫시터여부('N'), 프로필이미지(NULL가능));


ALTER TABLE MEMBER add ENROLL_DATE DATE DEFAULT SYSDATE NOT NULL ; 

COMMIT;

