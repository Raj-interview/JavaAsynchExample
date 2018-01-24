package com.rah.asynch.repository;

import feign.Headers;
import feign.RequestLine;
import feign.Response;

import java.io.IOException;

public interface IApplicationRepository {

    @RequestLine("GET /search?client=ms-opera-mobile")
    @Headers({"Content-Type: application/x-www-form-urlencoded", "Accept: */*"})
    Response healthCheck();
}
