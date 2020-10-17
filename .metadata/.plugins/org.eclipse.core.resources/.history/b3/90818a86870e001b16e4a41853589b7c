package com.hibernate.fun.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fun.entity.Student;

public class QueryStudentDemo {
	
	
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			//start transaction
			session.beginTransaction();
			
			List<Student> theStudent = session.createQuery("from Student").list();
			
			displayStudent(theStudent);
			
			theStudent = session.createQuery("from Student s where s.lastName='Lefever'").list();
			
			
			System.out.println("Choosen from the query: ");
			displayStudent(theStudent);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudent) {
		for(Student tempStudent: theStudent) {
			System.out.println(tempStudent);
		}
	}
}
