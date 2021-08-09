package com.kh.mini.view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kh.mini.common.ChangePanel;

public class MainPage extends JPanel {
	private MainFrame mf;
	private JPanel mainPage;

	// 주자창 정보를 객체 배열로 선언하고 static 필드 사용해서 간편하게 사용할 수 있게 만들어두었음

	public MainPage(MainFrame mf) {

		this.mf = mf;
		this.mainPage = this;

		this.setBackground(Color.white); // 패널 배경색
		this.setLayout(null); // 레이아웃 세팅
		Font font = new Font("/*HY견고딕*/", Font.BOLD, 20); // 폰트 세팅

		// 전체 라벨 사이즈 조절용 변수
		int width = 70;
		int height = 70;

		/***** 주차장 영역 표시 label 설정 사항 ******/
		String[] parkingZoneMark = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4",
				"C5" };
		JLabel[] abc = new JLabel[15];
		int x = 0;
		int y = 0;
		for (int i = 0; i < abc.length; i++) {
			if (i < 5) { // a 구역 0~4
				y = 45;
				switch (i) {
				case 0:
					x = 100;
					break;
				case 1:
					x = 270;
					break;
				case 2:
					x = 440;
					break;
				case 3:
					x = 690;
					break;
				case 4:
					x = 860;
					break;
				}
			} else if (i < 10) { // b 구역 5~9
				y = 145;
				switch (i) {
				case 5:
					x = 100;
					break;
				case 6:
					x = 270;
					break;
				case 7:
					x = 440;
					break;
				case 8:
					x = 690;
					break;
				case 9:
					x = 860;
					break;
				}
			} else { // c 구역 10~14
				y = 245;
				switch (i) {
				case 10:
					x = 100;
					break;
				case 11:
					x = 270;
					break;
				case 12:
					x = 440;
					break;
				case 13:
					x = 690;
					break;
				case 14:
					x = 860;
					break;
				}
			}

			abc[i] = new JLabel(parkingZoneMark[i]);
			abc[i].setFont(font);
			abc[i].setLocation(x, y);
			abc[i].setSize(width, height);

			// test용////////////////////////////
//			MainFrame.parkInfo[2].setParkingState(true);
//			MainFrame.parkInfo[2].setCarNum("1234");
//			MainFrame.parkInfo[2].setDate(new Date());
//			MainFrame.parkInfo[2].setStartTime(System.currentTimeMillis());
//			
//			MainFrame.parkInfo[3].setParkingState(true);
//			MainFrame.parkInfo[3].setCarNum("1235");
//			MainFrame.parkInfo[3].setDate(new Date());
//			MainFrame.parkInfo[3].setStartTime(System.currentTimeMillis());
			////////////////////////////////////

			if (MainFrame.parkInfo[i].isParkingState()) {
				Image icon = new ImageIcon("imageFile/parkingCar.PNG").getImage().getScaledInstance(width, height, 0);

				x -= 12; // 문자열에서 이미지로 바꾸면 위치가 조금 변형되어 조절하기 위한 행위
				y -= 5;
				abc[i].setLocation(x, y);
				abc[i].setIcon(new ImageIcon(icon));
			}

			this.add(abc[i]);
		}

		/******** 지금부터는 메뉴이동을 위한 버튼 ************/
		// 입차 버튼
		Image enterIcon = new ImageIcon("imageFile/enterBtn.PNG").getImage().getScaledInstance(100, 100, 0);
		JButton enterBtn = new JButton(new ImageIcon(enterIcon));
		enterBtn.setBorderPainted(false);
		enterBtn.setFocusPainted(false);
//		enterBtn.setContentAreaFilled(false);
		enterBtn.setBackground(Color.white);

		enterBtn.setLocation(200, 350);
		enterBtn.setSize(103, 103);
		enterBtn.addActionListener(new GotoEnterCarPageListener());
		this.add(enterBtn);

		JLabel enterLabel = new JLabel("입차");
		Font btnLabelFont = new Font("HY견고딕", Font.BOLD, 20); // 폰트 세팅
		enterLabel.setFont(btnLabelFont);
		enterLabel.setSize(50, 50);
		enterLabel.setLocation(225, 450);
		this.add(enterLabel);

		// 출차 버튼
		Image exitIcon = new ImageIcon("imageFile/exitBtn.PNG").getImage().getScaledInstance(100, 100, 0);
		JButton exitBtn = new JButton(new ImageIcon(exitIcon));
		exitBtn.setBorderPainted(false);
		exitBtn.setFocusPainted(false);
//		exitBtn.setContentAreaFilled(false);
		exitBtn.setBackground(Color.white);

		exitBtn.setLocation(450, 350);
		exitBtn.setSize(103, 103);
		exitBtn.addActionListener(new GotoExitCarPageListener());
		this.add(exitBtn);

		JLabel exitLabel = new JLabel("출차");
		exitLabel.setFont(btnLabelFont);
		exitLabel.setSize(50, 50);
		exitLabel.setLocation(480, 450);
		this.add(exitLabel);

		// 조회버튼
		Image searchIcon = new ImageIcon("imageFile/searchBtn.PNG").getImage().getScaledInstance(100, 100, 0);
		JButton searchBtn = new JButton(new ImageIcon(searchIcon));
		searchBtn.setBorderPainted(false);
		searchBtn.setFocusPainted(false);
//		searchBtn.setContentAreaFilled(false);

		searchBtn.setForeground(Color.white);
		searchBtn.setBackground(Color.white);

		searchBtn.setLocation(700, 350);
		searchBtn.setSize(103, 103);
		searchBtn.addActionListener(new GotoSearchCarPageListener());
		this.add(searchBtn);

		JLabel searchLabel = new JLabel("조회");
		searchLabel.setFont(btnLabelFont);
		searchLabel.setSize(50, 50);
		searchLabel.setLocation(730, 450);
		this.add(searchLabel);

		// 요금 안내 버튼***********
		Image feeinfoIcon = new ImageIcon("imageFile/guideBtn2.png").getImage().getScaledInstance(60, 60, 0);
		JButton feeBtn = new JButton(new ImageIcon(feeinfoIcon));
		feeBtn.setBorderPainted(false);
		feeBtn.setFocusPainted(false);
		feeBtn.setContentAreaFilled(false);
		feeBtn.setLocation(860, 420);
		feeBtn.setSize(100, 100);
		this.add(feeBtn);

		JLabel infoLabel = new JLabel("요금표");
		infoLabel.setFont(new Font("HY견고딕", Font.BOLD, 15));
		infoLabel.setSize(50, 50);
		infoLabel.setLocation(885, 490);
		this.add(infoLabel);

		// 다이얼로그*******************************************
		JDialog dialog = new JDialog(mf, "주차 요금안내");
		dialog.setBounds(620, 300, 650, 400);
		// dialog.setBackground(Color.WHITE);
		dialog.setLayout(null);

		Image icon = new ImageIcon("imageFile/parking.png").getImage().getScaledInstance(100, 100, 0);
		JLabel iLabel = new JLabel(new ImageIcon(icon));
		iLabel.setLocation(70, 20);
		iLabel.setSize(120, 120);

		JLabel dL1 = new JLabel("주차 요금 안내");
		dL1.setLocation(220, 70);
		dL1.setSize(300, 50);
		dL1.setFont(new Font("윤고딕240", Font.BOLD, 40));
		Color color = Color.DARK_GRAY;
		dL1.setForeground(color); // 글씨색

		int x2 = 150;
		int y2 = 150;
		int width2 = 250;
		int height2 = 50;
		Font dFont = new Font("HY견고딕", Font.PLAIN, 20);

		JLabel dL2 = new JLabel("30분");
		dL2.setLocation(x2, y2);
		dL2.setSize(width2, height2);
		dL2.setFont(dFont);
		dL2.setForeground(color);

		JLabel dL3 = new JLabel("무료");
		dL3.setLocation(x2 + 250, y2);
		dL3.setSize(width2, height2);
		dL3.setFont(dFont);
		dL3.setForeground(color);

		JLabel dL4 = new JLabel("30분 이후 10분당");
		dL4.setLocation(x2, y2 + 50);
		dL4.setSize(width2, height2);
		dL4.setFont(dFont);
		dL4.setForeground(color);

		JLabel dL5 = new JLabel("400원");
		dL5.setLocation(x2 + 250, y2 + 50);
		dL5.setSize(width2, height2);
		dL5.setFont(dFont);
		dL5.setForeground(color);

		JLabel dL6 = new JLabel("쿠폰 이용시");
		dL6.setLocation(x2, y2 + 100);
		dL6.setSize(width2, height2);
		dL6.setFont(dFont);
		dL6.setForeground(color);

		JLabel dL7 = new JLabel("1시간 무료");
		dL7.setLocation(x2 + 250, y2 + 100);
		dL7.setSize(width2, height2);
		dL7.setFont(dFont);
		dL7.setForeground(color);

		feeBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});

		dialog.add(iLabel);
		dialog.add(dL1);
		dialog.add(dL2);
		dialog.add(dL3);
		dialog.add(dL4);
		dialog.add(dL5);
		dialog.add(dL6);
		dialog.add(dL7);

		mf.add(this);
	}

	// 입차 버튼 클릭시 패널전환을 위한 클래스
	private class GotoEnterCarPageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ChangePanel.changePanel(mf, mainPage, new EnterCarPage(mf));

		}

	}

	// 출차 버튼 클릭시 패널전환을 위한 클래스
	private class GotoExitCarPageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ChangePanel.changePanel(mf, mainPage, new ExitCarPage(mf));
		}

	}

	// 조회 버튼 클릭시 패널전환을 위한 클래스
	private class GotoSearchCarPageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ChangePanel.changePanel(mf, mainPage, new SearchCarPage(mf));
		}

	}

	/***** 지금부터는 주차장 그림을 그리는 동작 ******/
	public void paintComponent(Graphics g) {
		// 현재 주차장을 그리고 있음
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// 선 디자인 셋팅
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, 0));
		g2.setColor(Color.gray);
		// A 구역 초기 세팅
		int x = 40;
		int y = 35;

		// 선그리기 A1 구역
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 A2 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 A3 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 A4 구역
		x += 250;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 A5 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// B 구역 초기 세팅
		x = 40;
		y = 35;

		// 선그리기 B1 구역
		y += 100;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 B2 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 B3 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 B4 구역
		x += 250;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 B5 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// C 구역 초기 세팅
		x = 40;
		y = 35;

		// 선그리기 C1 구역
		y += 200;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 C2 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 C3 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 C4 구역
		x += 250;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// 선그리기 C5 구역
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

	}
}
