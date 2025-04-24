package com.kalima.metadata.controller;


import com.kalima.metadata.entity.Organisation;

import com.kalima.metadata.services.OrganisationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/organisation")
@RequiredArgsConstructor
public class OrganisationController {

    final OrganisationService organisationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organisation createOrganisation(@RequestBody Organisation organisation) {

        return organisationService.createOrganisation(organisation);
    }

    @GetMapping(value = "/{idOrganisation}")
    @ResponseStatus(HttpStatus.OK)
    public Organisation getOrganisationById(@PathVariable Long idOrganisation){
        return  organisationService.getOrganisationById(idOrganisation);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Organisation updateOrganisation(@RequestBody Organisation organisation){

        return organisationService.updateOrganisation(organisation);
    }

    @DeleteMapping(value = "/{idOrganisation}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteOrganisation(@PathVariable Long idOrganisation){
        organisationService.deleteOrganisation(idOrganisation);
    }
}
