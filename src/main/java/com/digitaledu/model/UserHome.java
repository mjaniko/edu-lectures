package com.digitaledu.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@Entity
@Table(name = "user_home")
public class UserHome extends AbstractEntity{

    @OneToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "device_hash")
    private String deviceHash;

    @Column(name = "home_name")
    private String homeName;

}