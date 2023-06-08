package com.hotel.controller;

import com.hotel.data.RoomDetail;
import com.hotel.data.RoomList;

import java.util.Scanner;

public class Reserve {

    public static void roomSampleData(String reserveDate) {

        RoomList roomList = Main.getRoomList();
        RoomDetail roomDetail = Main.getRoomDetail();

        System.out.println(reserveDate + "에 이용 가능한 객실들 입니다.\n");
        System.out.printf("%5s-------------\n", " ");

        for (String roomNumber : roomList.getRoomList()) {
            System.out.printf("%6s%s ", " ", roomNumber);

            if (roomNumber.equals("103") || roomNumber.equals("203") || roomNumber.equals("303")) {
                System.out.println();
            }
        }

        System.out.printf("%5s-------------\n", " ");

        Scanner sc = new Scanner(System.in);
        System.out.print("이용을 원하시는 객실 번호를 입력해주세요: ");
        String selectedRoomNumber = sc.next();

        if (roomDetail.getDetailList().containsKey(selectedRoomNumber)) {
            RoomDetail selectedRoom = roomDetail.getDetailList().get(selectedRoomNumber);
            System.out.println("방 번호: " + selectedRoom.getRoomNum());
            System.out.println("이용 가능 인원: " + selectedRoom.getRoomCapcity());
            System.out.println("침대 개수: " + selectedRoom.getRoomBed());
            System.out.println(selectedRoom.getCheckTime());
            System.out.println("가격: " + selectedRoom.getRoomPrice());
        }
    }

    public static void reserve() {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n예약 도와드리겠습니다.");
        System.out.println("호텔 이용하실 날짜를 입력해주세요.");

        System.out.print("년: ");
        String year = sc.next();

        System.out.print("월: ");
        String month = sc.next();

        System.out.print("일: ");
        String day = sc.next();

        String reserveDate = year + "/" + month + "/" + day;
        roomSampleData(reserveDate);
    }
}
