package com.zmx;

import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;
import org.mockserver.model.Header;
import org.mockserver.model.HttpForward;
import org.mockserver.verify.VerificationTimes;

import java.util.concurrent.TimeUnit;

import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpForward.forward;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;
import static org.mockserver.model.StringBody.exact;


/**
 * 启动一个假服务
 */
public class FakeServer {

    private static ClientAndServer mockServer;

    public static void main(String[] args) {
        mockServer = ClientAndServer.startClientAndServer(8801);
        mockServer.when(
                request()
                        .withMethod("GET")
                        .withPath(""))
                .respond(response()
                        .withStatusCode(200)
                        .withBody("hello")
                );

//        new MockServerClient("127.0.0.1", 8801)
//                .when(
//                        request()
//                                .withMethod("GET")
//                                .withPath("/xx"),
//                        exactly(3)
//                )
//                .forward(
//                        forward()
//                                .withHost("www.163.com")
//                                .withPort(80)
//                                .withScheme(HttpForward.Scheme.HTTPS)
//                );
//        new MockServerClient("127.0.0.1", 8801)
//                .when(
//                        request()
//                                .withMethod("POST")
//                                .withPath("/validate")
//                                .withHeader("Content-type, application/json")
//                                .withBody(exact("{username: 'foo', password: 'bar'}")),
//                        exactly(1)
//                )
//                .respond(
//                        response()
//                                .withStatusCode(401)
//                                .withHeaders(
//                                        new Header("Content-Type", "application/json; charset=utf-8"),
//                                        new Header("Cache-Control", "public, max-age=86400")
//                                )
//                                .withBody("{ message: 'incorrect username and password combination' }")
//                                .withDelay(TimeUnit.SECONDS,1)
//                );

//        new MockServerClient("localhost", 8801).verify(
//                request()
//                        .withMethod("POST")
//                        .withPath("/validate")
//                        .withBody(exact("{username: 'foo', password: 'bar'}")),
//                VerificationTimes.exactly(1)
//        );
    }
}
