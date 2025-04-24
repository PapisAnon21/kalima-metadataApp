package com.kalima.metadata.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"chatbot"})
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_organisation")
    private Organisation organisation;

    @OneToOne(mappedBy = "application", fetch = FetchType.LAZY)
    private Chatbot chatbot;
}
