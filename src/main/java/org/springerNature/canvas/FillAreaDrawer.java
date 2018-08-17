package org.springerNature.canvas;

public class FillAreaDrawer extends CanvasDrawer{

	public void fillArea (String [][] canvas , int x , int y , String color){
		paintCoordinates(canvas, x, y, color);
	}
	
	/**
	 * recursive method to color each point with its 4 adjacent points (up,down,right,left)
	 * @param canvas
	 * @param x
	 * @param y
	 * @param color
	 */
	private void paintCoordinates(String [][] canvas , int x , int y , String color){
		if (isValidCoordinate(canvas, x, y, color)){
			canvas[y][x] = color;
			paintCoordinates(canvas, x, y-1, color);	// check upper point
			paintCoordinates(canvas, x+1, y, color);	// check point to the right
			paintCoordinates(canvas, x, y+1, color);	// check down point
			paintCoordinates(canvas, x-1, y, color);	// check point to the left
		}
		
	}
	
	/**
	 * this method will check whether current point should be painted or not
	 * @param canvas
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	private boolean isValidCoordinate(String [][] canvas , int x , int y , String color){
		int height = getCanvasHeight(canvas);
		int width = getCanvasWidth(canvas);
		if (x >= 0 && x < width && y >= 0 && y < height){		//if inside matrix
			if (isColorCoordinate(canvas, x, y,color)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * this method will check whether the point we want to color is already colored 
	 * or its a part of line
	 * @param canvas
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	private boolean isColorCoordinate(String [][] canvas, int x, int y, String color){
		String coordinateColor = canvas[y][x];
		if (coordinateColor.equalsIgnoreCase("x") || coordinateColor.equalsIgnoreCase(color)){
			return false;
		}
		return true;
	}
}
