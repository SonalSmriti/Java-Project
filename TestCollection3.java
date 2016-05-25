package com.sonal.testCollection;

import java.util.*;

class Student {
	int rollno;
	String name;
	int age;

	Student(int rollno , String name , int age){
		this.rollno=rollno;
		this.name=name;
		this.age=age;
	}
}




public class TestCollection3 {
	public static void main(String[] args) {
		Student s1 = new Student(101 , "Sonal" , 25);
		Student s2 = new Student(102 , "Ravi" , 26);
		Student s3 = new Student(103 , "Sunny", 22);
		
		ArrayList<String> al = new ArrayList<String>();
		al.add(s1);
		al.add(s2);
		al.add(s3);
		
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			Student st= (Student)itr.next();
			System.out.println(st.rollno + "" +st.name+ "" +st.age);
		}
		
	}

}
