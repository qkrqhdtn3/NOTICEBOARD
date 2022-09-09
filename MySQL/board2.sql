CREATE DATABASE IF NOT EXISTS qqta DEFAULT CHARACTER SET utf8mb4;

USE qqta;

#DROP TABLE IF EXISTS board;

CREATE TABLE IF NOT EXISTS board(
    boardId BIGINT NOT NULL,
    memberId BIGINT NOT NULL,
    subject VARCHAR(200) NOT NULL,
    content VARCHAR(1000) NOT NULL,
    regDate VARCHAR(100),
    readCount INT,
    PRIMARY KEY (boardId),
    FOREIGN KEY (memberId) references member(memberId));

INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, NAME, READCOUNT) VALUES (1, 'TEST_SUBJECT1', 'TEST', 'k', 0);
INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, NAME, READCOUNT) VALUES (2, 'TEST_SUBJECT2', 'TEST', 'k', 0);
INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, NAME, READCOUNT) VALUES (3, 'TEST_SUBJECT3', 'TESt', 'k', 0);
INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, NAME, READCOUNT) VALUES (4, 'TEST_SUBJECT4', 'Test', 'k', 0);
INSERT IGNORE INTO BOARD (boardId, SUBJECT, CONTENT, NAME, READCOUNT) VALUES (5, 'TEST_SUBJECT5', 'TESt', 'k', 0);

#member.sql
CREATE TABLE IF NOT EXISTS member(
    memberId bigint,
    password VARCHAR(50),
    memberName VARCHAR(50),
    nickName VARCHAR(20),
    verified tinyint(1),
    PRIMARY KEY (memberId)
    );

INSERT IGNORE INTO member (ID, PASSWORD, NAME) VALUES ('id1', 'password', 'name1');
INSERT IGNORE INTO member (ID, PASSWORD, NAME) VALUES ('id2', 'passwoRd', 'name2');
INSERT IGNORE INTO member (ID, PASSWORD, NAME) VALUES ('id3', 'passworD', 'name3');

#emailToken.sql
CREATE TABLE IF NOT EXISTS emailToken(
    emailTokenId varchar(40),
    expirationDate timestamp,
    expired tinyint(1),
    PRIMARY KEY(id)
);

#alter table board
ALTER TABLE board ADD likeId INT;
ALTER TABLE board ADD likeCheck tinyint(1) DEFAULT 0;

#alter table member
ALTER TABLE member ADD memberName varchar(50);

#변경점
#all
    # id become bigint
#board
    # boardId, memberId
    # fk(memberId)
#member
    # memberId, memberName, nickName
#emailToken
    # id
#like
    # likeId, likeCheck
    # add boardId, memberId
    # fk(boardId), fk(memberId)
CREATE TABLE IF NOT EXISTS postLike(
    likeId BIGINT,
    boardId BIGINT,
    memberId BIGINT,
    likeCheck tinyint(1) DEFAULT 0,
    PRIMARY KEY (likeId),
    FOREIGN KEY (boardId) REFERENCES board(boardId),
    FOREIGN KEY (memberId) REFERENCES member(memberId)
    );