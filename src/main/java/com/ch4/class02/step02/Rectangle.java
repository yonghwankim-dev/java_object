package com.ch4.class02.step02;

public class Rectangle {
	private int left;
	private int top;
	private int right;
	private int bottom;

	public Rectangle(int left, int top, int right, int bottom) {
		this.left = left;
		this.top = top;
		this.right = right;
		this.bottom = bottom;
	}

	public void enlarge(int multiple){
		right *= multiple;
		bottom *= multiple;
	}

	@Override
	public String toString() {
		return "Rectangle{" +
			"left=" + left +
			", top=" + top +
			", right=" + right +
			", bottom=" + bottom +
			'}';
	}
}
