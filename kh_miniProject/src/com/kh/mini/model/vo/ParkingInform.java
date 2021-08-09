package com.kh.mini.model.vo;

import java.io.Serializable;
import java.util.Date;

public class ParkingInform implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8602843626598555474L;
	
	
	private boolean parkingState=false; // ���������� �������� �˷��ִ� ����
	private String carNum=""; // ��ȣ�� ����
	private long startTime=0L; // ������ �����ð� ����
	private Date date;

	public ParkingInform() {
		super();
	}
	

	public ParkingInform(boolean parkingState, String carNum, long startTime, Date date) {
		super();
		this.parkingState = parkingState;
		this.carNum = carNum;
		this.startTime = startTime;
		this.date = date;
	}


	public boolean isParkingState() {
		return parkingState;
	}

	public void setParkingState(boolean parkingState) {
		this.parkingState = parkingState;
	}

	public String getCarNum() {
		return carNum;
	}

	public void setCarNum(String carNum) {
		this.carNum = carNum;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "ParkingInform [parkingState=" + parkingState + ", carNum=" + carNum + ", startTime=" + startTime
				+ ", date=" + date + "]";
	}

	
	

	
	

}
