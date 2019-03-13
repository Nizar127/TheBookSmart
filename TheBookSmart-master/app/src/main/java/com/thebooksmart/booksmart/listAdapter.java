package com.thebooksmart.booksmart;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;

import static com.android.volley.VolleyLog.TAG;


//this is adapter for recycler view which is for business listed
public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder>{

    private static final String TAG = "listAdapter";

    private Context context;
    private List<ListItem> listItems;
    private OnItemClickListener itemClick;


    public listAdapter(Context context, List<ListItem> listItems) {
        this.listItems = listItems;
        this.context = context;
    }




    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);  //supposed to be parent..but i don't know for version 3.0 android studi
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {
        Log.d(TAG, "onBindViewHolder: called");
        final ListItem listItem = listItems.get(position);

        //load the image
        Glide.with(context)
                .asBitmap()
                .load(listItem.getBizImg())  ///try to put position in bracket in case listitem not workinf
                .into(viewHolder.bizImg);

        viewHolder.availBiz.setText(listItem .getAvailBiz());
        viewHolder.availBizDetail.setText(listItem .getAvailBizDetail());

        //viewHolder.itemView.setOnClickListener(onClickListener);
    viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d(TAG, "onClick:  clicked on ");

            Toast.makeText(context, listItem.getAvailBiz(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, ListBusinessActivity.class);
            intent.putExtra("image_url",listItem.getBizImg());
            intent.putExtra("Business_Name",listItem.getAvailBiz());
            intent.putExtra("Business_Details", listItem.getAvailBizDetail());
            context.startActivity(intent);
        }
    });


    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        itemClick = listener;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView bizImg;
        public TextView availBiz;
        public TextView availBizDetail;
        public Button viewPackage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            bizImg = (ImageView)itemView.findViewById(R.id.bizImg);
            availBiz = (TextView)itemView.findViewById(R.id.availBiz);
            availBizDetail = (TextView)itemView.findViewById(R.id.availBizDetail);
            viewPackage = (Button)itemView.findViewById(R.id.viewPackage);

           //when click on it..this is open up detail
            itemView.setOnClickListener(new View.OnClickListener()
            {
               // private static final String TAG = "ViewHolder";
                @Override
                public void onClick(View v) {
                    if(itemClick != null){
                        int position = getAdapterPosition();
                        // Log.d(TAG, "onClick: working");
                        if (position !=  RecyclerView.NO_POSITION) {
                            itemClick.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

}
