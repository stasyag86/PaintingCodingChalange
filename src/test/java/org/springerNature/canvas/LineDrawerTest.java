package org.springerNature.canvas;

import junit.framework.TestCase;

public class LineDrawerTest extends TestCase{

	public void testDrawLineHorizontal(){
		LineDrawer lineDrawer = new LineDrawer();
		int width = 20;
		int height = 4;
		String [][] canvas = lineDrawer.createCanvas(width, height);
		lineDrawer.drawLine(canvas, 1, 2, 6, 2);
		assertEquals("x", canvas[2][1]);
		assertEquals("x", canvas[2][2]);
		assertEquals("x", canvas[2][3]);
		assertEquals("x", canvas[2][4]);
		assertEquals("x", canvas[2][5]);
		assertEquals("x", canvas[2][6]);
	}
	
	public void testDrawLineVertical(){
		LineDrawer lineDrawer = new LineDrawer();
		int width = 20;
		int height = 4;
		String [][] canvas = lineDrawer.createCanvas(width, height);
		lineDrawer.drawLine(canvas, 6, 2, 6, 3);
		assertEquals("x", canvas[2][6]);
		assertEquals("x", canvas[3][6]);
	}
}
