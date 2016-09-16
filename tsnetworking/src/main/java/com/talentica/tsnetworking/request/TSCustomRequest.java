package com.talentica.tsnetworking.request;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.talentica.tsnetworking.callback.TSListener;

/**
 * Custom request ( only used in volley )
 *
 * @author nandan.dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */
public class TSCustomRequest extends com.android.volley.Request {

    private final TSListener mListener;

    public TSCustomRequest(int method, String url, TSListener listener, com.android.volley.Response.ErrorListener errorListener) {
        super(method, url,errorListener);
        this.mListener = listener;
    }

    @Override
    protected com.android.volley.Response<com.android.volley.NetworkResponse> parseNetworkResponse(com.android.volley.NetworkResponse response) {
        mListener.parseNetworkResponse(response);
        return Response.success(response, HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(Object response) {

    }

    @Override
    public void deliverError(VolleyError error) {
        super.deliverError(error);
        mListener.parseNetworkError(error);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
