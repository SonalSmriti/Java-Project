package com.sonal;

import com.sonal.Animal;

public class Cat extends Animal {

	public Cat(int age, String name) {
		super(age, name);
		System.out.println("This is Cat Constructor");
	}

	@Override
	public void speak() {
		System.out.println("Meew Meew" + "My name is" + getName());
	}


	

}
