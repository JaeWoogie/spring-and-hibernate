package com.hibernate.fun.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fun.entity.Student;

public class ReadStudentDemo {
	
	
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating student object...");
			
			Student tempStudent = new Student("Lisa", "Lefever", "whatever@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("saving the student");
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
		} finally {
			factory.close();
		}
	}
}
