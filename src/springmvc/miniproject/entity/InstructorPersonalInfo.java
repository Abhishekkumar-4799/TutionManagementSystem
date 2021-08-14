package springmvc.miniproject.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_personal_info")
public class InstructorPersonalInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="instructor_name")
	private String name;
	
	@OneToOne(mappedBy="instructorPersonalInfo",
			  cascade= CascadeType.ALL
			 )
	private InstructorDigitalInfo instructorDigitalInfo;
	
	public InstructorPersonalInfo() {}
	public InstructorPersonalInfo(int id, String name, LocalDate dateOfBirth) {
		//super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public InstructorDigitalInfo getInstructorDigitalInfo() {
		return instructorDigitalInfo;
	}
	public void setInstructorDigitalInfo(InstructorDigitalInfo instructorDigitalInfo) {
		this.instructorDigitalInfo = instructorDigitalInfo;
	}
	
}
