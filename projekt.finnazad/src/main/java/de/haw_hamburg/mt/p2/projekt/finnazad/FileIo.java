package de.haw_hamburg.mt.p2.projekt.finnazad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileIo {
	
	private PaintArea paintArea = new PaintArea();
	
	public void saveData() {
		
		try {
			File file = new File("Data.txt");
			FileOutputStream fos = new FileOutputStream(file, false);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			if(paintArea.getForms().size() != 0) {
				for(MyRectangle form: paintArea.getForms()) {
					oos.writeObject(form);
					System.out.println("Es wurde irgendwo was gespeichert.");
				}
			}
			fos.close();
			oos.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public void openData() {
		
		try {
			File file = new File("Data.txt");
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			paintArea.setForms((ArrayList<MyRectangle>) ois.readObject());
			ois.close();
			paintArea.repaint();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

}
