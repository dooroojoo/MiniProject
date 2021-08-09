package com.kh.mini.searchcar;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class ParkingPanel extends JPanel {

	public ParkingPanel() {

		this.setLayout(new GridLayout(3, 5, 0, 0));
		this.setBounds(410, 70, 500, 400);
		this.setBackground(Color.white);

	}
}