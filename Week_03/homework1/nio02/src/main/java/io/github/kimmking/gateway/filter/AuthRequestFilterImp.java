package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class AuthRequestFilterImp implements HttpRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthRequestFilterImp.class);

    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        logger.info(" fullRequest is :::: {}",fullRequest.uri());
        if (fullRequest.uri().startsWith("/admin") && noAuth(fullRequest)) {

            FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1,
                    HttpResponseStatus.NON_AUTHORITATIVE_INFORMATION);
            ctx.write(response);
            // 这里并没能控制住没有权限之后的操作，依然把请求发给了后端。。。 什么情况？
            ctx.flush();
            ctx.close();
        }
    }

    private Boolean noAuth(FullHttpRequest fullRequest) {
        return true;
    }
}
