package com.zmx.okttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class Get8801 extends AbstractOkhttp{

    public static void main(String[] args) throws IOException {
        Get8801 get8801 = new Get8801();
        // run FakeServer first
        String response = get8801.run();
        System.out.println(response);
    }

    public String run() throws IOException {
        Request request = new Request.Builder().url(url).build();

        try (Response response = client.newCall(request).execute()) {
            return Objects.requireNonNull(response.body()).string();
        }
    }

}
