package com.sonal.testCollection;
import java.util.*;

public class TestCollection8 {
	public static void main(String[] args) {
		LinkedHashMap<Integer, String> lhm= new LinkedHashMap<Integer , String>();
		lhm.put(100, "Amit");
		lhm.put(101, "Sonal");
		lhm.put(102, "Ravi");
		
		for (Map.Entry m:lhm.entrySet()) {
			System.out.println(m.getKey()+ "" +m.getValue());
		}
		
		
	}

}
