package com.talentica.tsnetworking.error;

import com.android.volley.VolleyError;

/**
 * Error class for Volley
 *
 * @author nandan.dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */
public class TSVolleyError {
    private VolleyError mError;

    public TSVolleyError(VolleyError error) {
        mError = error;
    }

    /**
     * error message for volley
     *
     * @return : String error message
     */
    public String getErrorMsg() {
        return mError.getCause().getMessage();
    }

    /**
     * error code for volley
     *
     * @return : Integer error code
     */
    public int getErrorCode() {
        if (mError.networkResponse != null)
            return mError.networkResponse.statusCode;
        return -1;
    }

}
