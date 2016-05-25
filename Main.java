package com.sonal;

import com.sonal.Animal;

public class Main {
	public static void main(String[] args) {
		Animal a = new Dog(1 , "Tommy");
		Animal b = new Cat(2 , "Tom");
		Cat c= new Cat(3 , "tom1");
		makeAnimalSpeak(a);
		makeAnimalSpeak(b);
		makeAnimalSpeak(c);
		a.speak();
		b.speak();
		c.speak();
		
	}
	
	public static void makeAnimalSpeak(Animal animal) {
		animal.speak();
		
	}
		
	}


