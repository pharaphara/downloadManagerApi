package com.pharaphara.downloadManagerApi.controller;


import com.pharaphara.downloadManagerApi.services.DownloadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
public class downloadController {

    @Autowired
    DownloadManager downloadManager;

    @PostMapping(value = "/download",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<String>> download(@RequestBody String url){
      return downloadManager.createDownload(url);
    }
}
