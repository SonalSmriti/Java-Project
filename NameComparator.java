package com.sonal.testCollection;

import java.util.*;

public class NameComparator implements Comparator{
	public int compare(Object obj1 , Object obj2) {
		Student1 s1=(Student1)obj1;
		Student1 s2=(Student1)obj2;
		
		return s1.name.compareTo(s2.name);
	}
	

}
