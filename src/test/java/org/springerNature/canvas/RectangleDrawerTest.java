package org.springerNature.canvas;

import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RectangleDrawerTest extends TestCase{

	@Test
	public void testDrawRectangle(){
		int width = 20;
		int height = 4;
		RectangleDrawer rectangleDrawer = new RectangleDrawer();
		String [][] canvas = rectangleDrawer.createCanvas(width, height);
		rectangleDrawer.drawRectangle(canvas, 15, 0, 19, 2);
		assertEquals("x", canvas[0][15]);
		assertEquals("x", canvas[0][16]);
		assertEquals("x", canvas[0][17]);
		assertEquals("x", canvas[0][18]);
		assertEquals("x", canvas[0][19]);
		assertEquals("x", canvas[1][15]);
		assertEquals("x", canvas[1][15]);
		assertEquals("x", canvas[2][15]);
		assertEquals("x", canvas[2][16]);
		assertEquals("x", canvas[2][17]);
		assertEquals("x", canvas[2][18]);
		assertEquals("x", canvas[2][19]);
	}
}
