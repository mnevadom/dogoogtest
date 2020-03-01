package com.udemy.backend.services.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.udemy.backend.converter.CourseConverter;
import com.udemy.backend.entity.Course;
import com.udemy.backend.model.CourseModel;
import com.udemy.backend.respositories.CourseJpaRepository;
import com.udemy.backend.services.CourseService;


@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{
	
	private static final Log LOG = LogFactory.getLog(CourseServiceImpl.class);
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Autowired
	@Qualifier("courseConverter")
	private CourseConverter converter;

	@Override
	public List<CourseModel> listAllCourses() {
		LOG.info("Call: listaAllCourses");
		
		return converter.entity2modelList(courseJpaRepository.findAll());
	}

	@Override
	public Course addCourse(CourseModel model) {
		LOG.info("Call: addCourse");
		return courseJpaRepository.save(converter.model2entity(model));
	}

	@Override
	public int removeCourse(int id) {
		courseJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public CourseModel updateCourse(CourseModel model) {
		return converter.entity2model(courseJpaRepository.save(converter.model2entity(model)));
	}

}
