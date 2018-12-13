package com.base.library.net;

import com.base.library.bean.GetConfigRequest;
import com.base.library.bean.ParkInfo;
import com.base.library.bean.Robot;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by yg on 2018/12/12.
 */

public interface TestService {
    @GET(ApiConstants.PARK_INFO)
    Observable<BaseResponse<ParkInfo>> getParkInfo(@Query("robotId") String robotId);
    @POST(ApiConstants.ROBOT_INFO)
    Observable<BaseResponse<Robot>> getRobotInfo(@Body GetConfigRequest request);
}
