package com.talentica.tsnetworking.networking;

import android.content.Context;
import android.util.Log;

import com.talentica.tsnetworking.util.Util;

/**
 * Base Networking Class. This class decides either retrofit to use
 * or volley.
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */


public class TSNetworking {

    private final String mUrl;

    private com.talentica.tsnetworking.callback.TSCallback mCallback;


    TSNetworkingVolley mNetworkingVolley = null;
    TSNetworkingRetro mNetworkingRetro = null;

    /**
     * static inner class used to hold application specific variables
     */
    public static class Builder {
        private String url = null;
        private com.talentica.tsnetworking.callback.TSCallback callback;
        private Context mContext;

        public com.talentica.tsnetworking.callback.TSCallback getCallback() {
            return callback;
        }

        public Context getContext() {
            return mContext;
        }

        public Builder setUrl(String baseUrl) {
            if (Util.VERBOSE)
                Util.log("Url Set "+baseUrl, this.getClass().getSimpleName());
            this.url = baseUrl;
            return this;
        }

        public Builder withCallback(com.talentica.tsnetworking.callback.TSCallback callback) {
            this.callback = callback;
            this.mContext = (Context) callback;
            return this;
        }

        public TSNetworking build() {
            return new TSNetworking(this);
        }
    }

    /**
     * private inner class
     *
     * @param builder : builder object holding different user inputs
     */
    private TSNetworking(Builder builder) {
        mUrl = builder.url;

        boolean volley = Util.isPackageExist("com.android.volley.Response");
        boolean retroFit = Util.isPackageExist("retrofit2.Response");

        if (volley) {

            if (Util.VERBOSE)
                Util.log("Volley Available", this.getClass().getSimpleName());

            Util.isVolley = true;
        } else if (retroFit) {

            if (Util.VERBOSE)
                Util.log("Retrofit Available", this.getClass().getSimpleName());

            Util.isRetro = true;

        } else {

            if (Util.VERBOSE)
                Util.log("Retrofit or volley not found. Are you sure any one of these libraries are available ?", this.getClass().getSimpleName());

        }


        if (Util.isVolley) {
            mNetworkingVolley = new TSNetworkingVolley(builder);
        } else {
            mNetworkingRetro = new TSNetworkingRetro(mUrl, builder);
        }
    }

    /**
     * Get Response for an url.
     *
     * @param subUrl : Sub url for the response
     */
    public void getTSGetResponse(String subUrl) {
        if (Util.isVolley) {

            if (Util.VERBOSE)
                Util.log("Getting Response using volley", this.getClass().getSimpleName());

            if (mNetworkingVolley != null) {
                mNetworkingVolley.getResponse(mUrl, subUrl);
            }

        } else {

            if (Util.VERBOSE)
                Util.log("Getting response using retrofit", this.getClass().getSimpleName());

            if (mNetworkingRetro != null) {
                mNetworkingRetro.getResponse(subUrl);
            }
        }
    }

}
