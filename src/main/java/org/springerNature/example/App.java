package org.springerNature.example;

import java.util.Scanner;

import org.springerNature.canvas.CanvasDrawer;
import org.springerNature.canvas.FillAreaDrawer;
import org.springerNature.canvas.LineDrawer;
import org.springerNature.canvas.RectangleDrawer;
import org.springerNature.constants.ConstantsUtil;
import org.springerNature.cordinates.InputCordinates;
import org.springerNature.validation.IValidate;
import org.springerNature.validation.ValidateInput;

public class App 
{
	private static String[][] canvas = null;
	private static CanvasDrawer canvasDrower = new CanvasDrawer();
	private static LineDrawer lineDrawer = new LineDrawer();
	private static RectangleDrawer rectangleDrawer = new RectangleDrawer();
	private static FillAreaDrawer fillAreaDrawer = new FillAreaDrawer();
	
    public static void main( String[] args )
    {
    	startProgram();
    }
    
    public static void startProgram(){
    	IValidate inputValidator = new ValidateInput();
    	String input = "";
    	do{
    		Scanner inputReader = new Scanner(System.in);  // Reading from System.in
        	System.out.print("enter command: ");
        	input = inputReader.nextLine();
        	if (inputValidator.isValidInput(input)){
        		handleInput(input);
        	}
    	}while(!isExitProgram(input));
    	
    	System.out.println("Good Bye !");
    }
    
    public static void handleInput(String input){
    	String[] splitedInput = input.split("\\s+");
    	String command = splitedInput[0];
    	if (isExitProgram(command)){
    		return;
    	}
    	
    	InputCordinates inputCordinates = getInputCordinates(splitedInput);
    	switch (command) {
		case ConstantsUtil.DRAW_CANVAS:
			hadleDrawCanvas(inputCordinates);
			break;
		case ConstantsUtil.DRAW_LINE:
			handleDrawLine(inputCordinates);
			break;
		case ConstantsUtil.DRAW_RECTANGLE:
			handleDrawRectangle(inputCordinates);
			break;
		case ConstantsUtil.FILL_ENTIRE_AREA:
			handleFillArea(inputCordinates);
			break;
		default:
			break;
		}
    	canvasDrower.printCanvas(canvas);
    }
    
    private static void hadleDrawCanvas(InputCordinates inputCordinates){
    	int width = inputCordinates.getX1();
		int height = inputCordinates.getY1();
		canvas = canvasDrower.createCanvas(width, height);
    }
    
    private static void handleDrawLine(InputCordinates inputCordinates){
    	lineDrawer.drawLine(canvas, inputCordinates.getX1(), inputCordinates.getY1(),
				inputCordinates.getX2(), inputCordinates.getY2());
    }
    
    private static void handleDrawRectangle(InputCordinates inputCordinates){
    	rectangleDrawer.drawRectangle(canvas, inputCordinates.getX1(), inputCordinates.getY1(),
				inputCordinates.getX2(), inputCordinates.getY2());
    }
    
    private static void handleFillArea(InputCordinates inputCordinates){
    	fillAreaDrawer.fillArea(canvas, inputCordinates.getX1(), inputCordinates.getY1(),
				inputCordinates.getColor());
    }
    
    public static InputCordinates getInputCordinates(String[] splitedInput){
    	InputCordinates inputCordinates = null;
    	String command = splitedInput[0];
    	int x1 = Integer.parseInt(splitedInput[1]);
		int y1 = Integer.parseInt(splitedInput[2]);
		int x2;
		int y2;
    	switch (command) {
    	case ConstantsUtil.DRAW_CANVAS:
    		inputCordinates = new InputCordinates(x1 + 1, y1 + 1, 0, 0);
    		break;
    	case ConstantsUtil.DRAW_LINE: 
    	case ConstantsUtil.DRAW_RECTANGLE:
			x2 = Integer.parseInt(splitedInput[3]);
			y2 = Integer.parseInt(splitedInput[4]);
			inputCordinates = new InputCordinates(x1, y1, x2, y2);
			break;
    	case ConstantsUtil.FILL_ENTIRE_AREA:
			String c = splitedInput[3];
			inputCordinates = new InputCordinates(x1, y1, c);
			break;
    	}
    	return inputCordinates;
    }
    
    
    public static boolean isExitProgram(String input){
    	if(input.equalsIgnoreCase(ConstantsUtil.EXIT_PROGRAM)){
    		return true;
    	}
    	return false;
    }
    
}
