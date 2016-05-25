package com.sonal;

public class RectAbs extends ShapeAbs {

	@Override
	void draw() {System.out.println("Drawing Rectangle");
	}
	
	public static void main(String[] args) {
		//ShapeAbs s =new ShapeAbs();
		ShapeAbs s1=new RectAbs();
		//ShapeAbs s2=new CircleAbs();
		s1.draw();
		s1.paint();
	}

	@Override
	void paint() {System.out.println("Painting Rectangle");
		
	}


}
