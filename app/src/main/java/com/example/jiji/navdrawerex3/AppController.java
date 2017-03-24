package com.example.jiji.navdrawerex3;

import android.app.Application;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Jiji on 3/8/2017.
 */

public class AppController extends Application {

    public static String TAG=AppController.class.getSimpleName();

    private RequestQueue mRequestQueue;
    private static AppController instance;

    @Override
    public void onCreate(){
        super.onCreate();
        instance=this;
    }

    public static synchronized AppController getInstance(){
        return instance;
    }

    public RequestQueue getRequestQueue(){

        if (mRequestQueue==null){
            mRequestQueue= Volley.newRequestQueue(getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        req.setTag(TAG);
        getRequestQueue().add(req);
    }
}
