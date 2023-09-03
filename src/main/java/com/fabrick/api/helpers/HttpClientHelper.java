package com.fabrick.api.helpers;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class HttpClientHelper {

    private String apiKey;

    private String baseUrl;

    private String authSchema;

    public HttpClientHelper(String apiKey, String baseUrl, String authSchema) {
        this.apiKey = apiKey;
        this.baseUrl = baseUrl;
        this.authSchema = authSchema;
    }

    public HttpUrl.Builder getEndpointUrl(String endpoint) {
        return HttpUrl.parse(baseUrl + "/" + endpoint)
                .newBuilder();
    }

    public Request.Builder getBaseRequest(String url) {
        return new Request.Builder()
                .header("Auth-Schema", authSchema)
                .addHeader("Api-Key", apiKey)
                .addHeader("X-Time-Zone", "Europe/Rome")
                .url(url);
    }

    public String getResponseBody(Request request) throws IOException {
        return new OkHttpClient().newCall(request).execute().body().string();
    }
}
