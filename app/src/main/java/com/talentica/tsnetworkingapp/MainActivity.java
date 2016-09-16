package com.talentica.tsnetworkingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.talentica.tsnetworking.call.TSCall;
import com.talentica.tsnetworking.callback.TSCallback;
import com.talentica.tsnetworking.error.TSError;
import com.talentica.tsnetworking.networking.TSNetworking;
import com.talentica.tsnetworking.response.TSResponse;

public class MainActivity extends AppCompatActivity implements TSCallback {

    private TSNetworking networking;
    private final String URL = "https://api.stackexchange.com/2.2/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        networking = new TSNetworking.Builder().setUrl(URL).withCallback(this).build();

        networking.getTSGetResponse("search?order=desc&sort=activity&tagged=android&site=stackoverflow");

    }

    @Override
    public void onResponse(TSCall call, TSResponse response) {
        Log.d("tsnetworking", "response code " + response.code());
        Log.d("tsnetworking", "response body " + response.getBody());
    }

    @Override
    public void onFailure(TSError error) {
        Log.d("tsnetworking", "response error message " + error.getErrorMsg());
        Log.d("tsnetworking", "response error code " + error.getErrorCode());

    }
}
