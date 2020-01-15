
-- 기존 테이블 삭제 

DROP TABLE BOOK;
DROP TABLE TRANS_INFO;
DROP TABLE TRANS;
DROP TABLE LOCATION_INFO;
DROP TABLE USER_INFO;

-- create table
CREATE TABLE USER_INFO(
                USER_ID VARCHAR2(20) PRIMARY KEY,
                USER_PW VARCHAR2(20) NOT NULL,
                USER_NAME VARCHAR2(20),
                USER_BIRTH VARCHAR2(20),
                USER_PHONE VARCHAR2(20),
                USER_EMAIL VARCHAR2(20));
CREATE TABLE LOCATION_INFO(
                LOC_NUM VARCHAR2(20) PRIMARY KEY,
                LOC_NAME VARCHAR2(20) NOT NULL);
CREATE TABLE TRANS(
                TRANS_CODE VARCHAR2(20) PRIMARY KEY,
                TRANS_TYPE VARCHAR2(20));
CREATE TABLE TRANS_INFO(
                TRANS_SERV_NUM VARCHAR2(20) PRIMARY KEY, 
                TRANS_TYPE VARCHAR2(20),
                TRANS_NUM VARCHAR2(20),
                TRANS_DEP_LOC VARCHAR2(20),
                TRANS_DEST_LOC VARCHAR2(20),
                TRANS_DEP_TIME VARCHAR2(20),
                TRANS_ARR_TIME VARCHAR2(20),
                TRANS_GRADE VARCHAR2(20),
                TRANS_SEAT NUMBER(10),
                TRANS_FARE NUMBER(10),
                CONSTRAINT trans_transtype_fk FOREIGN KEY ("TRANS_TYPE")
                REFERENCES TRANS ("TRANS_CODE"));

                
CREATE TABLE BOOK(
                BOOK_NUM VARCHAR2(20) PRIMARY KEY,
                USER_ID VARCHAR2(20),
                DEP_LOC_NUM VARCHAR2(20),
                ARR_LOC_NUM VARCHAR2(20),
                SERV_NUM VARCHAR2(20),
                DEP_TIME VARCHAR2(20),
                ARR_TIME VARCHAR2(20),
                BOOK_NOM NUMBER(20),
                BOOK_FARE NUMBER(20),
                BOOK_DATE DATE,
                CONSTRAINT book_userid_fk FOREIGN KEY ("USER_ID")
                REFERENCES USER_INFO("USER_ID"),
                CONSTRAINT book_deplocbum_fk FOREIGN KEY ("DEP_LOC_NUM")
                REFERENCES LOCATION_INFO ("LOC_NUM"),
                CONSTRAINT book_arrlocnum_fk FOREIGN KEY ("ARR_LOC_NUM")
                REFERENCES LOCATION_INFO ("LOC_NUM"),
                CONSTRAINT book_transservnum_fk FOREIGN KEY ("SERV_NUM")
                REFERENCES TRANS_INFO ("TRANS_SERV_NUM"));

-- insert

-- 유저 테이블 더미 데이터 삽입 
INSERT INTO USER_INFO
VALUES('TEST1','1111','김철수','1995/04/17','010-1111-1111','TEST1@TEST.MAIL');
INSERT INTO USER_INFO
VALUES('TEST2','1111','홍길동','1995/12/12','010-2222-2222','TEST2@TEST.MAIL');
INSERT INTO USER_INFO
VALUES('TEST3','1111','김예시','1995/12/17','010-3333-3333','TEST3@TEST.MAIL');

-- 지역 테이블 삽입
INSERT INTO LOCATION_INFO
VALUES('L1','서울');
INSERT INTO LOCATION_INFO
VALUES('L2','부산');
INSERT INTO LOCATION_INFO
VALUES('L3','대구');
INSERT INTO LOCATION_INFO
VALUES('L4','인천');
INSERT INTO LOCATION_INFO
VALUES('L5','광주');
INSERT INTO LOCATION_INFO
VALUES('L6','대전');
INSERT INTO LOCATION_INFO
VALUES('L7','울산');

-- 교통종류 테이블 삽입 
INSERT INTO TRANS
VALUES('Trans1','버스');
INSERT INTO TRANS
VALUES('Trans2','기차');

-- 기차 운행 정보 테이블 
-- 서울->부산
INSERT INTO TRANS_INFO
VALUES('Ts1','Trans2','t1','L1','L2','2020/01/01 12:00:00','2020/01/01 15:30:00','ITX',10,1000);
-- 서울->대구
INSERT INTO TRANS_INFO
VALUES('Ts2','Trans2','t2','L1','L3','2020/01/01 12:00:00','2020/01/01 13:30:00','ITX',10,1000);
-- 서울->광주
INSERT INTO TRANS_INFO
VALUES('Ts3','Trans2','t3','L1','L4','2020/01/01 12:00:00','2020/01/01 15:30:00','ITX',10,1000);
                            
-- 버스 운행 테이블
-- 서울->광주
INSERT INTO TRANS_INFO
VALUES('Bs1','Trans1','B1','L1','L2','2020/01/01 12:00:00','2020/01/01 15:30:00','ITX',10,1000);
-- 서울->대구
INSERT INTO TRANS_INFO
VALUES('Bs2','Trans1','B2','L1','L3','2020/01/01 12:00:00','2020/01/01 13:30:00','ITX',10,1000);
-- 서울->광주
INSERT INTO TRANS_INFO
VALUES('Bs3','Trans1','B3','L1','L4','2020/01/01 12:00:00','2020/01/01 15:30:00','ITX',10,1000);


-- 예매 현황 데이터 삽입
INSERT INTO BOOK
VALUES('booking1','TEST1','L1','L2','Bs1','2020/01/01 12:00:00','2020/01/01 15:30:00',1,1000,sysdate);
