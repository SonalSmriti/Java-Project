package com.sonal.testCollection;

import java.util.*;

class HashSet {
	public static void main(String[] args) {
		LinkedHashSet<String> h1 = new LinkedHashSet<String>();
		h1.add("Ravi");
		h1.add("Sonal");
		h1.add("Ravi");
		h1.add("Sunny");
		
		Iterator<String> itr= h1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
	}

}
