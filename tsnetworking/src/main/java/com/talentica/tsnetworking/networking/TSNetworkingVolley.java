package com.talentica.tsnetworking.networking;

import com.android.volley.NetworkResponse;
import com.android.volley.VolleyError;
import com.talentica.tsnetworking.call.TSCall;
import com.talentica.tsnetworking.call.TSVolleyCall;
import com.talentica.tsnetworking.callback.TSCallback;
import com.talentica.tsnetworking.callback.TSListener;
import com.talentica.tsnetworking.error.TSError;
import com.talentica.tsnetworking.error.TSVolleyError;
import com.talentica.tsnetworking.request.TSCustomRequest;
import com.talentica.tsnetworking.response.TSResponse;
import com.talentica.tsnetworking.response.TSVolleyResponse;
import com.talentica.tsnetworking.util.Util;

/**
 * Main Networking class for Volley.
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSNetworkingVolley implements com.android.volley.Response.ErrorListener, TSListener {
    private TSCallback mCallBack;
    private TSCustomRequest mRequest;
    private com.android.volley.RequestQueue mRequestQueue;


    TSNetworkingVolley(TSNetworking.Builder builder) {
        mRequestQueue = com.android.volley.toolbox.Volley.newRequestQueue(builder.getContext());
        mCallBack = builder.getCallback();
    }


    /**
     * parse network response if success
     *
     * @param response : network response
     */
    @Override
    public void parseNetworkResponse(NetworkResponse response) {

        if (Util.VERBOSE)
            Util.log("Volley got successful response", this.getClass().getSimpleName());

        mCallBack.onResponse(new TSCall(new TSVolleyCall(mRequestQueue)), new TSResponse(new TSVolleyResponse(response)));
    }

    /**
     * parse network error
     *
     * @param error : volley error
     */
    @Override
    public void parseNetworkError(VolleyError error) {
        if (error != null) {

            if (Util.VERBOSE)
                Util.log("Volley call failed", this.getClass().getSimpleName());

            mCallBack.onFailure(new TSError(new TSVolleyError(error)));
        }
    }


    @Override
    public void onResponse(Object response) {
        //ignore
    }

    /**
     * Get response for an url
     *
     * @param subUrl
     */
    public void getResponse(String url, String subUrl) {

        if (Util.VERBOSE)
            Util.log("Trying to get response using volley", this.getClass().getSimpleName());

        mRequest = new TSCustomRequest(com.android.volley.Request.Method.GET, url + subUrl, this, this);
        mRequest.setTag("TAG");
        mRequestQueue.add(mRequest);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }
}
