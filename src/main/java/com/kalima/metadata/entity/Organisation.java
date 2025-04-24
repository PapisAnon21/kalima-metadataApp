package com.kalima.metadata.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@JsonIgnoreProperties({"applications"})
public class Organisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY)
    private List<Application> applications;
}
