package com.digitaledu.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Table(name = "permission")
public class Permission extends AbstractEntity {

    @Column(name = "name")
    private String name;
}
