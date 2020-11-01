package com.zmx.okttp;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;

public abstract class AbstractOkhttp {
    protected OkHttpClient client = new OkHttpClient();
    protected static final String url = "http://localhost:8801";
    protected static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
}
