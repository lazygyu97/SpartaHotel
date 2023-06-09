package com.hotel.controller;

import com.hotel.data.Receipt;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ReserveCheck {
    static Receipt receipt = Receipt.getInstance();
    private ArrayList targetKeyList1 = new ArrayList();
    private ArrayList targetKeyList2 = new ArrayList();
    private HashSet<String> commonKeySet = new HashSet<>(targetKeyList1);
    private ArrayList commonKeyList = new ArrayList(commonKeySet);
    private Scanner sc = new Scanner(System.in);
    private String inputCancelIndex;
    private String cancelRoomNum;

    public String getInputCancelIndex() {
        return inputCancelIndex;
    }

    public void setCancelRoomNum(String cancelRoomNum) {
        this.cancelRoomNum = cancelRoomNum;
    }

    public String getCancelRoomNum() {
        System.out.println(cancelRoomNum);
        return cancelRoomNum;
    }

    public ReserveCheck() {
        reserveCheck();
    }
    public ReserveCheck(String str) {
    }

    //예약 확인 기능
    private void reserveCheck() {

        System.out.println("========================================================================");
        System.out.println("2. 예약 확인 및 취소 서비스를 선택하셨습니다.\n");

        if (Receipt.getReceiptHashMap().isEmpty()) {
            System.out.println("현재 예약 내역이 없습니다.");
        } else {

            String targetKey;

            System.out.print("예약하신 분의 성함을 입력해주세요 > ");
            String targetName = sc.nextLine();

            System.out.print("예약하신 분의 전화번호를 특수문자없이 숫자로만 입력해주세요 > 010");
            String inputPhone = sc.nextLine();
            String targetPhone = "010"+inputPhone;


            for (Map.Entry<String, Receipt> entry : Receipt.getReceiptHashMap().entrySet()) {

                Receipt receiptEntry = entry.getValue();
                System.out.println("name:"+entry.getValue().getName());
                System.out.println("phone:"+entry.getValue().getPhone());
                System.out.println("roomNum:"+entry.getValue().getRoomNum());
                System.out.println("reserveId:"+entry.getValue().getReserveId());
                System.out.println("roomDate:"+entry.getValue().getRoomDate());
                if (receiptEntry.getName().equals(targetName)) {
                    targetKey = entry.getKey();
                    targetKeyList1.add(targetKey);
                    System.out.println("targetKeyList1"+targetKeyList1);
                }

            }
            for (Map.Entry<String, Receipt> entry : Receipt.getReceiptHashMap().entrySet()) {
                Receipt receiptEntry = entry.getValue();

                if (receiptEntry.getPhone().equals(targetPhone)) {
                    targetKey = entry.getKey();
                    targetKeyList2.add(targetKey);
                    System.out.println("targetKeyList2"+targetKeyList2);
                }
            }
            commonKeySet.retainAll(targetKeyList2);
            System.out.println(commonKeyList);
            System.out.println("\n예약자 정보는 다음과 같습니다. ");

            AtomicInteger number1 = new AtomicInteger(1);
            commonKeyList.forEach(key -> {
                Receipt ReceiptList = Receipt.getReceiptHashMap().get(key);
                System.out.printf("⊙ 예약번호 %s\n예약자: %s, 전화번호: %s, 예약날짜: %s, 예약호수: %s\n\n",
                        ReceiptList.getReserveId(), ReceiptList.getName(),ReceiptList.getPhone(),ReceiptList.getRoomDate(),ReceiptList.getRoomNum());
            });//forEach

            reserveCancel();
        }//if~else
    }//reserveCheck()

    //예약 삭제 기능
    public void reserveCancel(){
        System.out.print("\n예약 취소를 원하는 내역의 '예약번호'를 입력해주세요. > ");
        inputCancelIndex = sc.nextLine();
        cancelRoomNum = Receipt.getReceiptHashMap().get(inputCancelIndex).getRoomNum();
        System.out.println(cancelRoomNum);
//            String receiptCancelIndex = (String) commonKeyList.get(inputCancelIndex);

        Receipt.getReceiptHashMap().remove(inputCancelIndex);

        //예약 취소 확인
        System.out.println("\n예약이 취소되었는지 확인해주세요. ");

        AtomicInteger number2 = new AtomicInteger(1);
        commonKeyList.stream().forEach(key -> {
            Receipt ReceiptList = Receipt.getReceiptHashMap().get(key);
            if (Receipt.getReceiptHashMap().size()==0){
                System.out.println("예약 내역이 없습니다!!!");
            }else{
                if (commonKeyList.size() < 10) {
                    System.out.print("선택 0" + number2.getAndIncrement() + ". ");
                } else {
                    System.out.print("선택 " + number2.getAndIncrement() + ". ");
                }
            }

            System.out.println(ReceiptList);
        });
        //-------------------------------------------------------------------------------------------
        //관리자 예약 확인 기능

        System.out.println("========================================================================");
        System.out.println("[ 관리자 예약 확인 목록 ]");
        System.out.println("-------------------------");


        Set receiptSet = Receipt.getReceiptHashMap().entrySet();
        Iterator iterator = receiptSet.iterator();

        while (iterator.hasNext()) {
            Map.Entry receiptEntry = (Map.Entry) iterator.next();
            System.out.println(receiptEntry.getKey() + "번 예약 정보. " + receiptEntry.getValue().toString());
        }
    }
}

