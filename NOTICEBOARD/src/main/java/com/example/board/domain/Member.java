package com.example.board.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
public class Member {

    @Id
    private long memberId;
    private String password;
    private String memberName;
    private String nickname;
    private boolean verified;

    public void setVerified(){
        verified = true;
    }
}
