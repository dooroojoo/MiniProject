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
		// �����ӻ�� �ΰ��̹��� ����
		try {
			this.setIconImage(ImageIO.read(new File("imageFile/parkinglot.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		/**** ������ ������ �ٷ� ��ü ���� ****/
		for (int i = 0; i < MainFrame.parkInfo.length; i++) {
			MainFrame.parkInfo[i] = new ParkingInform();
		}

		// ������ �������� ������ �����ϴ� �۾�
		File file = new File("miniProject.dat");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileSaveAndOpen.fileOpen(); // ���� �ҷ�����

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				FileSaveAndOpen.fileSave();
				System.out.println("��������Ϸ�");
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

		this.setTitle("�̴� ������Ʈ");
		this.setBounds(450, 200, 1000, 600);

		this.setResizable(false);
		new MainPage(this);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
