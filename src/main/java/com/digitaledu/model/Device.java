package com.digitaledu.model;

import com.digitaledu.data.enums.EDeviceState;

import javax.persistence.*;

@Entity
@Table(name = "device")
public class Device extends AbstractEntity {

    @Column(name = "device_name")
    private String deviceName;

    @Enumerated(EnumType.STRING)
    @Column(name = "device_state")
    private EDeviceState deviceState;

}
