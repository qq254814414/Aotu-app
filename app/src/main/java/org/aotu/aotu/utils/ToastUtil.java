package org.aotu.aotu.utils;

import android.widget.Toast;

import org.aotu.aotu.AoTuApp;


public class ToastUtil
{
    public static void longToast(String msg)
    {
        Toast toast = Toast.makeText(AoTuApp.context, msg, Toast.LENGTH_LONG);
        toast.setGravity(80, 0, 40);
        toast.show();
    }

    public static void shortToast(String msg)
    {
        Toast toast = Toast.makeText(AoTuApp.context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(80, 0, 40);
        toast.show();
    }
}