package com.example.eng.dressshow;

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DressesAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Dress> mDressList;
    int dressNum ;
//    String dresskind;
    public DressesAdapter(Context c , ArrayList<Dress> dressesList){
        mDressList =dressesList ;
        dressNum = mDressList.size();
        context = c;
//        dresskind = dreskind;
    }
    @Override
    public int getCount() {
        return dressNum;
    }

    @Override
    public Object getItem(int position) {
        return mDressList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Dress aDress = mDressList.get(position);
        final ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(context);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(200, 200));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setContentDescription(context.getString(R.string.dress_display));
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent widget = new Intent();
                    widget.setAction("android.appwidget.action.APPWIDGET_UPDATE");
                    widget.putExtra("WIDGET_KEY",mDressList.get(position).getDressImage());
                    context.sendBroadcast(widget);



                    Intent intent = new Intent(context,DressDetailes.class);
                    intent.putExtra("LIST_KEY",mDressList.get(position));
//                    intent.putExtra("dresskind",dresskind);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    Log.v("adapterkey",""+dresskind);
//                    context.sendBroadcast(intent);
                    context.startActivity(intent);
                }
            });
        } else {
            imageView = (ImageView) convertView;
        }
        Glide.with(context).load(aDress.getDressImage()).diskCacheStrategy(DiskCacheStrategy.ALL).placeholder(R.drawable.loading).error(R.drawable.error).centerCrop().into(imageView);
        return imageView;
    }


}
