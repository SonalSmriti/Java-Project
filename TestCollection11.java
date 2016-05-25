package com.sonal.testCollection;

import java.util.*;
import java.io.*;

		
public class TestCollection11 {
	public static void main(String[] args) {
		ArrayList ar=new ArrayList();
		ar.add(new Student(101, "Vijay", 20));
		ar.add(new Student(106, "Sonal", 21));
		ar.add(new Student(105, "Ravi", 22));
		
		Collections.sort(ar);
		Iterator itr=ar.iterator();
		while(itr.hasNext()) {
			Student st=(Student)itr.next();
			System.out.println(st.rollno + "" +st.name+ ""+st.age);
	}
}
}

