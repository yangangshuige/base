package com.base.library.activity;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.base.library.R;
import com.base.library.bean.GetConfigRequest;
import com.base.library.bean.ParkInfo;
import com.base.library.bean.Robot;
import com.base.library.net.ApiManager;
import com.base.library.net.BaseObserver;
import com.base.library.net.BaseResponse;
import com.base.library.net.RxSchedulers;
import com.base.library.net.TestService;

public class TestActivity extends AppCompatActivity {

    private String TAG="TestActivity";
    String androidID;
    String parkId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        androidID = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public void getParkInfo(View view){
        ApiManager.getInstence().getService(TestService.class).getParkInfo(androidID)
                .compose(RxSchedulers.<BaseResponse<ParkInfo>>applySchedulers())
                .subscribe(new BaseObserver<BaseResponse<ParkInfo>>() {
                    @Override
                    public void onSuccess(BaseResponse<ParkInfo> parkInfoBaseResponse) {
                        Log.e(TAG,parkInfoBaseResponse.getData().toString());
                        if(parkInfoBaseResponse.isResponseSuccess()){
                            Log.e(TAG,parkInfoBaseResponse.getData().toString());
                            parkId=parkInfoBaseResponse.getData().getParkNum();
                        }
                    }

                    @Override
                    public void onFail(Throwable e) {

                    }
                });

    }
    public void getRobotInfo(View view){
        GetConfigRequest request = new GetConfigRequest();
        request.setParkId(parkId);
        request.setRobotId(androidID);
        ApiManager.getInstence().getService(TestService.class).getRobotInfo(request)
                .compose(RxSchedulers.<BaseResponse<Robot>>applySchedulers())
                .subscribe(new BaseObserver<BaseResponse<Robot>>() {
                    @Override
                    public void onSuccess(BaseResponse<Robot> parkInfoBaseResponse) {
                        Log.e(TAG,parkInfoBaseResponse.getData().toString());
                        if(parkInfoBaseResponse.isResponseSuccess()){
                        }
                    }

                    @Override
                    public void onFail(Throwable e) {

                    }
                });

    }
}
