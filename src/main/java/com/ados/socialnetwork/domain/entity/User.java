package com.ados.socialnetwork.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Entity
@Data
public class User extends BaseEntity {
    private String firstName;
    private String lastName;
    private Integer gender;
    private Date birthday;
    private String email;
    private String password;
    private String role;

    @OneToOne
    @JoinColumn(name = "profile_image_id")
    private Image profileImage;

    @OneToOne
    @JoinColumn(name = "cover_image_id")
    private Image coverImage;

    private String city;
    private String country;
    private String relationship;
}
