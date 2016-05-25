package com.sonal;

public abstract class Animal {
	
	private int age;
	private String name;
	
	
	public Animal(int age , String name) {
		setAge(age);
		setName(name);
		System.out.println("In Animal Constructor");
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		if (age < 0 || age > 100) {
			throw new IllegalArgumentException("age should be between 0 and 100 inclusive");
		}
		this.age = age;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		this.name = name;
	}
	
	public abstract void speak();
	
	

}
