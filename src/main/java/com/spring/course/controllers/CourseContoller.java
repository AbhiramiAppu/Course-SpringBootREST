package com.spring.course.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.course.model.Course;
import com.spring.course.services.CourseService;

@RestController
@RequestMapping("/course")
public class CourseContoller {
	
	@Autowired
	private CourseService service;
	
	@RequestMapping(value="/putCourseData", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public String putCourseData(@RequestBody Course st) {
		
		boolean status = service.addCourseToDb(st);
		
		if(status) {
			return "Course added successfully";
		}else {
			return "Course update failed";
		}
	
	}
	
	
	
	
	@RequestMapping(value="/deleteCourseData/{cid}",method=RequestMethod.DELETE)
	public String deleteCourseData(@PathVariable Long cid) {
		boolean status = service.deleteCourseFromDb(cid);
		
		if(status) {
			return "Course deleted successfully";
		}else {
			return "Course delete failed";
		}
	}
	
	
	
	@RequestMapping(value="/courseinfo",method=RequestMethod.GET)
	public List<Course> getCourseInfo(){
		
		List<Course> li = service.getCourseData();
		return li;
	}


	
	@RequestMapping(value="/postCourseData", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	
	public Course coursePostCall(@RequestBody Course course) {
		
		//validation
		if(Objects.isNull(course.getCid()) || (course.getCid() == 0)){
			
			throw new IllegalArgumentException("Course id is mandatory field or invalid argument passed");
			
		}
		
		//service
		Course courseObj = service.getCourseDataBasedOnId(course.getCid());
		
		return courseObj;
		
	}
	
	

}
