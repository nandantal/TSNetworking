package com.talentica.tsnetworking.error;

import com.talentica.tsnetworking.error.model.TSRetroModel;

import java.io.IOException;
import java.lang.annotation.Annotation;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Error class for Retrofit
 *
 * @author nandan.dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSRetroError {

    private Response<ResponseBody> mResponse;
    TSRetroModel error = null;
    private Throwable t = null;


    public TSRetroError(Response<ResponseBody> response, retrofit2.Retrofit retrofit) {
        mResponse = response;
        Converter<ResponseBody, TSRetroModel> converter =
                retrofit
                        .responseBodyConverter(TSRetroModel.class, new Annotation[0]);

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {

        }
    }

    public TSRetroError(Throwable throwable) {
        t = throwable;
    }

    /**
     * error status code for retrofit
     *
     * @return : integer status code
     */
    public int getStatusCode() {
        if (error != null)
            return error.status();
        return -1;
    }

    /**
     * error message for retrofit
     *
     * @return : String error message
     */
    public String getErrorMsg() {
        if (t != null)
            return t.getLocalizedMessage();
        return error.message();
    }

}
