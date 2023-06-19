package com.hotel.controller;

//어진 리팩토링 중
import com.hotel.data.Receipt;
import com.hotel.data.ReserveDate;
import com.hotel.data.RoomDetail;
import com.hotel.data.RoomList;

import java.time.LocalDate;
import java.util.*;

import static com.hotel.controller.Reserve.reserve;
import static com.hotel.controller.Reserve.sc;

public class Main {

    private RoomList roomList;
    private RoomDetail roomDetail;
    private Receipt receipt;

    public void setRoomList(RoomList roomList) {
        this.roomList = roomList;
    }

    public void setRoomDetail(RoomDetail roomDetail) {
        this.roomDetail = roomDetail;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }



    private String dateValue;
    static String roomNum;
    static ArrayList<String> dateValue2;
    static String roomNum2;


    public static void start() {

        if (Receipt.getReceiptHashMap().isEmpty()) {

        } else {

            //최종 영수증에 방번호와 예약 날짜를 가져와 룸디테일의 해당 날짜 데이터를 추가한다.
            for (Map.Entry<String, Receipt> entry : Receipt.getReceiptHashMap().entrySet()) {
                ArrayList<String> deleteDates = new ArrayList<>();

                roomNum = entry.getValue().getRoomNum();
                dateValue = entry.getValue().getRoomDate();
                deleteDates.add(dateValue);
                RoomDetail.getDetailList().get(roomNum).setRoomDates(deleteDates);

            }

//            for (Map.Entry<String, RoomDetail> entry2 : RoomDetail.getDetailList().entrySet()) {
//                roomNum2= entry2.getValue().getRoomNum();
//                dateValue2=entry2.getValue().getRoomDates();
//                System.out.println(roomNum2+": "+dateValue2);
//            }

        }

        Scanner sc = new Scanner(System.in);
        int selectNum;
        boolean flag = true;
        System.out.printf("\n%5s안녕하세요 스파르타 호텔입니다!\n\n", " ");
        while (flag) {
            System.out.printf("%5s이용하실 서비스를 선택해주세요!\n\n", " ");
            System.out.println("1. 호텔 예약  2. 예약 확인 및 취소  3. 종료  4.관리자 모드(비밀번호 필요)\n");

            System.out.print("서비스 번호를 입력해주세요 :");
            selectNum = sc.nextInt();


            if (selectNum == 1) {
                System.out.print("========================================================================");
                System.out.println("\n예약 도와드리겠습니다.");
                reserve();
            } else if (selectNum == 2) {
                choiceCheck();
                System.out.print("========================================================================");

            } else if (selectNum == 3) {
                System.out.println("========================================================================");
                System.out.println("종료합니다.");
                System.out.print("========================================================================");
                flag=false;
                break;
            } else if(selectNum == 4) {
                System.out.println("========================================================================");
                System.out.print("관리자 모드 비밀번호를 입력해주세요 :");
                int pw =sc.nextInt();

                if(pw==1234){
                    System.out.println("비밀번호가 일치합니다 관리자 모드를 실행합니다.");
                    manager();
                }else {
                    System.out.print("========================================================================");
                }

            }else  {
                System.out.println("========================================================================");
                System.out.println("잘못된 입력값입니다. 다시 입력해주세요!");
                System.out.println("========================================================================");
                continue;
            }
        }


    }
    public static void manager(){
        System.out.println("1.각 방이 예약된 날짜 조회     2.예약 영수증 전체 조회     3.관리자 모드 종료");
        System.out.print("->");
        int num = sc.nextInt();

        if(num ==1){
            System.out.println("==================================================================================================================");
            System.out.println("각 방이 예약된 날짜 조회입니다.");
            System.out.println("==================================================================================================================");
            for (Map.Entry<String, RoomDetail> entry2 : RoomDetail.getDetailList().entrySet()) {
                roomNum2 = entry2.getValue().getRoomNum();
                dateValue2 = entry2.getValue().getRoomDates();
                System.out.println(roomNum2 + "가 예약된 날짜 :" + dateValue2);
            }
            System.out.println("==================================================================================================================");
        manager();
        }else if(num ==2){
            System.out.println("==================================================================================================================");
            System.out.println("예약 영수증 전체 조회입니다.");
            System.out.println("==================================================================================================================");

            if(Receipt.getReceiptHashMap().size()>0){
                for (Map.Entry<String, Receipt> entry : Receipt.getReceiptHashMap().entrySet()) {
                    Receipt receiptEntry = entry.getValue();
                    String reserveId = receiptEntry.getReserveId();
                    String name = receiptEntry.getName();
                    String phone = receiptEntry.getPhone();
                    String date = receiptEntry.getRoomDate();
                    String room = receiptEntry.getRoomNum();
                    System.out.printf("예약자 : %s   전화번호: %s   예약날짜: %s    예약한 방 : %s    예약번호 : %s\n", name, phone, date, room, reserveId);
                }
                System.out.println("==================================================================================================================");
                manager();

            }else {
                System.out.println("!!!아직 예약된 내역이 없습니다!!!");
                System.out.println("==================================================================================================================");
                manager();

            }

        }else if(num==3){
            System.out.println("==================================================================================================================");
            System.out.println("관리자 모드를 종료합니다.");
            System.out.println("==================================================================================================================");

            start();
        }else {
            System.out.println("==================================================================================================================");
            System.out.println("잘못된 입력값입니다 다시 입력해주세요");
            System.out.println("==================================================================================================================");
            manager();
        }
    }
    public static void choiceCheck() {
        new ReserveCheck();
        System.out.println("==================================================================================================================");
        try {
            for (int i = 0; i < 2; i++) {
                Thread.sleep(2000);
            }
        } catch (Exception e) {

        } finally {
            start();
        }
    }

    public static void main(String[] args) {
        setData();
        start();
    }
}
