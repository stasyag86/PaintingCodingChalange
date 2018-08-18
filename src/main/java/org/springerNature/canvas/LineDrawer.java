package org.springerNature.canvas;

public class LineDrawer extends CanvasDrawer{

	public void drawLine (String [][] canvas , int x1 , int y1 , int x2 , int y2){
		if (isDrawHorizontal(y1, y2)){
			drawHorizontalLine(canvas, x1, y1, x2, y2);
		}else{
			drawVerticalLine(canvas, x1, y1, x2, y2);
		}
	}
	
	protected void drawHorizontalLine(String [][] canvas , int x1 , int y1 , int x2 , int y2){
		for (int i = x1 ; i <= x2 ; i++){
			canvas[y1][i] = "x";
		}
	}
	
	protected void drawVerticalLine(String [][] canvas , int x1 , int y1 , int x2 , int y2){
		for (int i = y1 ; i <= y2 ; i++){
			canvas[i][x1] = "x";
		}
	}
	
	private boolean isDrawHorizontal (int y1 , int y2){
		if (y1 == y2){
			return true;
		}
		return false;
	}

}
