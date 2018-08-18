package org.springerNature.cordinates;

public class InputCordinates {

	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private String color;
	
	public InputCordinates(int x1, int y1, int x2, int y2) {
		this.x1 = x1-1;
		this.y1 = y1-1;
		this.x2 = x2-1;
		this.y2 = y2-1;
	}
	
	public InputCordinates(int x1, int y1, String c) {
		this.x1 = x1-1;
		this.y1 = y1-1;
		this.color = c;
	}

	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String c) {
		this.color = c;
	}
	
	
}
