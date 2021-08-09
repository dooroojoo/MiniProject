package com.kh.mini.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.kh.mini.common.ChangePanel;
import com.kh.mini.exit.PanelR;
import com.kh.mini.model.vo.ParkingInform;

public class ExitCarPage extends JPanel {

	private MainFrame mf;
	private JPanel exitCarPage;
	private JPanel tempPanel = null;
	private JLabel lb4;
	private JTextField tf2;
	private String coupon[] = { "PQRST4", "UVWXY5", "Z88888", "ABCDE1", "FGHIJ2", "KLMNO3" };
	private PanelR pr;
	private int douCount=0;
	

	public ExitCarPage(MainFrame mf) {
		for(int i=0; i<MainFrame.parkInfo.length; i++) {
			System.out.println(MainFrame.parkInfo[i]);
		}
		this.mf = mf;
		exitCarPage = this;
		ParkingInform pi = new ParkingInform();

		this.setBackground(Color.white);
//		this.setBounds(450, 200, 1000, 600);
		Font font = new Font("HY견고딕", Font.PLAIN, 16);

		// Layout 지정 없이 위치 지정하면서 배치하는 방법
		this.setLayout(null);

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
//				exitCarPage.remove(pr);
				exitCarPage.revalidate();
				exitCarPage.repaint(); // 잠시대기
				ChangePanel.changePanel(mf, exitCarPage, new MainPage(mf));
			}

		});
		this.add(backBtn);
		/////////////////////////////////////////////////////

		JLabel lb = new JLabel("요금정산"); // 라벨
		lb.setFont(new Font("HY견고딕", Font.PLAIN, 32));
		lb.setLocation(180, 65);
		lb.setSize(150, 100);

		JLabel lb2 = new JLabel("차량 번호를 입력해주세요.");
		lb2.setFont(font);
		lb2.setLocation(154, 125);
		lb2.setSize(200, 100);

		JTextField tf = new JTextField(20); // 텍스트칠수있는필드(컬럼사이즈)
		tf.setLocation(90, 190);
		tf.setSize(310, 70);

		JButton btn = new JButton("요금확인"); // 버튼
		btn.setFont(font);
		btn.setForeground(Color.white);
		btn.setBackground(new Color(94, 94, 94));
		btn.setLocation(190, 410);
		btn.setSize(100, 50);

		JLabel lb3 = new JLabel("쿠폰을 등록하여 사용하세요.");
		lb3.setFont(font);
		lb3.setLocation(150, 210);
		lb3.setSize(210, 150);

		lb4 = new JLabel("입력이 완료되면 확인버튼을 누르시오");
		lb4.setHorizontalAlignment(JLabel.CENTER);
		lb4.setFont(font);
		lb4.setForeground(Color.red);
		lb4.setLocation(92, 315);
		lb4.setSize(300, 150);
		this.add(lb4);

		tf2 = new JTextField(20);
		tf2.setLocation(90, 300);
		tf2.setSize(310, 70);

//		JButton btn2 = new JButton("등록");
//		btn2.setFont(font);
//		btn2.setForeground(Color.white);
//		btn2.setBackground(new Color(94, 94, 94));
//		btn2.setLocation(400, 300);
//		btn2.setSize(80, 70);

//		JLabel result = new JLabel("");
//		result.setFont(font);
//		result.setLocation(600, 100);
//		result.setSize(145, 100);

		Image car = new ImageIcon("imageFile/eecar.PNG").getImage().getScaledInstance(300, 300, 0);
		JLabel ccar = new JLabel(new ImageIcon(car));
		ccar.setLocation(580, 120);
		ccar.setSize(300, 300);

		ccar.setBackground(Color.white);

		/*
		 * btn.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) {
		 * 
		 * ChangePanel.changePanel(mf, exitCarPage, new Receipt()); }
		 * 
		 * });
		 */

		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String str = tf.getText();
				String cp = tf2.getText();
				int index=0;
				int count = 0;
				boolean couponBool=false;
				
				int couponCheck = 0;

				for (int i = 0; i < coupon.length; i++) {
					if (coupon[i].equals(cp)) {
						couponCheck = 1;
						couponBool=true;
						//System.out.println("Test");
					}
				}
//				String coupon[] = {"PQRST4","UVWXY5","Z88888","ABCDE1","FGHIJ2","KLMNO3"};

				Date presentDate = new Date(); // 요금확인 버튼이 눌린시점에 시간 계산

				for (int i = 0; i < MainFrame.parkInfo.length; i++) {
					if (MainFrame.parkInfo[i].getCarNum().equals(str)
							&& !MainFrame.parkInfo[i].getCarNum().equals("")) {
						count ++;
						index = i;
						
						douCount++;

					} 
				}
				
				
				if (MainFrame.parkInfo[index].isParkingState() != false) { // 1234에서 true로 활성화 된 상태
					if(douCount>1) {
						exitCarPage.remove(tempPanel);
						exitCarPage.add(ccar);
						exitCarPage.revalidate();
						exitCarPage.repaint();
					}
					//System.out.println("index:" +index);
					tempPanel = new PanelR(mf, exitCarPage,index, couponBool);
				}

				if (count == 1 && couponCheck == 1) {
					//System.out.println("index:" +index);
					lb4.setText("차량과 쿠폰 조회가 완료되었습니다.");
					exitCarPage.remove(ccar);
					exitCarPage.add(tempPanel);
					exitCarPage.revalidate();
					exitCarPage.repaint();
					

				} else if (count == 1 && couponCheck == 0) {
					//System.out.println("index:" +index);
					//System.out.println(count);
					lb4.setText("차량 조회가 완료되었습니다.");
					exitCarPage.remove(ccar);
					exitCarPage.add(tempPanel);
					exitCarPage.revalidate();
					exitCarPage.repaint();
					

				} else {
					lb4.setText("일치하는 차량이 없습니다.");
					douCount=0;
					if (tempPanel != null) {
						//System.out.println("dasdasdsad");
						exitCarPage.remove(tempPanel);
						exitCarPage.add(ccar);
						exitCarPage.revalidate();
						exitCarPage.repaint();
					}
					tempPanel =null;
				}
				
				


				tf.requestFocus();

			}

		});

		this.add(ccar);
		this.add(lb);
		this.add(lb2);
		this.add(tf);
		this.add(lb3);
		this.add(tf2);
		this.add(btn);

	}

}