package com.yls.pmlist.pm_list;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListPackageActivity extends ListActivity {


    ListView lv;
    List<AppInfo> appInfoList = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        setListAdapter(new AppListAdapter(this,appInfoList));
    }

    private void init() {
        appInfoList = new ArrayList<>();
        queryappInfoListInfo();
    }

    private void queryappInfoListInfo() {
        PackageManager pm = getPackageManager();
        //1
        List<ApplicationInfo> appInfos = pm.getInstalledApplications(PackageManager.MATCH_UNINSTALLED_PACKAGES);
        //2
//        Intent i = new Intent(Intent.ACTION_MAIN);
//        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(i, PackageManager.MATCH_DEFAULT_ONLY);
        Log.i("pmlist","size:"+appInfos.size());
        if(appInfoList != null){
            appInfoList.clear();
/*            for (ResolveInfo ri : resolveInfos){
                AppInfo ai = new AppInfo((String)ri.activityInfo.loadLabel(pm),     //app name,暂时用label代替
                        ri.activityInfo.packageName,
                        ri.loadIcon(pm));
                Log.i("pmlist",ai.toString());
                appInfoList.add(ai);
            }*/
            //
            for (ApplicationInfo appInfo:appInfos){
                if((appInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0){
                    AppInfo ai2 = new AppInfo((String)appInfo.loadLabel(pm),appInfo.packageName,appInfo.loadIcon(pm));
                    appInfoList.add(ai2);
                //本来是系统程序，被用户手动更新后，该系统程序也成为第三方应用程序了  ???
                }else if((appInfo.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0){
                    AppInfo ai3 = new AppInfo((String)appInfo.loadLabel(pm),appInfo.packageName,appInfo.loadIcon(pm));
                    appInfoList.add(ai3);
                }
            }
        }
    }
}
