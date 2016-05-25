package com.sonal;

import java.security.GeneralSecurityException;

public class Encap {
	private int age;
	private String name;
	private String city;
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setName (String Newname) {
		name = Newname;
		
	}
	
	public void setCity (String city) {
		this.city = city;
	}
	
	public static void main(String[] args) {
		Encap e = new Encap();
		e.setAge(11);
		e.setName("Sonal");
		e.setCity("Dehradun");
		System.out.println("Name is " + e.getName());
		System.out.println("Age is" + e.getAge());
		System.out.println("City is " + e.getCity());
	}
	

}
