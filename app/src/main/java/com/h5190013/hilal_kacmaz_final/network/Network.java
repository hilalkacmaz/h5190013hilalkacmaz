package com.h5190013.hilal_kacmaz_final.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Network {
    public  static  boolean checkInternet(Context context)
    {
        ConnectivityManager connectivityManager =(ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo =connectivityManager.getActiveNetworkInfo();

        if(networkInfo!=null && networkInfo.isAvailable() && networkInfo.isConnected()) {
            return  true;
        }
        else {
            return  false;
        }

    }
}
