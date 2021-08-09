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

	public ImagePanel(MainFrame mf, JPanel enterCarPage) { // 매개변수 왜 받는데.....
		this.mf = mf;
		this.enterCarPage = enterCarPage;
		this.imagePanel=this;
		this.setLayout(null);

		// \\\\
		this.setBackground(Color.white);
		// \\\\

		String[] str = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4", "C5" };

//		// 추차가능구역 안내용(파란색 사각형)
//		JLabel label1 = new JLabel();
//		label1.setBackground(new Color(52, 152, 219));
//		label1.setOpaque(true);			// 투명도 조절(true일 때 불투명)
//		label1.setBounds(50, 100, 30, 30);
//		this.add(label1);									// 얘도 for문으로 15번 돌려서 자리 지정해야 하지 않나...?
//
//		Font font = new Font("/*HY견고딕*/", Font.BOLD, 20);
//		JLabel text1 = new JLabel("주차가능");
//		text1.setFont(font);
//		text1.setBounds(85, 100, 150, 30);
//		this.add(text1);
//
//		// 추차불가능구역 안내용(회색 사각형)
//		JLabel label2 = new JLabel();
//		label2.setBackground(new Color(94, 94, 94));
//		label2.setOpaque(true);
//		label2.setBounds(210, 100, 30, 30);
//		this.add(label2);
//
//		JLabel text2 = new JLabel("주차불가능");
//		text2.setFont(font);
//		text2.setBounds(245, 100, 150, 30);
//		this.add(text2);

		Font font = new Font("/*HY견고딕*/", Font.BOLD, 20);
		// 확인용 라벨
		confirm = new JLabel("주차 위치를 선택해주세요");
		confirm.setFont(font);
		confirm.setLocation(45, 400);
		confirm.setSize(370, 40);
		confirm.setHorizontalAlignment(JLabel.CENTER);
		this.add(confirm);

		// 최종 확인 버튼
		JButton last = new JButton("확인");
		last.setFont(new Font("/*HY견고딕*/", Font.PLAIN, 16));
		last.setForeground(Color.white);
		last.setBackground(new Color(94, 94, 94));
		last.setLocation(180, 440);
		last.setSize(100, 50);
		this.add(last);

		// 버튼 관련

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
			 * 여기 안되면 원래꺼(바탕화면 메모) 가져다 붙이기
			 */

			// \\\\ 이미지 넣기
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
					///////// getsource: 이벤트가 일어나는 위치 반환. tempBtn은 이벤트가 일어나고 있는 버튼 받는 용도. 근데 e는 왜
					///////// 들어가는데.....? jbutton 괄호 친 건 뭐고?
					//System.out.println(tempBtn.getLocation());
					//System.out.println(tempBtn.getName());

//					confirm.setLocation(108, 400);
//					confirm.setSize(300, 50);

					String result = "";
					// 인덱스를 따오기 위한 작업
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
						confirm.setText(result + "는 이용하실 수 없습니다.");
					} else {
						confirm.setText(result + "에 주차하시겠습니까?");
					}

//					// 인덱스를 따오기 위한 작업
//					for(int i=0; i<str.length; i++) {
//						if(tempBtn.getText().equals(str[i])){	// 누른 버튼의 값이 String 배열의 값과 같은 경우
//							index=i;							// 인덱스값 자리 위치(0~14)값으로 변경
//							System.out.println(index);			// 테스트 출력
//							break;
//						}
//					}
				}
			});
			this.add(btn[i]);
		}

		//System.out.println(index); // 테스트 출력(입차 시 맨 처음에 100 찍히는 거)
		last.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (index == 100) { // 아무것도 선택하지 않은 상태일 때는 check변수에 들어있는 값이 100임
					confirm.setText("선택하신 자리가 없습니다.");
				} else if(!MainFrame.parkInfo[index].isParkingState()) {
					confirm.setText("완료 처리되었습니다.");
					btn[index].setEnabled(false);
//					btn[index].setBackground(new Color(94, 94, 94));
					
					
					MainFrame.parkInfo[index].setParkingState(true); // 주차장 자리 사용여부 등록
					MainFrame.parkInfo[index].setCarNum(MainFrame.carNum);
					System.out.println(MainFrame.carNum);
					MainFrame.parkInfo[index].setDate(new Date());
					MainFrame.parkInfo[index].setStartTime(System.currentTimeMillis()); // 주차장 등록시간 저장
					
					
//					System.out.println(MainFrame.parkInfo[index].isParkingState()); // 테스트 출력
					JOptionPane.showMessageDialog(null, "완료처리되었습니다.", "입차완료", JOptionPane.PLAIN_MESSAGE); // 부모컴포넌트(null일
																											// 시 default
																											// frame),
																											// 내용, 제목,
																											// 아이콘 없는
																											// 메세지 형태
					ChangePanel.changePanel(mf, enterCarPage, new MainPage(mf));

				}

			}

		});

	}
}