package com.sonal.testCollection;

import java.util.*;

public class TestCollection {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Sonal");
		al.add("Ravi");
		al.add("Ravi");
		al.add("Sunny");
		
		Iterator itr= al.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

}
