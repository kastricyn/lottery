package ru.kastricyn.lottery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kastricyn.lottery.entity.ParticipantEntity;

public interface ParticipantRepository extends JpaRepository<ParticipantEntity, Long> {}
