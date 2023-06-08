package com.hotel.data;

import java.util.ArrayList;
import java.util.HashMap;

public class Receipt {
    private String reserveId;
    private String name;
    private String phone;
    private String roomNum;
    private ArrayList<String> roomDate;

    private static HashMap<String, Receipt> receiptHashMap = new HashMap<>();

    public Receipt(String reserveId, String name, String phone, String roomNum, ArrayList roomDate) {
        this.reserveId = reserveId;
        this.name = name;
        this.phone = phone;
        this.roomNum = roomNum;
        this.roomDate = roomDate;
    }
//    @Override   //더미 값 출력시 주소값으로 나와서 추가했습니다.
//    public String toString() {
//        return  "이름=" + name +
//                ", 전화번호=" + phone +
//                ", 방 번호=" + roomNum +
//                ", 날짜=" + roomDate;
//    }

    public Receipt() {

    }

    public String getReserveId() {
        return reserveId;
    }

    public void setReserveId(String reserveId) {
        this.reserveId = reserveId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public ArrayList getRoomDate() {
        return roomDate;
    }

    public void setRoomDate(ArrayList roomDate) {
        this.roomDate = roomDate;
    }

    public static HashMap<String, Receipt> getReceiptHashMap() {
        return receiptHashMap;
    }

    public void setReceiptHashMap(HashMap<String, Receipt> receiptHashMap) {
        Receipt.receiptHashMap = receiptHashMap;
    }

    public static Receipt getInstance() {
        return new Receipt();
    }

}
