package com.kalima.metadata.services;

import com.kalima.metadata.entity.Chatbot;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

public interface ChatbotService {

    Chatbot createChatbot(Chatbot chatbot, MultipartFile[] documents);

    Optional<Chatbot> getChatbotById(Long idChatbot);

    Chatbot getChatbotByApplicationName(String applicationName);

    Chatbot updateChatbot(Chatbot chatbot);

    void deleteChatbot(Long idChatbot);
}
