package com.kalima.metadata.services;


import com.kalima.metadata.entity.Organisation;

public interface OrganisationService {

    Organisation createOrganisation(Organisation organisation);

    Organisation getOrganisationById(Long idOrganisation);

    Organisation updateOrganisation(Organisation organisation);

    void deleteOrganisation(Long  idOrganisation);
}
