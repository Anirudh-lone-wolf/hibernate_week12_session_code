package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Student;


public class StudentClient {

	public static void main(String[] args) {
		
		//create session factory
				SessionFactory factory = new Configuration()
						                     .configure("hibernate.cfg.xml")
						                     .addAnnotatedClass(Course.class)
						                     .addAnnotatedClass(Student.class)
						                     .buildSessionFactory();
				
				//create session
				Session session = factory.openSession();
				
				try {
					
					Student ramesh = new Student("Ramesh", "ramesh@gmail.com");
					
					Student suresh = new Student("Suresh", "suresh@gmail.com");
					
					Course statastics = new Course("Stats", 40);
					Course science = new Course("Science", 40);
					Course computers = new Course("Computers", 60);
					Course history = new Course("History", 20);
					
					ramesh.addCourse(statastics);
					ramesh.addCourse(science);
					ramesh.addCourse(computers);
					ramesh.addCourse(history);
					
					suresh.addCourse(science);
					suresh.addCourse(computers);
					
					session.beginTransaction();
					
					session.save(statastics);
					session.save(science);
					session.save(computers);
					session.save(history);
					
					session.save(ramesh);
					session.save(suresh);
					
					session.getTransaction().commit();;
					
				}catch(Exception e) {
					System.out.println("exception : ");
					e.printStackTrace();
				}finally {
					session.close();
					factory.close();
				}
		
	}

}
