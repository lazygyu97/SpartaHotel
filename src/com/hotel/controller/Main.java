package com.hotel.controller;

import com.hotel.data.Receipt;
import com.hotel.data.ReserveDate;
import com.hotel.data.RoomDetail;
import com.hotel.data.RoomList;

import java.time.LocalDate;
import java.util.*;

import static com.hotel.controller.Reserve.reserve;

public class Main {

    private static RoomList roomList;
    private static RoomDetail roomDetail;

    public static void setData() {

        roomList = RoomList.getInstance();
        roomDetail = RoomDetail.getInstance();

        LocalDate startDate = LocalDate.now(); // 현재 날짜를 가져옴
        ArrayList<LocalDate> dates = new ArrayList<>();


        for (int i = 0; i < 7; i++) {

            dates.add(startDate.plusDays(i)); // 시작 날짜에 i일을 더한 날짜를 리스트에 추가
        }

        ReserveDate.setRoomDate(dates);

        ArrayList<String> rooms = new ArrayList<>();
        HashMap<String, RoomDetail> detail = new HashMap<>();

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

        detail.put("101", new RoomDetail("101", "1", "1", "체크인->13:00 / 체크아웃->12:00", dates, 85000));
        detail.put("102", new RoomDetail("102", "1", "1", "체크인->13:00 / 체크아웃->12:00", dates, 85000));
        detail.put("103", new RoomDetail("103", "1", "1", "체크인->13:00 / 체크아웃->12:00", dates, 85000));
        detail.put("201", new RoomDetail("201", "2", "2", "체크인->13:00 / 체크아웃->12:00", dates, 93000));
        detail.put("202", new RoomDetail("202", "2", "2", "체크인->13:00 / 체크아웃->12:00", dates, 93000));
        detail.put("203", new RoomDetail("203", "2", "2", "체크인->13:00 / 체크아웃->12:00", dates, 93000));
        detail.put("301", new RoomDetail("301", "3", "2", "체크인->13:00 / 체크아웃->12:00", dates, 110000));
        detail.put("302", new RoomDetail("302", "3", "2", "체크인->13:00 / 체크아웃->12:00", dates, 110000));
        detail.put("303", new RoomDetail("303", "3", "2", "체크인->13:00 / 체크아웃->12:00", dates, 110000));

        roomDetail.setDetailList(detail);

    }


    public static void start() {

        if (Receipt.getReceiptHashMap().isEmpty()) {

        } else {
            for (Map.Entry<String, Receipt> entry : Receipt.getReceiptHashMap().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().getName();
                System.out.println(key + ": " + value);
            }
        }

        Scanner sc = new Scanner(System.in);
        boolean flag1 = true;
        int selectNum;

        System.out.printf("\n%5s안녕하세요 스파르타 호텔입니다!\n\n", " ");
        while (flag1) {
            System.out.printf("%5s이용하실 서비스를 선택해주세요!\n\n", " ");
            System.out.println("1. 호텔 예약  2. 예약 확인  3. 예약 취소  4. 종료\n");

            System.out.print("서비스 번호를 입력해주세요 :");
            selectNum = sc.nextInt();


            if (selectNum == 1) {
                flag1 = false;
                System.out.print("========================================================================");
                System.out.println("\n예약 도와드리겠습니다.");

                reserve();
            } else if (selectNum == 2) {
                flag1 = false;
                System.out.print("========================================================================");

            } else if (selectNum == 3) {
                flag1 = false;
                System.out.print("========================================================================");

            } else if (selectNum == 4) {
                flag1 = false;
                System.out.print("========================================================================");

            } else {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요");
                continue;
            }
        }


    }

    public static void main(String[] args) {
        setData();
        start();
    }
}
