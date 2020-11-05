import org.mockserver.client.MockServerClient;
import org.mockserver.integration.ClientAndServer;

import static org.mockserver.matchers.Times.exactly;
import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;


/**
 * 启动一个假服务
 */
public class FakeServer {

    public static final int serverPort = 8088;
    private static ClientAndServer mockServer;

    public static void main(String[] args) {
        mockServer = ClientAndServer.startClientAndServer(serverPort);

        mockServer
                .when(
                        request()
                                .withMethod("GET")
                                .withPath("/admin"))
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody("admin page")
                );

        mockServer
                .when(
                        request()
                                .withMethod("GET")
                                .withPath(""))
                .respond(
                        response()
                                .withStatusCode(200)
                                .withBody("hello")
                );


//        new MockServerClient("127.0.0.1", serverPort)
//                .when(
//                        request()
//                                .withMethod("POST")
//                                .withPath(""),
//                        exactly(3)
//                )
//                .respond(
//                        response()
//                                .withStatusCode(200)
//                                .withBody(" TO BE !")
//                );

//        new MockServerClient("127.0.0.1", 8801)
//                .when(
//                        request()
//                                .withMethod("POST")
//                                .withPath(""),
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
