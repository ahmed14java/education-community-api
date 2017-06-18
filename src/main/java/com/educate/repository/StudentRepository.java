package com.educate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educate.domain.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{

}
