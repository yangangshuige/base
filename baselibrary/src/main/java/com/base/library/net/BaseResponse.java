package com.base.library.net;

/**
 * Created by yg on 2018/12/12.
 */

public class BaseResponse<T> {
    String code ;
    String desc;
    T data;

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public T getData() {
        return data;
    }

    public boolean isResponseSuccess(){
        return ApiConstants.RESPONSE_SUCCESS.equals(getCode());
    }
}
