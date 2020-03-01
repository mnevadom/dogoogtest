package com.udemy.backend.services;

import java.util.List;

import com.udemy.backend.entity.Course;
import com.udemy.backend.model.CourseModel;

public interface CourseService {
	
	public List<CourseModel> listAllCourses();
	public Course addCourse(CourseModel course);
	public int removeCourse(int id);
	public CourseModel updateCourse(CourseModel course);
}
