package com.sonal;

public class My_calculation extends Calculation {
	
	public void multiplication (int x , int y) {
		z = x*y;
		System.out.println("Multiplication os two numbers is" +z);
	}
	
	public static void main(String[] args) {
		int x = 20 ; int y = 10;
		My_calculation calc = new My_calculation();
		calc.addition(x, y);
		calc.subtraction(x, y);
		calc.multiplication(x, y);
		Calculation calc1 = new Calculation();
		calc1.addition(x, y);
		calc1.addition(x, y);
		System.out.println(calc instanceof My_calculation);
		System.out.println(calc1 instanceof Calculation);
		System.out.println(calc instanceof Calculation);
		System.out.println(calc1 instanceof My_calculation);
		
	}
}
