package com.ados.socialnetwork.domain.entity;

import com.ados.socialnetwork.domain.entity.key.RelationshipKey;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.util.Date;

@Data
@Entity
@IdClass(RelationshipKey.class)
public class Relationship {
    @Id
    private Long user1Id;
    @Id
    private Long user2Id;

    private String description;

    private Integer status;

    @CreationTimestamp
    private Date createAt;

    @UpdateTimestamp
    private Date updateAt;
}
