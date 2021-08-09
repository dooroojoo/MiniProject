package com.kh.mini.common;

import javax.swing.JPanel;

import com.kh.mini.view.MainFrame;


public class ChangePanel {
	public static void changePanel(MainFrame mf, JPanel op, JPanel np) {
		// 컨테이너(프레임)과 교체 될 이전 패널(old panel), 새 패널(new Panel)의 주소
		// 매개변수로 전달 받음
		mf.remove(op); 		// old panel 지우기
		mf.add(np); 		// new panel 올리기
		mf.revalidate();	
		// 레이아웃 관리자에게 새 구성요소를 재설정하도록 ( 새롭게 올라간 컴포넌트가 보이게 하기 위해 )
		mf.repaint();
		// 구성 요소 다시 그리도록
	}
}
