package com.ados.socialnetwork.domain.entity;

import com.ados.socialnetwork.domain.entity.key.UserPostKey;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@IdClass(UserPostKey.class)
public class UserPost {
    @Id
    private Long userId;

    @Id
    private Long postId;

    private String description;

    private Integer status;

    @CreationTimestamp
    private Date createAt;

    @UpdateTimestamp
    private Date updateAt;
}
