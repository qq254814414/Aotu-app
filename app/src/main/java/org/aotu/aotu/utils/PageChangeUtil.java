package org.aotu.aotu.utils;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class PageChangeUtil
{
    private static Fragment nowFragment = null;

    public static void replaceFragment(Context context, int id, Fragment fragment) {
        AppCompatActivity activity = (AppCompatActivity)context;
        String fragmentName = fragment.getClass().getName();
        FragmentManager manager = activity.getSupportFragmentManager();
        if (nowFragment == null) {
            nowFragment = fragment;
            manager.beginTransaction().replace(id, fragment).commit();
        }
        if (!nowFragment.getClass().getName().equals(fragmentName)) {
            nowFragment = fragment;
            manager.beginTransaction().replace(id, fragment).addToBackStack(fragmentName).commit();
        }
    }
}