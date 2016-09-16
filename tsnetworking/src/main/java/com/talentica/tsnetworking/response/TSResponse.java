package com.talentica.tsnetworking.response;

import com.talentica.tsnetworking.util.Util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Main Response class for retrofit or volley
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */
public final class TSResponse {

    private TSVolleyResponse mVolleyResponse;
    private TSRetroResponse mRetroResponse;

    public TSResponse(TSVolleyResponse volleyResponse) {
        this.mVolleyResponse = volleyResponse;
    }


    public TSResponse(TSRetroResponse retroResponse) {
        this.mRetroResponse = retroResponse;
    }

    /**
     * check response code
     *
     * @return : response code
     */
    public int code() {
        if (Util.isVolley)
            return mVolleyResponse.code();
        else
            return mRetroResponse.code();
    }

    /**
     * check if the response is successful
     *
     * @return : boolean
     */
    public boolean isSuccessful() {
        if (Util.isVolley)
            return mVolleyResponse.isSuccessful();
        else
            return mRetroResponse.isSuccessful();
    }

    /**
     * get body of the response
     *
     * @return : string
     */
    public String getBody() {
        if (Util.isVolley) {
            return mVolleyResponse.getBody();

        } else {
            return mRetroResponse.getBody();
        }
    }

}
