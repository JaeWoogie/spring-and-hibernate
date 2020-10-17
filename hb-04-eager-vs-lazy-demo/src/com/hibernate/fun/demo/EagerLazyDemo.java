package com.hibernate.fun.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fun.entity.Course;
import com.hibernate.fun.entity.Instructor;
import com.hibernate.fun.entity.InstructorDetail;
import com.hibernate.fun.entity.Student;

public class EagerLazyDemo {
	
	
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId=1;
			
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Courses: " + tempInstructor.getCourse());
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			session.close();
			
			factory.close();
		}
	}
}
