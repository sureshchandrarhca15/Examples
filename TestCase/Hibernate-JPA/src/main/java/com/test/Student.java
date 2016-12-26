package com.test;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

	public Student() {

	}

	public Student(String id) {
		super(id);
	}

	public String universityID;

	public String getUniversityID() {
		return universityID;
	}

	public void setUniversityID(String universityID) {
		this.universityID = universityID;
	}

	
	
	
}
