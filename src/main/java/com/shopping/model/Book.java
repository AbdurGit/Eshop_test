package com.shopping.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Book {
	@Id
 private int id;
 private String title;
 
 @ManyToOne
 private Student student;
 
 public Book() {
		
	}

public Book(int id, String title, Student student) {
	super();
	this.id = id;
	this.title = title;
	this.student = student;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public Student getStudent() {
	return student;
}

public void setStudent(Student student) {
	this.student = student;
}
 
}
