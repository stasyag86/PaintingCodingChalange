package org.springerNature.canvas;

public class RectangleDrawer extends LineDrawer{
	
	public void drawRectangle (String [][] canvas , int x1 , int y1 , int x2 , int y2){
		drawHorizontalLine(canvas, x1, y1, x2, y1);	//draw upper line
		drawVerticalLine(canvas, x1, y1, x1, y2);	//draw left border
		drawVerticalLine(canvas, x2, y1, x1, y2);	//draw right border
		drawHorizontalLine(canvas, x1, y2, x2, y1);	//draw bottom line
	}

}
