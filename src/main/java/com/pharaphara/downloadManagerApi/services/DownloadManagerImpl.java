package com.pharaphara.downloadManagerApi.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharaphara.downloadManagerApi.entity.DetailsResponseDTO;
import com.pharaphara.downloadManagerApi.entity.Download;
import com.pharaphara.downloadManagerApi.entity.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

@Service
@EnableScheduling
public class DownloadManagerImpl implements DownloadManager {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Autowired
    private FileDownloader fileDownloader;

    @Value("${uptobox.userToken}")
    private String userToken;
    @Value("${uptobox.waitingTokenUrl}")
    private String waitingTokenUrl;
    @Value("${uptobox.fileInfoUrl}")
    private String fileInfoUrl;
    private final LinkedBlockingQueue<Download> downloadList = new LinkedBlockingQueue<>();





    @Override
    public Mono<ResponseEntity<String>> createDownload(String url) {

        String finalUrl = waitingTokenUrl.replace("[USR_TOKEN]",userToken).replace("[FILE_CODE]",url);

        return webClientBuilder.build()
                .get()
                .uri(fileInfoUrl.replace("[FILE_CODE]", url))
                .accept(MediaType.TEXT_HTML)
                .retrieve()
                .toEntity(String.class)
                .doOnSuccess(responseEntity -> {
                    ObjectMapper mapper = new ObjectMapper();
                    try {
                        DetailsResponseDTO detailsResponseDTO = mapper.readValue(responseEntity.getBody(), DetailsResponseDTO.class);

                        String code = detailsResponseDTO.getData().getList().get(0).getFile_code();
                        String filename = detailsResponseDTO.getData().getList().get(0).getFile_name();
                        long size = detailsResponseDTO.getData().getList().get(0).getFile_size();
                        webClientBuilder.build()
                                .get()
                                .uri(finalUrl)
                                .accept(MediaType.TEXT_HTML)
                                .retrieve()
                                .toEntity(String.class)
                                .doOnSuccess(responseEntity2 -> {

                                    try {
                                        ResponseDTO responseDTO = mapper.readValue(responseEntity2.getBody(), ResponseDTO.class);
                                        String downloadLink = (String) responseDTO.getData().get("dlLink");
                                        downloadList.add(new Download(code, filename, size, downloadLink));


                                    } catch (JsonProcessingException e) {
                                        throw new RuntimeException(e);
                                    }

                                }).subscribe();


                    } catch (JsonProcessingException e) {
                        throw new RuntimeException(e);
                    }


                });
    }

    @Scheduled(fixedRate = 5, timeUnit = TimeUnit.SECONDS)
    private void scheduled() throws InterruptedException {
        fileDownloader.downloadFile(downloadList.take());


    }





}
