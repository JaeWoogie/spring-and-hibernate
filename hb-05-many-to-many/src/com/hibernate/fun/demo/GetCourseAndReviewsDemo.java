package com.hibernate.fun.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fun.entity.Course;
import com.hibernate.fun.entity.Instructor;
import com.hibernate.fun.entity.InstructorDetail;
import com.hibernate.fun.entity.Review;
import com.hibernate.fun.entity.Student;

public class GetCourseAndReviewsDemo {
	
	
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId=11;
			
			Course tempCourse = session.get(Course.class, theId);
			
			System.out.println("The course is " + tempCourse);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			session.close();
			
			factory.close();
		}
	}
}
