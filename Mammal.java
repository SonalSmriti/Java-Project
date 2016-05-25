package com.sonal;

public class Mammal implements AnimalInterface {

	@Override
	public void eats() {
		System.out.println("Mammal eats");
		
	}

	@Override
	public void moves() {
		System.out.println("Mammal moves");
	}
	public static void main(String[] args) {
		Mammal m=new Mammal();
		m.eats();
		m.moves();
	}

}
