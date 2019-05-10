package com.digitaledu.repository;

import com.digitaledu.model.DeviceState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceStateRepository extends JpaRepository<DeviceState, Long>, JpaSpecificationExecutor {
}
