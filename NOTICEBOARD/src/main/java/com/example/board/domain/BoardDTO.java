package com.example.board.domain;

import lombok.Getter;
import lombok.Setter;

//CREATE TABLE `board`(
//		  `seq` INT NOT NULL,
//		  `subject` VARCHAR(200) NOT NULL,
//		  `content` VARCHAR(1000) NOT NULL,
//		  `name` VARCHAR(20) NOT NULL,
//		  `reg_date` VARCHAR(100),
//		  `readCount` INT NULL,
//		  PRIMARY KEY (`seq`));

@Getter
@Setter
public class BoardDTO {
	int seq;
	String subject;
	String content;
	String name;
	String reg_date;
	int readCount;
	
	
}
