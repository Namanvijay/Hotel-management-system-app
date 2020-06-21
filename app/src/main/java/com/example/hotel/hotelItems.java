package com.example.hotel;

public class hotelItems {
    private String hotel_name,checkindate,checkoutdate,numberofadults,typeofroom,hotel_image;

    public hotelItems(String hotel_name, String checkindate, String checkoutdate, String numberofadults, String typeofroom,String hotel_image) {
        this.hotel_name = hotel_name;
        this.checkindate = checkindate;
        this.checkoutdate = checkoutdate;
        this.numberofadults = numberofadults;
        this.typeofroom = typeofroom;
        this.hotel_image = hotel_image;
    }

    public hotelItems() {
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_image() {
        return hotel_image;
    }

    public void setHotel_image(String hotel_image) {
        this.hotel_image = hotel_image;
    }

    public String getCheckindate() {
        return checkindate;
    }

    public void setCheckindate(String checkindate) {
        this.checkindate = checkindate;
    }

    public String getCheckoutdate() {
        return checkoutdate;
    }

    public void setCheckoutdate(String checkoutdate) {
        this.checkoutdate = checkoutdate;
    }

    public String getNumberofadults() {
        return numberofadults;
    }

    public void setNumberofadults(String numberofadults) {
        this.numberofadults = numberofadults;
    }

    public String getTypeofroom() {
        return typeofroom;
    }

    public void setTypeofroom(String typeofroom) {
        this.typeofroom = typeofroom;
    }
}
