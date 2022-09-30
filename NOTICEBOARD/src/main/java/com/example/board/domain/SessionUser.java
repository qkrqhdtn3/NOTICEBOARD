package com.example.board.domain;

import lombok.Getter;

//session dto
@Getter
public class SessionUser {
    private String memberName;
    private String email;
    private String picture;

    public SessionUser(User user) {
        this.memberName = user.getMemberName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
