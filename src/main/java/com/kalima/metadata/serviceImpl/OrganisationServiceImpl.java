package com.kalima.metadata.serviceImpl;

import com.kalima.metadata.entity.Organisation;
import com.kalima.metadata.repository.OrganisationRepository;
import com.kalima.metadata.services.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@RequiredArgsConstructor
@Service
public class OrganisationServiceImpl implements OrganisationService {

    final OrganisationRepository organisationRepository;

    @Override
    public Organisation createOrganisation(Organisation organisation) {

        return organisationRepository.save(organisation);

    }

    @Override
    public Organisation getOrganisationById(Long idOrganisation)
    {
        return organisationRepository.findOrganisationById(idOrganisation);
    }

    @Override
    public Organisation updateOrganisation(Organisation organisation)
    {
        // TODO organisation must have an idea , implement some security to check that
        if(organisationRepository.existsById(organisation.getId()))
        return organisationRepository.save(organisation);
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Organisation not found with this id : " + organisation.getId());
    }

    @Override
    public void deleteOrganisation(Long idOrganisation)
    {
        organisationRepository.deleteById(idOrganisation);
    }
}
