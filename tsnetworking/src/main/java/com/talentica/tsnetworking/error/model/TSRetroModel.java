package com.talentica.tsnetworking.error.model;

/**
 * Model class used for retrofit error
 *
 * @author Nandan Kaushik Dutta
 * @version 0.1.1 (Beta)
 * @since 2016-8-21
 */

public class TSRetroModel {


    private int statusCode;
    private String message;

    public TSRetroModel() {
    }

    public int status() {
        return statusCode;
    }

    public String message() {
        return message;
    }

}
