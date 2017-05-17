package com.alberto.main;

import java.awt.AWTException;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import com.alberto.notes.addNewNote;

public class Main {
    private SystemTray sysTray;
    private PopupMenu menu;
    private MenuItem item1;
    private TrayIcon trayIcon;

    private void initComponents() {
        if (SystemTray.isSupported()) {
            sysTray = SystemTray.getSystemTray();
     
            String icoPath = "C:/home.png";
            menu = new PopupMenu();
            item1 = new MenuItem("Exit");
            menu.add(item1);

            item1.addActionListener(new ActionListener() {
               public void actionPerformed(ActionEvent e) {
                   System.exit(0);
               }
            });
            

            trayIcon = new TrayIcon(new ImageIcon(icoPath).getImage(), "Alberto",menu);
            trayIcon.setImageAutoSize(true);
            try {
                sysTray.add(trayIcon);     
                trayIcon.displayMessage("Albrerto", "Application Starting", TrayIcon.MessageType.INFO); //THIS IS THE LINE THAT SHOULD SHOW THE MESSAGE

                
            }catch(AWTException e) {
                System.out.println(e.getMessage());
             }
            trayIcon.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mouseClicked(MouseEvent arg0) {
					// TODO Auto-generated method stub
					new addNewNote();
				}
			});
        }
    }

    public static void main(String[]args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new Main().initComponents();
            }
        });
    }

}


