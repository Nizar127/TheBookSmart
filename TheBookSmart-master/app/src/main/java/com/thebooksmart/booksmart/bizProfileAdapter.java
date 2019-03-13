package com.thebooksmart.booksmart;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

public class bizProfileAdapter extends BaseAdapter {

    //imageloader to load images
    private ImageLoader imageloader;

    //context
    private Context context;



    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override



    public View getView(int position, View convertView, ViewGroup parent) {
        //Creating a linear layout
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        //NetworkImageView
        NetworkImageView networkImageView = new NetworkImageView(context);

        //Initializing ImageLoader
        //imageloader = CustomVolleyRequest.getInstance(context).getImageLoader();
       // imageloader.get(images.get(position), ImageLoader.getImageListener(networkImageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        //Setting the image url to load
       // networkImageView.setImageUrl(images.get(position),imageLoader);

        //Creating a textview to show the title
        TextView textView = new TextView(context);
       // textView.setText(names.get(position));

        //Scaling the imageview
        networkImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        networkImageView.setLayoutParams(new GridView.LayoutParams(200,200));

        //Adding views to the layout
        linearLayout.addView(textView);
        linearLayout.addView(networkImageView);

        //Returnint the layout
        return linearLayout;
    }
}


