package com.hotel.data;

import java.util.ArrayList;

public class RoomList {

    private static ArrayList<String> roomList = new ArrayList();

    public static ArrayList<String> getRoomList() {
        return roomList;
    }

    public void setRoomList(ArrayList<String> roomList) {
        this.roomList = roomList;
    }

    public static RoomList getInstance() {
        return new RoomList();
    }


}
