package com.example.demo.helpers;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

public class HttpServletRequestToString {

    public static String convertToString(HttpServletRequest request) {
        StringBuilder stringBuilder = new StringBuilder();

        // Request method and URL
        stringBuilder.append(request.getMethod()).append(" ").append(request.getRequestURL());
        if (request.getQueryString() != null) {
            stringBuilder.append("?").append(request.getQueryString());
        }
        stringBuilder.append("\n");

        // Request headers
        Map<String, String> headers = getRequestHeaders(request);
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            stringBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        // Request body (if it's a POST request)
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            // TODO: Implement logic to read and append request body
        }

        return stringBuilder.toString();
    }

    private static Map<String, String> getRequestHeaders(HttpServletRequest request) {
        Map<String, String> headers = new LinkedHashMap<>();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = Collections.list(request.getHeaders(headerName)).toString();
            headers.put(headerName, headerValue);
        }
        return headers;
    }
}

