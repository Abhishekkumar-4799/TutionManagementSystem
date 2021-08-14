package springmvc.miniproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="instructor_digital_info")
public class InstructorDigitalInfo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="email")
	private String email;
	@Column(name="linkedin_profile")
	private String linkedIn;
	@Column(name="insta_profile")
	private String instaProfile;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="instructor_Id")
	private InstructorPersonalInfo instructorPersonalInfo;
	
	public InstructorDigitalInfo() {
		
	}
	public InstructorDigitalInfo(String email, String linkedIn, String instaProfile) {
		this.email = email;
		this.linkedIn = linkedIn;
		this.instaProfile = instaProfile;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLinkedIn() {
		return linkedIn;
	}
	public void setLinkedIn(String linkedIn) {
		this.linkedIn = linkedIn;
	}
	public String getInstaProfile() {
		return instaProfile;
	}
	public void setInstaProfile(String instaProfile) {
		this.instaProfile = instaProfile;
	}
	public InstructorPersonalInfo getInstructorPersonalInfo() {
		return instructorPersonalInfo;
	}
	public void setInstructorPersonalInfo(InstructorPersonalInfo instructorPersonalInfo) {
		this.instructorPersonalInfo = instructorPersonalInfo;
	} 	
//	public int getInstructorId() {
//		return instructorId;
//	}
//	public void setInstructorId(int instructorId) {
//		this.instructorId = instructorId;
//	} 
	@Override
	public String toString() {
		return "instructorDigitalInfo [id=" + id + ", email=" + email + ", linkedIn=" + linkedIn + ", instaProfile="
				+ instaProfile + "]";
	}
}
