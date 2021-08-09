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

	// ����â ������ ��ü �迭�� �����ϰ� static �ʵ� ����ؼ� �����ϰ� ����� �� �ְ� �����ξ���

	public MainPage(MainFrame mf) {

		this.mf = mf;
		this.mainPage = this;

		this.setBackground(Color.white); // �г� ����
		this.setLayout(null); // ���̾ƿ� ����
		Font font = new Font("/*HY�߰��*/", Font.BOLD, 20); // ��Ʈ ����

		// ��ü �� ������ ������ ����
		int width = 70;
		int height = 70;

		/***** ������ ���� ǥ�� label ���� ���� ******/
		String[] parkingZoneMark = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4",
				"C5" };
		JLabel[] abc = new JLabel[15];
		int x = 0;
		int y = 0;
		for (int i = 0; i < abc.length; i++) {
			if (i < 5) { // a ���� 0~4
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
			} else if (i < 10) { // b ���� 5~9
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
			} else { // c ���� 10~14
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

			// test��////////////////////////////
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

				x -= 12; // ���ڿ����� �̹����� �ٲٸ� ��ġ�� ���� �����Ǿ� �����ϱ� ���� ����
				y -= 5;
				abc[i].setLocation(x, y);
				abc[i].setIcon(new ImageIcon(icon));
			}

			this.add(abc[i]);
		}

		/******** ���ݺ��ʹ� �޴��̵��� ���� ��ư ************/
		// ���� ��ư
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

		JLabel enterLabel = new JLabel("����");
		Font btnLabelFont = new Font("HY�߰��", Font.BOLD, 20); // ��Ʈ ����
		enterLabel.setFont(btnLabelFont);
		enterLabel.setSize(50, 50);
		enterLabel.setLocation(225, 450);
		this.add(enterLabel);

		// ���� ��ư
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

		JLabel exitLabel = new JLabel("����");
		exitLabel.setFont(btnLabelFont);
		exitLabel.setSize(50, 50);
		exitLabel.setLocation(480, 450);
		this.add(exitLabel);

		// ��ȸ��ư
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

		JLabel searchLabel = new JLabel("��ȸ");
		searchLabel.setFont(btnLabelFont);
		searchLabel.setSize(50, 50);
		searchLabel.setLocation(730, 450);
		this.add(searchLabel);

		// ��� �ȳ� ��ư***********
		Image feeinfoIcon = new ImageIcon("imageFile/guideBtn2.png").getImage().getScaledInstance(60, 60, 0);
		JButton feeBtn = new JButton(new ImageIcon(feeinfoIcon));
		feeBtn.setBorderPainted(false);
		feeBtn.setFocusPainted(false);
		feeBtn.setContentAreaFilled(false);
		feeBtn.setLocation(860, 420);
		feeBtn.setSize(100, 100);
		this.add(feeBtn);

		JLabel infoLabel = new JLabel("���ǥ");
		infoLabel.setFont(new Font("HY�߰��", Font.BOLD, 15));
		infoLabel.setSize(50, 50);
		infoLabel.setLocation(885, 490);
		this.add(infoLabel);

		// ���̾�α�*******************************************
		JDialog dialog = new JDialog(mf, "���� ��ݾȳ�");
		dialog.setBounds(620, 300, 650, 400);
		// dialog.setBackground(Color.WHITE);
		dialog.setLayout(null);

		Image icon = new ImageIcon("imageFile/parking.png").getImage().getScaledInstance(100, 100, 0);
		JLabel iLabel = new JLabel(new ImageIcon(icon));
		iLabel.setLocation(70, 20);
		iLabel.setSize(120, 120);

		JLabel dL1 = new JLabel("���� ��� �ȳ�");
		dL1.setLocation(220, 70);
		dL1.setSize(300, 50);
		dL1.setFont(new Font("�����240", Font.BOLD, 40));
		Color color = Color.DARK_GRAY;
		dL1.setForeground(color); // �۾���

		int x2 = 150;
		int y2 = 150;
		int width2 = 250;
		int height2 = 50;
		Font dFont = new Font("HY�߰��", Font.PLAIN, 20);

		JLabel dL2 = new JLabel("30��");
		dL2.setLocation(x2, y2);
		dL2.setSize(width2, height2);
		dL2.setFont(dFont);
		dL2.setForeground(color);

		JLabel dL3 = new JLabel("����");
		dL3.setLocation(x2 + 250, y2);
		dL3.setSize(width2, height2);
		dL3.setFont(dFont);
		dL3.setForeground(color);

		JLabel dL4 = new JLabel("30�� ���� 10�д�");
		dL4.setLocation(x2, y2 + 50);
		dL4.setSize(width2, height2);
		dL4.setFont(dFont);
		dL4.setForeground(color);

		JLabel dL5 = new JLabel("400��");
		dL5.setLocation(x2 + 250, y2 + 50);
		dL5.setSize(width2, height2);
		dL5.setFont(dFont);
		dL5.setForeground(color);

		JLabel dL6 = new JLabel("���� �̿��");
		dL6.setLocation(x2, y2 + 100);
		dL6.setSize(width2, height2);
		dL6.setFont(dFont);
		dL6.setForeground(color);

		JLabel dL7 = new JLabel("1�ð� ����");
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

	// ���� ��ư Ŭ���� �г���ȯ�� ���� Ŭ����
	private class GotoEnterCarPageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ChangePanel.changePanel(mf, mainPage, new EnterCarPage(mf));

		}

	}

	// ���� ��ư Ŭ���� �г���ȯ�� ���� Ŭ����
	private class GotoExitCarPageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ChangePanel.changePanel(mf, mainPage, new ExitCarPage(mf));
		}

	}

	// ��ȸ ��ư Ŭ���� �г���ȯ�� ���� Ŭ����
	private class GotoSearchCarPageListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			ChangePanel.changePanel(mf, mainPage, new SearchCarPage(mf));
		}

	}

	/***** ���ݺ��ʹ� ������ �׸��� �׸��� ���� ******/
	public void paintComponent(Graphics g) {
		// ���� �������� �׸��� ����
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// �� ������ ����
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, 0));
		g2.setColor(Color.gray);
		// A ���� �ʱ� ����
		int x = 40;
		int y = 35;

		// ���׸��� A1 ����
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� A2 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� A3 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� A4 ����
		x += 250;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� A5 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// B ���� �ʱ� ����
		x = 40;
		y = 35;

		// ���׸��� B1 ����
		y += 100;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� B2 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� B3 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� B4 ����
		x += 250;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� B5 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// C ���� �ʱ� ����
		x = 40;
		y = 35;

		// ���׸��� C1 ����
		y += 200;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� C2 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� C3 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� C4 ����
		x += 250;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

		// ���׸��� C5 ����
		x += 170;
		g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 80, x + 150, y + 80));

	}
}
