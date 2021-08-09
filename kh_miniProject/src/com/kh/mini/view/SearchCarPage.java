package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.common.ChangePanel;
import com.kh.mini.model.vo.ParkingInform;
import com.kh.mini.searchcar.ParkingPanel;

public class SearchCarPage extends JPanel {
	private MainFrame mf;
	private JPanel searchCarPage;

	ParkingInform pi = new ParkingInform();

	public SearchCarPage(MainFrame mf) {
		this.mf = mf;
		searchCarPage = this;

		this.setLayout(null);
		this.setBounds(450, 200, 1000, 600);
		this.setBackground(Color.white);
		Font font = new Font("HY�߰��", Font.PLAIN, 16);

		// �ڷΰ��� ��ư
		Image back = new ImageIcon("imageFile/back.PNG").getImage().getScaledInstance(35, 35, 0);
		JButton backBtn = new JButton(new ImageIcon(back));
		backBtn.setLocation(35, 45);
		backBtn.setSize(35, 35);
		backBtn.setBorderPainted(false);

		backBtn.setBackground(Color.white);
		
		
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel.changePanel(mf, searchCarPage, new MainPage(mf));
			}

		});

		// ���� ��ȸ Ÿ��Ʋ
		JLabel title = new JLabel("���� ��ȸ");
		title.setFont(new Font("HY�߰��", Font.PLAIN, 40)); // ��Ʈ ������
		title.setLocation(130, 100);
		title.setSize(400, 100);
		title.setBackground(new Color(111, 111, 111));

		// ���� ��ȣ �Է� �ʵ�
		JTextField number = new JTextField(20);
		number.setText("���� ��ȣ�� �Է����ּ���.");
		number.setHorizontalAlignment(JLabel.CENTER);
		number.setLocation(80, 200);
		number.setSize(280, 40);

		// �Է� �ʵ忡 ���콺 Ŭ���ϸ� "���� ��ȣ�� �Է����ּ���." �ؽ�Ʈ ����
		number.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (number.getText().equals("���� ��ȣ�� �Է����ּ���.")) {
					number.setText(null);
				}

			}
		});

		// Ȯ�� ��ư Ŭ�� �� ��� ��Ÿ���� ����
		JLabel result = new JLabel();
		result.setLocation(95, 280);
		result.setSize(250, 40);
		result.setHorizontalAlignment(JLabel.CENTER); // ���� ��� ����
		result.setFont(title.getFont().deriveFont(15f)); // ��Ʈ ������

		// Ȯ�� ��ư
		JButton button = new JButton("Ȯ��");
		button.setLocation(165, 350);
		button.setSize(100, 40);
		button.setFont(font);
		button.setBackground(new Color(111, 111, 111));
		button.setForeground(Color.white);

		// ���� ��ġ �г�
		ParkingPanel pp = new ParkingPanel();

		// ������ġ �� �迭 �ݺ������� ���� �� �гο� �߰�
		String[] abc = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4", "C5" };
		JLabel[] car = new JLabel[15];

		for (int i = 0; i < car.length; i++) {
			pp.add(car[i] = new JLabel(abc[i]));
			car[i].setFont(new Font("�������", Font.BOLD, 30));

			Image bg = new ImageIcon("image/pzone" + (i + 1) + ".png").getImage().getScaledInstance(100, 133, 0);
			car[i].setIcon(new ImageIcon(bg));

		}

		Image icon = new ImageIcon("image/car.png").getImage().getScaledInstance(100, 133, 0);

		// Ȯ�� ��ư �̺�Ʈ
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int count = 0;
				int index = 0;

				for (int i = 0; i < MainFrame.parkInfo.length; i++) {
					if (number.getText().equals("���� ��ȣ�� �Է����ּ���.")) {
						count = 2;

						// �Է��� ���� ���� ��
					} else if (number.getText().isEmpty()) {
						count = 2;

						// �Է��� ���� ������ ���� ��ȣ�� ��ġ�ϸ� �ڵ��� ������ ����
					} else if (number.getText().equals(MainFrame.parkInfo[i].getCarNum())) {
						car[i].setIcon(new ImageIcon(icon));
						count = 1;
						index = i; // ��ġ Ȯ�ο� �ε���

						//�����Ǿ� ���� ���� ��ȣ�� �Է����� ��
					} else if (!number.getText().equals(MainFrame.parkInfo[i].getCarNum())) {
						Image bg = new ImageIcon("image/pzone" + (i + 1) + ".png").getImage().getScaledInstance(100,
								133, 0);
						car[i].setIcon(new ImageIcon(bg));

					}
					if (count == 1) {
						result.setText(car[index].getText() + " ��ġ�� �����Ǿ� �ֽ��ϴ�.");
					} else if (count == 2) {
						result.setText("��ȣ�� �Է����� �ʾҽ��ϴ�.");
					} else {
						result.setText("��ȸ�Ǵ� ������ �����ϴ�.");
					}
				}
			}
		});

		this.add(backBtn);
		this.add(title);
		this.add(number);
		this.add(result);
		this.add(button);
		this.add(pp);

	}

}