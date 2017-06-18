package com.educate.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educate.domain.ClassRoom;
import com.educate.domain.Teacher;
import com.educate.repository.ClassRoomRepository;
import com.educate.repository.TeacherRepository;

@Service
public class ClassRoomService {

	@Autowired
	private ClassRoomRepository classRoomRepository;

	@Autowired
	private TeacherRepository teacherRepository;

	public Iterable<ClassRoom> list() {
		Iterable<ClassRoom> classRooms = classRoomRepository.findAll();
		return classRooms;
	}

	public ClassRoom createClassRoom(ClassRoom classRoom) {
		teacherRepository.save(classRoom.getTeacher());
		return classRoomRepository.save(classRoom);
	}

	public ClassRoom updateClassRoom(Long id) {
		ClassRoom classRoom = classRoomRepository.findOne(id);
		return classRoomRepository.save(classRoom);
	}

	public void deleteClassRoom(Long id) {
		classRoomRepository.delete(id);
	}
}
