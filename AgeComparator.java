package com.sonal.testCollection;

import java.util.*;

public class AgeComparator implements Comparator {
	public int compare(Object obj1, Object obj2) {
		Student1 s1= (Student1)obj1;
		Student1 s2= (Student1)obj2;
		
		if (s1.age==s2.age)
			return 0;
		else if(s1.age>s2.age)
			return 1;
		else 
			return -1;
		
	}
	

}
