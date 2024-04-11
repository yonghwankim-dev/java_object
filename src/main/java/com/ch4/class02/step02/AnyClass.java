package com.ch4.class02.step02;

/**
 * Rectangle 캡슐화 개선
 */
public class AnyClass {
	void anyMethod(Rectangle rectangle, int multiple){
		rectangle.enlarge(multiple);
		System.out.println(rectangle);
	}

	public static void main(String[] args) {
		AnyClass anyClass = new AnyClass();
		anyClass.anyMethod(new Rectangle(2, 2, 2, 2), 5);
	}
}
