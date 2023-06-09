package com.hotel.controller;

import com.hotel.data.Receipt;
import com.hotel.data.RoomDetail;
import com.hotel.data.RoomList;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static com.hotel.controller.Main.start;

public class ReserveCheck {

    public ReserveCheck() {
        reserveCheck();
    }

    String roomNumber;
    String roomDates;


    private void delete(String roomNumber, String date) {
        RoomDetail.getDetailList().get(roomNumber).getRoomDates().remove(date);
    }

    private void reserveCheck() {

        System.out.println("========================================================================");
        System.out.println("2. 예약 확인 및 취소 서비스를 선택하셨습니다.\n");

        Scanner sc = new Scanner(System.in);

        if (Receipt.getReceiptHashMap().isEmpty()) {
            System.out.println("2초 후 홈으로 돌아갑니다...");

        } else {

            String targetKey;

            ArrayList targetKeyList1 = new ArrayList();
            ArrayList targetKeyList2 = new ArrayList();

            System.out.print("예약하신 분의 성함을 입력해주세요 > ");
            String targetName = sc.nextLine();

            System.out.print("예약하신 분의 전화번호를 특수문자없이 숫자로만 입력해주세요 > 010");
            String inputPhone = sc.nextLine();
            String targetPhone = "010" + inputPhone;


            for (Map.Entry<String, Receipt> entry : Receipt.getReceiptHashMap().entrySet()) {

                Receipt receiptEntry = entry.getValue();

                if (receiptEntry.getName().equals(targetName)) {
                    targetKey = entry.getKey();
                    targetKeyList1.add(targetKey);
                }

            }
            for (Map.Entry<String, Receipt> entry : Receipt.getReceiptHashMap().entrySet()) {
                Receipt receiptEntry = entry.getValue();

                if (receiptEntry.getPhone().equals(targetPhone)) {
                    targetKey = entry.getKey();
                    targetKeyList2.add(targetKey);
                }
            }

            HashSet<String> commonKeySet = new HashSet<>(targetKeyList1);
            commonKeySet.retainAll(targetKeyList2);
            ArrayList commonKeyList = new ArrayList(commonKeySet);
            System.out.println("\n예약자 정보는 다음과 같습니다. ");
            System.out.println("==================================================================================================================");

            AtomicInteger number1 = new AtomicInteger(1);

            commonKeyList.stream().forEach(key -> {
                Receipt ReceiptList = Receipt.getReceiptHashMap().get(key);
                if (commonKeyList.size() < 10) {
                    System.out.print("선택 0" + number1.getAndIncrement() + ". ");
                } else {
                    System.out.print("선택 " + number1.getAndIncrement() + ". ");
                }
//                roomNumber = ReceiptList.getRoomNum();
//                roomDates = ReceiptList.getRoomDate();
                System.out.printf("예약자 : %s   전화번호: %s   예약날짜: %s    예약한 방 : %s    예약번호 : %s\n",
                        ReceiptList.getName(), ReceiptList.getPhone(), ReceiptList.getRoomDate(), ReceiptList.getRoomNum(), ReceiptList.getReserveId());

            });
            System.out.println("==================================================================================================================");

            System.out.println("예약을 취소하시겠습니까?");
            System.out.println("1.예약취소  2.홈으로 ");
            System.out.print("->");
            int num = sc.nextInt();

            if (num == 1) {
                sc.nextLine();
                System.out.print("\n예약 취소를 원하는 내역의 '예약번호' 를 입력해주세요. > ");
                String inputCancelIndex = sc.nextLine();

                roomNumber= Receipt.getReceiptHashMap().get(inputCancelIndex).getRoomNum();
                roomDates= Receipt.getReceiptHashMap().get(inputCancelIndex).getRoomDate();
                delete(roomNumber, roomDates);
                Receipt.getReceiptHashMap().remove(inputCancelIndex);

                //예약 취소 확인 -> 수정 필요
                System.out.println("\n예약이 취소되었는지 확인해주세요. ");
                System.out.println("==================================================================================================================");

                for (Map.Entry<String, Receipt> entry : Receipt.getReceiptHashMap().entrySet()) {

                    Receipt receiptEntry = entry.getValue();
                    String reserveId = receiptEntry.getReserveId();
                    String name = receiptEntry.getName();
                    String phone = receiptEntry.getPhone();
                    String date = receiptEntry.getRoomDate();
                    String room = receiptEntry.getRoomNum();
                    System.out.printf("예약자 : %s   전화번호: %s   예약날짜: %s    예약한 방 : %s    예약번호 : %s\n", name, phone, date, room, reserveId);

                }
                System.out.println("2초 후 홈으로 돌아갑니다...");

            } else {
                System.out.println("2초 후 홈으로 돌아갑니다...");

            }


//            //-------------------------------------------------------------------------------------------
//            //관리자 예약 확인 기능
//
//            System.out.println("========================================================================");
//            System.out.println("[ 관리자 예약 확인 목록 ]");
//            System.out.println("-------------------------");
//
//
//            Set receiptSet = Receipt.getReceiptHashMap().entrySet();
//            Iterator iterator = receiptSet.iterator();
//
//            while (iterator.hasNext()) {
//                Map.Entry receiptEntry = (Map.Entry) iterator.next();
//                System.out.println(receiptEntry.getKey() + "번 예약 정보. " + receiptEntry.getValue().toString());
//            }
        }
    }
}

