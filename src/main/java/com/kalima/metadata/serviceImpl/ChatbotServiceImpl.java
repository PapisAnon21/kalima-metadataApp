package com.kalima.metadata.serviceImpl;

import com.kalima.metadata.entity.Chatbot;
import com.kalima.metadata.entity.Index;
import com.kalima.metadata.repository.ChatbotRepository;
import com.kalima.metadata.services.ChatbotService;
import com.kalima.metadata.services.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ChatbotServiceImpl implements ChatbotService {

    final ChatbotRepository chatbotRepository;
    final IndexService indexService;

    @Override
    public Chatbot createChatbot(Chatbot chatbot, MultipartFile[] documents) {

        Chatbot savedChatbot = chatbotRepository.save(chatbot);

        // when we create the chatbot , we also create the index knowledge base
        List<Index> indexesFromChatbot = chatbot.getIndexes();

        log.info("this is the index for chatbot");
        log.info(String.valueOf(indexesFromChatbot));

        indexService.createIndexes(indexesFromChatbot, chatbot, documents);

        return savedChatbot;
    }

    @Override
    public Optional<Chatbot> getChatbotById(Long idChatbot) {
        return chatbotRepository.findById(idChatbot);
    }

    @Override
    public Chatbot getChatbotByApplicationName(String nameApplication){
        return chatbotRepository.findChatbotByApplicationName(nameApplication);
    }

    @Override
    public Chatbot updateChatbot(Chatbot chatbot) {
        // TODO chatbot must have an id, implement some security to check that
        if (chatbotRepository.existsById(chatbot.getId())) {
            return chatbotRepository.save(chatbot);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Chatbot not found with this id : " + chatbot.getId());
        }
    }

    @Override
    public void deleteChatbot(Long idChatbot) {
        chatbotRepository.deleteById(idChatbot);
    }

}
