package com.spring.course.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.spring.course.model.Course;

@Component
public class CourseDao {
	
	@Autowired
	private JdbcTemplate template;
	
	
	public boolean addCourseToDb(Course st) {
		boolean status = false;
		
		try {
			
			String sql = "insert into course(courseid,coursename,amount,field,duration) values("+st.getCid()+",'"+st.getCname()+"',"+st.getCamount()+",'"+st.getCfield()+"',"+st.getCduration()+")";
			
			template.execute(sql);
			status = true;
			}catch(Exception e) {
			status = false;
		}
		
		return status;
	}

	
	
	
	public boolean deleteCourseFromDb(Long cid) {
		
		boolean status = false;

		try {

			String sql = "delete from course where courseid = "+cid;

			template.execute(sql);
			status = true;
			} catch (Exception e) {
			status = false;
		}

		return status;
		
	}
	
	
	
	
	public List<Course> getCourseData(){
		
		String sql =  "select * from course";
		
		List<Course> courseList = template.query(sql, new ResultSetExtractor<List<Course>>() {
			
			@Override
			public List<Course> extractData(ResultSet rs) throws SQLException,DataAccessException{
				List<Course> list = new ArrayList<>();
				while(rs.next()) {
					Course course = new Course();
					course.setCid(rs.getInt("courseid"));
					course.setCname(rs.getString("coursename"));
					course.setCamount(rs.getInt("amount"));
					course.setCfield(rs.getString("field"));
					course.setCduration(rs.getInt("duration"));
					list.add(course);
				}
				return list;
			}
		
		});
		
		courseList.stream().forEach(course -> {
			System.out.println(course.getCid() + "-" + course.getCname());
		});

		return courseList;

	}

	
	
	
	public List<Course> getCourseDataBasedOnId(int cid) {
		
		String sql =  "select * from course where courseid = "+cid;
		
		List<Course> courseList = template.query(sql, new ResultSetExtractor<List<Course>>() {
			
			@Override
			public List<Course> extractData(ResultSet rs) throws SQLException,DataAccessException{
				List<Course> list = new ArrayList<>();
				while(rs.next()) {
					Course course = new Course();
					course.setCid(rs.getInt("courseid"));
					course.setCname(rs.getString("coursename"));
					course.setCamount(rs.getInt("amount"));
					course.setCfield(rs.getString("field"));
					course.setCduration(rs.getInt("duration"));
					list.add(course);
				}
				return list;
			}
		
		});
		
		courseList.stream().forEach(course -> {
			System.out.println(course.getCid() + "-" + course.getCname());
		});

		return courseList;
	}

	
}
