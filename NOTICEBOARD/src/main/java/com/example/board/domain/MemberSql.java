package com.example.board.domain;

public class MemberSql {
	public static final String SELECT = """
				SELECT id,password,name FROM member WHERE 1=1
			""";
	
	public static final String ID_CONDITION = """
				AND id=:id
			""";
	
	public static final String PASSWORD_CONDITION = """
				AND password=:password
			""";
}
