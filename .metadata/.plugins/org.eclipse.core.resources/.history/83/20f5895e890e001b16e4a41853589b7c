package com.hibernate.fun.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fun.entity.Student;

public class CreateStudentDemo {
	
	
	
	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class).buildSessionFactory();
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			System.out.println("creating student object...");
			
			Student tempStudent = new Student("Daffy", "Duck", "IHateCoding@gmail.com");
			
			session.beginTransaction();
			
			System.out.println("saving the student");
			System.out.println(tempStudent);
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			//Retrieve the data
			System.out.println("Saved student. Generated id: " + tempStudent.getId());
			
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("\nGetting student with id: " + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			session.getTransaction().commit();
			
			System.out.println("Done!!");
			
		} finally {
			factory.close();
		}
	}
}
