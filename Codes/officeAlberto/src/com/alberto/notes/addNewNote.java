package com.alberto.notes;

import java.awt.Color;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class addNewNote extends Thread {
	private JFrame frame= new JFrame();
	private JEditorPane textPane = new JEditorPane();
	JComboBox<String> notesType = new JComboBox<String>();
	
    private String[] description = { "Notes", "Sunmoksha", "Todo",
	      "Utility", "Birthday", "Phone No", "E- Mail"};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new addNewNote();
	}
	public addNewNote(){
		start();
	}
	public void run(){
		initFrame();
		
		textPane.setBounds(0,10,frame.getWidth(),frame.getHeight()-50);
		textPane.setOpaque(false);
		textPane.setForeground(Color.black);
		frame.getContentPane().add(textPane);
		
		int count=0;
		while (count < description.length)
			notesType.addItem(description[count++]);

		notesType.setBounds(textPane.getWidth()-270,textPane.getHeight()+10,150,30);
		notesType.setBackground(new Color(0, 0, 0,0));
		notesType.setForeground(Color.BLACK);
		notesType.setOpaque(false);
		frame.getContentPane().add(notesType);
		
		JButton save = new JButton("Save");
		save.setBounds(textPane.getWidth()-90,textPane.getHeight()+10,70,30);
		save.setBackground(new Color(0, 0, 0,0));
		save.setOpaque(true);
		
		save.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				new saveNote().save(textPane.getText(),notesType.getSelectedItem().toString());
				frame.dispose();
			}
		});
		
		frame.getContentPane().add(save);
		
		
		frame.setVisible(true);
		
	}
	private void initFrame() {
		// TODO Auto-generated method stub

		((JComponent)frame.getContentPane()).setBorder(BorderFactory.createMatteBorder( 2, 2, 2, 2, Color.RED) );
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		frame.setBackground(Color.BLACK);
		frame.setOpacity((float) 0.5);
		frame.setAlwaysOnTop(true);
		frame.setType(Type.UTILITY);
		frame.setBounds(50,100,300,450);
		
		final JLabel close = new JLabel("X");
		close.setBounds(frame.getWidth()-15,5,10,10);
		close.setForeground(Color.black);
		close.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				close.setForeground(Color.black);
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				close.setForeground(Color.red);
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub
				frame.dispose();
			}
		});
		frame.getContentPane().add(close);
	}
}
