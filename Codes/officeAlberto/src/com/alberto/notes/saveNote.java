package com.alberto.notes;

import javax.swing.JOptionPane;

import com.oksbwn.mail.sendNote;

public class saveNote {

	public void save(String testVal, String type) {
		// TODO Auto-generated method stub
		sendNote sendNoteObj= new sendNote(new String[]{"oksbwn","**********"});
		if(sendNoteObj.send(type, testVal)){
			new Thread(new Runnable() {	
				
				@Override
				public void run() {
					try {
						JOptionPane.showMessageDialog(null, "Note Saved.");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

}
