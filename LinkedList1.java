package com.sonal.testCollection;

import java.util.*;

public class LinkedList1 {
	public static void main(String[] args) {
		LinkedList<String> l1 = new LinkedList<String>();
		l1.add("Ravi");
		l1.add("Sonal");
		l1.add("Ravi");
		
		Iterator<String> itr=l1.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		
		}

}
