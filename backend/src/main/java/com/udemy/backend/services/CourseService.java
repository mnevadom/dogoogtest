package com.udemy.backend.services;

import java.util.List;

import com.udemy.backend.entity.Course;

public interface CourseService {
	
	public List<Course> listAllCourses();
	public Course addCourse(Course course);
	public int removeCourse(int id);
	public Course updateCourse(Course course);
}
