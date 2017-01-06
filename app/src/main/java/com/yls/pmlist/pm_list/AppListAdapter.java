package com.yls.pmlist.pm_list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by mobvoi on 17-1-6.
 */

public class AppListAdapter extends BaseAdapter {

    LayoutInflater li;
    List<AppInfo> appInfoList;

    public AppListAdapter(Context c, List<AppInfo> appInfoList) {
        li = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.appInfoList = appInfoList;
    }

    @Override
    public int getCount() {
        return appInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return appInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = li.inflate(R.layout.appinfo_list_item,null);
        ImageView icon = (ImageView) view.findViewById(R.id.iv_icon);
        TextView tvAppName = (TextView) view.findViewById(R.id.tv_app_name);
        TextView tvPkgName = (TextView) view.findViewById(R.id.tv_pkg_name);
        AppInfo appInfo = (AppInfo) getItem(position);
        icon.setImageDrawable(appInfo.getAppIcon());
        tvAppName.setText(appInfo.getAppName());
        tvPkgName.setText(appInfo.getPackageName());
        return view;
    }
}
