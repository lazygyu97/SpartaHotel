package com.hotel.data;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomDetail {

    private String roomNum;
    private String roomCapcity;
    private String roomBed;
    private String checkTime;
    private ArrayList roomDates; //아직 애매함
    private int roomPrice;

    private static HashMap<String,RoomDetail> detailList = new HashMap<>();

    public RoomDetail(String roomNum, String roomCapcity, String roomBed, String checkTime, ArrayList roomDates, int roomPrice){
        this.roomNum=roomNum;
        this.roomCapcity=roomCapcity;
        this.roomBed=roomBed;
        this.checkTime=checkTime;
        this.roomDates=roomDates;
        this.roomPrice=roomPrice;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public void setRoomCapcity(String roomCapcity) {
        this.roomCapcity = roomCapcity;
    }

    public void setRoomBed(String roomBed) {
        this.roomBed = roomBed;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public void setRoomDates(ArrayList roomDates) {
        this.roomDates = roomDates;
    }

    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setDetailList(HashMap<String, RoomDetail> detailList) {
        this.detailList = detailList;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public String getRoomCapcity() {
        return roomCapcity;
    }

    public String getRoomBed() {
        return roomBed;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public ArrayList getRoomDates() {
        return roomDates;
    }

    public int getRoomPrice() {
        return roomPrice;
    }

    public static HashMap<String, RoomDetail> getDetailList() {
        return detailList;
    }

    private static RoomDetail instance; // 싱글톤 인스턴스 변수

    public static RoomDetail getInstance(){
        if (instance == null) {
            // 최초 호출 시에만 인스턴스 생성
            instance = new RoomDetail("default", "default", "default", "default", new ArrayList(), 0);
        }
        return instance;
    }


}
