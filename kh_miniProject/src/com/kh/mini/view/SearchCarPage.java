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
		Font font = new Font("HY견고딕", Font.PLAIN, 16);

		// 뒤로가기 버튼
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

		// 차량 조회 타이틀
		JLabel title = new JLabel("차량 조회");
		title.setFont(new Font("HY견고딕", Font.PLAIN, 40)); // 폰트 사이즈
		title.setLocation(130, 100);
		title.setSize(400, 100);
		title.setBackground(new Color(111, 111, 111));

		// 차량 번호 입력 필드
		JTextField number = new JTextField(20);
		number.setText("차량 번호를 입력해주세요.");
		number.setHorizontalAlignment(JLabel.CENTER);
		number.setLocation(80, 200);
		number.setSize(280, 40);

		// 입력 필드에 마우스 클릭하면 "차량 번호를 입력해주세요." 텍스트 제거
		number.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (number.getText().equals("차량 번호를 입력해주세요.")) {
					number.setText(null);
				}

			}
		});

		// 확인 버튼 클릭 시 결과 나타나는 공간
		JLabel result = new JLabel();
		result.setLocation(95, 280);
		result.setSize(250, 40);
		result.setHorizontalAlignment(JLabel.CENTER); // 글자 가운데 정렬
		result.setFont(title.getFont().deriveFont(15f)); // 폰트 사이즈

		// 확인 버튼
		JButton button = new JButton("확인");
		button.setLocation(165, 350);
		button.setSize(100, 40);
		button.setFont(font);
		button.setBackground(new Color(111, 111, 111));
		button.setForeground(Color.white);

		// 주차 위치 패널
		ParkingPanel pp = new ParkingPanel();

		// 주차위치 라벨 배열 반복문으로 생성 및 패널에 추가
		String[] abc = { "A1", "A2", "A3", "A4", "A5", "B1", "B2", "B3", "B4", "B5", "C1", "C2", "C3", "C4", "C5" };
		JLabel[] car = new JLabel[15];

		for (int i = 0; i < car.length; i++) {
			pp.add(car[i] = new JLabel(abc[i]));
			car[i].setFont(new Font("나눔고딕", Font.BOLD, 30));

			Image bg = new ImageIcon("image/pzone" + (i + 1) + ".png").getImage().getScaledInstance(100, 133, 0);
			car[i].setIcon(new ImageIcon(bg));

		}

		Image icon = new ImageIcon("image/car.png").getImage().getScaledInstance(100, 133, 0);

		// 확인 버튼 이벤트
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int count = 0;
				int index = 0;

				for (int i = 0; i < MainFrame.parkInfo.length; i++) {
					if (number.getText().equals("차량 번호를 입력해주세요.")) {
						count = 2;

						// 입력한 값이 없을 때
					} else if (number.getText().isEmpty()) {
						count = 2;

						// 입력한 값이 주차된 차량 번호와 일치하면 자동차 아이콘 노출
					} else if (number.getText().equals(MainFrame.parkInfo[i].getCarNum())) {
						car[i].setIcon(new ImageIcon(icon));
						count = 1;
						index = i; // 위치 확인용 인덱스

						//주차되어 있지 않은 번호를 입력했을 때
					} else if (!number.getText().equals(MainFrame.parkInfo[i].getCarNum())) {
						Image bg = new ImageIcon("image/pzone" + (i + 1) + ".png").getImage().getScaledInstance(100,
								133, 0);
						car[i].setIcon(new ImageIcon(bg));

					}
					if (count == 1) {
						result.setText(car[index].getText() + " 위치에 주차되어 있습니다.");
					} else if (count == 2) {
						result.setText("번호를 입력하지 않았습니다.");
					} else {
						result.setText("조회되는 차량이 없습니다.");
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