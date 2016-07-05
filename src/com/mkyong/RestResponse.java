package com.mkyong;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RestResponse {
	private Student student;
	public void setStudent(Student student) {
		this.student = student;
	}
	public Student getStudent() {
		return student;
	}
}
