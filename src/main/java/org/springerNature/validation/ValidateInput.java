package org.springerNature.validation;

import org.springerNature.constants.ConstantsUtil;

public class ValidateInput implements IValidate{
	
	private static int canvasHeight = -1;
	private static int canvasWidth = -1;

	public boolean isValidInput(String input) {
		if (!isEmptyString(input)){
			String[] splitedInput = input.split("\\s+");
			String command = splitedInput[0];
			switch (command) {
			case ConstantsUtil.DRAW_CANVAS:
				return isValidCanvas(splitedInput);
			case ConstantsUtil.DRAW_LINE:
				return isValidLine(splitedInput);
			case ConstantsUtil.DRAW_RECTANGLE:
				return isValidRectangle(splitedInput);
			case ConstantsUtil.FILL_ENTIRE_AREA:
				return isValidFillArea(splitedInput);
			case ConstantsUtil.EXIT_PROGRAM:
				return true;
			}
		}
		System.out.println("unknown command");
		return false;
	}
	
	public boolean isEmptyString (String str){
		if (str == null || str.equalsIgnoreCase("")){
			return true;
		}
		return false;
	}
	
	public boolean isValidCanvas(String[] splitedInput){
		int width = -1;
		int height = -1;
		try {
			width = Integer.parseInt(splitedInput[1]);
			height = Integer.parseInt(splitedInput[2]);
		} catch (NumberFormatException e) {
			System.out.println("enter valid numbers please");
			return false;
		} catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Create Canvas require height and width");
			return false;
		}
		
		if (width > 0 && height > 0){
			canvasHeight = height;
			canvasWidth = width;
			return true;
		}else{
			System.out.println("enter numbers bigger than 0 please");
			return false;
		}
	}
	
	public boolean isValidLine(String[] splitedInput){
		int x1 = -1;
		int y1 = -1;
		int x2 = -1;
		int y2 = -1;
		try {
			x1 = Integer.parseInt(splitedInput[1]);
			y1 = Integer.parseInt(splitedInput[2]);
			x2 = Integer.parseInt(splitedInput[3]);
			y2 = Integer.parseInt(splitedInput[4]);
		} catch (NumberFormatException e) {
			System.out.println("enter valid numbers please");
			return false;
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("require X1 Y1 X2 Y2");
			return false;
		}
		
		if (x1 > 0 && y1 > 0 && x2 > 0 && y2 > 0){
			if (x2 >= x1 && y2 >= y1){
				if (x2 <= canvasWidth && y2 <= canvasHeight){
					return true;
				}
			}
		}
		System.out.println("values are inccurect or extend canvas frame");
		return false;
	}
	
	private boolean isValidRectangle(String[] splitedInput){
		return isValidLine(splitedInput);
	}

	public boolean isValidFillArea(String[] splitedInput){
		int x1 = -1;
		int y1 = -1;
		String color = "";
		try {
			x1 = Integer.parseInt(splitedInput[1]);
			y1 = Integer.parseInt(splitedInput[2]);
			color = splitedInput[3];
		} catch (NumberFormatException e) {
			System.out.println("enter valid numbers please");
			return false;
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("require X1 Y1 C");
			return false;
		}
		
		if (x1 <= canvasWidth && y1 <= canvasHeight){
			if (color.length() == 1){
				return true;
			}
		}
		System.out.println("values are inccurect or extend canvas frame");
		return false;
	}
	
	
	
}
