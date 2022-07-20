package com.example.board.domain;

public class BoardSql {
//	public static final String SELECT = """
//			SELECT seq, subject, content, name, reg_date, readCount FROM board WHERE 1=1
//		""";
	public static final String SELECT = """
				SELECT * FROM BOARD WHERE 1=1
			""";

	public static final String INSERT = """
			INSERT INTO BOARD(seq, subject, content, name, reg_date, readcount) VALUES(:seq, :subject, :content, :name, :reg_date, 0)
			""";


	public static final String UPDATE_READCOUNT = """
				UPDATE BOARD SET readcount=readcount+1 WHERE 1=1
			""";

	public static final String SEQ_CONDITION = """
				AND seq=:seq
			""";
	
	public static final String MAX_SEQ = """
				SELECT max(seq) FROM BOARD
			""";


}
