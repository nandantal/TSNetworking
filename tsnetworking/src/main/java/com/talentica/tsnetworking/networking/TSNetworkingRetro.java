package com.talentica.tsnetworking.networking;

import com.talentica.tsnetworking.call.TSCall;
import com.talentica.tsnetworking.call.TSRetroCall;
import com.talentica.tsnetworking.callback.TSAPIInterface;
import com.talentica.tsnetworking.callback.TSCallback;
import com.talentica.tsnetworking.error.TSError;
import com.talentica.tsnetworking.error.TSRetroError;
import com.talentica.tsnetworking.response.TSResponse;
import com.talentica.tsnetworking.response.TSRetroResponse;
import com.talentica.tsnetworking.util.Util;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Main Networking class for Retrofit.
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSNetworkingRetro implements retrofit2.Callback<okhttp3.ResponseBody> {
    private TSCallback mCallBack;
    private retrofit2.Retrofit mRetrofit;
    private TSAPIInterface mTsResponse;

    TSNetworkingRetro(String url, TSNetworking.Builder builder) {
        mRetrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(url)
                .build();
        mTsResponse = mRetrofit.create(TSAPIInterface.class);
        mCallBack = builder.getCallback();
    }

    /**
     * Response will be sent by retrofit.
     *
     * @param call     : call
     * @param response : Response
     */
    @Override
    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
        if (response.isSuccessful()) {

            if (Util.VERBOSE)
                Util.log("Retrofit got successful response", this.getClass().getSimpleName());

            mCallBack.onResponse(new TSCall(new TSRetroCall(call)), new TSResponse(new TSRetroResponse(response)));
        } else {

            if (Util.VERBOSE)
                Util.log("Error response for retrofit", this.getClass().getSimpleName());

            mCallBack.onFailure(new TSError(new TSRetroError(response, mRetrofit)));
        }
    }

    /**
     * call by retrofit if response is failed
     *
     * @param call : call
     * @param t    : throwable
     */
    @Override
    public void onFailure(Call<ResponseBody> call, Throwable t) {

        if (Util.VERBOSE)
            Util.log("Retrofit call failed", this.getClass().getSimpleName());

        mCallBack.onFailure(new TSError(new TSRetroError(t)));
    }

    /**
     * Get response for an url
     *
     * @param subUrl
     */
    public void getResponse(String subUrl) {

        if (Util.VERBOSE)
            Util.log("Trying to get response using retrofit", this.getClass().getSimpleName());

        retrofit2.Call<okhttp3.ResponseBody> call = mTsResponse.getTSResponse(subUrl);
        //asynchronous call
        call.enqueue(this);
    }
}
