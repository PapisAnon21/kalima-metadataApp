package com.kalima.metadata.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Getter
@Setter
@Table(name = "index_table")
public class Index {

    @Id
    private Long id;
    private String name;

    @ElementCollection(fetch = FetchType.EAGER, targetClass = String.class)
    @JoinTable(name = "documents", joinColumns = @JoinColumn(name = "indexId"))
    private Collection<String> documents;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chatbot")
    private Chatbot chatbot;
}
