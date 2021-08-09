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
					isPossible.setText("아무것도 입력하지 않았습니다.");
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
									isPossible.setText("(차량 5부제)차량 끝번호 1, 6은 이용불가합니다.");
									flag = false;
								} else {
									isPossible.setText("주차구역을 선택해주세요.");
									flag = true;
								}
								break;
							case 2:
								if (value == '2' || value == '7') {
									isPossible.setText("(차량 5부제)차량 끝번호 2, 7은 이용불가합니다.");
									flag = false;
								} else {
									isPossible.setText("주차구역을 선택해주세요.");
									flag = true;
								}
								break;
							case 3:
								if (value == '3' || value == '8') {
									isPossible.setText("(차량 5부제)차량 끝번호 3, 8은 이용불가합니다.");
									flag = false;
								} else {
									isPossible.setText("주차구역을 선택해주세요.");
									flag = true;
								}
								break;
							case 4:
								if (value == '4' || value == '9') {
									isPossible.setText("(차량 5부제)차량 끝번호 4, 9는 이용불가합니다.");
									flag = false;
								} else {
									isPossible.setText("주차구역을 선택해주세요.");
									flag = true;
								}
								break;
							case 5:
								if (value == '5' || value == '0') {
									System.out.println("Test");
									isPossible.setText("(차량 5부제)차량 끝번호 0, 5은 이용불가합니다.");
									flag = false;

								} else {
									isPossible.setText("주차구역을 선택해주세요.");
									flag = true;
								}
								break;
							default:
								isPossible.setText("주차구역을 선택해주세요.");
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
							isPossible.setText("차량 번호를 다시 입력해주세요.");
						}
					} else {
						isPossible.setText("이미 주차된 차량번호입니다.");
					}

				} else {
					isPossible.setText("차량 번호는 4자리를 입력하셔야합니다.");
				}

			} catch (Exception e1) {

				isPossible.setText("차량 번호를 다시 입력해주세요.");

			}

		}

	}

	public InformationPanel(ImagePanel image) {
		this.image = image;
		info = this;
		this.setSize(500, 600);
		this.setLayout(null);
		this.setBackground(Color.white);

		JLabel register = new JLabel("차량번호 등록");
		register.setFont(new Font("/*HY견고딕*/", Font.BOLD, 40));
		register.setLocation(120, 100);
		register.setSize(300, 100);

		// 텍스트필드 이벤트 구현 클래스
		number = new PlaceholderTextField();
		number.setPlaceholder("차량 번호(숫자 4자리)를 입력해주세요.");
		number.setFont(new Font("/*HY견고딕*/", Font.BOLD, 20));
		number.setColumns(50);
		number.setLocation(75, 200);
		number.setSize(370, 40);
		number.setHorizontalAlignment(number.CENTER);

		isPossible = new JLabel();
		isPossible.setFont(new Font("/*HY견고딕*/", Font.BOLD, 17));
		isPossible.setLocation(10, 300);
		isPossible.setSize(500, 70);
		isPossible.setHorizontalAlignment(isPossible.CENTER);

		JButton button = new JButton("확인");
		button.setFont(new Font("/*HY견고딕*/", Font.PLAIN, 16));
		button.setForeground(Color.white);
		button.setBackground(new Color(94, 94, 94));
		button.setLocation(200, 400);
		button.setSize(100, 50);

		// 버튼 이벤트 구현
		button.addActionListener(new PanelAdd());

		this.add(register);
		this.add(number);
		this.add(isPossible);
		this.add(button);
	}

}