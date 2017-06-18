package com.educate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educate.domain.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Long>{

}
