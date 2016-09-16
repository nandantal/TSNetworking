package com.talentica.tsnetworking.callback;

import com.android.volley.VolleyError;

/**
 * Internal Listener class ( Used only for volley)
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public interface TSListener extends com.android.volley.Response.Listener {
    public void parseNetworkResponse(com.android.volley.NetworkResponse response);

    public void parseNetworkError(VolleyError error);
}
