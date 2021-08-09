package com.kh.mini.view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.common.ChangePanel;
import com.kh.mini.entercarpage.AdPanel;
import com.kh.mini.entercarpage.ImagePanel;
import com.kh.mini.entercarpage.InformationPanel;

public class EnterCarPage extends JPanel {

	// InformationPanel ip = new InformationPanel();

	private MainFrame mf;
	private JPanel enterCarPage;
	private JPanel information;
	private JPanel image;
	// \\\\
	// private JPanel ad;
	// \\\\
	public static JPanel imagePanel;
	public static JLabel adLabel;
	public static EnterCarPage enterStatic;
	public EnterCarPage(MainFrame mf) { // 여기 매개변수 뭔데
		this.mf = mf;
		this.enterCarPage = this;
		enterStatic=this;
		this.setLayout(null);
		this.setBackground(Color.white);
		
		
		Image adImage =new ImageIcon("imageFile/kh3.jpg").getImage().getScaledInstance(500, 500, 0);
		
		adLabel =new JLabel(new ImageIcon(adImage));
		adLabel.setBounds(500, 30, 500, 500);
		adLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(adLabel);
		

		//////////////////// 추가한 뒤로가기 버튼//////////////////////////
		Image back = new ImageIcon("imageFile/back.PNG").getImage().getScaledInstance(35, 35, 0);
		JButton backBtn = new JButton(new ImageIcon(back));
		backBtn.setLocation(35, 45);
		backBtn.setSize(35, 35);
		backBtn.setBorderPainted(false);

		backBtn.setBackground(Color.white);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				ChangePanel.changePanel(mf, enterCarPage, new MainPage(mf));
			}

		});
		this.add(backBtn);
		/////////////////////////////////////////////////////

		ImagePanel image = new ImagePanel(mf, enterCarPage); // 매개변수를 왜 받아요..... 매개변수 안 받으면 주차위치 선정할 때 에러
		image.setLocation(500, 0);
		image.setSize(500, 600);
		imagePanel=image;

		// \\\\
		// AdPanel ad = new AdPanel();
		// ad.setLocation(500, 0);
		// ad.setSize(500, 600);
		// \\\\

		InformationPanel info = new InformationPanel(image/* \\\\, ad\\\\ */); // 매개변수를 왜 받아요......
		info.setLocation(0, 0);
		info.setSize(500, 600);

		this.add(info);

//		mf.add(this);
	}

}