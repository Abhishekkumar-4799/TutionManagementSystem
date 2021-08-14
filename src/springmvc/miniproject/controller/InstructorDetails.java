package springmvc.miniproject.controller;

import java.util.List;

import springmvc.miniproject.entity.InstructorDigitalInfo;
import springmvc.miniproject.entity.InstructorPersonalInfo;

public class InstructorDetails {
	InstructorPersonalInfo instructorPersonalInfo;
	InstructorDigitalInfo instructorDigitalInfo;
	public InstructorPersonalInfo getInstructorPersonalInfo() {
		return instructorPersonalInfo;
	}
	public void setInstructorPersonalInfo(InstructorPersonalInfo instructorPersonalInfo) {
		this.instructorPersonalInfo = instructorPersonalInfo;
	}
	public InstructorDigitalInfo getInstructorDigitalInfo() {
		return instructorDigitalInfo;
	}
	public void setInstructorDigitalInfo(InstructorDigitalInfo instructorDigitalInfo) {
		this.instructorDigitalInfo = instructorDigitalInfo;
	}
}
