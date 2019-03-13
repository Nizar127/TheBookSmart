package com.thebooksmart.booksmart.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.thebooksmart.booksmart.R;
import com.thebooksmart.booksmart.bizAvail;

import java.util.List;

public class MyAvailBizAdapter extends ArrayAdapter<bizAvail> {

    //list values of the list from bizAvail
    List<bizAvail> bizAvailList;

    //activity context
    Context context;

    //layout resource for list item
    int resource;

    //cnstructor initializing
    public MyAvailBizAdapter(Context context, int resource, List<bizAvail> bizAvaillist){
        super(context, resource, bizAvaillist);
        this.context = context;
        this.resource = resource;
        this.bizAvailList = bizAvaillist;
    }

    //this will return listview item as a item
    //hopefully
    public View getView(final int position, View convertView, ViewGroup parent){
        //we need ttog et the view of the xml for our list item
        //which is available_business xml
        //therefore we need layountinflater
        LayoutInflater layoutInflater = LayoutInflater.from(context);

        //getting the view
        View view = layoutInflater.inflate(resource, null, false);

        //get the view elements of the list from view
        ImageView imageView = view.findViewById(R.id.bookPic);
        TextView description = view.findViewById(R.id.bookDescription);
        Button buttonBook = view.findViewById(R.id.bookNow);

        //get the avail biz of the specified position
        //bizAvail bizavail =  bizAvailList.get(position);
        bizAvail bizAvail = bizAvailList.get(position);

        //adding values to the list item
        //imageView.setImageDrawable(context.getResources().getDrawable(bizAvail.getImg()));
       // description.setText(bizAvail.getDesc()); ///somehow it does not called

        ///adding a click listener to the buttom to book items
        buttonBook.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                bookbizAvail(position);
            }
        });

        //return view
        return view;
    }

    //this method will book item and move it to next page
    private void bookbizAvail(final int position){
        //create an alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Are You Sure You Want To Book This Booking");

        //if the response is positive, book items
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                //add it to db
                //we will remove it soon
                //this require logic algo
                bizAvailList.remove(position);

            }

        });

        //if no then
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        //create and display the alert for convenience use
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}
