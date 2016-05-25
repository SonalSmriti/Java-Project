package com.sonal.testCollection;
import java.util.*;

public class TestCollection5 {
	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();
		al.add("Sonal");
		al.add("Ravi");
		al.add(1,"Sunny");
		al.add("Rinni");
		
		System.out.println("element at 2nd position is " + al.get(2));
		
		ListIterator<String> itr=al.listIterator();
		System.out.println("traversing elements in forward direction");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
		System.out.println("traversing elements in backward direction");
		while(itr.hasPrevious()){
			System.out.println(itr.previous());
		}
		
	}

}
