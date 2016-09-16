package com.talentica.tsnetworking.error;

import com.talentica.tsnetworking.util.Util;

/**
 * This class is used to handle error msg returned by volley or
 * retrofit
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSError {
    private TSRetroError mRetroError;
    private TSVolleyError mVolleyError;

    /**
     * Constructor for retrofit
     *
     * @param retroError : Custom error msg for retrofit
     */
    public TSError(TSRetroError retroError) {
        mRetroError = retroError;
    }

    /**
     * Constructor for volley
     *
     * @param volleyError : Custom error msg for volley
     */
    public TSError(TSVolleyError volleyError) {
        mVolleyError = volleyError;
    }

    /**
     * get error code for volley or retrofit, default -1
     *
     * @return : integer
     */
    public int getErrorCode() {
        if (Util.isRetro)
            return mRetroError.getStatusCode();

        return mVolleyError.getErrorCode();
    }

    /**
     * get error message
     *
     * @return : String error message
     */
    public String getErrorMsg() {
        if (Util.isRetro)
            return mRetroError.getErrorMsg();

        return mVolleyError.getErrorMsg();
    }
}
