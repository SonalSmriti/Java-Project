package com.sonal.testCollection;

import java.util.*;

public class TestCollection10 {
	public static void main(String[] args) {
		ArrayList<String> ar= new ArrayList<String>();
		ar.add("Sonal");
		ar.add("Ravi");
		ar.add("Rinni");
		
		Collections.sort(ar);
		
		Iterator<String> itr=ar.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
