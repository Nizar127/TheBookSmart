package com.thebooksmart.booksmart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.thebooksmart.booksmart.Adapter.MyAvailBizAdapter;

import java.util.ArrayList;
import java.util.List;

public class business_availableActivity extends AppCompatActivity {


    //provide list from MyAvailBizAdapet
    List<bizAvail> bizAvailList;

    //the listview
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_available);

        //initialize objects
        bizAvailList = new ArrayList<>();
        listView = (ListView)findViewById(R.id.businessList);

        //add same values to out list
        //get it from DB
      /*  bizAvailList.add(new bizAvail(R.drawable.traveller,"Jack"));
        bizAvailList.add(new bizAvail(R.drawable.traveller,"Jamal"));
        bizAvailList.add(new bizAvail(R.drawable.traveller,"hassan"));
        bizAvailList.add(new bizAvail(R.drawable.traveller,"Gemasan"));

        //create adapter
        MyAvailBizAdapter adapter = new MyAvailBizAdapter(this, R.layout.available_business, bizAvailList);
*/
        //attach adapter to the listview
        /*listView.setAdapter(adapter);*/
    }



}
