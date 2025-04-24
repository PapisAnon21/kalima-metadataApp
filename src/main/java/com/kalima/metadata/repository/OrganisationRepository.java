package com.kalima.metadata.repository;

import com.kalima.metadata.entity.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {

    Organisation findOrganisationById(Long idOrganisation);
}
