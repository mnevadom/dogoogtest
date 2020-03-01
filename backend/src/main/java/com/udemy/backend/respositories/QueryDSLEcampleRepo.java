package com.udemy.backend.respositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;
import com.udemy.backend.entity.Course;
import com.udemy.backend.entity.QCourse;

@Repository("queryDSLEcampleRepo")
public class QueryDSLEcampleRepo {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager em;
	
	public void find(boolean exist) {
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder = new BooleanBuilder(qCourse.description.endsWith("OP"));
		
		if (exist) {
			Predicate pred2 = qCourse.id.eq(23);
			predicateBuilder.and(pred2);
		}else {
			Predicate pred3 = qCourse.name.endsWith("OP");
			predicateBuilder.and(pred3);
		}
		
		Course course1 = (Course) query.select(qCourse.name, qCourse.description).
				from(qCourse).
				where(predicateBuilder).fetchOne();
	}
	
	public void find() {
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		// dentro del select, van las columnas q necesitas de esa tabla. si la quieres entera, la entity tal cual
		Course course1 = (Course) query.select(qCourse.name, qCourse.description).
				from(qCourse).
				where(qCourse.id.eq(23)).fetchOne();
		
		List<Course> courses = query.select(qCourse).
				from(qCourse).
				where(qCourse.hours.between(20, 50)).fetch();
	}
}
