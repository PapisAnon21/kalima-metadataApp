package com.kalima.metadata.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Organisation {

    @Id
    private Long id;
    private String name;
    private String email;

    @OneToMany(mappedBy = "organisation", fetch = FetchType.LAZY)
    private List<Application> applications;

}
