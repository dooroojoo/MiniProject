package com.kh.mini.view;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import com.kh.mini.model.dao.FileSaveAndOpen;
import com.kh.mini.model.vo.ParkingInform;

public class MainFrame extends JFrame {
	public static ParkingInform[] parkInfo = new ParkingInform[15];
	public static String carNum="";
	public MainFrame() {
		// 프레임상단 로고이미지 변경
		try {
			this.setIconImage(ImageIO.read(new File("imageFile/parkinglot.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**** 주차장 정보를 다룰 객체 생성 ****/
		for (int i = 0; i < MainFrame.parkInfo.length; i++) {
			MainFrame.parkInfo[i] = new ParkingInform();
		}

		// 파일이 존재하지 않으면 생성하는 작업
		File file = new File("miniProject.dat");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileSaveAndOpen.fileOpen(); // 파일 불러오기

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				FileSaveAndOpen.fileSave();
				System.out.println("파일저장완료");
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

		});

		this.setTitle("미니 프로젝트");
		this.setBounds(450, 200, 1000, 600);

		this.setResizable(false);
		new MainPage(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
