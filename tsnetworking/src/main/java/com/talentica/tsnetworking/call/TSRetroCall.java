package com.talentica.tsnetworking.call;


/**
 * Custom call class for retrofit
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSRetroCall {

    private retrofit2.Call mRetroCall;

    //region retrofit

    public TSRetroCall(retrofit2.Call call) {
        this.mRetroCall = call;
    }

    /*public boolean isExecuted() {
        return mRetroCall.isExecuted();
    }*/


    public boolean isCanceled() {
        return mRetroCall.isCanceled();
    }

    public void cancel() {
        mRetroCall.cancel();
    }
    //endregion
}
