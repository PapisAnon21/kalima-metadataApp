package com.kalima.metadata.repository;

import com.kalima.metadata.entity.Chatbot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatbotRepository extends JpaRepository<Chatbot, Long> {

    Chatbot findChatbotByApplicationName(String nameApplication);
}
