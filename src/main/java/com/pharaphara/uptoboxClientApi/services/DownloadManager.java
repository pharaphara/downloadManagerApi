package com.pharaphara.uptoboxClientApi.services;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface DownloadManager {




    Mono<ResponseEntity<String>> createUptoboxDownload(String url);

    Mono<ResponseEntity<String>> createRegularDownload(String url);
}
