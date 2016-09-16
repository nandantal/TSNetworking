package com.talentica.tsnetworking.response;

import java.io.IOException;

/**
 * Response class for retrofit
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSRetroResponse {
    private retrofit2.Response<okhttp3.ResponseBody> response;

    public TSRetroResponse(retrofit2.Response response) {
        this.response = response;
        //response.body();
    }

    /**
     * get retrofit response code
     *
     * @return : response code
     */
    public int code() {
        return response.code();
    }

    /**
     * get retrofit response message
     *
     * @return : response message
     */
    public String message() {
        return response.message();
    }

    /**
     * was it successful
     *
     * @return : boolean
     */
    public boolean isSuccessful() {
        return response.isSuccessful();
    }

    /**
     * get the body of the retrofit response
     *
     * @return : string body
     */
    public String getBody() {
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        //endregion
    }

}
