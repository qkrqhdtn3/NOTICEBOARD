CREATE DATABASE IF NOT EXISTS qqta DEFAULT CHARACTER SET utf8mb4;

USE qqta;

#DROP TABLE IF EXISTS board;

CREATE TABLE IF NOT EXISTS board(
  boardId INT NOT NULL,
  subject VARCHAR(200) NOT NULL,
  content VARCHAR(1000) NOT NULL,
  memberId VARCHAR(20) NOT NULL,
  reg_date VARCHAR(100),
  readCount INT,
  PRIMARY KEY (boardId));

INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, memberId, READCOUNT) VALUES (1, 'TEST_SUBJECT1', 'TEST', 'k', 0);
INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, memberId, READCOUNT) VALUES (2, 'TEST_SUBJECT2', 'TEST', 'k', 0);
INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, memberId, READCOUNT) VALUES (3, 'TEST_SUBJECT3', 'TESt', 'k', 0);
INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, memberId, READCOUNT) VALUES (4, 'TEST_SUBJECT4', 'Test', 'k', 0);
INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, memberId, READCOUNT) VALUES (5, 'TEST_SUBJECT5', 'TESt', 'k', 0);

#member.sql
CREATE TABLE IF NOT EXISTS member(
	memberId VARCHAR(50),
	PASSWORD VARCHAR(50),
	memberName VARCHAR(20),
	PRIMARY KEY (memberId)
);

INSERT IGNORE INTO member (memberId, PASSWORD, memberName) VALUES ('memberId1', 'password', 'memberName1');
INSERT IGNORE INTO member (memberId, PASSWORD, memberName) VALUES ('memberId2', 'passwoRd', 'name2');
INSERT IGNORE INTO member (memberId, PASSWORD, NAME) VALUES ('memberId3', 'passworD', 'name3');

#emailToken.sql
CREATE TABLE IF NOT EXISTS emailToken(
    emailTokenId varchar(40),
    expirationDate timestamp,
    expired tinyint(1),
    memberId bigint unsigned,
    PRIMARY KEY(emailTokenId)
    );