package com.thebooksmart.booksmart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import com.thebooksmart.booksmart.Model.businessList;
import com.thebooksmart.booksmart.R;

import java.util.List;

public class businessList_adapter extends ArrayAdapter<businessList> {

    private List<businessList> businessLists;
    private Context biz;

    public businessList_adapter(List<businessList> P, Context c)
    {
        super(c,R.layout.activity_user_profile, P);
        this.businessLists = P;
        this.biz = c;

    }
    public  View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(biz);
        View view = inflater.inflate(R.layout.activity_user_profile,null,true);

        //EditText bizName = (EditText)view.findViewById(R.id.getbusinessname);
        //return super.getView(position, convertView, parent);
        //
        return view;
    }


}
