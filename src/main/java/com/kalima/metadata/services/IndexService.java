package com.kalima.metadata.services;


import com.kalima.metadata.entity.Chatbot;
import com.kalima.metadata.entity.Index;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IndexService {

    Index createIndex(Index index);

    void createIndexes(List<Index> indexes, Chatbot chatbot, MultipartFile[] documents);

    Index getIndexById(Long idIndex);

    Index getIndexByName(String nameIndex);

    Index updateIndex(Index index);

    void deleteIndex (Long idIndex);
}
