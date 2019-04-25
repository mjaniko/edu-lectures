package com.digitaledu.repository;

import com.digitaledu.model.Lecturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LecturerRepository extends CrudRepository<Lecturer, Long> {
}
