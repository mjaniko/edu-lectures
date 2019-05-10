package com.digitaledu.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "device_state")
public class DeviceState extends AbstractEntity{

    @Column(name = "name")
    private String name;

}
