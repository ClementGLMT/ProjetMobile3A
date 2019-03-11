package com.example.project_guillemaut;

import android.app.Activity;

import java.lang.ref.WeakReference;

public class ActivityModifier    {
    private static WeakReference<Activity> mActivityRef;
    public static void updateActivity(Activity activity){
        mActivityRef = new WeakReference<Activity>(activity);
    }
}
