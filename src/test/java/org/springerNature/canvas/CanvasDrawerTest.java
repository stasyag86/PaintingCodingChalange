package org.springerNature.canvas;

import junit.framework.TestCase;

public class CanvasDrawerTest extends TestCase{
	
	public void testCreateCanvas(){
		CanvasDrawer canvasDrower = new CanvasDrawer();
		int width = 2;
		int height = 3;
		String [][] canvas = canvasDrower.createCanvas(width, height);
		assertEquals(height, canvas.length);
		assertEquals(width, canvas[0].length);
		
		for (int i = 0 ; i < height ; i++){
			for (int j = 0 ; j < width ; j++){
				assertEquals(" ",canvas[i][j]);
			}
		}
	}

}
