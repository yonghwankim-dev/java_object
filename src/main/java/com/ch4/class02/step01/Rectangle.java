package com.ch4.class02.step01;

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

	public int getLeft() {
		return left;
	}

	public int getTop() {
		return top;
	}

	public int getRight() {
		return right;
	}

	public int getBottom() {
		return bottom;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public void setTop(int top) {
		this.top = top;
	}

	public void setRight(int right) {
		this.right = right;
	}

	public void setBottom(int bottom) {
		this.bottom = bottom;
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
