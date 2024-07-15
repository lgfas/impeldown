package com.lgfas.impeldown.repository;

import com.lgfas.impeldown.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrimeRepository extends JpaRepository<Crime, Long> {
}
