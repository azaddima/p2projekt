package de.haw_hamburg.mt.p2.projekt.finnazad;


	import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;

import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

	public class Controller {
		
	
	private Rectangle rect = new Rectangle(200,300,300,300);
	private PaintArea paintArea;
	private MyFormTemplate form;
	private Gui view = new Gui();
	    
    public Controller(){
    	
    	
    	
    	//get Canvas
    	paintArea = view.getPaintArea();
    	
    	//add rects
    	paintArea.addRect(100, 100);
    	paintArea.addRect(250, 100);
    	
    	//connect observer and observable at startup
    	connectObservers();
    	
    	
    	view.getColorSliderRed().addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
				if(form != null) {
					int redValue = view.getColorSliderRed().getValue();
					form.setR(redValue);
					System.out.println(form.getR());
					
					//update internal color
					form.setC();
					paintArea.repaint();
				}
			
			}
		});
    	
		view.getColorSliderGreen().addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
				if(form != null) {
					int greenValue = view.getColorSliderGreen().getValue();
					form.setG(greenValue);
					System.out.println(form.getG());
					
					//update internal color
					form.setC();
					paintArea.repaint();
				}
			}
		});
		
		view.getColorSliderBlue().addChangeListener(new ChangeListener() {
			
			public void stateChanged(ChangeEvent e) {
				
				if(form != null) {
					int blueValue = view.getColorSliderBlue().getValue();
					form.setB(blueValue);
					System.out.println(form.getB());
					
					//update internal color
					form.setC();
					paintArea.repaint();
				}
				
			
			}
		});
			
		
		// COLOR TEXTAREA
		view.getTextField().addKeyListener(new KeyAdapter() {
			
			
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkChange();
				}
			}
			
			public void checkChange() {
				 
				 int value = Integer.parseInt(view.getTextField().getText());
			     if ( value < 0 || value > 255){
			       JOptionPane.showMessageDialog(null,
			          "Error: Eine gültige Zahl eingeben: 0 -255", "Error Massage",
			          JOptionPane.ERROR_MESSAGE);
			     } else {
			    	 view.getColorSliderRed().setValue(value);
			     }
			
			}
		});
		
		view.getTextField_1().addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkChange();
				}
			}
			
			public void checkChange() {
				 
				 int value = Integer.parseInt(view.getTextField_1().getText());
			     if ( value < 0 || value > 255){
			       JOptionPane.showMessageDialog(null,
			          "Error: Eine gültige Zahl eingeben: 0 -255", "Error Massage",
			          JOptionPane.ERROR_MESSAGE);
			     } else {
			    	 view.getColorSliderGreen().setValue(value);
			     }
			
			}
		});
		
		view.getTextField_2().addKeyListener(new KeyAdapter() {
			
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					checkChange();
				}
			}
			
			public void checkChange() {
				
				 int value = Integer.parseInt(view.getTextField_2().getText());
			     if ( value < 0 || value > 255){
			       JOptionPane.showMessageDialog(null,
			          "Error: Eine gültige Zahl eingeben: 0 -255", "Error Massage",
			          JOptionPane.ERROR_MESSAGE);
			     } else {
			    	 view.getColorSliderBlue().setValue(value);
			     }
			}
		});
			
    	
		
		// -------
		// BOTTOM TAB
		// -------
		
    	view.getAddRectBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				view.getStopPntBtn().setVisible(true);
				//Paintstate [1](Rectangle)
				System.out.println("PaintState changed to 1");
				paintArea.setPaintState(1);
			}
		});
    	
    	view.getStopPntBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
		
				//Disable PaintStopButton
				view.getStopPntBtn().setVisible(false);
				
				//PaintState reset to 0. 
				System.out.println("PaintState resetet: " + paintArea.getPaintState());
				paintArea.resetPaintState();
			}
		});
    	
    	
    	// MOUSELISTENER
    	paintArea.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
				//---
				//PAINTSTATE 0
				// ---
				//sets active layer if object is clicked
				paintArea.objectsInPos(e.getX(), e.getY());

				//sets active FORM - for editing
				form = paintArea.getActiveRect();
				
				//---
				//PAINT STATE 1
				//---
				//ADD RECTANGLE
				int dimensions = 25; // starting size for rectangles
				System.out.println("PaintState: " + paintArea.getPaintState());
				if(paintArea.getPaintState() == 1) {
					
					paintArea.addRect(e.getX() - dimensions, e.getY() - dimensions);
					paintArea.repaint();
					
					// should add the connect observer and observable here
				}
			}
			
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
		});
    	

    	
//    	view.getPaintArea().repaint();

       
        
//        Timer timer = new Timer(10, new ActionListener() {
//        	
//        	public void actionPerformed(ActionEvent e) {
//        		
//        		//TODO - export to RECTANGLE class
//        		
//                rect.x += 5; // alle 10 ms
//
//                rect.y = (int) ((view.getBounds().height / 4) * Math.sin(rect.x * 0.005f)) + (view.getBounds().height / 2) -150;
//
//                if(rect.x > view.getBounds().width){
//                    rect.x = -230;
//                }
//
//                //change color ------------------
//                Color c = view.getPaintArea().getC();
//                int r = c.getRed();
//                int g = c.getGreen();
//                int b = c.getBlue();
//
//                r++;
//                g+= 10;
//                b+= 5;
//
//                r %= 255;
//                g %= 255;
//                b %= 255;
//
//                c = new Color(r,g,b);
//                view.getPaintArea().setC(c);
//
//
//                view.getPaintArea().repaint();
//
////                for (int i = 0; i < 10; i++) {
////
////                }
//                
//            }
//        });

//        timer.start();
        
    }
    
    
    public void connectObservers() {
    	 	
    	if(paintArea.getForms().size() != 0) {
    		
    		ArrayList<MyRectangle> rects = paintArea.getForms();
    		
        	for(MyRectangle rect: rects) {
        		rect.getObserver().addObserver(view);
        	}
    	}
    	
    }
    
}


