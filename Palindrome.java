package com.sonal;

public class Palindrome {
	public static void main(String[] args) {
	String str="sos";
	String revstring="";
	
	
	for(int i=str.length()-1; i>=0 ;i--) {
		revstring += str.charAt(i);
	}
	System.out.println(revstring);
	if (revstring.equalsIgnoreCase(str)){
		System.out.println("The String is a Palindorme");
	}
	else {
		System.out.println("The String is not a Palindrome");
	}
}

}
