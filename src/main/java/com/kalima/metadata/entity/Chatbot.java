package com.kalima.metadata.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Chatbot {

    @Id
    private Long id;
    private String name;
    private String prompt;

    @OneToOne(mappedBy = "chatbot", fetch = FetchType.LAZY)
    private Application application;

    @OneToMany(mappedBy = "chatbot", fetch = FetchType.EAGER)
    private List<Index> indexes;

}
