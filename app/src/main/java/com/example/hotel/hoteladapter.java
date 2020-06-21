package com.example.hotel;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.hotel.R;
import com.example.hotel.AppController;
import com.example.hotel.hotelItems;

import java.util.List;

public class hoteladapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;

    private List<com.example.hotel.hotelItems> hotelItems;
    private Context context;
    ImageLoader imageLoader  = AppController.getInstance().getImageLoader();
    public hoteladapter(Activity activity, List<hotelItems> hotelItems, Context context) {

        this.activity = activity;
        this.hotelItems = hotelItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return hotelItems.size();
    }

    @Override
    public Object getItem(int position){
        return hotelItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null)
            inflater = (LayoutInflater)activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null)
            convertView = inflater.inflate(R.layout.quizlist,null);

        if(imageLoader == null)
            imageLoader = AppController.getInstance().getImageLoader();

        TextView hotel_name = (TextView)convertView.findViewById(R.id.tvhotelname);
        NetworkImageView hotel_image = (NetworkImageView)convertView.findViewById(R.id.hotel_image);
        TextView checkindate = (TextView) convertView.findViewById(R.id.tvcheckindate);
        TextView checkoutdate = (TextView) convertView.findViewById(R.id.tvcheckoutdate);
        TextView numberofadults = (TextView) convertView.findViewById(R.id.tvnumberofadults);
        TextView typeofroom = (TextView) convertView.findViewById(R.id.tvtypeofroom);
        LinearLayout linearLayout_quiz = (LinearLayout)convertView.findViewById(R.id.quiz_layout);
        final hotelItems item = hotelItems.get(position);
        hotel_name.setText("Customer Name:-"+item.getHotel_name());
        checkindate.setText("Check In Date:-"+item.getCheckindate());
        checkoutdate.setText("Check Out Date:-"+item.getCheckoutdate());
        numberofadults.setText("Number of Rooms:-"+item.getNumberofadults());
        typeofroom.setText("Type of room:"+item.getTypeofroom());
        //quiz_name.setText("abc");
        hotel_image.setImageUrl(item.getHotel_image(),imageLoader);


        return convertView;
    }
}
