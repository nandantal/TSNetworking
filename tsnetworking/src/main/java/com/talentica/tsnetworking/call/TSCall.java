package com.talentica.tsnetworking.call;

import com.talentica.tsnetworking.response.TSResponse;

/**
 * Main Call class
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSCall {
    private TSRetroCall mRetroCall;
    private TSVolleyCall mVolleyCall;
    private TSResponse mResponse;

    public TSCall(TSRetroCall retroCall) {
        mRetroCall = retroCall;
    }

    public TSCall(TSResponse response) {
        mResponse = response;
    }

    public TSCall(TSVolleyCall volleyCall) {
        mVolleyCall = volleyCall;
    }

    public void cancel() {
        if (mRetroCall != null)
            mRetroCall.cancel();
        else if (mVolleyCall != null)
            mVolleyCall.cancel();
    }

}
