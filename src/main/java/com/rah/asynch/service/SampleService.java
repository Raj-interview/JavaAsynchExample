package com.rah.asynch.service;

import com.rah.asynch.repository.IApplicationRepository;
import feign.Response;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;

@Service
public class SampleService {

    @Inject
    IApplicationRepository applicationRepository;

    boolean lastRequestSuccess;

    public boolean healthCheck() {
        CompletableFuture.runAsync(() -> {
            System.out.println("In asynch call.");
            updateStatus();
        });
        return lastRequestSuccess;
    }

    private void updateStatus() {
        try {
            Response response = applicationRepository.healthCheck();
            if (response.status() == 200) {
                lastRequestSuccess = true;
            }
        } catch (Exception ex) {
            lastRequestSuccess = false;
        }
    }

}
