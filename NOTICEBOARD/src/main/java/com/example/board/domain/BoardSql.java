package com.example.board.domain;

public class BoardSql {
//	public static final String SELECT = """
//			SELECT boardId, subject, content, memberId, regDate, readCount FROM board WHERE 1=1
//		""";
	public static final String SELECT = """
				SELECT * FROM BOARD WHERE 1=1
			""";

	public static final String INSERT = """
			INSERT INTO BOARD(board_id, subject, content, member_id, reg_date, read_count) VALUES(:boardId, :subject, :content, :memberId, :regDate, 0)
			""";

	public static final String UPDATE = """
				UPDATE BOARD SET subject=:subject, content=:content WHERE 1=1
			""";
	
	public static final String DELETE = """
				DELETE FROM BOARD WHERE 1=1
			""";
	
	public static final String UPDATE_READ_COUNT = """
				UPDATE BOARD SET readCount=readCount+1 WHERE 1=1
			""";

	public static final String BOARDID_CONDITION = """
				AND boardId=:boardId
			""";
	
	public static final String MAX_BOARDID = """
				SELECT max(boardId) FROM BOARD
			""";


}
