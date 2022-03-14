package com.ados.socialnetwork.domain.entity;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer version;

    private String description;

    @CreationTimestamp
    private Date createAt;

    private String createBy;

    @UpdateTimestamp
    private Date updateAt;

    private String updateBy;

    private Integer status;
}
