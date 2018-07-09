package de.haw_hamburg.mt.p2.projekt.finnazad;

import java.awt.Graphics;
import java.io.Serializable;
//import java.awt.Rectangle;

public class MyRectangle extends MyFormTemplate implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	private Graphics g;
	private int height;
	private int width;
	
	public MyRectangle(int x, int y, int height, int width) {
		super(x, y);
		this.height = height;
		this.width = width;
		
	}

//	public MyRectangle(int x, int y, int height2, int width2) {
//		super(x, y);
//		this.height = height;
//		this.width = width;
//	}
	
	
	public boolean clickedInside(int mouseX, int mouseY) {
		
		int xPos = getX();
		int yPos = getY();
		
		if(mouseX >= xPos && mouseY >= yPos) {
			if(mouseX <= (xPos + width) && mouseY <= (yPos + height) ){
				return true;
				
			}
		}
		
		return false;
	}
	
	public void moveTo(int x, int y){
		setX(x);
		setY(y);

		setChanged();
		notifyObservers();
	}

	public void resizeWidth(int width){
		this.width = width;
	}

	public void resizeHeight(int height){

	}
	
	void draw(Graphics g) {
		
		g.setColor(getC());
		g.fillRect(getX(), getY(), width, height);
			
	}
}
