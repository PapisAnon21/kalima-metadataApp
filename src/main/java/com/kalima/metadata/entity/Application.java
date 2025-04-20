package com.kalima.metadata.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Application {

    @Id
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organisation")
    //@JsonIgnoreProperties("applications")
    private Organisation organisation;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_chatbot")
    private Chatbot chatbot;
}
