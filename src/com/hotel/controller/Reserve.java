package com.hotel.controller;

import com.hotel.data.RoomDetail;
import com.hotel.data.RoomList;

import java.util.Scanner;

public class Reserve {

    static void roomSampleData(String reserveDate) {
        Scanner sc = new Scanner(System.in);

        RoomList setData = new RoomList();
        RoomDetail setData2 = new RoomDetail();

        setData.roomList.add("101");
        setData.roomList.add("102");
        setData.roomList.add("103");
        setData.roomList.add("201");
        setData.roomList.add("202");
        setData.roomList.add("203");
        setData.roomList.add("301");
        setData.roomList.add("302");
        setData.roomList.add("303");

        System.out.println(reserveDate+"에 이용가능한 객실들 입니다.\n");

        System.out.printf("%5s-------------\n"," ");

        for (int i = 0; i < setData.roomList.size(); i++) {
            if (setData.roomList.get(i)=="101") {
                System.out.printf("%6s%s "," ",setData.roomList.get(i));

            } else if (setData.roomList.get(i) =="201") {
                System.out.printf("%6s%s "," ",setData.roomList.get(i));
            } else if (setData.roomList.get(i)== "301") {
                System.out.printf("%6s%s "," ",setData.roomList.get(i));
            }else {
                System.out.print(setData.roomList.get(i) + " ");
            }

            if (setData.roomList.get(i)=="103") {
                System.out.println();
            } else if (setData.roomList.get(i) =="203") {
                System.out.println();
            }else if(setData.roomList.get(i)=="303"){
                System.out.println();
            }
        }

        System.out.printf("%5s-------------\n"," ");

        System.out.println("이용을 원하시는 객실 번호를 입력해주세요 :");
        String roomNumber=sc.next();
//
//        setData2.detailList.put("101",new RoomDetail("101","2","1","체크인->11:00/체크아웃->13:00","",1000000));
//        setData2.detailList.put("102",new RoomDetail("102","2","1","체크인->11:00/체크아웃->13:00","",1000000));
//        setData2.detailList.put("103",new RoomDetail("103","2","1","체크인->11:00/체크아웃->13:00","",1000000));
//        setData2.detailList.put("201",new RoomDetail("201","2","2","체크인->11:00/체크아웃->13:00","",2000000));
//        setData2.detailList.put("202",new RoomDetail("202","2","2","체크인->11:00/체크아웃->13:00","",2000000));
//        setData2.detailList.put("203",new RoomDetail("203","2","2","체크인->11:00/체크아웃->13:00","",2000000));
//        setData2.detailList.put("301",new RoomDetail("301","3","2","체크인->11:00/체크아웃->13:00","",3000000));
//        setData2.detailList.put("302",new RoomDetail("302","3","2","체크인->11:00/체크아웃->13:00","",3000000));
//        setData2.detailList.put("303",new RoomDetail("303","3","2","체크인->11:00/체크아웃->13:00","",3000000));

        if(setData2.detailList.containsKey(roomNumber)){
            System.out.println("방 번호 : "+setData2.detailList.get(roomNumber).roomNum);
            System.out.println("이용 가능 인원 : "+setData2.detailList.get(roomNumber).roomCapcity);
            System.out.println("침대 개수 : "+setData2.detailList.get(roomNumber).roomBed);
            System.out.println(setData2.detailList.get(roomNumber).checkTime);
            System.out.println("가격 : "+setData2.detailList.get(roomNumber).roomPrice);
        }


    }
    public static void reserve(){
        Scanner sc = new Scanner(System.in);

        String year;
        String month;
        String day;
        String reserveDate;

        System.out.println("\n예약 도와드리겠습니다.");
        System.out.println("호텔 이용하실 날짜를 입력해주세요");
        System.out.print("년:");
        year=sc.next();
        System.out.print("월:");
        month=sc.next();
        System.out.print("일:");
        day=sc.next();

        reserveDate=year+"/"+month+"/"+day; //클래스 처리 고려

        roomSampleData(reserveDate);




    }
}
