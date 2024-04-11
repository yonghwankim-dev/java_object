package com.ch4.class02.step01;

public class AnyClass {
	void anyMethod(Rectangle rectangle, int multiple){
		rectangle.setRight(rectangle.getRight() * multiple);
		rectangle.setBottom(rectangle.getBottom() * multiple);
		System.out.println(rectangle);
	}

	public static void main(String[] args) {
		AnyClass anyClass = new AnyClass();
		anyClass.anyMethod(new Rectangle(2, 2, 2, 2), 5);
	}
}
