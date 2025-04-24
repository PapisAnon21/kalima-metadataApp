package com.kalima.metadata.controller;

import com.kalima.metadata.entity.Chatbot;
import com.kalima.metadata.services.ChatbotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/chatbot")
@RequiredArgsConstructor
public class ChatbotController {

    final ChatbotService chatbotService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chatbot createChatbot(@RequestPart("chatbot") Chatbot chatbot, @RequestPart("documents") MultipartFile[] documents) {
        return chatbotService.createChatbot(chatbot, documents);

    }

    @PostMapping(value = "/v2", consumes = "multipart/form-data")
    @ResponseStatus(HttpStatus.CREATED)
    public Chatbot createChatbot2(@RequestPart("chatbot") Chatbot chatbot, @RequestPart("indexFiles") MultipartFile[] indexFiles) {
        return chatbotService.createChatbot(chatbot, indexFiles);

    }

    @GetMapping(value = "/{idChatbot}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Chatbot> getChatbotById(@PathVariable Long idChatbot) {
        return chatbotService.getChatbotById(idChatbot);
    }

    @GetMapping(value = "application/{nameApplication}")
    @ResponseStatus(HttpStatus.OK)
    public Chatbot getChatbotByApplicationName(@PathVariable String nameApplication) {
        return chatbotService.getChatbotByApplicationName(nameApplication);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Chatbot updateChatbot(@RequestBody Chatbot chatbot) {
        // chatbot that is coming must have an id
        return chatbotService.updateChatbot(chatbot);
    }

    @DeleteMapping(value = "/{idChatbot}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteChatbot(@PathVariable Long idChatbot) {
        chatbotService.deleteChatbot(idChatbot);
    }

}
