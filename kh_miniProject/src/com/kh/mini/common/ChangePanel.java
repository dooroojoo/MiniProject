package com.kh.mini.common;

import javax.swing.JPanel;

import com.kh.mini.view.MainFrame;


public class ChangePanel {
	public static void changePanel(MainFrame mf, JPanel op, JPanel np) {
		// �����̳�(������)�� ��ü �� ���� �г�(old panel), �� �г�(new Panel)�� �ּ�
		// �Ű������� ���� ����
		mf.remove(op); 		// old panel �����
		mf.add(np); 		// new panel �ø���
		mf.revalidate();	
		// ���̾ƿ� �����ڿ��� �� ������Ҹ� �缳���ϵ��� ( ���Ӱ� �ö� ������Ʈ�� ���̰� �ϱ� ���� )
		mf.repaint();
		// ���� ��� �ٽ� �׸�����
	}
}
