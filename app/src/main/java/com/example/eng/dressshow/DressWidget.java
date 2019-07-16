package com.example.eng.dressshow;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RemoteViews;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.AppWidgetTarget;

/**
 * Implementation of App Widget functionality.
 */
public class DressWidget extends AppWidgetProvider {
    static String posterUL="";
    private static AppWidgetTarget appWidgetTarget;
    //    static  Dress dress = new Dress();
//    static String dressPoster = "";
    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Intent intent = new Intent(context, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        // Get the layout for the App Widget and attach an on-click listener
        // to the button
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.dress_widget);
        appWidgetTarget = new AppWidgetTarget( context, views, R.id.appwidget_imageview, appWidgetId );

        Glide
                .with( context.getApplicationContext() )
                .load( posterUL)
                .asBitmap()
                .into( appWidgetTarget );
        views.setOnClickPendingIntent(R.id.appwidget_imageview, pendingIntent);
        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);

        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent) {
            Log.e("RecipeWidget", "recieve if  " + AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            if (intent != null ) {
                posterUL = intent.getStringExtra("WIDGET_KEY");
                Log.v("dresscontent","not null"+posterUL);
                AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
                ComponentName thisAppWidget = new ComponentName(context.getPackageName(), DressWidget.class.getName());
                int[] appWidgetIds = appWidgetManager.getAppWidgetIds(thisAppWidget);
                onUpdate(context, appWidgetManager, appWidgetIds);
            } else {
                Log.e("dressDescriptionWidget", "recieve if  is null");
            }
            super.onReceive(context, intent);
    }
}

