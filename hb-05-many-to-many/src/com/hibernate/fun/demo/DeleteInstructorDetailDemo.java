package com.hibernate.fun.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fun.entity.Instructor;
import com.hibernate.fun.entity.InstructorDetail;
import com.hibernate.fun.entity.Student;

public class DeleteInstructorDetailDemo {
	
	
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			int theId=3;
			
			InstructorDetail tempInstructorDetail =
					session.get(InstructorDetail.class, theId);
			
			System.out.println("Deleting instructor detail " + tempInstructorDetail);
			
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			
			session.delete(tempInstructorDetail);
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} catch(Exception exc) {
			exc.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}
	}
}
