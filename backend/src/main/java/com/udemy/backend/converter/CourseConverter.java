package com.udemy.backend.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.udemy.backend.entity.Course;
import com.udemy.backend.model.CourseModel;

@Component("courseConverter")
public class CourseConverter {

//	Entity --> Model
	public CourseModel entity2model(Course course) {
		CourseModel cm = new CourseModel();
		
		cm.setName(course.getName());
		cm.setDescription(course.getDescription());
		cm.setHours(course.getHours());
		cm.setPrice(course.getPrice());
		
		return cm;
	}
	
//	Model --> Entity
	public Course model2entity(CourseModel model) {
		Course c = new Course();
		
		c.setName(model.getName());
		c.setDescription(model.getDescription());
		c.setHours(model.getHours());
		c.setPrice(model.getHours());
		
		return c;
	}
	
	public List<CourseModel> entity2modelList(List<Course> courses){
		List<CourseModel> modelList = new ArrayList<CourseModel>();
		courses.stream().forEach(c-> modelList.add(entity2model(c)));
		
		return modelList;
	}
}
