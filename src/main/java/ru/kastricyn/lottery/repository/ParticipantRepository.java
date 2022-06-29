package ru.kastricyn.lottery.repository;

import org.springframework.data.repository.CrudRepository;
import ru.kastricyn.lottery.dto.Participant;
import ru.kastricyn.lottery.entity.ParticipantEntity;

import java.util.List;

public interface ParticipantRepository extends CrudRepository<ParticipantEntity, Long> {
    List<Participant> getAll(); //так, просто для единообразия API
}
