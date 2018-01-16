package com.irfanstore.productReview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class App 
{
    public static void main(String[] args) {
            SpringApplication.run(App.class, args);
    }

    //Capturing all the traces. Can customize what we want to trace.
    @Bean
    public AlwaysSampler defaultSampler() {
        return new AlwaysSampler();
    }

}
