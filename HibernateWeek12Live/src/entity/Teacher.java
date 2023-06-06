package entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher")
public class Teacher {
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for auto-incrementimg the index
	private int id;
	@Column(name="f_name")
	private String f_name;
	@Column(name="l_name")
	private String l_name;
	@Column(name="email")
	private String email;
	
	//complex object
	@OneToOne(mappedBy = "teacher", cascade = CascadeType.ALL)
	private TeacherDetails teacherDetails;
	
	@OneToMany(mappedBy="teacher", cascade=CascadeType.ALL)
	private Set<Course> courses = new HashSet<>();
	
	public Teacher() {
		super();
	}

	public Teacher(String f_name, String l_name, String email) {
		super();
		this.f_name = f_name;
		this.l_name = l_name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TeacherDetails getTeacherDetails() {
		return teacherDetails;
	}

	public void setTeacherDetails(TeacherDetails teacherDetails) {
		this.teacherDetails = teacherDetails;
	}
	
	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	//scaffolding code to set both sides of the relationship to promote bi-directional mapping
	//it should be written in parent entity class
	public void addTeacherDetails(TeacherDetails theObjectOfTeacherDetails) {
		//here, "this" refers to the teacher object on which this method is called 
		this.setTeacherDetails(theObjectOfTeacherDetails);
		theObjectOfTeacherDetails.setTeacher(this);
	}
	
//	public void addCourse(Course theObjectOfCourse) {
//		this.courses.add(theObjectOfCourse);
//		theObjectOfCourse.setTeacher(this);
//	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", f_name=" + f_name + ", l_name=" + l_name + ", email=" + email + "]";
	}
	
}
