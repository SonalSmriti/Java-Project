package com.sonal.testCollection;
import java.util.*;

public class TestCollection9 {
	public static void main(String[] args) {
		TreeMap<Integer, String> lhm= new TreeMap<Integer , String>();
		lhm.put(100, "Amit");
		lhm.put(105, "Sonal");
		lhm.put(102, "Ravi");
		
		for (Map.Entry m:lhm.entrySet()) {
			System.out.println(m.getKey()+ "" +m.getValue());
		}
		
		
	}

}
