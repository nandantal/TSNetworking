package com.talentica.tsnetworking.callback;


import com.talentica.tsnetworking.call.TSCall;
import com.talentica.tsnetworking.error.TSError;
import com.talentica.tsnetworking.response.TSResponse;

/**
 * Callback interface for both volley and retrofit.
 * This class need to be implemented by the application.
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public interface TSCallback {

    /**
     * call on network response
     *
     * @param call     : Custom Call object
     * @param response : Custom Response object
     */
    void onResponse(TSCall call, TSResponse response);

    /**
     * call on failed response
     *
     * @param error : Custom Error msg
     */
    void onFailure(TSError error);
}
