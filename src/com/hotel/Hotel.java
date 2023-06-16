package com.hotel;

import com.hotel.data.Receipt;
import com.hotel.data.ReserveDate;
import com.hotel.data.RoomDetail;
import com.hotel.data.RoomList;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Hotel {
    public static void setData() { //main에서 없애기

        RoomList roomList = com.hotel.data.RoomList.getInstance();
        RoomDetail roomDetail = RoomDetail.getInstance();
        Receipt receipt = Receipt.getInstance(); // Receipt 인스턴스 초기화 추가

        LocalDate startDate = LocalDate.now(); // 현재 날짜를 가져옴
        ArrayList<LocalDate> dates = new ArrayList<>();
        receipt.setReceiptHashMap(new HashMap<>()); // receiptHashMap 초기화

        for (int i = 0; i < 7; i++) {

            dates.add(startDate.plusDays(i)); // 시작 날짜에 i일을 더한 날짜를 리스트에 추가
        }

        ReserveDate.setRoomDate(dates);

        ArrayList<String> rooms = new ArrayList<>();
        HashMap<String, RoomDetail> detail = new HashMap<>();
        ArrayList<String> defaultDates = new ArrayList<>();

        rooms.add("101");
        rooms.add("102");
        rooms.add("103");
        rooms.add("201");
        rooms.add("202");
        rooms.add("203");
        rooms.add("301");
        rooms.add("302");
        rooms.add("303");

        roomList.setRoomList(rooms);

        detail.put("101", new RoomDetail("101", "1", "1", "체크인->13:00 / 체크아웃->12:00", defaultDates, 85000));
        detail.put("102", new RoomDetail("102", "1", "1", "체크인->13:00 / 체크아웃->12:00", defaultDates, 85000));
        detail.put("103", new RoomDetail("103", "1", "1", "체크인->13:00 / 체크아웃->12:00", defaultDates, 85000));
        detail.put("201", new RoomDetail("201", "2", "2", "체크인->13:00 / 체크아웃->12:00", defaultDates, 93000));
        detail.put("202", new RoomDetail("202", "2", "2", "체크인->13:00 / 체크아웃->12:00", defaultDates, 93000));
        detail.put("203", new RoomDetail("203", "2", "2", "체크인->13:00 / 체크아웃->12:00", defaultDates, 93000));
        detail.put("301", new RoomDetail("301", "3", "2", "체크인->13:00 / 체크아웃->12:00", defaultDates, 110000));
        detail.put("302", new RoomDetail("302", "3", "2", "체크인->13:00 / 체크아웃->12:00", defaultDates, 110000));
        detail.put("303", new RoomDetail("303", "3", "2", "체크인->13:00 / 체크아웃->12:00", defaultDates, 110000));

        roomDetail.setDetailList(detail);

    }
}
