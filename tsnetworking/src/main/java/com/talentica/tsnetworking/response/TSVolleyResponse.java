package com.talentica.tsnetworking.response;


import java.io.UnsupportedEncodingException;

/**
 * Response class for volley
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSVolleyResponse {
    private com.android.volley.NetworkResponse mVolleyResponse;

    public TSVolleyResponse(com.android.volley.NetworkResponse response) {
        this.mVolleyResponse = response;
    }

    /**
     * get response code
     *
     * @return : code
     */
    public int code() {
        return mVolleyResponse.statusCode;
    }

    /**
     * was it successful
     *
     * @return : boolean
     */
    public boolean isSuccessful() {
        return com.android.volley.Response.success(mVolleyResponse, com.android.volley.toolbox.HttpHeaderParser.parseCacheHeaders(mVolleyResponse)).isSuccess();
    }

    /**
     * get response body
     *
     * @return : string body message
     */
    public String getBody() {

        try {
            return new String(mVolleyResponse.data, "UTF-8");
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
