package com.talentica.tsnetworking.callback;

/**
 * Internal interface class used by retrofit to initiate GET response
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */
public interface TSAPIInterface {

    @retrofit2.http.GET
    retrofit2.Call<okhttp3.ResponseBody> getTSResponse(@retrofit2.http.Url String anEmptyString);
}
