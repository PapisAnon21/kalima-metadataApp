package com.kalima.metadata.repository;

import com.kalima.metadata.entity.Index;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndexRepository extends JpaRepository<Index, Long> {

    Index findIndexById(Long idIndex);
    Index findIndexByName(String nameIndex);
}
