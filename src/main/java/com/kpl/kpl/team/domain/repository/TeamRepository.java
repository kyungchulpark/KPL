package com.kpl.kpl.team.domain.repository;

import com.kpl.kpl.team.domain.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
