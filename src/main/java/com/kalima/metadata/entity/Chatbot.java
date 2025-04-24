package com.kalima.metadata.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Chatbot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String prompt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_application")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Application application;

    @OneToMany(mappedBy = "chatbot", fetch = FetchType.EAGER)
    @JsonIgnoreProperties({"chatbot", "documents"})
    private List<Index> indexes;

}
