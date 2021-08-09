package com.kh.mini.entercarpage;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdPanel extends JPanel{
	
	public AdPanel() {
		this.setBounds(500, 0, 500, 600);
		
		Image ad = new ImageIcon("imageFile/car.PNG").getImage().getScaledInstance(300, 300, 0);
		JLabel la = new JLabel(new ImageIcon(ad));
		this.add(la);
	}
}