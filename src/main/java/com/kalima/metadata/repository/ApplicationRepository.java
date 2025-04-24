package com.kalima.metadata.repository;

import com.kalima.metadata.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Application findApplicationById(Long idApplication);
}
