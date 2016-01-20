package com.demo.hqinterviewdemo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by shivang on 19/1/16.
 */
public class InternetCheckUtils {

    public static ConnectivityManager connectivityManager;

    /**
     * Method call to check internet connection
     * @param con
     * @return boolean
     */
    public static boolean isOnline(Context con) {

        boolean connected = false;
        try {
            connectivityManager = (ConnectivityManager) con.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
            connected = networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
            return connected;

        } catch (Exception e) {
            System.out.println("CheckConnectivity Exception: " + e.getMessage());
            Log.v("connectivity", e.toString());
        }

        return connected;
    }
}
