
--기존 테이블 삭제 
/*
DROP TABLE USER_INFO;
DROP TABLE TRAIN;
DROP TABLE BUS;
DROP TABLE LOCATION;
DROP TABLE BOOK;
*/

-- create table
CREATE TABLE USER_INFO(
                USER_ID VARCHAR2(20) PRIMARY KEY,
                USER_PW VARCHAR2(20),
                USER_NAME VARCHAR2(20),
                USER_BIRTH DATE,
                USER_PHONE VARCHAR2(20),
                USER_EMAIL VARCHAR2(20));
CREATE TABLE TRAIN(
                TRAIN_NUM VARCHAR2(20) PRIMARY KEY,
                TRAIN_DEP_LOC VARCHAR2(20),
                TRAIN_DEST_LOC VARCHAR2(20),
                TRAIN_DEP_TIME DATE,
                TRAIN_ARR_TIME DATE,
                TRAIN_TYPE VARCHAR2(20),
                TRAIN_SEAT NUMBER(10),
                TRAIN_FARE NUMBER(10));
CREATE TABLE BUS(
                BUS_NUM VARCHAR2(20) PRIMARY KEY,
                BUS_DEP_LOC VARCHAR2(20),
                BUS_DEST_LOC VARCHAR2(20),
                BUS_DEP_TIME DATE,
                BUS_EST_TIME DATE,
                BUS_SEAT NUMBER(10),
                BUS_FARE NUMBER(10));
CREATE TABLE LOCATION(
                LOC_NUM VARCHAR2(20) PRIMARY KEY,
                LOC_NAME VARCHAR2(20));
CREATE TABLE BOOK(
                BOOK_NUM VARCHAR2(20) PRIMARY KEY,
                USER_ID VARCHAR2(20),
                DEP_LOC VARCHAR2(20),
                DEST_LOC VARCHAR2(20),
                TRANS VARCHAR2(20),
                BOOK_DATE DATE);

-- insert
