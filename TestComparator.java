package com.sonal.testCollection;
import java.util.*;
import java.lang.*;

public class TestComparator {
	public static void main(String[] args) {
		
	ArrayList ar=new ArrayList();
	ar.add(new Student1(111,"Sonal", 20));
	ar.add(new Student1(112,"Sunny", 22));
	ar.add(new Student1(113,"Ravi", 25));
	
	System.out.println("Sort by Name");
	Collections.sort(ar, new NameComparator());
	Iterator itr=ar.iterator();
	while (itr.hasNext()) {
		Student1 st=(Student1)itr.next();
		System.out.println(st.rollno +""+st.name +""+st.age);
	}
	
	System.out.println("Sort by age");
	Collections.sort(ar , new AgeComparator());
	Iterator itr2 = ar.iterator();
	while(itr2.hasNext()){
		Student1 st=(Student1)itr2.next();
				System.out.println(st.rollno+ ""+st.name+""+st.age);
	}
	

}
}
