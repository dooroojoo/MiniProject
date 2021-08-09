package com.kh.mini.entercarpage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.view.EnterCarPage;
import com.kh.mini.view.MainFrame;
import com.kh.mini.view.PlaceholderTextField;

public class InformationPanel extends JPanel {
	private JPanel info;
	private boolean flag;
	private PlaceholderTextField number;
	private JLabel isPossible;
	private ImagePanel image;
	

	private class PanelAdd implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			MainFrame.carNum = number.getText();
			try {
				Calendar cal = Calendar.getInstance();
				int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;

				String str = number.getText();
				
				if (str.length() == 0) {
					isPossible.setText("�ƹ��͵� �Է����� �ʾҽ��ϴ�.");
				} else if (str.length() == 4) {
					boolean check=false;
					for (int i = 0; i < MainFrame.parkInfo.length; i++) {
					
						if (MainFrame.parkInfo[i].getCarNum().equals(str)) {
							System.out.println("=========="+i);
							check=false;
							break;
						}else {
							check = true;
						}
						System.out.println(check);
					
					}
					if (check) {
						check=false;
						char value = number.getText().charAt(3);
						if (value >= '0' && value <= '9') {

							switch (dayOfWeek) {

							case 1:
								if (value == '1' || value == '6') {
									isPossible.setText("(���� 5����)���� ����ȣ 1, 6�� �̿�Ұ��մϴ�.");
									flag = false;
								} else {
									isPossible.setText("���������� �������ּ���.");
									flag = true;
								}
								break;
							case 2:
								if (value == '2' || value == '7') {
									isPossible.setText("(���� 5����)���� ����ȣ 2, 7�� �̿�Ұ��մϴ�.");
									flag = false;
								} else {
									isPossible.setText("���������� �������ּ���.");
									flag = true;
								}
								break;
							case 3:
								if (value == '3' || value == '8') {
									isPossible.setText("(���� 5����)���� ����ȣ 3, 8�� �̿�Ұ��մϴ�.");
									flag = false;
								} else {
									isPossible.setText("���������� �������ּ���.");
									flag = true;
								}
								break;
							case 4:
								if (value == '4' || value == '9') {
									isPossible.setText("(���� 5����)���� ����ȣ 4, 9�� �̿�Ұ��մϴ�.");
									flag = false;
								} else {
									isPossible.setText("���������� �������ּ���.");
									flag = true;
								}
								break;
							case 5:
								if (value == '5' || value == '0') {
									System.out.println("Test");
									isPossible.setText("(���� 5����)���� ����ȣ 0, 5�� �̿�Ұ��մϴ�.");
									flag = false;

								} else {
									isPossible.setText("���������� �������ּ���.");
									flag = true;
								}
								break;
							default:
								isPossible.setText("���������� �������ּ���.");
								flag = true;
							}

							if (flag) {
								info.getParent().add(image);
								info.getParent().remove(EnterCarPage.adLabel);
								info.getParent().revalidate();
								info.getParent().repaint();
							} else {
								info.getParent().add(EnterCarPage.adLabel);
								info.getParent().remove(image);
								info.getParent().revalidate();
								info.getParent().repaint();
							}
						} else {
							isPossible.setText("���� ��ȣ�� �ٽ� �Է����ּ���.");
						}
					} else {
						isPossible.setText("�̹� ������ ������ȣ�Դϴ�.");
					}

				} else {
					isPossible.setText("���� ��ȣ�� 4�ڸ��� �Է��ϼž��մϴ�.");
				}

			} catch (Exception e1) {

				isPossible.setText("���� ��ȣ�� �ٽ� �Է����ּ���.");

			}

		}

	}

	public InformationPanel(ImagePanel image) {
		this.image = image;
		info = this;
		this.setSize(500, 600);
		this.setLayout(null);
		this.setBackground(Color.white);

		JLabel register = new JLabel("������ȣ ���");
		register.setFont(new Font("/*HY�߰��*/", Font.BOLD, 40));
		register.setLocation(120, 100);
		register.setSize(300, 100);

		// �ؽ�Ʈ�ʵ� �̺�Ʈ ���� Ŭ����
		number = new PlaceholderTextField();
		number.setPlaceholder("���� ��ȣ(���� 4�ڸ�)�� �Է����ּ���.");
		number.setFont(new Font("/*HY�߰��*/", Font.BOLD, 20));
		number.setColumns(50);
		number.setLocation(75, 200);
		number.setSize(370, 40);
		number.setHorizontalAlignment(number.CENTER);

		isPossible = new JLabel();
		isPossible.setFont(new Font("/*HY�߰��*/", Font.BOLD, 17));
		isPossible.setLocation(10, 300);
		isPossible.setSize(500, 70);
		isPossible.setHorizontalAlignment(isPossible.CENTER);

		JButton button = new JButton("Ȯ��");
		button.setFont(new Font("/*HY�߰��*/", Font.PLAIN, 16));
		button.setForeground(Color.white);
		button.setBackground(new Color(94, 94, 94));
		button.setLocation(200, 400);
		button.setSize(100, 50);

		// ��ư �̺�Ʈ ����
		button.addActionListener(new PanelAdd());

		this.add(register);
		this.add(number);
		this.add(isPossible);
		this.add(button);
	}

}