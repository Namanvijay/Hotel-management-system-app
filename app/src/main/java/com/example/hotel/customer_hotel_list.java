package com.example.hotel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Cache;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class customer_hotel_list extends AppCompatActivity {
    private  ListView listView_quiz;
    private List<com.example.hotel.hotelItems> hotelItems;
    private com.example.hotel.hoteladapter hoteladapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_hotel_list);
        listView_quiz = (ListView) findViewById(R.id.hotel_list);
        hotelItems = new ArrayList<hotelItems>();
        hoteladapter = new hoteladapter(customer_hotel_list.this,hotelItems,this);
            listView_quiz.setAdapter(hoteladapter);

        //Cache cache = AppController.getInstance().getRequestQueue().getCache();
        //Cache.Entry entry = cache.get(Config.URL_fetch_room);
      /*  if(entry != null){
            // fetch the data from cache
            //Toast.makeText(customer_hotel_list.this,"abc",Toast.LENGTH_SHORT).show();
            try {
                String data = new String(entry.data, "UTF-8");
                Toast.makeText(customer_hotel_list.this,data,Toast.LENGTH_SHORT).show();
                parseJsonFeed(data);

            } catch (UnsupportedEncodingException e){
            e.printStackTrase();
            }
            }
            */

            StringRequest jsonReq = new StringRequest(Request.Method.GET,
                    Config.URL_fetch_room,  new Response.Listener<String>() {

                @Override
                public void onResponse(String response) {
                    VolleyLog.d(TAG, "Response: " + response.toString());
                    if (response != null) {
                        //Toast.makeText(getApplicationContext(),response,Toast.LENGTH_SHORT).show();
                        parseJsonFeed(response);
                    }
                }
            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    VolleyLog.d(TAG, "Error: " + error.getMessage());
                }
            });

            // Adding request to volley request queue
            AppController.getInstance().addToRequestQueue(jsonReq);

    }
    private void parseJsonFeed(String response) {
        try {
            //  Toast.makeText(getContext(),response,Toast.LENGTH_LONG).show();
            JSONArray quizArray = new JSONArray(response);
            //Toast.makeText(customer_hotel_list.this,"abc",Toast.LENGTH_LONG).show();
            for (int i = 0; i < quizArray.length(); i++) {
                JSONObject feedObj = (JSONObject) quizArray.get(i);
                Log.d("i=", String.valueOf(i));
                //Toast.makeText(customer_hotel_list.this,quizArray.length(),Toast.LENGTH_LONG).show();

                hotelItems item = new hotelItems();

                item.setHotel_name(feedObj.getString("hotelname"));
                item.setCheckindate(feedObj.getString("checkindate"));
                item.setCheckoutdate(feedObj.getString("checkoutdate"));
                item.setNumberofadults(feedObj.getString("numberofadults"));
                item.setTypeofroom(feedObj.getString("typeofroom"));
                item.setHotel_image(feedObj.getString("hotelimage"));
                hotelItems.add(item);
            }

            //notify data changes to list adapter
            hoteladapter.notifyDataSetChanged();
        }catch(JSONException e) {
            e.printStackTrace();
        }
        }
        }

