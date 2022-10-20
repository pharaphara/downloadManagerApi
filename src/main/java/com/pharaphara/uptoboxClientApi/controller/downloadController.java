package com.pharaphara.uptoboxClientApi.controller;


import com.pharaphara.uptoboxClientApi.services.DownloadManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
public class downloadController {

    @Autowired
    DownloadManager downloadManager;



    @PostMapping(value = "/download",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Mono<ResponseEntity<String>> download(@RequestBody String url){

        if(url.contains("uptobox")){
            return downloadManager.createUptoboxDownload(url.substring(url.lastIndexOf("/")+1));
        }

        return downloadManager.createRegularDownload(url);
    }


    @GetMapping("/ping")
    public ResponseEntity<String> ping(){
        return ResponseEntity.ok("UP and Running");
    }
}
