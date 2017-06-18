package com.educate.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.educate.domain.ClassRoom;

@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom, Long> {

}
