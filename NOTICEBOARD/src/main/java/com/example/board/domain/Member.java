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
    private String id;
    private String password;
    private String name;
    private boolean verified;

    public void setVerified(){
        verified = true;
    }
}
