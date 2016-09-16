TSNetworking (Beta)
========

Wrapper networking library that can be used with Retrofit or Volley

Retrofit : [link][1]

Volley : [link][2]


How To Use
--------

1. Build the jar ( Use gradle task "makeJar" to build ) . Latest version is available [here][3]
2. Import it on your project and include either Retrofit or Volley as second dependency.
3. Implement ```TSCallback``` in your main activity and initialize the library by using , ```TSNetworking networking = new TSNetworking.Builder().setUrl(URL).withCallback(this).build();```
4. Responses can be handled inside override method ```onResponse``` and ```onFailure```
5. That's it. You can switch between volley and retrofit only by changing dependency.
6. Final Activity will look like as below :


```java
public class MainActivity extends AppCompatActivity implements TSCallback {

    private TSNetworking networking;
    private final String URL = "https://api.stackexchange.com/2.2/"; //primary url

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        networking = new TSNetworking.Builder().setUrl(URL).withCallback(this).build();

        networking.getTSGetResponse("search?order=desc&sort=activity&tagged=android&site=stackoverflow");//get response

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
```
License :
=======

    Copyright 2016 Talentica Software
    Copyright 2013 Square, Inc.
    Copyright (C) 2011 The Android Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.


 [1]: https://github.com/square/retrofit
 [2]: https://android.googlesource.com/platform/frameworks/volley/
[3]: https://github.com/nandankd/TSNetworking/tree/master/tsnetworking/release