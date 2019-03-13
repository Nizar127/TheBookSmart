package com.thebooksmart.booksmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ListBusinessActivity extends AppCompatActivity implements listAdapter.OnItemClickListener {
    public static final String EXTRA_URL = "image_url";
    public static final String EXTRA_NAME = "availBiz";
    public static final String EXTRA_DETAILS = "availBizDetails";

    private static final String TAG = "ListBusinessActivity";
    private static final String URL_PRODUCTS = "https://192.168.43.91/thebooksmart/business.php";

    //store all the list
    List<ListItem> listItems;

    private listAdapter listAdapter;
    //the recyclerview
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_business);
        Log.d(TAG, "onCreate: started. ");

        //get the recyclerview from xml
        recyclerView = findViewById(R.id.listBiz);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initializing the listitem
        listItems = new ArrayList<>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadBusiness();




    }
    //this is use so that user can get details
    //should go to user profile
    /*private void getIncomingIntent(){
        Log.d(TAG, "getIncomingIntent:  checking for incoming intent");
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("Business_Name")&& getIntent().hasExtra("Business_Details"));
        Log.d(TAG, "getIncomingIntent: found");

        String imageUrl = getIntent().getStringExtra("image_url");
        String businessname = getIntent().getStringExtra("Business_Name");
        String businessdetails = getIntent().getStringExtra("Business_Details");
    }

    private void setImage(String imageUrl, String businessname, String businessdetails){
        Log.d(TAG, "setImage: setting the data");

        TextView name = findViewById(R.id.availBiz);
        name.setText(businessname);
        TextView details = findViewById(R.id.availBizDetail);
        details.setText(businessdetails);

        CircleImageView image = findViewById(R.id.profilePic);

    }
*/
    private void loadBusiness(){
        //use String request

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_PRODUCTS,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //converting the string to json array object
                            JSONArray array = new JSONArray(response);

                            //traversing through all the object
                            for (int i = 0; i < array.length(); i++) {
                                //getting business object from json array
                                JSONObject business = array.getJSONObject(i);

                                //adding the business to business list
                                listItems.add(new ListItem(
                                        business.getInt("id"),
                                        business.getString("bizImg"),
                                        business.getString("availBiz"),
                                        business.getString("availBizDetail")
                                ));
                            }

                            //create adapter object and setting it
                            listAdapter adapter = new listAdapter(ListBusinessActivity.this, listItems);
                            recyclerView.setAdapter(adapter);
                            //can't solve below error till now
                            //request help
                            listAdapter.setOnItemClickListener(ListBusinessActivity.this);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        Volley.newRequestQueue(this).add(stringRequest);
    }


    @Override
    public void onItemClick(int position) {
        Intent detailintent = new Intent(this, business_profile.class);
        ListItem clickedItem = new listItems.get(position);

        detailintent.putExtra(EXTRA_URL, clickedItem.getImageURL());
        detailintent.putExtra(EXTRA_NAME, clickedItem.getAvailBiz());
        detailintent.putExtra(EXTRA_DETAILS, clickedItem.getAvailBizDetail());

        startActivity(detailintent);
    }
}
