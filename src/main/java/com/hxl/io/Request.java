package com.hxl.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * <p>description</p>
 *
 * @author <a href="mailto:xxbjiy@163.com">huangxl</a>
 * @since 2020/5/6 15:04
 */
public class Request {
    private static final String GET = "GET";
    private static final String POST = "POST";
    private String url;
    private String method;

    public Request(InputStream inputStream) throws IOException {
        String httpRequest = null;
        byte[] buffer = new byte[1024];
        int len = 0;
        if ((len = inputStream.read(buffer)) > 0) {
            httpRequest = new String(buffer, 0, len);
        }
        String[] requestLine = httpRequest.split("\\n")[0].split("\\s");
        method = requestLine[0];
        url = requestLine[1];
        if (GET.equals(method)) {
            url = url.split("\\?")[0];
        }
    }

    public Request(String httpRequest) {
//        String httpRequest = buffer.toString();
        String[] requestLine = httpRequest.split("\\n")[0].split("\\s");
        method = requestLine[0];
        url = requestLine[1];
        if (GET.equals(method)) {
            url = url.split("\\?")[0];
        }
    }
}
