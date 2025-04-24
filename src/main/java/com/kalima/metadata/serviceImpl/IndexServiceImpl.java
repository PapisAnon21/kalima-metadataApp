package com.kalima.metadata.serviceImpl;

import com.kalima.metadata.client.ChatbotClient;
import com.kalima.metadata.entity.Chatbot;
import com.kalima.metadata.entity.Index;
import com.kalima.metadata.repository.IndexRepository;
import com.kalima.metadata.services.IndexService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexServiceImpl implements IndexService {

    final IndexRepository indexRepository;
    final ChatbotClient chatbotClient;

    @Override
    public Index createIndex(Index index) {
        return indexRepository.save(index);
    }

    @Override
    public void createIndexes(List<Index> indexes, Chatbot chatbot, MultipartFile[] documents) {

        List<String> documentsIndex = new ArrayList<>();

        for(MultipartFile documentss : documents){
            documentsIndex.add(documentss.getOriginalFilename());
        }


        for (Index index : indexes){
            index.setDocuments(documentsIndex);
            chatbotClient.createFilesIndex(index.getName(), documents);
            index.setChatbot(chatbot);
            indexRepository.save(index);
        }
        log.info("all indexes is create with this chatbot id {}", chatbot.getId());

    }

    @Override
    public Index getIndexById(Long idIndex) {
        return indexRepository.findIndexById(idIndex);
    }

    @Override
    public Index getIndexByName(String nameIndex) {
        return indexRepository.findIndexByName(nameIndex);
    }

    @Override
    public Index updateIndex(Index index) {
        return indexRepository.save(index);
    }

    @Override
    public void deleteIndex(Long idIndex){
        indexRepository.deleteById(idIndex);
    }
}
