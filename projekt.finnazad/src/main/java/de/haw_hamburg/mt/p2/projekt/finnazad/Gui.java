package de.haw_hamburg.mt.p2.projekt.finnazad;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JTextField;


public class Gui extends JFrame {

	//zeichenfläche
	private PaintArea paintArea = new PaintArea();
	private JButton addRectBtn;
	private JButton stopPntBtn;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JSlider colorSliderRed;
	private JSlider colorSliderGreen;
	private JSlider colorSliderBlue;
	
	public Gui() {
	
		//configPanel
		JPanel configPanel = new JPanel();
		configPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(configPanel, BorderLayout.EAST);
		configPanel.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel colorConfigPanel = new JPanel();
		configPanel.add(colorConfigPanel);
		colorConfigPanel.setLayout(new GridLayout(7, 1, 0, 0));
		
		JLabel lblColor = new JLabel("Color");
		colorConfigPanel.add(lblColor);
		lblColor.setHorizontalAlignment(SwingConstants.LEFT);
		lblColor.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel colorRedRow = new JPanel();
		colorConfigPanel.add(colorRedRow);
		
		JLabel lblRed = new JLabel("Red  ");
		lblRed.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorRedRow.add(lblRed);
		
		textField = new JTextField();
		colorRedRow.add(textField);
		textField.setColumns(5);
		
		colorSliderRed = new JSlider();
		colorSliderRed.setValue(0);
		colorSliderRed.setMinorTickSpacing(1);
		colorSliderRed.setMajorTickSpacing(1);
		colorRedRow.add(colorSliderRed);
		colorSliderRed.setMaximum(255);
		
		JPanel colorGreenRow = new JPanel();
		colorConfigPanel.add(colorGreenRow);
		
		JLabel lblGreen = new JLabel("Green\r\n");
		lblGreen.setFont(new Font("Tahoma", Font.PLAIN, 12));
		colorGreenRow.add(lblGreen);
		
		textField_1 = new JTextField();
		colorGreenRow.add(textField_1);
		textField_1.setColumns(5);
		
		colorSliderGreen = new JSlider();
		colorSliderGreen.setValue(0);
		colorSliderGreen.setMinorTickSpacing(1);
		colorSliderGreen.setMajorTickSpacing(1);
		colorGreenRow.add(colorSliderGreen);
		colorSliderGreen.setMaximum(255);
		
		JPanel colorBluePanel = new JPanel();
		colorConfigPanel.add(colorBluePanel);
		
		JLabel lblBlue = new JLabel("Blue");
		colorBluePanel.add(lblBlue);
		lblBlue.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		textField_2 = new JTextField();
		colorBluePanel.add(textField_2);
		textField_2.setColumns(5);
		
		colorSliderBlue = new JSlider();
		colorSliderBlue.setValue(0);
		colorBluePanel.add(colorSliderBlue);
		colorSliderBlue.setMajorTickSpacing(1);
		colorSliderBlue.setMinorTickSpacing(1);
		colorSliderBlue.setMaximum(255);
		
		
		
		//buttom panel
		JPanel southPanel = new JPanel();
		southPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		getContentPane().add(southPanel, BorderLayout.SOUTH);
		stopPntBtn = new JButton("Stop Paint");
		stopPntBtn.setVisible(false);
		addRectBtn = new JButton("Rectangle");
		southPanel.add(addRectBtn);
		southPanel.add(stopPntBtn);
		
		
		//CANVAS (PAINT AREA)
		getContentPane().add(paintArea, BorderLayout.CENTER);

		
		
		JPanel menuPanel = new JPanel();
		menuPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		FlowLayout fl_menuPanel = (FlowLayout) menuPanel.getLayout();
		fl_menuPanel.setAlignment(FlowLayout.LEFT);
		getContentPane().add(menuPanel, BorderLayout.NORTH);
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuPanel.add(menuBar);
		
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		JMenuItem mntmNew = new JMenuItem("New");
		mnFile.add(mntmNew);
		JMenuItem mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		JMenuItem mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		JMenu mnEdit = new JMenu("Edit");
		menuBar.add(mnEdit);
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mnEdit.add(mntmUndo);
		JMenuItem mntmRedo = new JMenuItem("Redo");
		mnEdit.add(mntmRedo);
		
		
		setVisible(true);
		setSize(1000,1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JButton getAddRectBtn() {
		return addRectBtn;
	}
	
	public JButton getStopPntBtn() {
		return stopPntBtn;
	}
	
	public PaintArea getPaintArea() {
		return paintArea;
	}

	public JSlider getColorSliderRed() {
		return colorSliderRed;
	}

	public void setColorSliderRed(JSlider colorSliderRed) {
		this.colorSliderRed = colorSliderRed;
	}

	public JSlider getColorSliderGreen() {
		return colorSliderGreen;
	}

	public void setColorSliderGreen(JSlider colorSliderGreen) {
		this.colorSliderGreen = colorSliderGreen;
	}

	public JSlider getColorSliderBlue() {
		return colorSliderBlue;
	}

	public void setColorSliderBlue(JSlider colorSliderBlue) {
		this.colorSliderBlue = colorSliderBlue;
	}


	
}
