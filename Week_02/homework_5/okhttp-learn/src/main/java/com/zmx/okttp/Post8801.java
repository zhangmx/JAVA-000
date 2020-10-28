package com.zmx.okttp;

import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class Post8801 extends AbstractOkhttp{
    public static void main(String[] args) throws IOException {
        Post8801 get8801 = new Post8801();
        // run FakeServer first
        String response = get8801.run();
        System.out.println(response);
    }

    public String run() throws IOException {
        return "TO BE CONTINUE!";
    }
}
