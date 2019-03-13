package com.thebooksmart.booksmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.thebooksmart.booksmart.ListBusinessActivity.EXTRA_DETAILS;
import static com.thebooksmart.booksmart.ListBusinessActivity.EXTRA_NAME;
import static com.thebooksmart.booksmart.ListBusinessActivity.EXTRA_URL;

public class business_profile extends AppCompatActivity {

    private static final String URL_PRODUCTS = "http://192.168.41.1/thebooksmart/profile.php";

    //a list to store all items in the profile
    //List<ListItem> businessdataList;

    //cardview object
    //private RelativeLayout cardview;

    int pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_profile);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(EXTRA_URL);
        String bizName =  intent.getStringExtra(EXTRA_NAME);
        String bizDetails = intent.getStringExtra(EXTRA_DETAILS);

        ImageView imageView = findViewById(R.id.bizImg);
        TextView textName = findViewById(R.id.availBiz);
        TextView textDetails = findViewById(R.id.availBizDetail);

        /*Glide.with(this)
                .asBitmap()
                .load(listItem.getBizImg())  ///try to put position in bracket in case listitem not workinf
                .into(viewHolder.bizImg);*/

        textName.setText(bizName);
        textDetails.setText(bizDetails);

       // cardview = (RelativeLayout) findViewById(R.id.profileBiz);

        //we going to pass the data first for respective data id

        /*Intent intent = getIntent();
        pos = intent.getExtras().getint("Position");

        final listAdapter adapter = new listAdapter(this);
        final CircleImageView img = (CircleImageView)findViewById(R.id.bizImg);
        final TextView business_name = (TextView)findViewById(R.id.availBiz);
        final TextView business_detail = (TextView)findViewById(R.id.availBizDetail);
        final TextView businss_rating = (TextView)findViewById(R.id.rating);
        final TextView business_booked = (TextView)findViewById(R.id.bookRate);
*/
        //set things up
        /*img.setImageResource(adapter.images(pos));
        business_name.setText(adapter.name(pos));
        business_detail.setText(adapter.businessDetail(pos));
        businss_rating.setText(adapter.)
        business_booked = (TextView)findViewById(R.id.bookRate);*/

        //Intent activityThatCalled = getIntent();

        //String previousActivity = activityThatCalled.getExtras().getString("callingActivity");

    }

    //create intent to go to booking biz
    public void bookBiz(View view) {
    }
}
