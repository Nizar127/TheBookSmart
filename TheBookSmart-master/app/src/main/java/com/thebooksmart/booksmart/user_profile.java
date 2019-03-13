package com.thebooksmart.booksmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/*
import com.google.firebase.FirebaseApp;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
*/

import com.google.firebase.database.FirebaseDatabase;

import de.hdodenhof.circleimageview.CircleImageView;

public class user_profile extends AppCompatActivity {

    //THIS IS PROFILE DATA
    //This is also place where user can edit their profile and all business are showcasing here
   /*  TextView bizname,bizdetails, bizkeyword, rating, booked;
    CircleImageView profile;
    private FirebaseDatabase ref;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

/*        bizname = (TextView) findViewById(R.id.NameID);
        bizdetails = (TextView) findViewById(R.id.DetailsID);
        bizkeyword = (TextView) findViewById(R.id.keywordID);
        rating = (TextView) findViewById(R.id.rating);
        booked = (TextView)findViewById(R.id.bookRate);*/

        //ref = new FirebaseDatabase("https://booksmart-1f7c3.firebaseio.com/"); //the url of firebase





    }


};
