package com.sonal.testCollection;

import java.lang.*;

public class Student implements Comparable {
	int rollno;
	String name;
	int age;
	Student(int rollno , String name , int age) {
	this.rollno=rollno;
	this.age=age;
	this.name=name;
}
	
public int compareTo(Object obj) {
	Student st=(Student)obj;
	if(age==st.age)
	return 0;
	else if(age >st.age)
	return 1;
	else return -1;
	}
}
