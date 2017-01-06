package com.yls.pmlist.pm_list;

import android.graphics.drawable.Drawable;

/**
 * Created by mobvoi on 17-1-6.
 */

public class AppInfo {
    private String appName;
    private String packageName;
    private Drawable appIcon;

    //setter and getter
    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }
    //end of setter and getter

    //constructor
    public AppInfo() {
    }
    public AppInfo(String appName, String packageName, Drawable appIcon) {
        this.appName = appName;
        this.packageName = packageName;
        this.appIcon = appIcon;
    }
    //end of constructor


    @Override
    public String toString() {
        return "AppInfo{" +
                "appName='" + appName + '\'' +
                ", packageName='" + packageName + '\'' +
                ", appIcon=" + appIcon +
                '}';
    }
}
