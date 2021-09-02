package com.spring.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.course.dao.CourseDao;
import com.spring.course.model.Course;

@Service
public class CourseService {
	
	@Autowired
	private CourseDao dao;
	
	
	public boolean addCourseToDb(Course st) {
		boolean status=dao.addCourseToDb(st);
		return status;

	}

	
	public boolean deleteCourseFromDb(Long cid) {
		boolean status = dao.deleteCourseFromDb(cid);
		return status;
	}
	
	
	
	public List<Course> getCourseData(){
		List<Course> stList = dao.getCourseData();
		
		return stList;
	}

	
	
	public Course getCourseDataBasedOnId(int cid) {
		
		List<Course> stList = dao.getCourseDataBasedOnId(cid);
		return stList.get(0);
	
	}

	
}
