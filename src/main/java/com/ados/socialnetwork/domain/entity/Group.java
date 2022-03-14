package com.ados.socialnetwork.domain.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "groups")
public class Group extends BaseEntity {

}
