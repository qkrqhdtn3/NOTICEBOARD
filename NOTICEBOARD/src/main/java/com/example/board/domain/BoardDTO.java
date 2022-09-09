package com.example.board.domain;

import lombok.Getter;
import lombok.Setter;

//CREATE TABLE `board`(
//		  `boardId` INT NOT NULL,
//		  `subject` VARCHAR(200) NOT NULL,
//		  `content` VARCHAR(1000) NOT NULL,
//		  `memberId` VARCHAR(20) NOT NULL,
//		  `regDate` VARCHAR(100),
//		  `readCount` INT NULL,
//		  PRIMARY KEY (`boardId`));

@Getter
@Setter
public class BoardDTO {
	long boardId;
	long memberId;
	String memberName;
	String subject;
	String content;
	String regDate;
	int readCount;
	
	
}
