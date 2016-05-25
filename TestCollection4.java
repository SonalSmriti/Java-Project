package com.sonal.testCollection;

import java.util.*;

public class TestCollection4 {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Ravi");
		al.add("Sonal");
		al.add("Sunny");
		al.add("Rinni");
		
		ArrayList<String> al1 = new ArrayList<String>();
		al1.add("Riya");
		al1.add("Ravi");
		
		//al.addAll(al1);
		//al.remove(al1);
		al.retainAll(al1);
		
		Iterator itr = al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
