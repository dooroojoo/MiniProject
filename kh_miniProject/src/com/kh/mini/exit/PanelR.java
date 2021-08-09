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
		Font font = new Font("HY�߰��", Font.PLAIN, 16);
		JButton calc = new JButton("�����ϱ�");
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
				JOptionPane.showMessageDialog(null, "�Ϸ�ó���Ǿ����ϴ�.", "�����Ϸ�", JOptionPane.PLAIN_MESSAGE); // �θ�������Ʈ(null��

				
				
				ChangePanel.changePanel(mf,  exitCarPage, new MainPage(mf));
			}
			
		});
		
		
		String[] parkingZoneMark = { "A�� 1��", "A�� 2��", "A�� 3��", "A�� 4��", "A�� 5��", "B�� 1��", "B�� 2��", "B�� 3��", "B�� 4��", "B�� 5��", "C�� 1��", "C�� 2��", "C�� 3��", "C�� 4��",
		"C�� 5��" };
		Font font2 = new Font("HY�߰��", Font.PLAIN, 35);
		JLabel carLocation = new JLabel(parkingZoneMark[index]);
		carLocation.setFont(font2);
		carLocation.setHorizontalAlignment(JLabel.CENTER);
		carLocation.setLocation(60, 115);
		carLocation.setSize(300, 40);
		this.add(carLocation);
		
		Font font3 = new Font("", Font.BOLD, 15);
		
		JLabel timeGuideMessage = new JLabel("���� �����ð�");
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
//		System.out.println("�ð��׽�Ʈ" + (end-start));
		
		long hour=result/360;
		result=result%360;
		long min=result/60;
		result=result%60;
		long sec=result;
		JLabel timeMessage = new JLabel(hour+"�� "+min+"�� "+sec+"��");
		timeMessage.setFont(font2);
		timeMessage.setHorizontalAlignment(JLabel.CENTER);
		timeMessage.setLocation(60, 200);
		timeMessage.setSize(300, 40);
		this.add(timeMessage);
		
		
		Font font4 = new Font("", Font.PLAIN, 15);
		JLabel startTime = new JLabel("���� :");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-a-hh-mm-ss");
		//System.out.println(MainFrame.parkInfo[index]);
		String formatDate = sdf.format(MainFrame.parkInfo[index].getDate().getTime());
		startTime.setText("���� : "+formatDate);
	//	System.out.println(formatDate);
		startTime.setFont(font4);
		startTime.setHorizontalAlignment(JLabel.CENTER);
		startTime.setLocation(60, 225);
		startTime.setSize(300, 40);
		this.add(startTime);
		
		
		JLabel presentTime = new JLabel("���� :");
		Date presentDate=new Date();
		String formatDate2=sdf.format(presentDate.getTime());
		presentTime.setText("���� : "+formatDate2);
		presentTime.setFont(font4);
		presentTime.setHorizontalAlignment(JLabel.CENTER);
		presentTime.setLocation(60, 245);
		presentTime.setSize(300, 40);
		this.add(presentTime);
		
		Font font6 = new Font("", Font.BOLD, 15);
		JLabel priceMessage = new JLabel("��ü �ݾ�");
		priceMessage.setFont(font6);
		priceMessage.setForeground(Color.gray);
		priceMessage.setHorizontalAlignment(JLabel.LEFT);
		priceMessage.setLocation(40, 290);
		priceMessage.setSize(300, 40);
		this.add(priceMessage);
		
		
		JLabel totalPrice = new JLabel("20000��");
		totalPrice.setFont(font6);
		totalPrice.setForeground(Color.gray);
		totalPrice.setHorizontalAlignment(JLabel.RIGHT);
		totalPrice.setLocation(80, 290);
		totalPrice.setSize(300, 40);
		this.add(totalPrice);
		long resultPay=temp; // �ʴ���
		int timePay=0;
		if(resultPay<10) {
			totalPrice.setText("0��");
			timePay=0;
		} else if (resultPay>=10 && resultPay<100) {
			int num=(int) (resultPay/10);
			
			switch(num) {
			case 1: 
				totalPrice.setText("500��"); timePay=500; break;
			case 2:
				totalPrice.setText("1000��");  timePay=1000; break;
			case 3:
				totalPrice.setText("1500��"); timePay=1500; break;
			case 4:
				totalPrice.setText("2000��"); timePay=2000; break;
			case 5:
				totalPrice.setText("2500��"); timePay=2500;break;
			case 6:
				totalPrice.setText("3000��"); timePay=3000;break;
			case 7:
				totalPrice.setText("3500��"); timePay=3500;break;
			case 8:
				totalPrice.setText("4000��"); timePay=4000;break;
			case 9:
				totalPrice.setText("4500��"); timePay=4500;break;
			}
			
		} else {
			totalPrice.setText("5000��");
			timePay=5000;
		}
		// 30�� ����                     // �����ֱ⿡���� 5�� ����
		// 30�� ���� 10�д� 400�� // 30�� ���� 10�ʴ� 500��
		// ���� �̿�� 1�ð� ����  // �����̿�� 10�� ����
		// �ִ��ѵ� 5õ��
		
		
		
		JLabel couponMessage = new JLabel("�� ���� �ݾ�");
		couponMessage.setFont(font6);
		couponMessage.setForeground(Color.gray);
		couponMessage.setHorizontalAlignment(JLabel.LEFT);
		couponMessage.setLocation(40, 310);
		couponMessage.setSize(300, 40);
		this.add(couponMessage);
		
		int couponPay=0;
		JLabel couponPrice = new JLabel("0��");
		if(couponBool==true) {
			couponPrice.setText("500��");
			couponPay=500;
		} else {
			couponPrice.setText("0��");
		}
		couponPrice.setFont(font6);
		couponPrice.setForeground(Color.gray);
		couponPrice.setHorizontalAlignment(JLabel.RIGHT);
		couponPrice.setLocation(80, 310);
		couponPrice.setSize(300, 40);
		this.add(couponPrice);
		
		
		Font font5 = new Font("", Font.BOLD, 20);
		JLabel resultMessage = new JLabel("�������� �ݾ�");
		resultMessage.setFont(font5);
		resultMessage.setHorizontalAlignment(JLabel.LEFT);
		resultMessage.setLocation(40, 350);
		resultMessage.setSize(300, 40);
		this.add(resultMessage);
		
		Font font7 = new Font("", Font.BOLD, 30);
		JLabel resultPrice = new JLabel("15000��");
		resultPrice.setText(""+(timePay-couponPay)+"��");
		resultPrice.setFont(font7);
		resultPrice.setHorizontalAlignment(JLabel.RIGHT);
		resultPrice.setLocation(80, 350);
		resultPrice.setSize(300, 40);
		this.add(resultPrice);
		
		
		
		
		
		
		
		
		
		
		
		
		this.add(calc);
		
		
		
		
	}
	public void paintComponent(Graphics g) {
		// ���� �������� �׸��� ����
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		// �� ������ ����
		g2.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, 0));
		g2.setColor(Color.black);
		// A ���� �ʱ� ����
		int x = 10;
		int y = 35;
		// ���׸��� A1 ����
		// g2.draw(new Line2D.Double(x, y, x + 150, y));
		g2.draw(new Line2D.Double(x, y + 60, x + 400, y + 60));

		g2.draw(new Line2D.Double(x, y + 60, x , y + 400));
		g2.draw(new Line2D.Double(x+400, y + 60, x+400 , y + 400));

		g2.draw(new Line2D.Double(x, y + 400, x + 400, y + 400));
		/////////////////////////////////////////////////////////
		
		
		// �߰���
		g2.setStroke(new BasicStroke(1, BasicStroke.CAP_ROUND, 0));
		g2.setColor(Color.gray);
		g2.draw(new Line2D.Double(x+30, y + 130, x + 370, y + 130));
		g2.draw(new Line2D.Double(x+30, y + 250, x + 370, y + 250));
		
	}
}


