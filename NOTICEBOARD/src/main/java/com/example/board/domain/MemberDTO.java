package com.example.board.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {
	Long memberId;
	String memberName;
	String password;
	String nickname;
	boolean verified;
}
