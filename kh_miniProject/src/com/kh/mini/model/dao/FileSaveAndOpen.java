package com.kh.mini.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.kh.mini.model.vo.ParkingInform;
import com.kh.mini.view.MainFrame;
import com.kh.mini.view.MainPage;



public class FileSaveAndOpen {
	public static void fileSave() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("miniProject.dat"))) {
			oos.writeObject(MainFrame.parkInfo);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void fileOpen() {

		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("miniProject.dat"))) {
			
			MainFrame.parkInfo=(ParkingInform[]) ois.readObject();
			
		} catch(EOFException e) {
			System.out.println("miniProject.dat ���� �б� �Ϸ�");
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		// �� �о�Դ��� ���Ȯ��
//		for(ParkingInform pi :MainPage.parkInfo) {
//			if(pi==null) break;
//			System.out.println(pi);
//			
//		}
	}
}
