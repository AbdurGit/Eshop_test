package com.shopping.model;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {

	@Id
	private int rollNo;
	private String fname;
	private String lname;

	@OneToMany(mappedBy = "student")
	private List<Book> booklist;
	@ManyToMany(mappedBy = "studentList")
	private List<Class> classList;

	public Student() {

	}

	public Student(int rollNo, String fname, String lname, List<Book> booklist, List<Class> classList) {
		super();
		this.rollNo = rollNo;
		this.fname = fname;
		this.lname = lname;
		this.booklist = booklist;
		this.classList = classList;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public List<Book> getBooklist() {
		return booklist;
	}

	public void setBooklist(List<Book> booklist) {
		this.booklist = booklist;
	}

	public List<Class> getClassList() {
		return classList;
	}

	public void setClassList(List<Class> classList) {
		this.classList = classList;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", fname=" + fname + ", lname=" + lname + ", booklist=" + booklist
				+ ", classList=" + classList + "]";
	}

}
