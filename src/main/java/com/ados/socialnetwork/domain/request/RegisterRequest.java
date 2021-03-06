package com.ados.socialnetwork.domain.request;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Date birthday;
    private Integer gender;
}
