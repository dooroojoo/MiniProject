package com.kh.mini.entercarpage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.mini.common.ChangePanel;
import com.kh.mini.view.MainFrame;
import com.kh.mini.view.MainPage;

public class ImagePanel extends JPanel {

	private JLabel confirm;
	private JButton tempBtn;
	private int index = 100;
	private MainFrame mf;
	private JPanel enterCarPage;
	private JButton[] btn = new JButton[15];
	private JPanel imagePanel;
	private String carNum;

	public ImagePanel(MainFrame mf, JPanel enterCarPage) { // �Ű����� �� �޴µ�.....
		this.mf = mf;
		this.enterCarPage = enterCarPage;
		this.imagePanel=this;
		this.setLayout(null);

		// \\\\
		this.setBackground(Color.white);
		// \\\\

		String[] str = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4", "C5" };

//		// �������ɱ��� �ȳ���(�Ķ��� �簢��)
//		JLabel label1 = new JLabel();
//		label1.setBackground(new Color(52, 152, 219));
//		label1.setOpaque(true);			// ���� ����(true�� �� ������)
//		label1.setBounds(50, 100, 30, 30);
//		this.add(label1);									// �굵 for������ 15�� ������ �ڸ� �����ؾ� ���� �ʳ�...?
//
//		Font font = new Font("/*HY�߰��*/", Font.BOLD, 20);
//		JLabel text1 = new JLabel("��������");
//		text1.setFont(font);
//		text1.setBounds(85, 100, 150, 30);
//		this.add(text1);
//
//		// �����Ұ��ɱ��� �ȳ���(ȸ�� �簢��)
//		JLabel label2 = new JLabel();
//		label2.setBackground(new Color(94, 94, 94));
//		label2.setOpaque(true);
//		label2.setBounds(210, 100, 30, 30);
//		this.add(label2);
//
//		JLabel text2 = new JLabel("�����Ұ���");
//		text2.setFont(font);
//		text2.setBounds(245, 100, 150, 30);
//		this.add(text2);

		Font font = new Font("/*HY�߰��*/", Font.BOLD, 20);
		// Ȯ�ο� ��
		confirm = new JLabel("���� ��ġ�� �������ּ���");
		confirm.setFont(font);
		confirm.setLocation(45, 400);
		confirm.setSize(370, 40);
		confirm.setHorizontalAlignment(JLabel.CENTER);
		this.add(confirm);

		// ���� Ȯ�� ��ư
		JButton last = new JButton("Ȯ��");
		last.setFont(new Font("/*HY�߰��*/", Font.PLAIN, 16));
		last.setForeground(Color.white);
		last.setBackground(new Color(94, 94, 94));
		last.setLocation(180, 440);
		last.setSize(100, 50);
		this.add(last);

		// ��ư ����

		int x = 70;
		int y = 50;
		int width = 80;
		int height = 106;

		for (int i = 0; i < str.length; i++) {
			if (i < 5) {
				x = 50;
				y = 80;
				switch (i) {
				case 0:
					x = 50 - 20;
					break;
				case 1:
					x += 80 - 20;
					break;
				case 2:
					x += 160 - 20;
					break;
				case 3:
					x += 240 - 20;
					break;
				case 4:
					x += 320 - 20;
					break;

				}
			} else if (i < 10) {
				x = 50;
				y = 186;
				switch (i) {
				case 5:
					x = 50 - 20;
					break;
				case 6:
					x += 80 - 20;
					break;
				case 7:
					x += 160 - 20;
					break;
				case 8:
					x += 240 - 20;
					break;
				case 9:
					x += 320 - 20;
					break;
				}
			} else {
				x = 50;
				y = 186 + 106;
				switch (i) {
				case 10:
					x = 50 - 20;
					break;
				case 11:
					x += 80 - 20;
					break;
				case 12:
					x += 160 - 20;
					break;
				case 13:
					x += 240 - 20;
					break;
				case 14:
					x += 320 - 20;
					break;
				}
			}
			/*
			 * ���� �ȵǸ� ������(����ȭ�� �޸�) ������ ���̱�
			 */

			// \\\\ �̹��� �ֱ�
			int value = 0;
			String[] filePath = new String[15];
			// System.out.println(filePath[1]+"asdasdas");

			for (int j = 0; j < filePath.length; j++) {
				filePath[j] = "imageFile/pzone" + (++value) + ".png";
				// System.out.println(filePath[j]);

			}

			if (MainFrame.parkInfo[i].isParkingState()) {
				//System.out.println("Tasfadsfas");
				Image img2 = new ImageIcon("imageFile/car.png").getImage().getScaledInstance(width, height, 0);
				btn[i] = new JButton(new ImageIcon(img2));
				btn[i].setBounds(x, y, width, height);

//				btn[i].setEnabled(false);
			} else {
				Image img = new ImageIcon(filePath[i]).getImage().getScaledInstance(width, height, 0);
				btn[i] = new JButton(new ImageIcon(img));

				btn[i].setBounds(x, y, width, height);
			}

			btn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					tempBtn = (JButton) e.getSource();
					///////// getsource: �̺�Ʈ�� �Ͼ�� ��ġ ��ȯ. tempBtn�� �̺�Ʈ�� �Ͼ�� �ִ� ��ư �޴� �뵵. �ٵ� e�� ��
					///////// ���µ�.....? jbutton ��ȣ ģ �� ����?
					//System.out.println(tempBtn.getLocation());
					//System.out.println(tempBtn.getName());

//					confirm.setLocation(108, 400);
//					confirm.setSize(300, 50);

					String result = "";
					// �ε����� ������ ���� �۾�
					if (tempBtn.getX() == 30 && tempBtn.getY() == 80) {
						result = "A1";
						index = 0;
					} else if (tempBtn.getX() == 110 && tempBtn.getY() == 80) {
						result = "A2";
						index = 1;
					} else if (tempBtn.getX() == 190 && tempBtn.getY() == 80) {
						result = "A3";
						index = 2;
					} else if (tempBtn.getX() == 270 && tempBtn.getY() == 80) {
						result = "A4";
						index = 3;
					} else if (tempBtn.getX() == 350 && tempBtn.getY() == 80) {
						result = "A5";
						index = 4;
					} else if (tempBtn.getX() == 30 && tempBtn.getY() == 186) {
						result = "B1";
						index = 5;
					} else if (tempBtn.getX() == 110 && tempBtn.getY() == 186) {
						result = "B2";
						index = 6;
					} else if (tempBtn.getX() == 190 && tempBtn.getY() == 186) {
						result = "B3";
						index = 7;
					} else if (tempBtn.getX() == 270 && tempBtn.getY() == 186) {
						result = "B4";
						index = 8;
					} else if (tempBtn.getX() == 350 && tempBtn.getY() == 186) {
						result = "B5";
						index = 9;
					} else if (tempBtn.getX() == 30 && tempBtn.getY() == 292) {
						result = "C1";
						index = 10;
					} else if (tempBtn.getX() == 110 && tempBtn.getY() == 292) {
						result = "C2";
						index = 11;
					} else if (tempBtn.getX() == 190 && tempBtn.getY() == 292) {
						result = "C3";
						index = 12;
					} else if (tempBtn.getX() == 270 && tempBtn.getY() == 292) {
						result = "C4";
						index = 13;
					} else if (tempBtn.getX() == 350 && tempBtn.getY() == 292) {
						result = "C5";
						index = 14;
					}

					if (MainFrame.parkInfo[index].isParkingState()) {
						confirm.setText(result + "�� �̿��Ͻ� �� �����ϴ�.");
					} else {
						confirm.setText(result + "�� �����Ͻðڽ��ϱ�?");
					}

//					// �ε����� ������ ���� �۾�
//					for(int i=0; i<str.length; i++) {
//						if(tempBtn.getText().equals(str[i])){	// ���� ��ư�� ���� String �迭�� ���� ���� ���
//							index=i;							// �ε����� �ڸ� ��ġ(0~14)������ ����
//							System.out.println(index);			// �׽�Ʈ ���
//							break;
//						}
//					}
				}
			});
			this.add(btn[i]);
		}

		//System.out.println(index); // �׽�Ʈ ���(���� �� �� ó���� 100 ������ ��)
		last.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (index == 100) { // �ƹ��͵� �������� ���� ������ ���� check������ ����ִ� ���� 100��
					confirm.setText("�����Ͻ� �ڸ��� �����ϴ�.");
				} else if(!MainFrame.parkInfo[index].isParkingState()) {
					confirm.setText("�Ϸ� ó���Ǿ����ϴ�.");
					btn[index].setEnabled(false);
//					btn[index].setBackground(new Color(94, 94, 94));
					
					
					MainFrame.parkInfo[index].setParkingState(true); // ������ �ڸ� ��뿩�� ���
					MainFrame.parkInfo[index].setCarNum(MainFrame.carNum);
					System.out.println(MainFrame.carNum);
					MainFrame.parkInfo[index].setDate(new Date());
					MainFrame.parkInfo[index].setStartTime(System.currentTimeMillis()); // ������ ��Ͻð� ����
					
					
//					System.out.println(MainFrame.parkInfo[index].isParkingState()); // �׽�Ʈ ���
					JOptionPane.showMessageDialog(null, "�Ϸ�ó���Ǿ����ϴ�.", "�����Ϸ�", JOptionPane.PLAIN_MESSAGE); // �θ�������Ʈ(null��
																											// �� default
																											// frame),
																											// ����, ����,
																											// ������ ����
																											// �޼��� ����
					ChangePanel.changePanel(mf, enterCarPage, new MainPage(mf));

				}

			}

		});

	}
}