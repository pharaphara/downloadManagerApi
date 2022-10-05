package com.pharaphara.downloadManagerApi.services;

import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface DownloadManager {




    Mono<ResponseEntity<String>> createDownload(String url);
}
