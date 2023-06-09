package com.hotel.controller;

import com.hotel.data.Receipt;
import com.hotel.data.ReserveDate;
import com.hotel.data.RoomDetail;
import com.hotel.data.RoomList;

import java.util.*;

import static com.hotel.controller.Main.start;

public class Reserve {

    static RoomList roomList = RoomList.getInstance();
    static RoomDetail roomDetail = RoomDetail.getInstance();
    static Receipt receipt = Receipt.getInstance();

    static Scanner sc = new Scanner(System.in);

    public static void payment(String selectedRoomNumber, String reserveDate) {
        System.out.printf("%5s----------------------------------------------", " ");
        System.out.printf("\n%5s결제 도와드리겠습니다.", " ");

        System.out.printf("\n%5s고객님의 이름을 입력해주세요 -> ", " ");
        String name = sc.next();
        System.out.printf("%5s고객님의 전화번호를 입력해주세요(특수문자x) -> 010", " ");
        String phone = sc.next();

//        if (phone.length() == 10) {
//            phone = phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6);
//        } else if (phone.length() == 11) {
//            phone = phone.substring(0, 3) + "-" + phone.substring(3, 6) + "-" + phone.substring(6);
//        } else {
//            System.out.println("     !!!!!잘못된 입력값입니다.!!!!!");
//            System.out.println("     결제 초기화면으로 돌아갑니다.");
//            payment(selectedRoomNumber, reserveDate);
//        }

        String uuid = UUID.randomUUID().toString().substring(0, 8);
        receipt.receiptAdd(uuid, name, "010" + phone, selectedRoomNumber, reserveDate);

        System.out.println("     결제 완료 되었습니다.");
        System.out.printf("%5s----------------------------------------------\n", " ");

        start();

    }

    public static void roomShow(String reserveDate) {

        System.out.println(reserveDate + "에 이용 가능한 객실들 입니다.\n");
        System.out.printf("%5s--------------------------\n", " ");

        for (String roomNumber : roomList.getRoomList()) {
            if (RoomDetail.getDetailList().get(roomNumber).getRoomDates().size() > 0) {
                for (int i = 0; i < RoomDetail.getDetailList().get(roomNumber).getRoomDates().size(); i++) {
                    if (Objects.equals(RoomDetail.getDetailList().get(roomNumber).getRoomDates().get(i).toString(), reserveDate)) {
                        System.out.printf("%6s%s ", " ", "xxx");
                        if (roomNumber.equals("103") || roomNumber.equals("203") || roomNumber.equals("303")) {
                            System.out.println();
                        }
                    } else {
                        System.out.printf("%6s%s ", " ", roomNumber);
                        if (roomNumber.equals("103") || roomNumber.equals("203") || roomNumber.equals("303")) {
                            System.out.println();
                        }
                    }
                }
            } else {
                System.out.printf("%6s%s ", " ", roomNumber);
                if (roomNumber.equals("103") || roomNumber.equals("203") || roomNumber.equals("303")) {
                    System.out.println();
                }
            }
        }
        System.out.printf("%5s--------------------------\n\n", " ");

        System.out.print("이용을 원하시는 객실 번호를 입력해주세요: ");
        String selectedRoomNumber = sc.next();

        if (roomDetail.getDetailList().containsKey(selectedRoomNumber)) {
            RoomDetail selectedRoom = RoomDetail.getDetailList().get(selectedRoomNumber);
            System.out.printf("\n%5s----------------------------------------------", " ");
            System.out.printf("\n%5s방 번호: %s", " ", selectedRoom.getRoomNum());
            System.out.printf("\n%5s이용 가능 인원: %s", " ", selectedRoom.getRoomCapcity());
            System.out.printf("\n%5s침대 개수: %s개", " ", selectedRoom.getRoomBed());
            System.out.printf("\n%5s%s", " ", selectedRoom.getCheckTime());
            System.out.printf("\n%5s가격: %s원", " ", selectedRoom.getRoomPrice());
            System.out.printf("\n%5s----------------------------------------------\n", " ");
            System.out.printf("%5s%s호실 %s 날짜로 예약하시겠습니까?", " ", selectedRoomNumber, reserveDate);
            System.out.printf("\n%5s1. 예약  2. 취소 (뒤로돌아가기)\n%5s-> ", " ", " ");
            int selectedNum = sc.nextInt();

            if (selectedNum == 1) {
                payment(selectedRoomNumber, reserveDate);
            } else if (selectedNum == 2) {
                reserve();
            } else {
                System.out.println("1 또는 2 숫자로 입력해주세요.");
            }
        } else {
            System.out.printf("----------------------------------------------\n", " ");
            System.out.println("이미 예약된 방이거나 잘못된 입력값입니다.\n돌아갑니다.");
            System.out.printf("----------------------------------------------\n", " ");

            roomShow(reserveDate);


        }


    }

    public static void reserve() {

        Scanner sc = new Scanner(System.in);

        String firstDay = ReserveDate.getRoomDate().get(0).toString();
        String lastDay = ReserveDate.getRoomDate().get(6).toString();

        System.out.println("예약 가능한 날짜는 " + firstDay + " 부터 " + lastDay + " 까지입니다.");
        System.out.println("호텔 이용하실 날짜를 입력해주세요.");

        System.out.print("날짜 입력 ->");
        String day = sc.next();

        int lineDate1 = Integer.parseInt(firstDay.substring(8, 10));
        int lineDate2 = Integer.parseInt(lastDay.substring(8, 10));

        if (lineDate1 <= Integer.parseInt(day) && Integer.parseInt(day) <= lineDate2) {
            if (day.length() == 1) {
                day = "0" + day;
                System.out.println(day);
            }
        } else {
            System.out.println("예약불가능한 날짜입니다.");
            reserve();
        }

        String reserveDate = firstDay.substring(0, 4) + "-" + firstDay.substring(5, 7) + "-" + day;
        roomShow(reserveDate);

    }
}
