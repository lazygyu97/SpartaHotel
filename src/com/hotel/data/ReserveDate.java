package com.hotel.data;

import java.time.LocalDate;
import java.util.ArrayList;

public class ReserveDate {

    private static ArrayList<LocalDate> roomDate;

    public ReserveDate() {
    }

    public static ArrayList<LocalDate> getRoomDate() {
        return roomDate;
    }

    public static void setRoomDate(ArrayList<LocalDate> roomDate) {
        ReserveDate.roomDate = roomDate;
    }
}
