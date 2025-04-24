package com.kalima.metadata.client;


import com.kalima.metadata.configuration.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@FeignClient(name = "chatbot-service", url = "${api.chatbot.base.url}", configuration = FeignConfig.class)
public interface ChatbotClient {

    @PostMapping(value = "/api/v1/chatbot/chatbotfull/create/index", consumes = "multipart/form-data")
    String createFilesIndex(@RequestParam(required = true) String indexName , @RequestPart MultipartFile[] files);

}
