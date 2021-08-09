package com.kh.mini.exit;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.kh.mini.common.ChangePanel;
import com.kh.mini.view.ExitCarPage;
import com.kh.mini.view.MainFrame;
import com.kh.mini.view.MainPage;

public class PanelR extends JPanel {
	private PanelR panelR;
	public PanelR(MainFrame mf, JPanel exitCarPage, int index, boolean couponBool) {
		panelR=this;
		this.setLocation(500, 0);
		this.setSize(500, 600);
		this.setLayout(null);
		this.setBackground(Color.white);
		Font font = new Font("HY견고딕", Font.PLAIN, 16);
		JButton calc = new JButton("출차하기");
		calc.setFont(font);
		calc.setForeground(Color.white);
		calc.setBackground(new Color(94, 94, 94));
		calc.setLocation(152, 410);
		calc.setSize(120, 50);
		calc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame.parkInfo[index].setParkingState(false);
				MainFrame.parkInfo[index].setCarNum("");
				MainFrame.parkInfo[index].setStartTime(0L);
				MainFrame.parkInfo[index].setDate(null);
				JOptionPane.showMessageDialog(null, "완료처리되었습니다.", "출차완료", JOptionPane.PLAIN_MESSAGE); // 부모컴포넌트(null일

				
				
				ChangePanel.changePanel(mf,  exitCarPage, new MainPage(mf));
			}
			
		});
		
		
		String[] parkingZoneMark = { "A행 1번", "A행 2번", "A행 3번", "A행 4번", "A행 5번", "B행 1번", "B행 2번", "B행 3번", "B행 4번", "B행 5번", "C행 1번", "C행 2번", "C행 3번", "C행 4번",
		"C행 5번" };
		Font font2 = new Font("HY견고딕", Font.PLAIN, 35);
		JLabel carLocation = new JLabel(parkingZoneMark[index]);
		carLocation.setFont(font2);
		carLocation.setHorizontalAlignment(JLabel.CENTER);
		carLocation.setLocation(60, 115);
		carLocation.setSize(300, 40);
		this.add(carLocation);
		
		Font font3 = new Font("", Font.BOLD, 15);
		
		JLabel timeGuideMessage = new JLabel("현재 주차시간");
		timeGuideMessage.setFont(font3);
		timeGuideMessage.setForeground(Color.gray);
		timeGuideMessage.setHorizontalAlignment(JLabel.CENTER);
		timeGuideMessage.setLocation(60, 160);
		timeGuideMessage.setSize(300, 45);
		this.add(timeGuideMessage);
		
		
		long end=System.currentTimeMillis()/1000;
		long start=MainFrame.parkInfo[index].getStartTime()/1000;
		long result=end-start;
		long temp=result;
//		System.out.println("시간테스트" + (end-start));
		
		long hour=result/360;
		result=result%360;
		long min=result/60;
		result=result%60;
		long sec=result;
		JLabel timeMessage = new JLabel(hour+"시 "+min+"분 "+sec+"초");
		timeMessage.setFont(font2);
		timeMessage.setHorizontalAlignment(JLabel.CENTER);
		timeMessage.setLocation(60, 200);
		timeMessage.setSize(300, 40);
		this.add(timeMessage);
		
		
		Font font4 = new Font("", Font.PLAIN, 15);
		JLabel startTime = new JLabel("입차 :");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-a-hh-mm-ss");
		//System.out.println(MainFrame.parkInfo[index]);
		String formatDate = sdf.format(MainFrame.parkInfo[index].getDate().getTime());
		startTime.setText("입차 : "+formatDate);
	//	System.out.println(formatDate);
		startTime.setFont(font4);
		startTime.setHorizontalAlignment(JLabel.CENTER);
		startTime.setLocation(60, 225);
		startTime.setSize(300, 40);
		this.add(startTime);
		
		
		JLabel presentTime = new JLabel("현재 :");
		Date presentDate=new Date();
		String formatDate2=sdf.format(presentDate.getTime());
		presentTime.setText("현재 : "+formatDate2);
		presentTime.setFont(font4);
		presentTime.setHorizontalAlignment(JLabel.CENTER);
		presentTime.setLocation(60, 245);
		presentTime.setSize(300, 40);
		this.add(presentTime);
		
		Font font6 = new Font("", Font.BOLD, 15);
		JLabel priceMessage = new JLabel("전체 금액");
		priceMessage.setFont(font6);
		priceMessage.setForeground(Color.gray);
		priceMessage.setHorizontalAlignment(JLabel.LEFT);
		priceMessage.setLocation(40, 290);
		priceMessage.setSize(300, 40);
		this.add(priceMessage);
		
		
		JLabel totalPrice = new JLabel("20000원");
		totalPrice.setFont(font6);
		totalPrice.setForeground(Color.gray);
		totalPrice.setHorizontalAlignment(JLabel.RIGHT);
		totalPrice.setLocation(80, 290);
		totalPrice.setSize(300, 40);
		this.add(totalPrice);
		long resultPay=temp; // 초단위
		int timePay=0;
		if(resultPay<10) {
			totalPrice.setText("0원");
			timePay=0;
		} else if (resultPay>=10 && resultPay<100) {
			int num=(int) (resultPay/10);
			
			switch(num) {
			case 1: 
				totalPrice.setText("500원"); timePay=500; break;
			case 2:
				totalPrice.setText("1000원");  timePay=1000; break;
			case 3:
				totalPrice.setText("1500원"); timePay=1500; break;
			case 4:
				totalPrice.setText("2000원"); timePay=2000; break;
			case 5:
				totalPrice.setText("2500원"); timePay=2500;break;
			case 6:
				totalPrice.setText("3000원"); timePay=3000;break;
			case 7:
				totalPrice.setText("3500원"); timePay=3500;break;
			case 8:
				totalPrice.setText("4000원"); timePay=4000;break;
			case 9:
				totalPrice.setText("4500원"); timePay=4500;break;
			}
			
		} else {
			totalPrice.setText("5000원");
			timePay=5000;
		}
		// 30분 무료                     // 보여주기에서는 5초 무료
		// 30분 이후 10분당 400원 // 30초 이후 10초당 500원
		// 쿠폰 이용시 1시간 무료  // 쿠폰이용시 10초 무료
		// 최대한도 5천원
		
		
		
		JLabel couponMessage = new JLabel("총 할인 금액");
		couponMessage.setFont(font6);
		couponMessage.setForeground(Color.gray);
		couponMessage.setHorizontalAlignment(JLabel.LEFT);
		couponMessage.setLocation(40, 310);
		couponMessage.setSize(300, 40);
		this.add(couponMessage);
		
		int couponPay=0;
		JLabel couponPrice = new JLabel("0원");
		if(couponBool==true) {
			couponPrice.setText("500원");
			couponPay=500;
		} else {
			couponPrice.setText("0원");
		}
		couponPrice.setFont(font6);
		couponPrice.setForeground(Color.gray);
		couponPrice.setHorizontalAlignment(JLabel.RIGHT);
		couponPrice.setLocation(80, 310);
		couponPrice.setSize(300, 40);
		this.add(couponPrice);
		
		
		Font font5 = new Font("", Font.BOLD, 20);
		JLabel resultMessage = new JLabel("결제예상 금액");
		resultMessage.setFont(font5);
		resultMessage.setHorizontalAlignment(JLabel.LEFT);
		resultMessage.setLocation(40, 350);
		resultMessage.setSize(300, 40);
		this.add(resultMessage);
		
		Font font7 = new Font("", Font.BOLD, 30);
		JLabel resultPrice = new JLabel("15000원");
		resultPrice.setText(""+(timePay-couponPay)+"원");
		resultPrice.setFont(font7);
		resultPrice.setHorizontalAlignment(JLabel.RIGHT);
		resultPrice.setLocation(80, 350);
		resultPrice.setSize(300, 40);
		this.add(resultPrice);
		
		
		
		
		
		
		
		
		
		
		
		
		this.add(calc);
		
		
		
		
	}
	public void paintComponent(Graphics g) {
		// 현재 주차장을 그리고 있음
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// 선 디자인 셋팅
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, 0));
		g2.setColor(Color.black);
		// A 구역 초기 세팅
		int x = 10;
		int y = 35;
		// 선그리기 A1 구역
		// g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 60, x + 400, y + 60));

		g2.draw(new Line2D.Double(x, y + 60, x , y + 400));
		g2.draw(new Line2D.Double(x+400, y + 60, x+400 , y + 400));

		g2.draw(new Line2D.Double(x, y + 400, x + 400, y + 400));
		/////////////////////////////////////////////////////////
		
		
		// 중간선
		g2.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, 0));
		g2.setColor(Color.gray);
		g2.draw(new Line2D.Double(x+30, y + 130, x + 370, y + 130));
		g2.draw(new Line2D.Double(x+30, y + 250, x + 370, y + 250));
		
	}
}


