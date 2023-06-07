package com.hotel.data;

import java.util.ArrayList;
import java.util.HashMap;

public class RoomDetail {
    public String roomNum;
    public String roomCapcity;
    public String roomBed;
    public String checkTime;
    public ArrayList roomDates; //아직 애매함
    public int roomPrice;

    public HashMap<String,RoomDetail> detailList = new HashMap<>();

    public RoomDetail(String roomNum, String roomCapcity, String roomBed, String checkTime, ArrayList roomDates, int roomPrice){
        this.roomNum=roomNum;
        this.roomCapcity=roomCapcity;
        this.roomBed=roomBed;
        this.checkTime=checkTime;
        this.roomDates=roomDates;
        this.roomPrice=roomPrice;
    }

    public RoomDetail(){

    }

}
