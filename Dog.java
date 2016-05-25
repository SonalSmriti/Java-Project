package com.sonal;

import com.sonal.Animal;

public class Dog extends Animal {

	public Dog(int age, String name) {
		super(age, name);
		System.out.println("This is Dog Constructor");
	}

	@Override
	public void speak() {
		System.out.println("Boow Boow"+ " My name is" + getName());

	}
	/* (non-Javadoc)
	 * @see com.sonal.Vegetarian#eats()
	 */
	public void eats() {
		System.out.println("Dog eats bones");
	}

}
