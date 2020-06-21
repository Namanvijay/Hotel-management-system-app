package com.example.hotel;

public class Config {

    /*   --------------------    variable name for the signup      ------------------------*/
    public static final String name = "name";
    public static final String email = "email";
    public static final String password = "password";
    public static final  String phone = "phone";
    public static final String gender = "gender";
    public static final String checkindate = "checkindate";
    public static final String checkoutdate = "checkoutdate";
    public static final String numberofadults = "numberofadults";
    public static final String typeofroom = "typeofroom";
    public static final String hotelname = "hotelname";
    public static final String hotelimage = "hotelimage";
    public static final String acimage = "http://www.palaciodegoa.com/img/rooms/deluxe-room.jpg";
    public static final String nonacimage="http://www.tgfdreamguesthouse.com/img/gallery/DLX-ROOM.jpg";


    /* -----------------      URL to connnect to databases          --------------------------*/

    public static final String URL_Normal_Signup_Customer = "https://book-learned-instru.000webhostapp.com/save.php";
    public static final String URL_register_room = "https://book-learned-instru.000webhostapp.com/saveroom.php";
    public static final String URL_fetch_room="https://book-learned-instru.000webhostapp.com/fetchhotel.php";
}
