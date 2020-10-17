package com.hibernate.fun.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.fun.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		//create session factory
				SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class).buildSessionFactory();
				
				//create session
				Session session = factory.getCurrentSession();
				
				try {
					System.out.println("creating student object...");
					
					Student tempStudent1 = new Student("eva", "Lefever", "sondfon@gmail.com");
					Student tempStudent2 = new Student("lisa", "lefever", "Moli@gmail.com");
					Student tempStudent3 = new Student("jackie", "Lefever", "jackie@gmail.com");
					
					session.beginTransaction();
					
					System.out.println("saving the student");
					session.save(tempStudent1);
					session.save(tempStudent2);
					session.save(tempStudent3);
					
					session.getTransaction().commit();
					
				} finally {
					factory.close();
				}
	}

}
