package com.pharaphara.uptoboxClientApi.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Configuration

public class WebClientBuilderConf {

    static Logger log = LoggerFactory.getLogger(WebClientBuilderConf.class);

    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder()
                //.filters(exchangeFilterFunctions -> exchangeFilterFunctions.addAll(Arrays.asList(logRequest(), logresponse())))

                .exchangeStrategies(ExchangeStrategies.builder()
                        .codecs(configurer -> configurer
                                .defaultCodecs()
                                .maxInMemorySize(16 * 1024 * 1024))
                        .build());
    }


//    private static ExchangeFilterFunction logRequest() {
//
//        return ExchangeFilterFunction.ofRequestProcessor(clientRequest -> {
//            System.out.println((" Request:"+ clientRequest.method()+" "+ clientRequest.url()));
//            clientRequest.headers().forEach((name, values) -> values.forEach(value -> System.out.println( name+"="+ value)));
//            return Mono.just(clientRequest);
//        });
//    }
//
//    private static ExchangeFilterFunction logresponse() {
//
//        return ExchangeFilterFunction.ofResponseProcessor(clientResponse -> {
//            System.out.println((" Response status: "+ clientResponse.statusCode()));
//            clientResponse.headers().asHttpHeaders().forEach((name, values) -> values.forEach(value -> System.out.println(( name+"="+ value))));
//            return Mono.just(clientResponse);
//        });
//    }
}
