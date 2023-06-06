package service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Course;
import entity.Teacher;
import entity.TeacherDetails;

public class CreateTeacher {
	
	public static void main(String[] args) {
		
		System.out.println("Connecting to database");
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Teacher.class)
				.addAnnotatedClass(TeacherDetails.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			System.out.println("creating a new teacher object......");
			Teacher teacher1 = new Teacher("Sararth","Binny","@gl.com");
			
			Course maths = new Course("Mathemetics", 3); 
			Course science = new Course("Science", 6);
			Course english = new Course("English", 2);
			
			System.out.println("creating a new teacher-details object......");
			TeacherDetails teacherDetails = new TeacherDetails("Bangalore", "Karnataka");
			teacher1.addTeacherDetails(teacherDetails);
			
//			teacher1.addCourse(english);
//			teacher1.addCourse(science);
//			teacher1.addCourse(maths);
			
			session.beginTransaction();
			System.out.println("saving the teacher object");
			session.save(teacher1);
			session.getTransaction().commit();
			
		}catch(Exception e) {
			System.out.println("error");
			e.printStackTrace();
			 
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
}
