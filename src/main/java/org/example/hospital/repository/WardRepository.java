package org.example.hospital.repository;

import org.example.hospital.model.Ward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WardRepository extends JpaRepository<Ward, Long> {
    Ward findByName(String name);
}
