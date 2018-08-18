package org.springerNature.canvas;

import junit.framework.TestCase;

public class FillAreaDrawerTest extends TestCase{

	public void testFillArea(){		
		int width = 20;
		int height = 4;
		RectangleDrawer rectangleDrawer = new RectangleDrawer();
		FillAreaDrawer fillAreaDrawer = new FillAreaDrawer();
		String [][] canvas = rectangleDrawer.createCanvas(width, height);
		rectangleDrawer.drawRectangle(canvas, 15, 0, 19, 2);
		fillAreaDrawer.fillArea(canvas, 16, 1, "o");
		// check colored
		assertEquals("o", canvas[1][16]);
		assertEquals("o", canvas[1][17]);
		assertEquals("o", canvas[1][18]);
		
		//check not colored
		assertEquals(" ", canvas[0][14]);
		assertEquals(" ", canvas[1][14]);
		assertEquals(" ", canvas[2][14]);
		assertEquals(" ", canvas[3][14]);
		assertEquals(" ", canvas[3][15]);
		assertEquals(" ", canvas[3][16]);
		assertEquals(" ", canvas[3][17]);
		assertEquals(" ", canvas[3][18]);
		assertEquals(" ", canvas[3][19]);
		
	}
	
}
