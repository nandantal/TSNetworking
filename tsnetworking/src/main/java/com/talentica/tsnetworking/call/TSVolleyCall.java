package com.talentica.tsnetworking.call;


import com.android.volley.VolleyError;

/**
 * Custom Call class for Volley
 *
 * @author nandan.dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSVolleyCall {

    private com.android.volley.RequestQueue mVolleyCall;
    private VolleyError mError;


    /**
     * Constructor used in case of any error
     *
     * @param call  : RequestQueue object
     * @param error : Volley Error object
     */
    public TSVolleyCall(com.android.volley.RequestQueue call, VolleyError error) {
        this.mVolleyCall = call;
        this.mError = error;
    }

    public TSVolleyCall(com.android.volley.RequestQueue call) {
        this.mVolleyCall = call;
    }

    /**
     * Cancel the current operation
     */
    public void cancel() {
        mVolleyCall.cancelAll("TAG");
    }

}
