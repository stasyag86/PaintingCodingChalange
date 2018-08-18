package org.springerNature.canvas;

import java.util.Arrays;

public class CanvasDrawer implements IDrawer{
	
	public String[][] createCanvas(int width, int height) {
		String [][] canvas = new String [height][width];
		for (int i = 0 ; i < height ; i++){
			Arrays.fill(canvas[i], " ");
		}
		return canvas;
		
	}
	
	public void printCanvas(String [][] canvas){
		printRowFrame(canvas);		// print upper row "------"
		printCanvasContent(canvas);
		printRowFrame(canvas);		// print lower row "------"
	}
	
	private void printRowFrame (String [][] canvas){
		int width = getCanvasWidth(canvas) + 2;
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < width; i++){
			stringBuilder.append("-");
		}
		System.out.println(stringBuilder);
	}
	
	private void printCanvasContent(String [][] canvas){
		int height = getCanvasHeight(canvas);
		int width = getCanvasWidth(canvas);
		for (int i=0 ; i < height ; i++){
			StringBuilder stringBuilder = new StringBuilder();
			for (int j=0; j < width ; j++){
				if (j == 0){
					stringBuilder.append("|");
				}
				stringBuilder.append(canvas[i][j]);
			}
			stringBuilder.append("|");
			System.out.println(stringBuilder);
		}
	}

	protected int getCanvasHeight(String [][] canvas){
		return canvas.length;
	}
	
	protected int getCanvasWidth(String [][] canvas){
		return canvas[0].length;
	}
}
