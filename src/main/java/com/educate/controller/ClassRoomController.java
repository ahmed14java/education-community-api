package com.educate.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.educate.domain.ClassRoom;
import com.educate.exception.PostNotFoundException;
import com.educate.services.ClassRoomService;

@RestController
@RequestMapping("/classroom")
public class ClassRoomController {

	@Autowired
	private ClassRoomService classRoomService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public Iterable<ClassRoom> listClassRoom() {
		Iterable<ClassRoom> classRooms = classRoomService.list();
		return classRooms;
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ClassRoom createClassRoom(@RequestBody ClassRoom classRoom) {
		return classRoomService.createClassRoom(classRoom);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ClassRoom updateClassRoom(@PathVariable("id") Long id) {
		ClassRoom classRoom = classRoomService.updateClassRoom(id);
		return classRoom;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteClassRoom(@PathVariable("id") Long id) {
		classRoomService.deleteClassRoom(id);
	}

	@ExceptionHandler(PostNotFoundException.class)
	public void handlePostNotFound(PostNotFoundException exception, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}
}
