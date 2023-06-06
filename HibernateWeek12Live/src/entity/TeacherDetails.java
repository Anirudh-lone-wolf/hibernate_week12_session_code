package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "teacher_details")
public class TeacherDetails {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) //for auto-incrementimg the index
	private int id;
	
	@Column(name="city", nullable = false)
	private String city;
	
	@Column(name="state", nullable = false)
	private String state;
	
	@OneToOne
	@JoinColumn(name = "teacher_id", nullable = false) //this is owner of the one-to-one birectional mapping.
	private Teacher teacher;

	public TeacherDetails() {
		super();
	}

	public TeacherDetails(String city, String state) {
		super();
		this.city = city;
		this.state = state;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Override
	public String toString() {
		return "TeacherDetails [id=" + id + ", city=" + city + ", state=" + state + "]";
	}

}
