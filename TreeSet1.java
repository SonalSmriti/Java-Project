package com.sonal.testCollection;
import java.util.*;


public class TreeSet1 {
	public static void main(String[] args) {
		TreeSet<String> t1=new TreeSet<String>();
		t1.add("Ravi");
		t1.add("Sonal");
		t1.add("Ankita");
		t1.add("Sonal");
		
		Iterator<String> itr=t1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
