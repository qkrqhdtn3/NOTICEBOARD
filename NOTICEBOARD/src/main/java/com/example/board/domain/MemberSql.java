package com.example.board.domain;

public class MemberSql {
	public static final String SELECT = """
				SELECT memberId,password,memberName FROM member WHERE 1=1
			""";
	
	public static final String MEMBER_NAME_CONDITION = """
				AND memberName=:memberName
			""";
	
	public static final String PASSWORD_CONDITION = """
				AND password=:password
			""";
}
