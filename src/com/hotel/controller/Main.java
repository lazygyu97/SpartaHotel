package com.hotel.controller;

import com.hotel.data.RoomDetail;

import java.util.Scanner;

import static com.hotel.controller.Reserve.reserve;

public class Main {


    public static void start(){

        Scanner sc = new Scanner(System.in);
        boolean flag1 = true;
        int selectNum;

        System.out.printf("\n%5s안녕하세요 스파르타 호텔입니다!\n\n"," ");
        while (flag1){
            System.out.printf("%5s이용하실 서비스를 선택해주세요!\n\n"," ");
            System.out.println("1. 호텔 예약  2. 예약 확인  3. 예약 취소  4. 종료\n");

            System.out.print("서비스 번호를 입력해주세요 :");
            selectNum= sc.nextInt();



            if(selectNum==1){
                flag1=false;
                System.out.print("========================================================================");
                reserve();
            }else if(selectNum==2){
                flag1=false;
                System.out.print("========================================================================");

            }else if(selectNum==3){
                flag1=false;
                System.out.print("========================================================================");

            }else if(selectNum==4){
                flag1=false;
                System.out.print("========================================================================");

            }else {
                System.out.println("잘못된 번호입니다. 다시 입력해주세요");
                continue ;
            }
        }



    }

    public static void main(String[] args) {

        start();
    }
}
